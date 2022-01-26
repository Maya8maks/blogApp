package com.borshcheva.blog.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String title;

    @Column()
    private String content;

    @Column(columnDefinition = "boolean default false")
    private Boolean star = false;

}
