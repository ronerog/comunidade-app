package com.comunidade.notification.service;

import org.springframework.stereotype.Service;

// TODO: Implementar o envio de e-mail
// Dicas:
// - Injetar JavaMailSender
// - Injetar TemplateEngine (Thymeleaf) para renderizar o template HTML
// - Criar MimeMessage com MimeMessageHelper
// - Definir from, to, subject e o corpo HTML
@Service
public class EmailService {

    // TODO: injetar JavaMailSender e TemplateEngine

    public void sendWelcomeEmail(String toEmail, String name) {
        // TODO: renderizar o template "welcome-email" com o nome do usuário
        //       e enviar o e-mail via mailSender.send(...)
    }
}
