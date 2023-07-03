package com.sparta.teamnews.entity;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comments")
@NoArgsConstructor
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(name = "comment")
    String comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
