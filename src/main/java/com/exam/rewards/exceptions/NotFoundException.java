package com.exam.rewards.exceptions;


import org.aspectj.weaver.ast.Not;

public class NotFoundException extends RuntimeException {
    private String text;

    public NotFoundException(String text){
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
