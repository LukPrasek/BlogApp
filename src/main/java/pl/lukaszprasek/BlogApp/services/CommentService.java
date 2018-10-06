package pl.lukaszprasek.BlogApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.BlogApp.domain.entities.CommentEntity;
import pl.lukaszprasek.BlogApp.domain.entities.PostEntity;
import pl.lukaszprasek.BlogApp.domain.repositories.PostRepository;

@Service
public class CommentService {

    private PostRepository postRepository;

    @Autowired
    public CommentService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public void addComment(String author, String comment, int postId) {
        PostEntity postEntity = postRepository.findById(postId).get();
        CommentEntity newComment = createNewCommentEntity(author, comment, postEntity);
        postEntity.getComments().add(newComment);
        postRepository.save(postEntity);
    }

    private CommentEntity createNewCommentEntity(String author, String comment, PostEntity postEntity) {
        CommentEntity newComment = new CommentEntity();
        newComment.setContent(comment);
        newComment.setAuthor(author);
        newComment.setPost(postEntity);
        return newComment;
    }
}
