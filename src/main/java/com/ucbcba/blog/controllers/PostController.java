package com.ucbcba.blog.controllers;

import com.ucbcba.blog.entities.Category;
import com.ucbcba.blog.entities.Comment;
import com.ucbcba.blog.entities.Post;
import com.ucbcba.blog.services.CategoryService;
import com.ucbcba.blog.services.CommentService;
import com.ucbcba.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by amolina on 19/09/17.
 */
@Controller
public class PostController {

    @RequestMapping("/")
    String hello() {
        return "Hello World";
    }

    private CommentService commentService;

    private PostService postService;


    private CategoryService categoryService;


    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    /**
     * List all posts.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/post/new", method = RequestMethod.GET)
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryService.listAllCategories());
        return "postForm";
    }




    /**
     * List all posts.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String save(@Valid Post post, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.listAllCategories());
            return "postForm";
        }
        postService.savePost(post);
        return "redirect:/posts";
    }

    /* List all posts.
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment(post));
        return "post";
    }


    @RequestMapping(value = "/post/like/{id}", method = RequestMethod.GET)
    public String like(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);
        post.setLikes(post.getLikes()+1);
        postService.savePost(post);
        return "redirect:/post/"+post.getId();
    }

    @RequestMapping(value = "/post/editar/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable Integer id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("categories", categoryService.listAllCategories());
        return "postForm";
    }

    @RequestMapping(value = "/post/eliminar/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable Integer id, Model model) {
        postService.deletePost(id);
        return "redirect:/posts";
    }


    /**
     * List all posts.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("posts", postService.listAllPosts());
        return "posts";
    }

}
