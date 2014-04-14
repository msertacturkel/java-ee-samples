package com.yourcompany.struts.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private Connection con;
	private List<Product> products;

	public List<Product> findAll() {
		System.out.println("buradayim");
		Connection connect = getConnection();
		System.out.println("baglanti saglandi");
		Product product = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			while (rs.next()) {
				product = new Product();
				String str = rs.getString("productname");
                product.setProductname(str);
                System.out.println(str);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;

	}

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				con = DriverManager.getConnection(
						"jdbc:derby://localhost:1527/myeclipse", "classiccars",
						"classiccars");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return con;
	}

}