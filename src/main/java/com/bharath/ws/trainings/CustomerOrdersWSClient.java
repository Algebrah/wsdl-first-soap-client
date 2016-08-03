package com.bharath.ws.trainings;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrdersWSClient {
	public static void main(String[] args) {
		try {
			CustomerOrdersService service = new CustomerOrdersService(
					new URL("http://localhost:8080/wsdlfirstws/services/customerOrders?wsdl"));
			CustomerOrdersPortType port = service.getCustomerOrdersPort();
			GetOrdersRequest request = new GetOrdersRequest();
			request.setCustomerId(BigInteger.valueOf(1));

			GetOrdersResponse response = port.getOrders(request);

			List<Order> orders = response.getOrder();

			for (Order order : orders) {
				List<Product> products = order.getProduct();
				for (Product product : products) {
					System.out.println("Prouduct Description: " + product.getDescription());
					System.out.println("Prouduct Quantity: " + product.getQuantity());
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
