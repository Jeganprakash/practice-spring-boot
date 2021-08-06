package com.practice.askandanswer.dto;

public class PostDto{
    private Integer id;
    private String content;
    private String username;

    public PostDto(Integer id, String content, String username) {
        this.id = id;
        this.content = content;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}