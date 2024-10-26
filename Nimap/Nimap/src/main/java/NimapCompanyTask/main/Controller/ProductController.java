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

import NimapCompanyTask.main.Entity.Product;
import NimapCompanyTask.main.Repository.ProductRepository;


	
	@RestController
	public class ProductController {
		@Autowired
		ProductRepository repo;
		@GetMapping("/product")
		
		public Page<Product> getAllProduct(
	            @RequestParam(defaultValue = "0") int page,  
	            @RequestParam(defaultValue = "2") int size, 
	            @RequestParam(defaultValue = "id") String sortBy 
	    ) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
	        return repo.findAll(pageable);
	    }
		
		public List<Product> getAllProducts(){
			
			List<Product> product = repo.findAll();		
			
			return product;
		}
		@PostMapping("/product/add")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void createProduct(@RequestBody Product product) {
			repo.save(product);
		}
		@GetMapping("/product/{id}")
		public Product getProduct(@PathVariable int id) {
			
			Product product = repo.findById(id).get();
			return product;
		}
		
		@PutMapping("/product/update/{id}")
		public Product updateProduct(int id) {
			
			Product product = repo.findById(id).get();
			repo.save(product);
			return product;
		}
		
		@DeleteMapping("/product/delete/{id}")
		public void removeProduct(@PathVariable int id) {
			Product product = repo.findById(id).get();
			repo.delete(product);
		}

}
