package com.mramallo.cryptotrackerapp.core.domain.util

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object CryptoHelper {

    fun decrypt(
        encryptedText: String
    ): String {
        try {
            // Parameters configuration
            val secretKey = "aesEncryptionKey"
            val keyBytes = secretKey.toByteArray(Charsets.UTF_8)

            // Create IV for CBC mode
            val iv = ByteArray(16) // By default

            // Decode encrypted text
            val encryptedBytes = Base64.decode(encryptedText, Base64.DEFAULT)

            // Create secret key and IV
            val secretKeySpec = SecretKeySpec(keyBytes, "AES")
            val ivParameterSpec = IvParameterSpec(iv)

            // Cipher configuration
            val cipher = Cipher.getInstance("AES/CBC/NoPadding")
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)

            // Decrypt
            val decryptedBytes = cipher.doFinal(encryptedBytes)

            // Convert to string decrypted text
            return String(decryptedBytes, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Decrypt error: ${e.message}")
        }
    }

}