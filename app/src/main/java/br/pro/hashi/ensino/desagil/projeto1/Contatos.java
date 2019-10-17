package br.pro.hashi.ensino.desagil.projeto1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Contatos extends AppCompatActivity {
    // Esta constante é um código que identifica o pedido de "mandar sms".
    private static final int REQUEST_SEND_SMS = 0;

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }


    private LinkedList<TextView> contacts = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private String[] contactNames = {
            "Harry Potter",
            "Lucio Malfoy",
            "Thor"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);

        TextView contact1 = findViewById(R.id.contact1);
        TextView contact2 = findViewById(R.id.contact2);
        TextView contact3 = findViewById(R.id.contact3);
        Button buttonup = findViewById(R.id.buttonup);
        Button buttonok = findViewById(R.id.buttonok);
        Button buttondown = findViewById(R.id.buttondown);
        Button buttonsend = findViewById(R.id.buttonsend);
        Button buttonhome = findViewById(R.id.buttonhome);

        contact1.setText(this.contactNames[0]);
        System.out.println();
        contacts.add(contact1);
        index.add(0);

        contact2.setText(this.contactNames[1]);
        contacts.add(contact2);
        index.add(1);

        contact3.setText(this.contactNames[2]);
        contacts.add(contact3);
        index.add(2);




        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Contatos.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = getIntent();
                    String mensagem = intent.getStringExtra("KeyMessage");



                    if (mensagem.length() <= 1 ){
                        showToast("Mensagem inválida!");
                        return;
                    }

                    String phone = number();

                    if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                        showToast("Número inválido!");
                        return;
                    }

                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage(phone, null, mensagem, null, null);
                    Intent intent2 = new Intent(Contatos.this, PaginaInicial.class);
                    startActivity(intent2);
                    showToast("Mensagem enviada");

                } else {

                    String[] permissions = new String[]{
                            Manifest.permission.SEND_SMS,
                    };

                    ActivityCompat.requestPermissions(Contatos.this, permissions, REQUEST_SEND_SMS);


                }
            }
        });

        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contatos.this, PaginaInicial.class);
                startActivity(intent);
            }

        });

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Contato selecionado");
            }

        });


        buttonup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up();

            }
        });



        buttondown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                down();
            }
        });

        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Contatos.this, PaginaInicial.class);
                startActivity(intent1);
            }
        });
    }


    private String getContacts() {
        return this.contactNames[this.index.get(1)];

    }

    private void up () {

        for (int i = 0; i <= this.contacts.size() - 1; i++) {

            TextView text = this.contacts.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex - 1 >= 0) {
                text.setText(this.contactNames[paginaIndex - 1]);
                this.index.set(i, paginaIndex - 1);
            } else {
                text.setText(this.contactNames[this.contactNames.length - 1]);
                this.index.set(i, this.contactNames.length - 1);
            }
        }
    }

    private void down () {
        for (int i = 0; i <= this.contacts.size() - 1; i++) {

            TextView text = this.contacts.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex + 1 <= this.contactNames.length - 1) {
                text.setText(this.contactNames[paginaIndex + 1]);
                this.index.set(i, paginaIndex + 1);
            } else {
                text.setText(this.contactNames[0]);
                this.index.set(i, 0);
            }
        }
    }

    private String number() {

        if (getContacts() == "Harry Potter") {
            return  "5541988146111";

        } else if (getContacts() == "Lucio Malfoy") {
            return  "5511986527674";

        } else if (getContacts() == "Thor") {

            return "5511959690079";
        }else {

            return "";
        }


    }
}



