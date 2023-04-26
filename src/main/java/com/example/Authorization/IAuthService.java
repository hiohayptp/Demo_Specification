package com.example.Authorization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IAuthService {
    public String getWebView() {
        String token = JWTUtils.getToken();
        if (token.isEmpty()) {
            log.info("token ís null");
        }
        return token;
    }
}
