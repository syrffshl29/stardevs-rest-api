package com.starcodes.tabungin.core.interfaces;

import com.starcodes.tabungin.model.TargetTabungan;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TargetService<T>{

    public ResponseEntity<Object> save(T t, HttpServletRequest request);//001-010
    public ResponseEntity<Object> delete(Long id, TargetTabungan targetTabungan, HttpServletRequest request);
    public ResponseEntity<Object>update(Long id, T t, HttpServletRequest request);//021-030
    public ResponseEntity<Object>findById(Long id, T t, HttpServletRequest request);//031-040
    public ResponseEntity<Object>findAll(Pageable pageable, HttpServletRequest request);//041-050
    public ResponseEntity<Object>findByParam(Pageable pageable,String column, String value, HttpServletRequest request);//051-060
}

