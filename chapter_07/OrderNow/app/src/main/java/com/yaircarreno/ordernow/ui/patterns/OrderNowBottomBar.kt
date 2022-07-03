package com.yaircarreno.ordernow.ui.patterns

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yaircarreno.ordernow.common.navigation.NavigationBarSection
import com.yaircarreno.ordernow.ui.theme.orange

@Composable
fun OrderNowBottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background),
        elevation = 10.dp
    ) {
        NavigationBarSection.sections.forEach { section ->
            val selected =
                currentDestination?.hierarchy?.any {
                    it.route == section.route
                } == true
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = section.icon,
                        contentDescription = stringResource(section.title)
                    )
                },
                label = { Text(text = stringResource(section.title)) },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = orange,
                onClick = {
                    navController.navigate(section.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}