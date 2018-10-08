package pl.lukaszprasek.BlogApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.BlogApp.domain.forms.CategoryForm;
import pl.lukaszprasek.BlogApp.domain.entities.CategoryEntity;
import pl.lukaszprasek.BlogApp.domain.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(CategoryForm categoryForm) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryForm.getName());
        categoryRepository.save(categoryEntity);
    }
}
