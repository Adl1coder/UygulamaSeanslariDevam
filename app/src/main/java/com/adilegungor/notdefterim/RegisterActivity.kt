package com.adilegungor.notdefterim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.adilegungor.notdefterim.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtMailInput.addTextChangedListener {
            val text = it?.toString()?.trim()
            if (text.isNullOrEmpty()) {
                // remove error message
                binding.edtMail.error = null

            } else {
                // set error message
                binding.edtMail.error = getString(R.string.error)
            }
        }

        binding.btnEmailSignIn.setOnClickListener {
            when (binding.edtMailInput.text?.length) {
                in 2..4 -> binding.edtMail.error = "Daha fazla karakter giriniz"
                // edit
                in 15..25 -> binding.edtMail.error = "Daha az karakter giriniz"
            }
        }

        binding.edtMail.addOnEditTextAttachedListener {
            binding.edtMail.error = null
        }

        binding.btnEmailSignIn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}