package com.ucbcba.blog.controllers;

import com.ucbcba.blog.entities.Comment;
import com.ucbcba.blog.entities.Post;
import com.ucbcba.blog.services.CommentService;
import com.ucbcba.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amolina on 26/09/17.
 */
@Controller
public class CommentController {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * List all posts.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String save(Comment comment, Model model) {
        commentService.saveComment(comment);
        return "redirect:/post/"+comment.getPost().getId();
    }
}
