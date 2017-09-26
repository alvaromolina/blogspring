package com.ucbcba.blog.services;

import com.ucbcba.blog.entities.Post;
import com.ucbcba.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    @Qualifier(value = "postRepository")
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.delete(id);
    }

}