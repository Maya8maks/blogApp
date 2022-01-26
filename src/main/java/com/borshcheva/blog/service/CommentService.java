package com.borshcheva.blog.service;

import com.borshcheva.blog.entity.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPostId(Long postId);

    Comment saveComment(Long postId, Comment commentt);

    List<Comment> getCommentsByPostIdAngByCommentId(Long postId, Long commentId);
}
