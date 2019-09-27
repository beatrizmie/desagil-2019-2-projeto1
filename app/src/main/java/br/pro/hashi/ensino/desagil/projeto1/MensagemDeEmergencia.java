package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MensagemDeEmergencia extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mensagem_de_emergencia);

    TextView writtenMessages = findViewById(R.id.written_messages);
    TextView writtenMessage1 = findViewById(R.id.written_message1);
//    TextView writtenMessage2 = findViewById(R.id.written_message2);
//    TextView writtenMessage3 = findViewById(R.id.written_message3);
//    TextView writtenMessage4 = findViewById(R.id.written_message4);
//    TextView writtenMessage5 = findViewById(R.id.written_message5);
    TextView chosenMessage = findViewById(R.id.chosen_message);

    writtenMessage1.setOnClickListener(v -> {
      String content = writtenMessage1.getText().toString();
      chosenMessage.setText(content);
    });

//    writtenMessage2.setOnClickListener(v -> {
//      String content = writtenMessage2.getText().toString();
//      chosenMessage.setText(content);
//    });
//
//    writtenMessage3.setOnClickListener(v -> {
//      String content = writtenMessage3.getText().toString();
//      chosenMessage.setText(content);
//    });
//
//    writtenMessage4.setOnClickListener(v -> {
//      String content = writtenMessage4.getText().toString();
//      chosenMessage.setText(content);
//    });
//
//    writtenMessage5.setOnClickListener(v -> {
//      String content = writtenMessage5.getText().toString();
//      chosenMessage.setText(content);
//    });
  }
}

