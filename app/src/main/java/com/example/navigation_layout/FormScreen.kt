package com.example.navigation_layout.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation_layout.ui.theme.NavigasiLayoutTheme

// Mengubah FormTextField agar terlihat seperti kartu dengan background putih
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
                text = value, // Menampilkan nilai yang sudah ada sebagai teks, bukan TextField input
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black // Warna teks input hitam
            )
            // Jika ini seharusnya bisa diedit, kita akan memakai TextField,
            // tetapi di gambar ini terlihat seperti tampilan data, bukan input
            // Contoh untuk input:
            // TextField(
            //     value = value,
            //     onValueChange = onValueChange,
            //     modifier = Modifier.fillMaxWidth(),
            //     colors = TextFieldDefaults.textFieldColors(
            //         containerColor = Color.Transparent, // Tanpa latar belakang TextField
            //         focusedIndicatorColor = Color.Transparent, // Hapus garis bawah saat fokus
            //         unfocusedIndicatorColor = Color.Transparent // Hapus garis bawah
            //     ),
            //     textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
            // )
        }
    }
}


@Composable
fun FormScreen(onNavigateHome: () -> Unit, onNavigateToFormPendaftaran: () -> Unit) { // Mengubah onNavigateBack menjadi onNavigateHome dan menambah onNavigateToFormPendaftaran
    // State untuk input field, diisi dengan contoh data seperti di gambar
    var namaLengkap by remember { mutableStateOf("Muhammad Array Al-Khozini") }
    var jenisKelamin by remember { mutableStateOf("Laki-laki") }
    var statusPerkawinan by remember { mutableStateOf("Lajang") }
    var alamat by remember { mutableStateOf("Kediri") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F5F5) // Latar belakang abu-abu sangat terang
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp), // Padding yang lebih besar
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Judul
            Text(
                text = "List Daftar Peserta",
                fontSize = 28.sp, // Ukuran font lebih besar
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C), // Warna ungu gelap
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
                    .align(Alignment.Start) // Judul rata kiri
            )

            // Input fields (sekarang sebagai tampilan data di kartu)
            FormTextField(label = "NAMA LENGKAP", value = namaLengkap, onValueChange = { namaLengkap = it })
            FormTextField(label = "JENIS KELAMIN", value = jenisKelamin, onValueChange = { jenisKelamin = it })
            FormTextField(label = "STATUS PERKAWINAN", value = statusPerkawinan, onValueChange = { statusPerkawinan = it })
            FormTextField(label = "ALAMAT", value = alamat, onValueChange = { alamat = it })

            Spacer(modifier = Modifier.weight(1f)) // Mengambil sisa ruang

            // Tombol "Beranda"
            Button(
                onClick = onNavigateHome, // Aksi untuk kembali ke beranda
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp) // Tinggi tombol
                    .clip(RoundedCornerShape(12.dp)), // Sudut membulat
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4)), // Warna ungu gelap
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp) // Sedikit efek elevasi
            ) {
                Text(text = "Beranda", color = Color.White, fontSize = 18.sp) // Warna teks putih
            }

            Spacer(modifier = Modifier.height(16.dp)) // Jarak antar tombol

            // Tombol "Formulir Pendaftaran"
            Button(
                onClick = onNavigateToFormPendaftaran, // Aksi untuk formulir pendaftaran
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp) // Tinggi tombol
                    .clip(RoundedCornerShape(12.dp)), // Sudut membulat
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4)), // Warna ungu gelap
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text(text = "Formulir Pendaftaran", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=360dp,height=720dp,dpi=480") // Memperbarui preview device
@Composable
fun FormScreenPreview() {
    NavigasiLayoutTheme {
        FormScreen(onNavigateHome = {}, onNavigateToFormPendaftaran = {})
    }
}