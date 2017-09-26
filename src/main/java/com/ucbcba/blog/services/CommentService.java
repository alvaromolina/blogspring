package com.ucbcba.blog.services;

import com.ucbcba.blog.entities.Comment;

public interface CommentService {

    Iterable<Comment> listAllComments();

    Comment getCommentById(Integer id);

    Comment saveComment(Comment comment);

    void deleteComment(Integer id);

}