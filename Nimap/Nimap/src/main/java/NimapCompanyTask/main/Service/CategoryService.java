package NimapCompanyTask.main.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import NimapCompanyTask.main.Entity.Category;
import NimapCompanyTask.main.Repository.CategoryRepository;



	
	@Service
	public class CategoryService {

	    @Autowired
	    private CategoryRepository categoryRepository;

	    public Page<Category> getAllCategories(Pageable pageable) {
	        return categoryRepository.findAll(pageable);
	    }
	    
	    public Optional<Category> getCategoryById(int id) {
	        return categoryRepository.findById(id);
	    }
	    
	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }
	    
	    public Category updateCategory(int id, Category categoryDetails) {
	        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(int id) {
	        categoryRepository.deleteById(id);
	    }
}
