package com.starcodes.tabungin.security;

import java.util.function.Function;

public class BcryptImpl {

    private static final BcryptCustom bcrypt = new BcryptCustom(11);

    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public static boolean verifyAndUpdateHash(String password,
                                              String hash,
                                              Function<String, Boolean> updateFunc) {
        return bcrypt.verifyAndUpdateHash(password, hash, updateFunc);
    }

    public static boolean verifyHash(String password , String hash)
    {
        return bcrypt.verifyHash(password,hash);
    }
    
    public static void main(String[] args) {
        String strUserName = "Syarifaf29";
        String hashKeDB = hash(strUserName);
        System.out.println("Ini Hash Ke DB: " + hashKeDB);
//        $2a$11$dXF2PV0L.onwqGfUDia9QOC4rxhCo88u1VDRneuLUuQm9FdoOAdRi
//        $2a$11$TDEJ8tAYRNTQCtGNbqO28.h83zAIRsFz2D/4ETj0uwaooDAKzsLYS
//        $2a$11$wdJcjTms4SsYcXu5RgXyTuytxqh.cRBldk9WYGVQ2FbZjIlMDUNr6
        System.out.println("Compare Hash 1 : "+verifyHash("Syarifaf29","$2a$11$dXF2PV0L.onwqGfUDia9QOC4rxhCo88u1VDRneuLUuQm9FdoOAdRi"));
        System.out.println("Compare Hash 2 : "+verifyHash("Syarifaf29","$2a$11$TDEJ8tAYRNTQCtGNbqO28.h83zAIRsFz2D/4ETj0uwaooDAKzsLYS"));
        System.out.println("Compare Hash 3 : "+verifyHash("Syarifaf29","$2a$11$wdJcjTms4SsYcXu5RgXyTuytxqh.cRBldk9WYGVQ2FbZjIlMDUNr6"));

    }
}