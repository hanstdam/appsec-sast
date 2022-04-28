package com.sonatype.infosec.owasp.a02;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sonatype.infosec.owasp.a02.exceptions.PersistentDataException;
import com.sonatype.infosec.owasp.a02.models.Product;
import com.sonatype.infosec.owasp.a02.repositories.ProductRepository;

@RestController
public class ProductController {

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Product>> getProducts() throws PersistentDataException {
		ProductRepository productRepository = new ProductRepository();

		List<Product> products = productRepository.getProducts();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
