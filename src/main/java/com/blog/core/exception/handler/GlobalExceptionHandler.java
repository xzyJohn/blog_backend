package com.blog.core.exception.handler;

import com.baomidou.mybatisplus.extension.api.R;
import com.blog.core.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 统一异常处理
 * @author xzy
 * @date Created in 9:58 2020/5/12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public R handleException(HttpServletRequest request,Throwable e){
        log.debug("execute methond exception error.url is {}", request.getRequestURI(), e);
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public R badRequestException(BadRequestException e){

        return R.failed(e.getMessage());
    }
}
