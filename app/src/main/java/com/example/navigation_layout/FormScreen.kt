package com.example.navigation_layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation_layout.ui.theme.PercobaanTheme

@Composable
fun FormScreen(onNavigateBack: () -> Unit) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFEADDFF)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
    }
        Text(
            text = "List Daftar Peserta",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A148C), // Darker purple for text
            modifier = Modifier.padding(bottom = 32.dp)
        )
        FormTextField(label = "NAMA LENGKAP", value = namaLengkap, onValueChange = { namaLengkap = it })
        Spacer(modifier = Modifier.height(16.dp))
        FormTextField(label = "JENIS KELAMIN", value = jenisKelamin, onValueChange = { jenisKelamin = it })
        Spacer(modifier = Modifier.height(16.dp))
        FormTextField(label = "STATUS PERKAWINAN", value = statusPerkawinan, onValueChange = { statusPerkawinan = it })
        Spacer(modifier = Modifier.height(16.dp))
        FormTextField(label = "ALAMAT", value = alamat, onValueChange = { alamat = it })

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNavigateBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4)) // Purple color for the button
        ) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun FormTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color(0xFF6750A4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp)
        )
    }
}