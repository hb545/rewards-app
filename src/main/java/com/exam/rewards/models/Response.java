package com.exam.rewards.models;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Response<T> {
    
    /** The message. */
    private String message;
    
    /** The data. */
    private T data;
}
