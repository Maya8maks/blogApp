package com.borshcheva.blog.controller;

import com.borshcheva.blog.entity.Post;
import com.borshcheva.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postservice;

    public PostController(PostService postservice) {
        this.postservice = postservice;
    }

    @GetMapping("/posts")
    public List<Post> getPostList() {
        return postservice.getPostList();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable("id") Long postId) {
        return postservice.getPostById(postId);
    }

    @PostMapping("/posts")
    public Post savePost(@RequestBody Post post) {
        return postservice.savePost(post);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable("id") Long postId) {
        postservice.deletePostById(postId);
        return "Post deleted successfully";
    }

    @PutMapping("/posts/{id}")
    public Post updatePostById(@PathVariable("id") Long postId, @RequestBody Post post) {
        return postservice.updatePost(postId, post);
    }

    @GetMapping("/posts/title/{title}")
    public List<Post> getPostByTitle(@PathVariable("title") String title) {
        return postservice.getPostsByTitle(title);
    }
}
