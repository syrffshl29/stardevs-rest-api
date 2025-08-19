package com.starcodes.tabungin.core.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TargetService<S> {
    public ResponseEntity<Object> save(S s, HttpServletRequest request);//001-010
    public ResponseEntity<Object>delete(Long id, S s, HttpServletRequest request);//011-020
    public ResponseEntity<Object>update(Long id, S s, HttpServletRequest request);//021-030
    public ResponseEntity<Object>findById(Long id, S s, HttpServletRequest request);//031-040
    public ResponseEntity<Object>findAll(Pageable pageable, HttpServletRequest request);//041-050
    public ResponseEntity<Object>findByParam(Pageable pageable,String column, String value, HttpServletRequest request);//051-060
    public ResponseEntity<Object> findByTargetId(Long targetId, HttpServletRequest request);
    public ResponseEntity<Object> findDetailTarget(Long targetId, HttpServletRequest request);

}
