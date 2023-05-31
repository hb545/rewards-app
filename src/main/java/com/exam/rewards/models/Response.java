package com.exam.rewards.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    
    /** The message. */
    private String message;
    
    /** The data. */
    private T data;
}
