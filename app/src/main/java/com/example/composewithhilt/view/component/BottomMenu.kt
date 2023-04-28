package com.example.composewithhilt.view.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payments
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.composewithhilt.view.Routes

@Composable
fun BottomMenu(navController: NavController) {
    val menuItemList = prepareBottomMenu()
    var selectedItem = remember { mutableStateOf("Home") }

    Box(modifier = Modifier.fillMaxSize()) {
        BottomNavigation(
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
        ) {
            menuItemList.forEach { item ->
                BottomNavigationItem(
                    selected = selectedItem.value == item.label,
                    onClick = {
                        selectedItem.value = item.label
                        if (navController.currentDestination?.route != item.route.route){
                            navController.navigate(item.route.route)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.Icon,
                            contentDescription = item.label
                        )
                    },
                    label = {
                        Text(text = item.label)
                    },
                    enabled = true
                )
            }
        }
    }
}

private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItem = mutableListOf<BottomMenuItem>()

    // 新增bottomMenuItem
    bottomMenuItem.add(BottomMenuItem("Home", Icons.Default.Home, Routes.Home))
    bottomMenuItem.add(BottomMenuItem("Income", Icons.Default.AccountBalance, Routes.Income))
    bottomMenuItem.add(BottomMenuItem("Pay Out", Icons.Default.Payments, Routes.PayOut))

    return bottomMenuItem
}

data class BottomMenuItem(val label: String, val Icon: ImageVector, val route: Routes)