package com.example.project_mobile.More

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project_mobile.DetailActivity
import com.example.project_mobile.ProductAdapter
import com.example.project_mobile.ProductItem
import com.example.project_mobile.R
import com.example.project_mobile.databinding.FragmentMoreBinding
import com.google.android.material.chip.ChipGroup

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val allProducts = listOf(
        ProductItem("Tas Anyaman Rotan", "Kerajinan", "Rp 150.000", R.drawable.tasanyaman_rotan),
        ProductItem("Sepatu Kulit Garut", "Fashion", "Rp 350.000", R.drawable.sepatukulit_garut),
        ProductItem("Kain Tenun NTT", "Fashion", "Rp 500.000", R.drawable.kain_tenun_ntt),
        ProductItem("Batik Tulis Pekalongan", "Fashion", "Rp 250.000", R.drawable.batiktulis_pakalongan),
        ProductItem("Keramik Kasongan", "Dekorasi", "Rp 120.000", R.drawable.keramik_kasongan),
        ProductItem("Patung Kayu Jepara", "Kerajinan", "Rp 850.000", R.drawable.patungkayu_jepara),
        ProductItem("Tas Eceng Gondok", "Kerajinan", "Rp 95.000", R.drawable.tas_eceng_gondok),
        ProductItem("Perhiasan Perak Celuk", "Kerajinan", "Rp 450.000", R.drawable.perak_celuk)
    )

    private val displayedProducts = mutableListOf<ProductItem>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val headerView = layoutInflater.inflate(R.layout.header_catalog, binding.listViewItems, false)
        binding.listViewItems.addHeaderView(headerView, null, false)

        val tvGreeting = headerView.findViewById<TextView>(R.id.tvGreeting)
        val sharedPref = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Iqbal")
        tvGreeting.text = "Halo, $username!"

        displayedProducts.clear()
        displayedProducts.addAll(allProducts)
        productAdapter = ProductAdapter(requireContext(), displayedProducts)
        binding.listViewItems.adapter = productAdapter

        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val headerCount = binding.listViewItems.headerViewsCount
            if (position >= headerCount) {
                val selected = displayedProducts[position - headerCount]
                val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                    putExtra("EXTRA_TITLE", selected.title)
                    putExtra("EXTRA_PRICE", selected.price)
                    putExtra("EXTRA_DETAIL", "${selected.title}\nKategori: ${selected.category}\nHarga: ${selected.price}\n\nProduk kerajinan dan karya kreatif unggulan dari sektor ekonomi kreatif Indonesia.")
                    putExtra("EXTRA_IMAGE", selected.imageResId)
                }
                startActivity(intent)
            }
        }

        val chipGroup = headerView.findViewById<ChipGroup>(R.id.chipGroupCategory)
        chipGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.chipAll -> filterCategory("Semua")
                R.id.chipKerajinan -> filterCategory("Kerajinan")
                R.id.chipFashion -> filterCategory("Fashion")
                R.id.chipDekorasi -> filterCategory("Dekorasi")
                else -> filterCategory("Semua")
            }
        }
    }

    private fun filterCategory(category: String) {
        displayedProducts.clear()
        if (category.equals("Semua", ignoreCase = true)) {
            displayedProducts.addAll(allProducts)
        } else {
            for (item in allProducts) {
                if (item.category.equals(category, ignoreCase = true)) {
                    displayedProducts.add(item)
                }
            }
        }
        productAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
