package com.blog.core.security;

import com.blog.modules.system.entity.User;
import com.blog.modules.system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xzy
 * @date Created in 9:09 2020/5/15
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user;
        user = userService.getByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("");
        }
        return new SecurityUser(user.getUserName(),user.getPassword());
    }
}
