package com.borshcheva.blog.service;

import com.borshcheva.blog.dto.PostCommentDto;
import com.borshcheva.blog.entity.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);

    List<Post> getPostList();

    Post getPostById(Long postId);

    void deletePostById(Long postId);

    Post updatePost(Long postId, Post post);

    List<Post> getPostsByTitle(String title);

    List<Post> getPostsOrderByTitle();

    List<Post> getStarPosts();

    Post updatePostSetStar(Long postId, Boolean update);

    PostCommentDto getPostFull(Long postId);
}
