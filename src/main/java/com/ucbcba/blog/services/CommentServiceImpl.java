package com.ucbcba.blog.services;

import com.ucbcba.blog.entities.Comment;
import com.ucbcba.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    @Qualifier(value = "commentRepository")
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Iterable<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.delete(id);
    }

}