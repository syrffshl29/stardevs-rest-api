package com.starcodes.tabungin.core.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TransaksiTabunganService <D>{
    public ResponseEntity<Object>save(D d, HttpServletRequest request);//001-010
    public ResponseEntity<Object>delete(Long id, D d, HttpServletRequest request);//011-020
    public ResponseEntity<Object>update(Long id, D d, HttpServletRequest request);//021-030
    public ResponseEntity<Object>findById(Long id, D d, HttpServletRequest request);//031-040
    public ResponseEntity<Object>findAll(Pageable pageable, HttpServletRequest request);//041-050
    public ResponseEntity<Object>findByParam(Pageable pageable,String column, String value, HttpServletRequest request);//051-060
    public ResponseEntity<Object> findByTargetId(Long targetId, HttpServletRequest request);
}

