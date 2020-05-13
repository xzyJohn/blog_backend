package com.blog.core.utils;

import com.blog.core.exception.BadRequestException;
import com.blog.core.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author xzy
 * @date Created in 10:19 2020/5/12
 */
@Slf4j
public class SecurityUtils {
    /**
     * 获取当前登陆的用户
     * @return
     */
    public static UserDetails getCurrentUser(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"当前登陆状态过期");
        }
        if(authentication.getPrincipal() instanceof UserDetails){
            UserDetails userDetails =(UserDetails) authentication.getPrincipal();
            UserDetailsService userDetailsService = SpringContextHolder.getBean(UserDetailsService.class);
            return userDetailsService.loadUserByUsername(userDetails.getUsername());
        }
        throw new BadRequestException(HttpStatus.UNAUTHORIZED,"找不到当前登陆用户的信息");
    }

    /**
     * 获取当前登陆用户名
     * @return
     */
    public static String getCurrentUserName(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"当前登陆状态过期");
        }
        UserDetails userDetails =(UserDetails)authentication.getPrincipal();
        return userDetails.getUsername();
    }

    public static Long getCurrentUserId(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"当前登陆状态过期");
        }
        if(authentication.getPrincipal() instanceof UserDetails){
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            return securityUser.getId();
        }
        throw new BadRequestException(HttpStatus.UNAUTHORIZED,"找不到当前登陆用户的信息");
    }

}
