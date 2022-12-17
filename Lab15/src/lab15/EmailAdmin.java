package lab15;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

public class EmailAdmin {
    public static String showMessages(final String userEmail, final String password) throws MessagingException, IOException {

        String host = "imap.yandex.ru";
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.imaps.ssl.trust", host);
        Session session = Session.getDefaultInstance(properties, null);
        Store store;
        store = session.getStore();
        store.connect("imap.yandex.ru", 993, userEmail, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        StringBuilder result = new StringBuilder();
        for (Message message : inbox.getMessages()) {
            result.append("<div style='width: 50%; border: 2px solid black; border-radius: 10px; padding: 20px; margin-bottom: 20px'>");
            result.append("<p style='font-size: 20px'>").append("<b>Date: </b>").append(message.getSentDate()).append("</p>");
            result.append("<p style='font-size: 18px'>").append("<b>Sender: </b>").append(InternetAddress.toString(message.getFrom())).append("</p>");
            result.append("<p style='font-size: 18px'>").append("<b>Theme: </b>").append(message.getSubject()).append("<br/>");
            String messageContent = "";
            String contentType = message.getContentType();

            if (contentType.contains("multipart")) {
                Multipart multiPart = (Multipart) message.getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    messageContent = part.getContent().toString();
                }
            } else if (contentType.contains("text/plain")
                    || contentType.contains("text/html")) {
                Object content = message.getContent();
                if (content != null) {
                    messageContent = content.toString();
                }
            }

            result.append("<p style='font-size: 18px'>").append("<b>Message: </b>").append(messageContent).append("<br/>");
            result.append("</div>");
        }

        inbox.close(true);
        store.close();
        return result.toString();
    }
}