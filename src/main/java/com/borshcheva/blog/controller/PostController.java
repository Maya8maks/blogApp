package com.borshcheva.blog.controller;

import com.borshcheva.blog.dto.PostCommentDto;
import com.borshcheva.blog.entity.Comment;
import com.borshcheva.blog.entity.Post;
import com.borshcheva.blog.service.CommentService;
import com.borshcheva.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/posts")
    public List<Post> getPostList(@RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "sort", required = false) String sort) {

        if (Objects.nonNull(title)) {
            return postService.getPostsByTitle(title);
        } else if (Objects.nonNull(sort)) {
            return postService.getPostsOrderByTitle();
        } else {
            return postService.getPostList();
        }
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable("id") Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/posts")
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable("id") Long postId) {
        postService.deletePostById(postId);
        return "Post deleted successfully";
    }

    @PutMapping("/posts/{id}")
    public Post updatePostById(@PathVariable("id") Long postId, @RequestBody Post post) {
        return postService.updatePost(postId, post);
    }

    @GetMapping("/posts/title/{title}")
    public List<Post> getPostByTitle(@PathVariable("title") String title) {
        return postService.getPostsByTitle(title);
    }

    @GetMapping("/posts/star")
    public List<Post> getStarPosts() {
        return postService.getStarPosts();
    }

    @PutMapping("/posts/{id}/star")
    public Post updatePostSetStarTrue(@PathVariable("id") Long postId) {
        return postService.updatePostSetStar(postId, true);
    }

    @DeleteMapping("/posts/{id}/star")
    public Post updatePostSetStarFalse(@PathVariable("id") Long postId) {
        return postService.updatePostSetStar(postId, false);
    }

    @GetMapping("/posts/{id}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable("id") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping("/posts/{id}/comments")
    public Comment saveComment(@PathVariable("id") Long postId, @RequestBody Comment comment) {
        return commentService.saveComment(postId, comment);
    }

    @GetMapping("/posts/{id}/comments/{commentId}")
    public List<Comment> getCommentsByPostIdAngByCommentId(@PathVariable("id") Long postId, @PathVariable("commentId") Long commentId) {
        return commentService.getCommentsByPostIdAngByCommentId(postId, commentId);
    }

    @GetMapping("/posts/{id}/full")
    public PostCommentDto getPostsWithComments(@PathVariable("id") Long postId) {
        return postService.getPostFull(postId);
    }
}
