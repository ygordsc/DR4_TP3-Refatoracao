package org.infnet.entity;

import org.infnet.service.DiscountPolicy;
import org.infnet.service.NotificationService;

import java.util.List;

public class Order {
    private final Client client;
    private final List<Product> productList;
    private final DiscountPolicy discountPolicy = new DiscountPolicy();
    private final double DISCOUNT_RATE = 0.1;

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
        double desconto = discountPolicy.calculateDiscount(total, DISCOUNT_RATE);

        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + desconto);
        System.out.println("Total final: R$" + (total - desconto));
    }

    public void sendMessage(NotificationService service) {
        service.sendNotification(client.getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}