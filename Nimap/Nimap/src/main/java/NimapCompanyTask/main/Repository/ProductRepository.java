package NimapCompanyTask.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import NimapCompanyTask.main.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
