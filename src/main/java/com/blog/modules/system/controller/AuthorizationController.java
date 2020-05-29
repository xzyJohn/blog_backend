package com.blog.modules.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.blog.core.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.blog.modules.system.dto.*;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xzy
 * @date Created in 11:27 2020/5/29
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthorizationController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @PostMapping("/login")
    public R<String> login(AuthUserDto authUser, HttpServletResponse response){
        UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(authUser.getUserName(),authUser.getPassword());
        Authentication authentication =authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =tokenProvider.createToken(authentication);
        response.addHeader("Authorization", "Bearer " + token);
        return R.ok(token);
    }
}
