package com.rest.webservices.restfulwebservices.Services;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String hello_world) {
        this.message= hello_world;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
