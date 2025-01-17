package com.example.liquibasepostgres;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.liquibasepostgres.model.Image;
import com.example.liquibasepostgres.model.Product;
import com.example.liquibasepostgres.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiquibasePostgresApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void testApplicationPersistence() {

		Product product = buildProduct();
		Product savedProduct = productRepository.save(product);

		Assert.assertNotNull(savedProduct.getId());
		Assert.assertNotNull(savedProduct.getImages().stream().findFirst().get().getId());
		Assert.assertNotNull(savedProduct.getSubProducts().stream().findFirst().get().getId());
		Assert.assertEquals("Default image", savedProduct.getImages().stream().findFirst().get().getType());
		Assert.assertEquals("Child Product", savedProduct.getSubProducts().stream().findFirst().get().getName());
	}

	private Image buildImage() {
		Image im = new Image();
		im.setType("Default image");
		return im;
	}

	private Product buildChildProduct() {
		Product parent = new Product();
		parent.setName("Child Product");
		parent.setDescription("This is a child product");
		return parent;
	}

	private Product buildProduct() {
		Product parent = new Product();
		parent.setName("Parent Product");
		parent.setDescription("This is a parent product");
		parent.addImage(buildImage());
		parent.addSubProduct(buildChildProduct());
		return parent;
	}
}
