package com.ucbcba.blog.repositories;

import com.ucbcba.blog.entities.Post;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by amolina on 25/09/17.
 */
@Transactional
public interface PostRepository extends CrudRepository<Post, Integer> {

}