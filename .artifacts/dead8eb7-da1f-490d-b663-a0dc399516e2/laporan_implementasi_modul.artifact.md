# LAPORAN PRAKTIKUM PEMROGRAMAN MOBILE
## Implementasi Komponen UI Lanjutan (Chip Group, Header Wave, GridLayout, dan Tutorial Screen)
### Proyek: KaryaKita (Marketplace Ekonomi Kreatif Indonesia)

---

## 1. PENDAHULUAN
Aplikasi **KaryaKita** adalah aplikasi mobile *e-commerce* berbasis marketplace yang dirancang khusus untuk mendukung, mempromosikan, dan menjual produk-produk dari sektor Ekonomi Kreatif Indonesia (kerajinan tangan, seni, kain tradisional, dan kriya dari pengrajin lokal).

Pada tahap pengembangan ini, dilakukan penambahan dan penyempurnaan komponen antarmuka (*User Interface*) tingkat lanjut berdasarkan modul praktikum, yang meliputi:
1. **`bg_header_wave`**: Desain latar belakang header bergelombang (*wave*) menggunakan Vector Drawable.
2. **Chip Group**: Komponen Material Design untuk filter kategori produk yang interaktif dan modern.
3. **GridLayout & Tutorial Screen**: Layar panduan penggunaan aplikasi (*onboarding/tutorial*) yang menampilkan fitur-fitur utama KaryaKita dalam bentuk tata letak kisi (*Grid*).

---

## 2. IMPLEMENTASI KOMPONEN

### A. Background Header Wave (`bg_header_wave.xml`)
Komponen ini dibuat untuk mempercantik bagian atas header halaman utama dan katalog dengan kurva bergelombang khas desain modern.
* **Lokasi File:** `app/src/main/res/drawable/bg_header_wave.xml`
* **Penjelasan Kode:** Menggunakan format XML Vector Drawable dengan path SVG untuk membentuk kurva lengkung estetis berwarna hijau tua (*forest green*) yang melambangkan identitas alam dan produk lokal.

### B. Chip Group (`ChipGroup` & `Chip`)
Pengganti tombol kategori biasa menjadi komponen Material Design *Chip* yang mendukung pemilihan tunggal (*single selection*) dan status *checked*.
* **Penerapan:** Ditempatkan di halaman katalog (*MoreFragment / header_catalog.xml*) untuk menyaring produk berdasarkan kategori (Semua, Kerajinan, Fashion, Dekorasi).
* **Penjelasan Kode:** Menggunakan `<com.google.android.material.chip.ChipGroup>` dengan gaya pilihan (`style="@style/Widget.MaterialComponents.Chip.Choice"`).

### C. GridLayout & Tutorial Screen
Layar tutorial dipersembahkan untuk pengguna baru (*onboarding*) guna menjelaskan cara kerja aplikasi KaryaKita dalam mendukung kreator lokal.
* **Tata Letak (Layout):** Menggunakan `<androidx.gridlayout.widget.GridLayout>` (atau LinearLayout berstruktur grid) untuk menyusun menu/langkah panduan secara rapi dalam bentuk kolom dan baris.
* **Fitur Tutorial:** Menjelaskan 3 langkah utama:
  1. Autentikasi & Login Akun.
  2. Eksplorasi Katalog Produk UMKM Lokal.
  3. Transaksi Mandiri (Keranjang & Checkout).

---

## 3. KESIMPULAN
Penerapan komponen lanjutan seperti *Chip Group*, *Header Wave*, *GridLayout*, dan *Tutorial Screen* berhasil diintegrasikan ke dalam aplikasi **KaryaKita**. Seluruh komponen selaras dengan tema ekonomi kreatif, meningkatkan estetika visual (*user experience*), serta memenuhi seluruh persyaratan modul praktikum.
