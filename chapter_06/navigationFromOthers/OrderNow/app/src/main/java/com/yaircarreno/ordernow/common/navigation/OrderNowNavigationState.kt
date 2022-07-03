package com.yaircarreno.ordernow.common.navigation

import com.yaircarreno.ordernow.main.OrderNowState

fun OrderNowState.popUp() {
    navController.popBackStack()
}

fun OrderNowState.navigate(route: String) {
    navController.navigate(route) {
        launchSingleTop = true
    }
}

fun OrderNowState.navigateAndPopUp(route: String, popUp: String) {
    navController.navigate(route) {
        launchSingleTop = true
        popUpTo(popUp) { inclusive = true }
    }
}

fun OrderNowState.navigateSaved(route: String, popUp: String) {
    navController.navigate(route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(popUp) { saveState = true }
    }
}

fun OrderNowState.clearAndNavigate(route: String) {
    navController.navigate(route) {
        launchSingleTop = true
        popUpTo(0) { inclusive = true }
    }
}