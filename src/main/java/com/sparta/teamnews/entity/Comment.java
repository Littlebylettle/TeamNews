package com.sparta.teamnews.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Cleanup;

public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(name = "comment")
    String comment;
    @Column(name = "createAt")
    String createAt;
    @Column(name = "modifiedAt")
    String modifiedAt;

}
