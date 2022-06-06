package com.davahamka.kinder.common

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")

    // auth screen
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object InformationScreen: Screen("information_screen")
    object UserPreferredScreen: Screen("auth_userpreferred_screen")
    object UserRestrictionScreen: Screen("auth_userrestriction_screen")

    // home screen
    object HomeScreen: Screen("home_screen")

    // mission screen
    object MissionScreen: Screen("mission_screen")

    // message / chat screen
    object MessageScreen: Screen("message_screen")
    object MessageDetailScreen: Screen("message_detail_screen")

    // account screen
    object AccountScreen: Screen("account_screen")

    // donation screen
    object DonateScreen: Screen("donate_screen")
    object CameraScreen: Screen("camera_screen")
    object DescriptionFormScreen: Screen("description_form_screen")
    object DonateMapScreen: Screen("donate_map_screen")
    object DonateConfirmationScreen: Screen("donate_confirmation_screen")
    object DonateConfirmationSecondScreen: Screen("donate_confirmation_second_screen")
    object DonateDetailMapScreen: Screen("donate_detail_map_screen")
    object DonateConfirmationReceiveScreen: Screen("donate_confirmation_receive_screen")
    object SendRateScreen: Screen("send_rate_screen")


    // leaderboard & level screen
    object LeaderboardScreen: Screen("leaderboard_screen")
    object LevelScreen: Screen("level_screen")


    // routing helpers args
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
