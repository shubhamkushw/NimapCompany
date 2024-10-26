package NimapCompanyTask.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import NimapCompanyTask.main.Entity.Category;
import NimapCompanyTask.main.Repository.CategoryRepository;



	
	@RestController
	public class CategoryController {
		
		@Autowired
		CategoryRepository repo;
		@GetMapping("/category")
		
		public Page<Category> getAllCategories(
	            @RequestParam(defaultValue = "0") int page, 
	            @RequestParam(defaultValue = "2") int size, 
	            @RequestParam(defaultValue = "id") String sortBy 
	    ) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
	        return repo.findAll(pageable);
	    }
		public List<Category> getAllCategories(){
			
			 List<Category>categories = repo.findAll();
			
			return categories;
		}
		
		
		@PostMapping("/category/add")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void createCategory(@RequestBody Category category) {
			repo.save(category);
		}
		
		
		@GetMapping("/category/{id}")
		public Category getCategory(@PathVariable int id) {
			Category category = repo.findById(id).get();
			
			return category;
		}
		
		@PutMapping("/category/update/{id}")
		public Category updateCategory(int id) {
			Category category = repo.findById(id).get();
			repo.save(category);
			return category;
		}
		@DeleteMapping("/category/delete/{id}")
		public void removeCategory(@PathVariable int id) {
			Category category = repo.findById(id).get();
			repo.delete(category);
		}
}
