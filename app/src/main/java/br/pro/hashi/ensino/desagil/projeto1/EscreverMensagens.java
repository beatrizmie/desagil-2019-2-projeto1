package br.pro.hashi.ensino.desagil.projeto1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class EscreverMensagens extends AppCompatActivity {
  private static final int REQUEST_SEND_SMS = 0;
  Translator translator = new Translator();
  String morseWritten;
  char romanWritten;
  String morseOnGoing = "";
  LinkedList<String> romanWords = new LinkedList<>();

  private void showToast(String text) {

    // Constrói uma bolha de duração curta.
    Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

    // Mostra essa bolha.
    toast.show();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_escrever_mensagens);

    TextView textMessage = findViewById(R.id.text_message);
    TextView writtenMessage = findViewById(R.id.written_message);
    TextView writtenMorse = findViewById(R.id.written_morse);
    Button buttondel = findViewById(R.id.buttondel);
    Button buttonmorse = findViewById(R.id.buttonmorse);
    Button buttoncontact = findViewById(R.id.buttoncontact);
    Button buttonspace = findViewById(R.id.buttonspace);
    Button buttonhome = findViewById(R.id.buttonhome);


    buttonhome.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent2 = new Intent(EscreverMensagens.this, PaginaInicial.class);
        startActivity(intent2);
      }

    });

    buttonmorse.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        morseOnGoing += "-";
        writtenMorse.setText(morseOnGoing);
        return true;
      }

    });

    buttonmorse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        morseOnGoing += ".";
        writtenMorse.setText(morseOnGoing);
      }

    });

    buttondel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (morseOnGoing != null && morseOnGoing.length() > 0) {
          morseOnGoing = morseOnGoing.substring(0, morseOnGoing.length() - 1);
          writtenMorse.setText(morseOnGoing);
        } else {
          String message = writtenMessage.getText().toString();

          if (!message.isEmpty()) {
            message = message.substring(0, message.length() - 1);
            writtenMessage.setText(message);
          }
        }
      }

    });


    buttonspace.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          if (morseOnGoing != "") {
            morseWritten = morseOnGoing;
            romanWritten = translator.morseToChar(morseWritten);
            morseOnGoing = "";
            writtenMorse.setText(morseOnGoing);
            romanWords.add(String.valueOf(romanWritten));
            System.out.println(writtenMessage);

            String content = "";

            for (String word : romanWords) {
              content += (word);
            }

            writtenMessage.setText(content);


          } else {
            romanWords.add(" ");
          }
        } catch (Exception exception) {
          Toast.makeText(getApplicationContext(), "Morse não reconhecido, favor tentar novamente.", Toast.LENGTH_LONG).show();
          morseOnGoing = "";
          writtenMorse.setText(morseOnGoing);
        }


      }
    });

    buttoncontact.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        morseWritten = "";
        romanWritten = translator.morseToChar(morseWritten);
        romanWords.add(String.valueOf(romanWritten));
        String content = "";

        for (String word : romanWords) {
          content += (word);
        }
        String msg = content;

        if (ContextCompat.checkSelfPermission(EscreverMensagens.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
          Intent intent = getIntent();
          if (msg.length() <= 1) {
            showToast("Mensagem inválida!");
            return;
          }

          String phone = "5511986527674";

          SmsManager manager = SmsManager.getDefault();
          manager.sendTextMessage(phone, null, msg, null, null);
          Intent intent2 = new Intent(EscreverMensagens.this, PaginaInicial.class);
          startActivity(intent2);
          showToast("Mensagem enviada");

        } else {

          String[] permissions = new String[]{
            Manifest.permission.SEND_SMS,
          };

          ActivityCompat.requestPermissions(EscreverMensagens.this, permissions, REQUEST_SEND_SMS);


        }


      }

    });

  }
}
