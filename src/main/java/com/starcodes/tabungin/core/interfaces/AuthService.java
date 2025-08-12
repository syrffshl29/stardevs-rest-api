package com.starcodes.tabungin.core.interfaces;

import com.starcodes.tabungin.dto.validation.RegisterDto;
import com.starcodes.tabungin.model.User;

public interface AuthService {
    User register(RegisterDto dto);
}
