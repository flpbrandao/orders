package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.OrderItem;
import entities.enums.OrderStatus;
import entities.Client;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private OrderStatus status;
	private Date moment;
	private Client client;
	
	public Order () {
		
	}

	public Order(OrderStatus status, Date moment, Client client) {
		this.status = status;
		this.moment = moment;
		this.client = client;
	}

	private List<OrderItem> items = new ArrayList<>();

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public void addItem(OrderItem items) {
		this.items.add(items);

	}
	public void removeItem(OrderItem items) {
		this.items.remove(items);
	}

	public double Total(OrderItem items) {
		double sum =0;
		for (OrderItem it: this.items) {
			sum += it.subTotal();
			
		}
		return sum;

	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", Total(null)));
		return sb.toString();
	}
}
