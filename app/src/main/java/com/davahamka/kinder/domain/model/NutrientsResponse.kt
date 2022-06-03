package com.davahamka.kinder.domain.model
import com.google.gson.annotations.SerializedName


data class NutrientsResponse(
    @SerializedName("foods")
    val foods: List<Food>
)

data class Food(
    @SerializedName("alt_measures")
    val altMeasures: List<AltMeasure>,
    @SerializedName("brand_name")
    val brandName: Any,
    @SerializedName("brick_code")
    val brickCode: Any,
    @SerializedName("class_code")
    val classCode: Any,
    @SerializedName("consumed_at")
    val consumedAt: String,
    @SerializedName("food_name")
    val foodName: String,
    @SerializedName("full_nutrients")
    val fullNutrients: List<FullNutrient>,
    @SerializedName("lat")
    val lat: Any,
    @SerializedName("lng")
    val lng: Any,
    @SerializedName("meal_type")
    val mealType: Int,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("ndb_no")
    val ndbNo: Int,
    @SerializedName("nf_calories")
    val nfCalories: Int,
    @SerializedName("nf_cholesterol")
    val nfCholesterol: Int,
    @SerializedName("nf_dietary_fiber")
    val nfDietaryFiber: Int,
    @SerializedName("nf_p")
    val nfP: Int,
    @SerializedName("nf_potassium")
    val nfPotassium: Int,
    @SerializedName("nf_protein")
    val nfProtein: Double,
    @SerializedName("nf_saturated_fat")
    val nfSaturatedFat: Double,
    @SerializedName("nf_sodium")
    val nfSodium: Double,
    @SerializedName("nf_sugars")
    val nfSugars: Double,
    @SerializedName("nf_total_carbohydrate")
    val nfTotalCarbohydrate: Double,
    @SerializedName("nf_total_fat")
    val nfTotalFat: Double,
    @SerializedName("nix_brand_id")
    val nixBrandId: Any,
    @SerializedName("nix_brand_name")
    val nixBrandName: Any,
    @SerializedName("nix_item_id")
    val nixItemId: Any,
    @SerializedName("nix_item_name")
    val nixItemName: Any,
    @SerializedName("photo")
    val photo: Photo,
    @SerializedName("serving_qty")
    val servingQty: Int,
    @SerializedName("serving_unit")
    val servingUnit: String,
    @SerializedName("serving_weight_grams")
    val servingWeightGrams: Int,
    @SerializedName("source")
    val source: Int,
    @SerializedName("sub_recipe")
    val subRecipe: Any,
    @SerializedName("tag_id")
    val tagId: Any,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("upc")
    val upc: Any
)

data class AltMeasure(
    @SerializedName("measure")
    val measure: String,
    @SerializedName("qty")
    val qty: Int,
    @SerializedName("seq")
    val seq: Int,
    @SerializedName("serving_weight")
    val servingWeight: Int
)

data class FullNutrient(
    @SerializedName("attr_id")
    val attrId: Int,
    @SerializedName("value")
    val value: Double
)

data class Metadata(
    @SerializedName("is_raw_food")
    val isRawFood: Boolean
)

data class Photo(
    @SerializedName("highres")
    val highres: String,
    @SerializedName("is_user_uploaded")
    val isUserUploaded: Boolean,
    @SerializedName("thumb")
    val thumb: String
)

data class Tags(
    @SerializedName("food_group")
    val foodGroup: Int,
    @SerializedName("item")
    val item: String,
    @SerializedName("measure")
    val measure: Any,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("tag_id")
    val tagId: Int
)