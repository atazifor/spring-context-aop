package main;

import cofig.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService  = applicationContext.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Amin Taz");
        comment.setText("First text with no AOP");
        commentService.publishComment(comment);
    }
}
