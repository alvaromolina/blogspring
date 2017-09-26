package com.ucbcba.blog.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by amolina on 26/09/17.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    public Comment(){

    }
    public Comment(Post post){
        this.post = post;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
