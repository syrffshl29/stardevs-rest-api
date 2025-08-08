package com.starcodes.tabungin.security;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESLightEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

/**
 * Class implementasi fungsional enkripsi dengan Algoritma AES
 */
public class Crypto {

//    private static final String defaultKey = "4d05ac36ce72f080dc9e29af7d03bf0dd15a530305415c811a6a64767108145d";
//    private static final String defaultKey = "7cf79176bfc48d17ea3c84d26399404244a4f0d3d3e2d8c01d5a6d9b37bbf7e8";
    private static final String defaultKey = "c821e3b10f8e50cc20b199964c868a2bdc6b4c553ce16588c1da4339a7321fad";

    public static String performEncrypt(String keyText, String plainText) {
        try{
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] ptBytes = plainText.getBytes();
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(true, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
            int oLen = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(Hex.encode(rv));
        } catch(Exception e) {
            return "Error";
        }
    }

    public static String performEncrypt(String cryptoText) {
        return performEncrypt(defaultKey, cryptoText);
    }

    public static String performDecrypt(String keyText, String cryptoText) {
        try {
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] cipherText = Hex.decode(cryptoText.getBytes());
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(false, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
            int oLen = cipher.processBytes(cipherText, 0, cipherText.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(rv).trim();
        } catch(Exception e) {
            return "Error";
        }
    }

    public static String performDecrypt(String cryptoText) {
        return performDecrypt(defaultKey, cryptoText);
    }

    public static void main(String[] args) {
        String strToEncryptEmail = "syarifaf29@gmail.com";//put text to encrypt in here
        System.out.println("Encryption Result : "+performEncrypt(strToEncryptEmail));

        String strToDecryptEmail = "2fab4e4115647e1b08bc0a4e6ecc3feb703862865f7a41afe9c535e0c2a18e3b";//put text to decrypt in here
        System.out.println("Decryption Result : "+performDecrypt(strToDecryptEmail));

        String strToEncryptPassword = "ZeusLight29.";//put text to encrypt in here
        System.out.println("Encryption Result : "+performEncrypt(strToEncryptPassword));

        String strToDecryptPassword = "ee32ddd4d048d535cf95c323430ce3c9";//put text to decrypt in here
        System.out.println("Decryption Result : "+performDecrypt(strToDecryptPassword));

    }

}