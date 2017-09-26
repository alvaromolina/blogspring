package com.ucbcba.blog.services;

import com.ucbcba.blog.entities.Post;

public interface PostService {

    Iterable<Post> listAllPosts();

    Post getPostById(Integer id);

    Post savePost(Post product);

    void deletePost(Integer id);

}