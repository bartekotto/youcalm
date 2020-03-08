package com.example.youcalm.ui.login

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.youcalm.MainActivity
import com.example.youcalm.R


class FingerprintAuth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_fingerprint_auth)
        val fLabel = findViewById<TextView>(R.id.authText)
        val fImage =
            findViewById<View>(R.id.authLogo) as ImageView
        fImage.setOnClickListener(View.OnClickListener {
            if (fLabel.text == "Touch to continue") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("key", "Kotlin")
                startActivity(intent)
            }

        })
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            val fingerprintManager =
                getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager

            if (!fingerprintManager.isHardwareDetected) {
                fLabel.text = "No fingerprint hardware detected"
            } else if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.USE_FINGERPRINT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.USE_FINGERPRINT),
                    1
                )
                onRequestPermissionsResult(
                    1, arrayOf(Manifest.permission.USE_FINGERPRINT), IntArray(
                        ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.USE_FINGERPRINT
                        )
                    )
                );
            } else if (!keyguardManager.isDeviceSecure || !fingerprintManager.hasEnrolledFingerprints()) {
                fLabel.text = "Configure lock in settings"
            } else {
                fLabel.text = "place finger on scanner"
                val fingerprintHandler = FingerprintHandler(this)
                fingerprintHandler.startAuth(fingerprintManager, null)
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                } else {

                }
                return
            }
            else -> {
            }
        }
    }
}

