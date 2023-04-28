package com.example.composewithhilt.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.composewithhilt.viewmodel.HomeViewModel

@Composable
fun HomePage(viewModel: HomeViewModel) {
    val current = viewModel.currentKeepBook.collectAsState()
    val total = current.value.income - current.value.payOut

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "收入：${current.value.income}", fontSize = 35.sp, color = Color.Blue)
        Text(text = "支出：${current.value.payOut}", fontSize = 35.sp, color = Color.Red)
        Text(
            text = "目前總額：${total}",
            fontSize = 45.sp,
            color = if (total >= 0) Color.Green else Color.Red
        )
    }

}