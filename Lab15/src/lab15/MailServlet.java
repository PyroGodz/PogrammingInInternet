package lab15;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;

public class MailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        final String userEmail = context.getInitParameter("UserEmail");
        final String userPassword = context.getInitParameter("UserPassword");

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, userPassword);
            }
        };
        try {
            MimeMessage msg = new MimeMessage(Session.getInstance(props, auth));

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(context.getInitParameter("UserEmail")));
            msg.setSubject(context.getInitParameter("Subject"), "UTF-8");
            msg.setText(request.getParameter("message"), "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getParameter("email"), false));
            Transport.send(msg);
            response.sendRedirect("./sendmail.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}