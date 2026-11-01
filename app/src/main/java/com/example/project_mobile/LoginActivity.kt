
package com.example.project_mobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.project_mobile.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menangani tombol Enter pada kolom password
        binding.etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.btnLogin.performClick()
                true
            } else {
                false
            }
        }

        // Proses login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            Log.d(
                "CEK_LOGIN",
                "Username terinput: '$username'"
            )

            // Validasi input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this,
                    "Kolom tidak boleh kosong!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Menyimpan status login agar dikenali SplashScreenActivity
            val sharedPref = getSharedPreferences(
                "UserPrefs",
                Context.MODE_PRIVATE
            )

            sharedPref.edit()
                .putBoolean("isLogin", true)
                .putString("username", username)
                .apply()

            Toast.makeText(
                this,
                "Login Berhasil!",
                Toast.LENGTH_SHORT
            ).show()

            // Berpindah ke BaseActivity (yang membungkus Bottom Navigation & Fragment)
            val intent = Intent(
                this@LoginActivity,
                BaseActivity::class.java
            )

            startActivity(intent)
            finish()
        }
    }
}
