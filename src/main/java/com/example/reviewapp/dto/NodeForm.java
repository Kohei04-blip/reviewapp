package com.example.reviewapp.dto;

import jakarta.validation.constraints.NotBlank;

public class NodeForm {

    @NotBlank(message = "タイトルを入力してください")
    private String title;

    private String content;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}