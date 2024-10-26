package NimapCompanyTask.main.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


	
	@Entity
	@Table(name = "product")
	public class Product {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private double price;
		
		private String name;
		
		@ManyToOne
		@JoinColumn(name = "category_id",  nullable = false)
		@JsonIgnore
		private Category category;
		
		public Product() {
			// TODO Auto-generated constructor stub
		}
		

		public Product(int id, double price, String name, Category category) {
			super();
			this.id = id;
			this.price = price;
			this.name = name;
			this.category = category;
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", price=" + price + ", name=" + name + ", category=" + category + "]";
		}
}
