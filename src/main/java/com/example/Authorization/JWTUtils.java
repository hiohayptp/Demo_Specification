package com.example.Authorization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class JWTUtils {
    public static String getToken() {
        try {
            HttpServletRequest request;
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (servletRequestAttributes != null) {
                request = servletRequestAttributes.getRequest();
                var authorization = request.getHeader("Authorization");
                return ObjectUtils.isNotEmpty(authorization) ? authorization.replace("Bearer ", "") : "";
            } else {
                return "";
            }

        } catch (Exception e) {
            return "";
        }
    }
}
