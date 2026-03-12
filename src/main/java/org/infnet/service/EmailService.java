package org.infnet.service;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Enviando e-mail para " + to + ": " + message);
    }
}
