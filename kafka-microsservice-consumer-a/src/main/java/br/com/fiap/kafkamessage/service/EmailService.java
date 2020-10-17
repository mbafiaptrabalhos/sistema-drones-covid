package br.com.fiap.kafkamessage.service;

public interface EmailService {

    void sendSimpleMessage( String to,
                            String subject,
                            String text);
}
