package com.example.bmiviewmodel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmiviewmodel.ui.theme.BmiViewModelTheme
import com.example.bmiviewmodel.viewmodel.BmiViewmodel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiViewModelTheme {
                    MyApp()
            }
        }
    }
}

@Composable
fun MyApp(viewModel: BmiViewmodel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text="Bmi calculator",
            modifier = Modifier.align(Alignment.CenterHorizontally).padding( top = 8.dp, bottom = 8.dp ),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary
        )
        OutlinedTextField(
            value = viewModel.height,
            onValueChange = {
                viewModel.height = it
                viewModel.calculateBMI()
                            },
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.weight,
            onValueChange = {
                viewModel.weight = it
                viewModel.calculateBMI()
                            },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        viewModel.bmi?.let {
            Text("Your bmi is %.1f".format(it), style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BmiViewModelTheme {
        MyApp()
    }
}