package com.borshcheva.blog.service;

import com.borshcheva.blog.entity.Comment;
import com.borshcheva.blog.entity.Post;
import com.borshcheva.blog.repository.CommentRepository;
import com.borshcheva.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment saveComment(Long postId, Comment comment) {
        Post postDb = postRepository.getById(postId);
        comment.setCreationDate(new Date());
        comment.setPost(postDb);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostIdAngByCommentId(Long postId, Long commentId) {
        return commentRepository.findByPostIdAndId(postId, commentId);
    }
}
