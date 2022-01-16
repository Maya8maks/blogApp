package com.borshcheva.blog.service;

import com.borshcheva.blog.entity.Post;

import java.util.List;

public interface PostService {

    public Post savePost(Post post);

    public List<Post> getPostList();

    public Post getPostById(Long postId);

    public void deletePostById(Long postId);

    public Post updatePost(Long postId, Post post);

   public List<Post> getPostsByTitle(String title);
}
