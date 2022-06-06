package com.davahamka.kinder.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Rect
import android.net.Uri
import android.os.AsyncTask
import android.provider.Settings
import android.util.Log
import android.util.Size
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.override
import androidx.core.content.ContextCompat
import com.davahamka.kinder.ml.ObjectDetectorImageAnalyzer
import com.davahamka.kinder.presentation.ui.component.TopBarDescription
import com.davahamka.kinder.presentation.ui.theme.Green3
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.google.mlkit.common.model.LocalModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.DetectedObject
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.custom.CustomObjectDetectorOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@SuppressLint("UnsafeOptInUsageError")
@Composable
fun CameraCapture(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
    onImageFile: (File, value:String) -> Unit = { _, _ -> { } }
) {

    val context = LocalContext.current

    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    val localModel = LocalModel.Builder()
        .setAssetFilePath("objectone.tflite")
        .build()

    val customObjectDetectorOptions = CustomObjectDetectorOptions.Builder(localModel)
        .setDetectorMode(CustomObjectDetectorOptions.STREAM_MODE)
        .enableClassification()
        .setClassificationConfidenceThreshold(0.5f)
        .setMaxPerObjectLabelCount(3)
        .build()

    val objectDetector = ObjectDetection.getClient(customObjectDetectorOptions)

    var label by remember { mutableStateOf(" ")}
    var boundaryPoint by remember { mutableStateOf(Rect(0,0,0,0)) }


    Permission(
        permission = Manifest.permission.CAMERA,
        rationale = "You said you wanted a picture, so I'm going to have to ask for permission.",
        permissionNotAvailableContent = {
            Column(modifier) {
                Text("O noes! No Camera!")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package", context.packageName, null)
                    })
                }) {
                    Text("Open Settings")
                }
            }
        }
    ) {
       
        Scaffold(
            topBar = { TopBarDescription(title = "Check your food") }
        ) {
            Box(modifier = modifier) {
                val lifecycleOwner = LocalLifecycleOwner.current
                val coroutineScope = rememberCoroutineScope()
                var previewUseCase by remember { mutableStateOf<UseCase>(Preview.Builder().build()) }
                val imageCaptureUseCase by remember {
                    mutableStateOf(
                        ImageCapture.Builder()
                            .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
                            .build()
                    )
                }
                Box (modifier = Modifier.fillMaxSize()){
                    CameraPreview(
                        modifier = Modifier.fillMaxSize(),
                        onUseCase = {
                            previewUseCase = it
                        }
                    )

                    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                        var boundaryPaint = Paint()
                        boundaryPaint.color = Color.Green
                        boundaryPaint.strokeWidth = 10f
                        boundaryPaint.style = PaintingStyle.Stroke

                        var textPaint = android.graphics.Paint()
                        textPaint.color = android.graphics.Color.GREEN
                        textPaint.style = android.graphics.Paint.Style.FILL
                        textPaint.textSize = 40f

                        drawContext.canvas.drawRect(boundaryPoint?.left?.toFloat(), boundaryPoint?.top?.toFloat(),boundaryPoint?.right?.toFloat(), boundaryPoint?.bottom?.toFloat(), boundaryPaint)
                        drawContext.canvas.nativeCanvas.drawText(label, boundaryPoint?.centerX().toFloat(), boundaryPoint?.centerY().toFloat(), textPaint)
                    })

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .width(300.dp)
                            .padding(32.dp)
                            .align(Alignment.BottomCenter)
                        ,
                        contentPadding = PaddingValues(vertical = 12.dp),
                        onClick = {
                            coroutineScope.launch {
                                imageCaptureUseCase.takePicture(context.executor).let {
                                    onImageFile(it, label)
                                }
                            }
                        }
                    ) {
                        Text("Continue")
                    }
                }

                val imageAnalysis = ImageAnalysis.Builder()
                    .setTargetResolution(Size(1280, 720))
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()

                imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(context)) { imageProxy ->
                    val rotationDegrees = imageProxy.imageInfo.rotationDegrees

                    val image = imageProxy.image

                    if (image != null) {
                        val processImage = InputImage.fromMediaImage(image, rotationDegrees)

                        objectDetector
                            .process(processImage)
                            .addOnSuccessListener { objects ->
                                for(i in objects) {
                                    label = i.labels.firstOrNull()?.text ?: ""
                                    boundaryPoint = i.boundingBox
                                }
                                imageProxy.close()
                            }
                            .addOnFailureListener {
                                Log.d("ERR","err - ${it.message}")
                                imageProxy.close()
                            }
                    }
                }


                LaunchedEffect(previewUseCase) {





                    val cameraProvider = context.getCameraProvider()
                    try {
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner, cameraSelector, imageAnalysis, previewUseCase, imageCaptureUseCase,
                        )
                    } catch (ex: Exception) {
                        Log.e("CameraCapture", "Failed to bind camera use cases", ex)
                    }
                }
            }
        }
    }
}

suspend fun ImageCapture.takePicture(executor: Executor): File {

    val photoFile = withContext(Dispatchers.IO) {
        kotlin.runCatching {
            File.createTempFile("image", "jpg")
        }.getOrElse { ex ->
            Log.e("TakePicture", "Failed to create temporary file", ex)
            File("/dev/null")
        }
    }

    return suspendCoroutine { continuation ->
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        takePicture(outputOptions, executor, object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                continuation.resume(photoFile)
            }
            override fun onError(ex: ImageCaptureException) {
                Log.e("TakePicture", "Image capture failed", ex)
                continuation.resumeWithException(ex)
            }
        })
    }
}
