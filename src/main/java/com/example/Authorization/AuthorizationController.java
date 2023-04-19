package com.example.Authorization;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthorizationController {
    private final IAuthService authService;

    @PostMapping("/request/uri/webview")
    public ResponseEntity<String> getWebView(@Valid @RequestBody HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authService.getWebView( httpServletRequest));
    }
}
