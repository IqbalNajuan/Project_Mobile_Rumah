package com.example.project_mobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.project_mobile.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    private val tutorialSteps = listOf(
        TutorialStep(
            "1. Eksplorasi Karya Lokal",
            "Temukan produk kriya, tenun, batik, dan kerajinan tangan terbaik buatan pengrajin UMKM Indonesia.",
            android.R.drawable.ic_menu_compass,
            "Halaman 1 dari 3"
        ),
        TutorialStep(
            "2. Kenali Kisah Pengrajin",
            "Pelajari kisah di balik pembuatan karya, material ramah lingkungan, dan daerah asal pengrajin lokal.",
            android.R.drawable.ic_menu_info_details,
            "Halaman 2 dari 3"
        ),
        TutorialStep(
            "3. Transaksi & Dukung UMKM",
            "Pilih karya favorit Anda, tambahkan ke keranjang, dan lakukan transaksi mandiri dengan mudah.",
            android.R.drawable.ic_menu_add,
            "Halaman 3 dari 3"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarTutorial)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Panduan Aplikasi"

        val adapter = TutorialAdapter(tutorialSteps)
        binding.viewPagerTutorial.adapter = adapter

        val navigateToNextApp = {
            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)
            val target = if (isLogin) BaseActivity::class.java else LoginActivity::class.java
            startActivity(Intent(this, target))
            finish()
        }

        binding.toolbarTutorial.setNavigationOnClickListener {
            if (binding.viewPagerTutorial.currentItem > 0) {
                binding.viewPagerTutorial.currentItem = binding.viewPagerTutorial.currentItem - 1
            } else {
                navigateToNextApp()
            }
        }

        binding.viewPagerTutorial.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    binding.btnPrev.visibility = View.INVISIBLE
                } else {
                    binding.btnPrev.visibility = View.VISIBLE
                }

                if (position == tutorialSteps.size - 1) {
                    binding.btnNext.text = "Mulai Jelajahi KaryaKita"
                } else {
                    binding.btnNext.text = "Lanjut"
                }
            }
        })

        binding.btnPrev.setOnClickListener {
            val current = binding.viewPagerTutorial.currentItem
            if (current > 0) {
                binding.viewPagerTutorial.currentItem = current - 1
            }
        }

        binding.btnNext.setOnClickListener {
            val current = binding.viewPagerTutorial.currentItem
            if (current < tutorialSteps.size - 1) {
                binding.viewPagerTutorial.currentItem = current + 1
            } else {
                navigateToNextApp()
            }
        }
    }
}
