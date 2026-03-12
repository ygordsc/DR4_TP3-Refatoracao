package org.infnet;

import java.util.List;

class Order {
    private final Client client;
    private final List<Product> productList;
    private final double discountRate = 0.1;

    public Order(Client client, List<Product> productList) {
        this.client = client;
        this.productList = productList;
    }

    public void printInvoice() {
        double total = 0;
        System.out.println("Cliente: " + client.getName());
        for (Product product : productList) {
            System.out.println(product.getQuantity() + "x " + product.getName() + " - R$" + product.getPrice());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + (total * discountRate));
        System.out.println("Total final: R$" + (total * (1 - discountRate)));
    }

    public void sendEmail() {
        EmailService.sendEmail(client.getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}