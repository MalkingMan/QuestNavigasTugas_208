// GANTI SELURUH ISI FILE FormScreen.kt DENGAN KODE INI

package com.example.navigation_layout.form // Pastikan package ini benar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// Pastikan ini adalah nama Theme Anda setelah di-refactor
import com.example.navigation_layout.ui.theme.NavigasiLayoutTheme

// Fungsi FormTextField ini sudah benar, tidak perlu diubah.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp), // Sedikit padding vertikal antar kartu
        shape = RoundedCornerShape(8.dp), // Sudut membulat
        colors = CardDefaults.cardColors(containerColor = Color.White) // Latar belakang putih
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = label,
                fontSize = 14.sp,
                color = Color.Gray // Warna label sedikit abu-abu
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value, // Menampilkan nilai yang sudah ada sebagai teks
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black // Warna teks input hitam
            )
        }
    }
}


@Composable
fun FormScreen(onNavigateHome: () -> Unit, onNavigateToFormPendaftaran: () -> Unit) {
    // State untuk input field
    var namaLengkap by remember { mutableStateOf("Muhammad Array Al-Khozini") }
    var jenisKelamin by remember { mutableStateOf("Laki-laki") }
    var statusPerkawinan by remember { mutableStateOf("Lajang") }
    var alamat by remember { mutableStateOf("Kediri") }

    // Mendefinisikan warna dari gambar (sesuai dengan file Anda)
    // Warna ungu tua untuk header dan tombol
    val headerColor = Color(0xFF6750A4)
    // Warna ungu muda untuk latar belakang konten
    val backgroundColor = Color(0xFFEADDFF)
    // Warna putih untuk teks di header
    val titleColor = Color.White

    // --- Layout Baru Dimulai Di Sini ---

    Column(
        modifier = Modifier
            .fillMaxSize()
            // Terapkan warna latar belakang ungu muda ke seluruh layar
            .background(backgroundColor)
    ) {
        // 1. Header Ungu
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerColor)
                .padding(top = 64.dp, bottom = 32.dp, start = 24.dp, end = 24.dp), // Padding Top dinaikkan
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "List Daftar Peserta",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = titleColor // Teks warna putih
            )
        }

        // 2. Konten (Kartu dan Tombol)
        Column(
            modifier = Modifier
                .fillMaxSize() // Isi sisa ruang
                // Padding untuk area konten
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Kartu Tampilan Data
            FormTextField(label = "NAMA LENGKAP", value = namaLengkap, onValueChange = { namaLengkap = it })
            FormTextField(label = "JENIS KELAMIN", value = jenisKelamin, onValueChange = { jenisKelamin = it })
            FormTextField(label = "STATUS PERKAWINAN", value = statusPerkawinan, onValueChange = { statusPerkawinan = it })
            FormTextField(label = "ALAMAT", value = alamat, onValueChange = { alamat = it })

            // Spacer untuk mendorong tombol ke bawah
            Spacer(modifier = Modifier.weight(1f))

            // Tombol "Beranda"
            Button(
                onClick = onNavigateHome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                // Gunakan 'shape' untuk sudut membulat
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = headerColor), // Warna ungu tua
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text(text = "Beranda", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp)) // Jarak antar tombol

            // Tombol "Formulir Pendaftaran"
            Button(
                onClick = onNavigateToFormPendaftaran,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = headerColor), // Warna ungu tua
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text(text = "Formulir Pendaftaran", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}


// Fungsi Preview ini sudah benar, tidak perlu diubah.
@Preview(showBackground = true, device = "spec:width=360dp,height=720dp,dpi=480")
@Composable
fun FormScreenPreview() {
    NavigasiLayoutTheme {
        FormScreen(onNavigateHome = {}, onNavigateToFormPendaftaran = {})
    }
}