package com.example.Authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/request/uri/webview")
    public ResponseEntity<String> getWebView() {
        return ResponseEntity.ok(authService.getWebView());
    }
}
