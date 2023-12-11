package com.example.nasdak.Service;

import com.example.nasdak.Domain.Category;
import com.example.nasdak.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public void save(Category category) { categoryRepository.save(category);
    }

    public void categoryUpdate(Category category) { categoryRepository.categoryUpdate(category.getCategoryNo(), category.getContent());
    }

    public void categoryDelete(Category category) { categoryRepository.delete(category);
    }

    public Category findById(long categoryNo) { return categoryRepository.findById(categoryNo).get();
    }
}
