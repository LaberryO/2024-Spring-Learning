package com.laberry.junior.util;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @GetMapping("/debug/auth")
    public ResponseEntity<String> getAuthenticationInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null) {
            return ResponseEntity.ok("로그인 상태: " + auth.isAuthenticated() +
                                     ", 사용자: " + auth.getName() +
                                     ", 권한: " + auth.getAuthorities());
        }
        return ResponseEntity.ok("로그인 정보 없음");
    }
}
