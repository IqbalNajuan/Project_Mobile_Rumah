package com.example.project_mobile

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_mobile.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        setSupportActionBar(binding.toolbarDetail)

        supportActionBar?.apply {
            title = "Detail Produk"
            subtitle = "KaryaKita"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Menerima data dari Intent ketika item diklik di katalog/keranjang
        val title = intent.getStringExtra("EXTRA_TITLE") ?: "KaryaKita"
        val price = intent.getStringExtra("EXTRA_PRICE") ?: ""
        val detail = intent.getStringExtra("EXTRA_DETAIL") ?: ""
        val imageRes = intent.getIntExtra("EXTRA_IMAGE", R.drawable.ekonomi_kreatif)

        binding.tvDetailTitle.text = title
        binding.tvDetailPrice.text = price
        binding.tvDetailDesc.text = detail
        binding.imgDetailProduct.setImageResource(imageRes)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
