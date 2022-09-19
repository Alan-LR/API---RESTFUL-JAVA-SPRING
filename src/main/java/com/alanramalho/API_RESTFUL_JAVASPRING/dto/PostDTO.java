package com.alanramalho.API_RESTFUL_JAVASPRING.dto;

import java.io.Serializable;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.Post;

public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    public PostDTO() {
    }

    public PostDTO(Post obj) {
        id = obj.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
