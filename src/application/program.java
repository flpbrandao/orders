package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// TODO Auto-generated method stub

		System.out.println("Enter client data:");
		System.out.print("Enter client's name:");
		String name = sc.nextLine();
		System.out.println("Enter client's birth date:");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter client email: ");
		String email = sc.next();

		// IMPORTANTE: Instanciar uma coisa de cada vez. Se leu os dados
		// do cliente e isso já preenche o construtor, instancie!

		Client client = new Client(name, email, birthDate);

		// Passar para dados do pedido:

		System.out.println("Enter order data:");
		OrderStatus orderData = OrderStatus.valueOf(sc.next());

		// Instanciar o pedido. Lembrar que a ordem dos argumentos passados
		// tem que casar com a ordem que foi feita o construtor na classe de origem

		Order order = new Order(orderData, new Date(), client);

		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter # " + (i + 1) + " data: ");
			System.out.println("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();

			// Instanciar o produto com as informações lidas.
			// Instanciar o OrderItem com as informações lidas e também com o produto
			// vinculado.
			// p tem vários atributos e podem ser acessados como sub atributos do Product.
			// p não é uma variável, é um tipo de classe com vários atributos já declarados
			// no OrderItem como variável.

			Product p = new Product(productName, productPrice);
			OrderItem oi1 = new OrderItem(productQuantity, productPrice, p);
			order.addItem(oi1); // Adiciona a entrada na lista de pedidos a cada vez que roda o for

			System.out.println(p.getName());
		}
		System.out.println(order);
		sc.close();
	}

}
