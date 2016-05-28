package sendingmail;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author mohamedfashkl
 */
public class SendingMail extends Application {

    Group root;
    Scene scene;
    Button btn;
    Label to, from, sub;
    TextField toTxt, fromTxt, subTxt;
    TextArea txtArea;

    public static void emailing() {
        String To = "mohamed.mig35@hotmail.com";
        // sender email ID
        String From = "mohamed.su37@gmail.com";
        //host name
        String host = "localhost";
        //get system propertites
        Properties properties = System.getProperties();
        //setup mail server
        properties.setProperty("mail.smtp.host", host);
        //get the default session object
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage mimeMessage = new MimeMessage(session);

            //Set From: header field of the header
            mimeMessage.setFrom(new InternetAddress(From));

            //Set To: header field of the header
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(To));

            //Set Subject : header field
            mimeMessage.setSubject("This is the Subject Line .. test Maling");

            //Set subject : acutual message
            mimeMessage.setText("Messeage sent sucessfully ........ wow ");

            //send message
            Transport.send(mimeMessage);
            System.out.println("Sent email sucessfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage primaryStage) {
        to = new Label("To");
        from = new Label("From");
        sub = new Label("Subject");
        btn = new Button("Send");

        toTxt = new TextField();
        fromTxt = new TextField();
        subTxt = new TextField();
        txtArea = new TextArea();

        to.setLayoutX(20);
        to.setLayoutY(10);
        to.setFont(new Font("tahoma", 15));
//        to.setTextFill(Color.web("#0076a3"));


        toTxt.setLayoutX(80);
        toTxt.setLayoutY(10);
        toTxt.setPrefWidth(350);
        toTxt.setPrefHeight(30);
        from.setLayoutX(20);
        from.setLayoutY(60);
        from.setFont(new Font("tahoma", 15));
        fromTxt.setLayoutX(80);
        fromTxt.setLayoutY(60);
        fromTxt.setPrefWidth(350);
        fromTxt.setPrefHeight(30);

        sub.setLayoutX(20);
        sub.setLayoutY(120);
        sub.setFont(new Font("tahoma", 15));
        subTxt.setLayoutX(80);
        subTxt.setLayoutY(120);
        subTxt.setPrefWidth(350);
        subTxt.setPrefHeight(30);

        txtArea.setLayoutX(20);
        txtArea.setLayoutY(180);
        txtArea.setPrefSize(570, 250);
        txtArea.setVisible(true);

        btn.setLayoutX(450);
        btn.setLayoutY(450);
        btn.setFont(new Font("tahoma", 15));


        emailing();


        root = new Group();

        root.getChildren().addAll(to, from, sub, toTxt, fromTxt, subTxt, txtArea, btn);
        scene = new Scene(root, 610, 500, Color.LIGHTGRAY);
        primaryStage.setTitle("New Email");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
