package com.example.Authorization;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class IAuthService {
    public String getWebView(HttpServletRequest httpServletRequest) {
        String token = JWTUtils.getToken();
        if (ObjectUtils.isEmpty(token)) {
            throw new ApplicationException(HttpStatusEnums.ACCOUNT_ERROR.getMessage(),
                    HttpStatusEnums.ACCOUNT_ERROR.getCode(), null);
        }
    }
}
