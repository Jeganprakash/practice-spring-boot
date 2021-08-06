package com.practice.askandanswer.entity;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @OneToOne
    @JoinColumn(name="username")
    private User user;

}
