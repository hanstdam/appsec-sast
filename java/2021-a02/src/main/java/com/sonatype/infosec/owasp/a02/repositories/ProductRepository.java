package com.sonatype.infosec.owasp.a02.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.sonatype.infosec.owasp.a02.enumerations.ApiErrorCode;
import com.sonatype.infosec.owasp.a02.exceptions.PersistentDataException;
import com.sonatype.infosec.owasp.a02.models.Product;

public class ProductRepository {
	private String url = "jdbc:mysql://localhost:8081/sql";  
	private String userName = "xyz";  
	private String password = "abc"; //CWE-259: Hard-coded password
	
	public ProductRepository() {
		
	}
	
	public List<Product> getProducts() throws PersistentDataException {
		List<Product> products = new LinkedList<Product>();
		try (Connection connection = DriverManager.getConnection(url, userName, password)) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet rs = statement.executeQuery("select name, description from products")) {
					while (rs.next()) {
						String name = rs.getString("name");
						String description = rs.getString("description");
						products.add(new Product(name, description));
					}
					
					return products;
				} catch (SQLException e) {
					throw new PersistentDataException(ApiErrorCode.PERSISTANT_DATA_CANNOT_QUERY_PRODUCTS, "Cannot query all products");
				}
			} catch (SQLException e) {
				throw new PersistentDataException(ApiErrorCode.PERSISTANT_DATA_CANNOT_CREATE_STATEMENT, "Cannot create statement");
			}
		} catch (SQLException e) {
			throw new PersistentDataException(ApiErrorCode.PERSISTANT_DATA_CANNOT_CONNECT, "Cannot connect to database");
		}
	}
}
