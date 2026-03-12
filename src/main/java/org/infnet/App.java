package org.infnet;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Client client1 = new Client("João", "joao@email.com");
        Product notebook = new Product("Notebook", 1, 3500.0);
        Product mouse = new Product("Mouse", 2, 80.0);

        List<Product> products = new ArrayList<Product>();
        products.add(notebook);
        products.add(mouse);

        Order order = new Order(client1, products);
        order.printInvoice();
        order.sendEmail();
    }
}