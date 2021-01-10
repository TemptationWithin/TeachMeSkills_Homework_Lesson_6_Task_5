package com.homeWork_Lesson_6_Task_5.exceptions;

public class WrongArrayException extends ArrayIndexOutOfBoundsException{
    public WrongArrayException(String message){
        super(message);
    }
}
