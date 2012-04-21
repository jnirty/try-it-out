package com.example.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.domain.Order;

public class DatabaseQueryBean extends JdbcDaoSupport {

	public String query(final int customerId) {
		List<Order> orders = getJdbcTemplate()
				.query("SELECT orderId, price, orderCode from ORDERS WHERE customerId = ?",
						new Integer[] { customerId }, new RowMapper<Order>() {
							public Order mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								int orderId = rs.getInt(1);
								double price = rs.getDouble(2);
								String orderCode = rs.getString(3);
								return new Order(orderId, customerId, price,
										orderCode);
							}
						});
		System.out.println("query result size = " + orders.size());
		if (orders.size() != 0) {
			return orders.get(0).toString();
		}
		return null;
	}

	public List<Order> findAll() {

		String sql = "SELECT * FROM ORDERS";

		List<Order> orders = new ArrayList<Order>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			Order order = new Order((Long) row.get("orderId"),
					(Integer) row.get("customerId"), (Double) row.get("price"),
					(String) row.get("orderCode"));
			orders.add(order);
		}

		return orders;
	}
}
