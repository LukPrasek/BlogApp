package pl.lukaszprasek.BlogApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.BlogApp.domain.forms.PostForm;
import pl.lukaszprasek.BlogApp.services.CategoryService;
import pl.lukaszprasek.BlogApp.services.CommentService;
import pl.lukaszprasek.BlogApp.services.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableAsync
public class MainController {



        @Autowired
        CommentService commentService;

        @Autowired
        PostService postService;

        @Autowired
        CategoryService categoryService;

        @GetMapping("/")
        public String index(Model model) {
            model.addAttribute("posts", postService.getRepository().findAll());
            return "index";
        }

        @GetMapping("/post/{id}")
        public String post(@PathVariable("id") int id,
                           Model model) {
            model.addAttribute("post", postService.getRepository().findById(id).orElseThrow(IllegalStateException::new));
            return "post";
        }

        @PostMapping("/comment/{postId}")
        public String addComment(@RequestParam("comment") String comment,
                                 @RequestParam("author")  String author,
                                 @PathVariable("postId") int postId){
            commentService.addComment(author, comment, postId);
            return "redirect:/post/" + postId;
        }


        @GetMapping("/add/post")
        public String addPost(Model model){
            model.addAttribute("postForm", new PostForm());
            model.addAttribute("categories", categoryService.getCategories());
            return "addPost";
        }

        @PostMapping("/add/post")
        public String addPost(@ModelAttribute PostForm postForm, HttpServletRequest httpServletRequest){
            postService.addPost(postForm, httpServletRequest.getRemoteHost());
            return "redirect:/";
        }
}
