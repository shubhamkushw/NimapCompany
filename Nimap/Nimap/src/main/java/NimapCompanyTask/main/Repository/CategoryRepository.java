package NimapCompanyTask.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import NimapCompanyTask.main.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
