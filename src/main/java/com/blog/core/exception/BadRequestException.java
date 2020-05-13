package com.blog.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author xzy
 * @date Created in 10:23 2020/5/12
 */
@Getter
public class BadRequestException extends RuntimeException {
    private Integer status =BAD_REQUEST.value();

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status,String msg){
        super(msg);
        this.status = status.value();
    }
}
