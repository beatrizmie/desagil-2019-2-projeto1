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

import java.util.LinkedList;

public class MensagensProntas extends AppCompatActivity {

    private static final int REQUEST_SEND_SMS = 0;
    private LinkedList<TextView> messages = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private String[] dfltMsg = {
            "SOS"
    };

    private void showToast(String text) {

      // Constrói uma bolha de duração curta.
      Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

      // Mostra essa bolha.
      toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens_prontas);

        TextView writtenMessage1 = findViewById(R.id.written_message1);


        TextView chosenMessage = findViewById(R.id.chosen_message);
        Button buttonup = findViewById(R.id.buttonup);
        Button buttondown = findViewById(R.id.buttondown);
//        Button buttonnext = findViewById(R.id.buttonnext);
        Button buttonback = findViewById(R.id.buttonback);
        Button buttonsend = findViewById(R.id.buttonsend);


        writtenMessage1.setText(this.dfltMsg[0]);
        messages.add(writtenMessage1);
        index.add(0);
        chosenMessage.setText(dfltMsg[0]);



        buttonsend.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(MensagensProntas.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
              String mensagem = "SOS";
              String phone = "5511986527674";

              SmsManager manager = SmsManager.getDefault();
              manager.sendTextMessage(phone, null, mensagem, null, null);
              Intent intent2 = new Intent(MensagensProntas.this, PaginaInicial.class);
              startActivity(intent2);
              showToast("Mensagem enviada");

            } else {

              String[] permissions = new String[]{
                Manifest.permission.SEND_SMS,
              };

              ActivityCompat.requestPermissions(MensagensProntas.this, permissions, REQUEST_SEND_SMS);
            }
          }
        });



//        buttonnext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String msg = dfltMsg[0];
//                Intent intent = new Intent(MensagensProntas.this,Contatos.class);
//                intent.putExtra("KeyMessage",msg);
//                startActivity(intent);
//            }
//
//        });


        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MensagensProntas.this, PaginaInicial.class);
                startActivity(intent1);
            }
        });
    }

}
