package com.practice.askandanswer.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="post_content")
    private String content;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    public Post(){

    }
    public Post(Integer id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
