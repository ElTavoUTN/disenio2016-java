package Adaptador;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sistemacompraproveedores.ConfiguracionSMTP;
import sistemacompraproveedores.DTO.DTOEmail;

public class AdaptadorSMTP implements AdaptadorEnvioMail {

    ConfiguracionSMTP smtp = new ConfiguracionSMTP();

    public static String Username;
    public static String PassWord;
    String Mensage = "";
    String To = "";
    String Subject = "";

    public AdaptadorSMTP() {

    }

    public void finalize() throws Throwable {

    }

    public void enviarMail(DTOEmail mail) {

        smtp.setHost("127.0.0.1");
        smtp.setPuerto("25");
        smtp.setUsuario("postmaster@localhost");
        smtp.setContraseña("mi");

        Username = smtp.getUsuario();
        PassWord = smtp.getContraseña();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtp.getHost());
        props.put("mail.smtp.port", smtp.getPuerto());
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        });

//        Mensage = "Correo de prueba";
//        To = "gustavolemos089@gmail.com";
//        Subject = "Prueba";

        Mensage = mail.getMensaje();
        To = mail.getTo();
        Subject = mail.getAsunto();

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));

            message.setSubject(Subject);
            message.setText(Mensage);

            Transport.send(message);

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }

}
