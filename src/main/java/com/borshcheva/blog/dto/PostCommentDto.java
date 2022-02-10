package com.borshcheva.blog.dto;

import com.borshcheva.blog.entity.Comment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostCommentDto {
    private Long id;
    private String title;
    private String content;
    private boolean star;
    private List<Comment> comments = new ArrayList<>();
}
