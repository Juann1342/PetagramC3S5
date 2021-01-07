//linkks de los tutoriales
// https://www.youtube.com/watch?v=pXl5CifFlM0&t=1029s
// https://www.youtube.com/watch?v=Bl-u50dJ54k

package com.juan.petagram3week;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContacto extends AppCompatActivity {

    EditText tvNombreContacto, tvMensajeContacto, tvEmailContacto;
    Button enviarComentario;
    String sEmail, sPass;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarCn);
        setSupportActionBar(miActionBar);
        final ActionBar ab =getSupportActionBar();
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);

        tvNombreContacto = findViewById(R.id.tvNombreContacto);
        tvMensajeContacto= findViewById(R.id.tvMsjContacto);
        tvEmailContacto= findViewById(R.id.tvEmailContacto);
        enviarComentario= findViewById(R.id.enviarComentario);

        sEmail= "emaildepruebacurso@gmail.com"; //configurar mail de salida
        sPass="emaildeprueba"; //contrasenia del mail de salida

        enviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com"); //google
                properties.put("mail.smtp.starttls.enable", "true");

                // properties.put("mail.smtp.host", "smtp.live.com"); //hotmail
                 properties.put("mail.smtp.socketFactory.port", "587"); //google
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "587");// google


                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(sEmail,sPass);
                        }
                    });
                    if (session !=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(sEmail));

                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tvEmailContacto.getText().toString()));//a quien le enviamos

                        message.setContent(tvMensajeContacto.getText().toString(),"text/html; charset=utf-8");
                        Transport.send(message); //google

             //           Transport transport = session.getTransport("smtp");//hotmail
               //         transport.connect("smtp.live.com",587,sEmail,sPass);//hotmail
                 //       transport.sendMessage(message,message.getAllRecipients());//hotmail
                   //     transport.close(); //hotmail

                        Toast.makeText(ActivityContacto.this,"Mensaje enviado", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ActivityContacto.this,e.toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });
    }



}