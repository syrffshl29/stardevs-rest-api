package com.starcodes.tabungin.util;

import com.starcodes.tabungin.handler.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResponse {

    public static ResponseEntity<Object> dataBerhasilDisimpan(HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED, null, null, request);
    }
    public static ResponseEntity<Object> dataBerhasilDiubah(HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Data Berhasil Diubah", HttpStatus.OK, null, null, request);
    }
    public static ResponseEntity<Object> dataBerhasilDihapus(HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Data Berhasil Dihapus", HttpStatus.OK, null, null, request);
    }
    public static ResponseEntity<Object> internalServerError(String errorCode, HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null, errorCode, request);
    }
    public static ResponseEntity<Object> objectNull(String errorCode, HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST, null, errorCode, request);
    }
    public static ResponseEntity<Object> dataDitemukan(Object data, HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Data Berhasil Ditemukan", HttpStatus.OK, data,null, request);
    }
    public static ResponseEntity<Object> dataTidakDitemukan(String errorCode, HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST, null, errorCode, request);
    }

}