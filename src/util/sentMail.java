/* Αυτο το servlet θα εστελνε email
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//χρειαζόμαστε το Java Activation Framework και το JavaMail API
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class sentEmail extends HttpServlet{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Recipient's email 
      String to = "abcd@gmail.com";
 
      // Sender's email 
      String from = "web@gmail.com";
 
      // Από που στέλνουμε το e-mail
      String host = "localhost";
 
      // Get system properties
      Properties properties = System.getProperties();
 
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
 
      // Get the default Session.
      Session session = Session.getDefaultInstance(properties);
      
	  // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         message.setSubject("This is the Subject Line!");
         //Εδώ θα έμπαινε το μήνυμα
         message.setText("This is actual message");
         // Στείλε το mail
         Transport.send(message);
         String title = "Send Email";
         String res = "Sent message successfully....";
         String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n" +
         "<p align=\"center\">" + res + "</p>\n" +
         "</body></html>");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
} 
*/