package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.Enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Order order;
		//client-info
		System.out.println("Informação do cliente:");
		System.out.print("nome: ");
		String clientName=sc.nextLine();
		System.out.print("email: ");
		String clientEmail=sc.nextLine();
		System.out.println("Data de nascimento (dd/mm/yyyy): ");
		String clientBD = sc.nextLine();
		Client client = new Client(clientName,clientEmail,sdf.parse(clientBD));
		//product-info
		System.out.println("Informação de produto");
		System.out.print("estado da encomenda: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.print("Quantos Item deseja ? ");
		int x= sc.nextInt();
		order = new Order(new Date(),status,client);
		for (int i=1;i<=x;i++) {
			System.out.println("Product #"+i);
			System.out.print("Nome: ");
			sc.nextLine();
			String name= sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int amount=sc.nextInt();
			order.addItem(new OrderItem(new Product(name,price),amount));
		}

		System.out.println(order.toString());
		sc.close();
	}

}
