package com.practice.askandanswer.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="comment")
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="comment_content")
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @OneToOne
    @JoinColumn(name="username")
    private User user;

}
