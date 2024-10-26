package NimapCompanyTask.main.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import NimapCompanyTask.main.Entity.Product;
import NimapCompanyTask.main.Repository.ProductRepository;

	
	@Service
	public class ProductService {

	    @Autowired
	    private ProductRepository productRepository;

	    public Page<Product> getAllProduct(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }
	    
	    public Optional<Product> getProductById(int id) {
	        return productRepository.findById(id);
	    }
	    
	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }
	    
	    public Product updateProduct(int id, Product productDetails) {
	        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
	        product.setName(productDetails.getName());
	        return productRepository.save(product);
	    }

	    public void deleteProduct(int id) {
	        productRepository.deleteById(id);
	    }
}
