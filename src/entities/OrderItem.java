package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product;
	
	public OrderItem(Product product,Integer quantity) {
		this.quantity=quantity;
		this.product=product;
		this.price=product.getPrice()*quantity;		
	}

	public Integer getQuantity() {
		return quantity;
	}


	public Product getProduct() {
		return product;
	}

	public Double subTotal() {
		return price;
	}
	
	
}
