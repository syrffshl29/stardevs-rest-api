package com.starcodes.tabungin.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoginDto {


    /** Ini adalah regex gabungan dari 3 regex email, username dan no hp
     * karena pada saat login user dapat memasukkan salah satu dari ketiga format tersebut
     * maka regex nya juga dibuat sedemikian rupa
     */
    @NotNull(message = "Username Tidak Boleh Null")
    @Pattern(regexp = "^(?=.{1,256})(?=.{1,64}@.{1,255}$)(?:(?![.])[a-zA-Z0-9._%+-]+(?:(?<!\\\\)[.][a-zA-Z0-9-]+)*?)@[a-zA-Z0-9.-]+(?:\\.[a-zA-Z]{2,50})+$|^([a-z0-9\\.]{8,16})$|^(62|\\+62|0)8[0-9]{9,13}$$",message = "Username Tidak Valid")
    private String username;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@_#\\-$])[\\w].{8,15}$",
            message = "Format Password Tidak Valid")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	//input login
}
