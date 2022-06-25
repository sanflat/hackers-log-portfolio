package com.example.hackerslog.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * ユーザの認証の状態を参照する処理を記載するクラス
 */
@Component
public class UserAuthClass {

    public static void getAuthModelAttribute(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("USER"));
        if(hasUserRole) {
            String userName = auth.getName();
            model.addAttribute("userName", userName);
            model.addAttribute("isSignIn", true);
        }else {
            model.addAttribute("isSignIn", false);
        }
    }
}
