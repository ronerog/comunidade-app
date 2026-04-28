package com.comunidade.notification.service;

import org.springframework.stereotype.Service;

// TODO Fase 4: implementar envio de e-mail HTML usando JavaMailSender + Thymeleaf.
//
// Esqueleto:
//
//   @Service
//   @RequiredArgsConstructor
//   @Slf4j
//   public class EmailService {
//
//       private final JavaMailSender mailSender;
//       private final TemplateEngine templateEngine;
//
//       @Value("${notification.email.from}")
//       private String from;
//
//       @Value("${notification.email.from-name}")
//       private String fromName;
//
//       public void sendWelcomeEmail(String toEmail, String name) {
//           Context ctx = new Context();
//           ctx.setVariable("name", name);
//           ctx.setVariable("appUrl", "http://localhost:3000");
//
//           String html = templateEngine.process("welcome-email", ctx);
//
//           MimeMessage message = mailSender.createMimeMessage();
//           try {
//               MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//               helper.setFrom(from, fromName);
//               helper.setTo(toEmail);
//               helper.setSubject("Bem-vindo à Plataforma Comunidade");
//               helper.setText(html, true);
//               mailSender.send(message);
//               log.info("E-mail de boas-vindas enviado para {}", toEmail);
//           } catch (MessagingException | UnsupportedEncodingException e) {
//               throw new EmailDeliveryException("Falha ao enviar e-mail para " + toEmail, e);
//           }
//       }
//   }
//
// Por que lançar exceção custom em vez de catch + log? Porque o consumer
// precisa saber que falhou para o RabbitMQ re-entregar (Fase 4: DLQ).
@Service
public class EmailService {

    // TODO Fase 4: implementar
}
