package com.example.composewithhilt.view.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.composewithhilt.viewmodel.PayOutViewModel

@Composable
fun PayOutPage(viewModel: PayOutViewModel) {

    val item = viewModel.item.collectAsState()
    val inputIncome = remember { mutableStateOf(0) }
    val focusManager = LocalFocusManager.current

    item.value.let {
        if (it.id != 0) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = inputIncome.value.toString(),
                    onValueChange = {

                        if (it.any { c -> !c.isDigit() }) {
                            return@TextField
                        }
                        if (it.isEmpty() || it == "0") {
                            inputIncome.value = 0
                            return@TextField
                        }
                        Log.i("Arvin-log", it)
                        if (it.startsWith("0")) {
                            inputIncome.value = it.substring(1).toInt()
                        } else {
                            inputIncome.value = it.toInt()
                        }
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }),
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = {
                        viewModel.addPayOut(inputIncome.value)
                        inputIncome.value = 0
                    }
                ) {
                    Text(text = "新增支出")
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Color.Red
                )
            }
        }
    }
}