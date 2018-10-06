package pl.lukaszprasek.BlogApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.BlogApp.domain.entities.CategoryEntity;
import pl.lukaszprasek.BlogApp.domain.entities.PostEntity;
import pl.lukaszprasek.BlogApp.domain.forms.PostForm;
import pl.lukaszprasek.BlogApp.domain.repositories.CategoryRepository;
import pl.lukaszprasek.BlogApp.domain.repositories.PostRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;
@Service
public class PostService {


    private PostRepository postRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public PostService(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    //@Async // zadanie asynchroniczne - przyspiesza zwrot strony, nie gwarantuje wykonania przed wyslaniem response do usera
    @Transactional
    public void addPost(PostForm postForm, String userIp) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(postForm.getCategory());
        PostEntity postEntity = new PostEntity();
        postEntity.setCategory(categoryEntity.orElseThrow(IllegalStateException::new));
        postEntity.setAuthor(postForm.getAuthor());
        postEntity.setArticle(postForm.getArticle());
        postEntity.setTitle(postForm.getTitle());
        postEntity.setComments(Collections.emptyList());
        postEntity.setUserIp(userIp);
        postRepository.save(postEntity);
    }

    public PostRepository getRepository() {
        return postRepository;
    }
}
