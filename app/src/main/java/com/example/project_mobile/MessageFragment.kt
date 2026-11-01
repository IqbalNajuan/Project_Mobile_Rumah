package com.example.project_mobile.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project_mobile.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Ibu Sari - Bali", "Pesanan tas anyaman rotan sedang kami proses ya kak, mohon ditunggu.", "https://avatar.iran.liara.run/public/1", "09:15"),
        MessageModel("Bapak Jajang - Garut", "Sepatu kulitnya sisa ukuran 42, Kak. Apakah mau dikirim hari ini?", "https://avatar.iran.liara.run/public/11", "08:30"),
        MessageModel("Toko Batik Rahayu", "Terima kasih sudah mendukung karya lokal UMKM kami!", "https://avatar.iran.liara.run/public/3", "Kemarin"),
        MessageModel("Admin KaryaKita", "Selamat datang di KaryaKita! Lengkapi profil Anda untuk mulai berbelanja.", "https://avatar.iran.liara.run/public/4", "Senin")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Profil & Pesan"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}