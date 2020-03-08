package com.example.youcalm.ui.login

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.hardware.fingerprint.FingerprintManager
import android.os.CancellationSignal
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.youcalm.R


class FingerprintHandler(val context: Context) : FingerprintManager.AuthenticationCallback() {

    fun startAuth(
        fingerprintManager: FingerprintManager,
        cryptoObject: FingerprintManager.CryptoObject?
    ) {
        val cancellationSignal = CancellationSignal()
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null)
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        super.onAuthenticationError(errorCode, errString)
        this.update("FingerPrint Error", false)
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        this.update("Fingerprint unrecognized", false)
    }

    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult?) {
        super.onAuthenticationSucceeded(result)
        this.update("Touch to continue", true)
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
        super.onAuthenticationHelp(helpCode, helpString)
        this.update("Error" + helpString, false)
    }

    private fun update(message: String, authResult: Boolean) {
        val fLabel =
            (context as Activity).findViewById<View>(R.id.authText) as TextView
        val fImage =
            (context).findViewById<View>(R.id.authLogo) as ImageView
        fLabel.text = message
        if (!authResult) {
            fLabel.setTextColor(Color.RED)
        } else {
            fLabel.setTextColor(Color.GREEN)
            fImage.setImageResource(R.drawable.done_foreground)
        }
    }
}
