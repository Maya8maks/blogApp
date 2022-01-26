package com.borshcheva.blog.service;


import com.borshcheva.blog.entity.Post;
import com.borshcheva.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post updatePost(Long postId, Post post) {
        Post postDb = postRepository.findById(postId).get();
        if (Objects.nonNull(post.getTitle()) && !"".equalsIgnoreCase(post.getTitle())) {
            postDb.setTitle(post.getTitle());
        }
        if (Objects.nonNull(post.getContent()) && !"".equalsIgnoreCase(post.getContent())) {
            postDb.setContent(post.getContent());
        }
        return postRepository.save(postDb);
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public List<Post> getPostsOrderByTitle() {
        return postRepository.findByOrderByTitleAsc();
    }

    @Override
    public List<Post> getStarPosts() {
        return postRepository.findByStarTrue();
    }

    @Override
    public Post updatePostSetStar(Long postId, Boolean updateValue) {
        Post post = postRepository.findById(postId).get();
        post.setStar(updateValue);

        return postRepository.save(post);
    }


}
