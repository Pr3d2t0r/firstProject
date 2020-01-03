package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Enum.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}



	public OrderStatus getStatus() {
		return status;
	}



	public Client getClient() {
		return client;
	}


	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double soma=0;
		for(OrderItem oI:items) {
			soma+=oI.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Encomenda: "+"\n");
		sb.append("Data de compra: "+sdf.format(moment)+"\n");
		sb.append("Estato da encomenda: "+status+"\n");
		sb.append("Client: "+client.getName()+"\n");
		sb.append("Itens da encomenda: "+"\n");
		for(OrderItem oI:items) {
			sb.append(oI.getProduct()+", Quantity: "+oI.getQuantity()+", SubTotal: "+oI.subTotal()+"\n");
		}
		sb.append("Preço Total: "+total());
		sb.append("\n");
		return sb.toString();
	}
	
}
