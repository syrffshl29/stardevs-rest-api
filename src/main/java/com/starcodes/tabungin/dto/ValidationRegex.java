package com.starcodes.tabungin.dto;

public class ValidationRegex {
	//class untuk menyimpan pola regex validasi
	public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
	public static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,20}$";
	public static final String PHONE_NUMBER_REGEX = "^\\+?[0-9]{10,15}$";
}
