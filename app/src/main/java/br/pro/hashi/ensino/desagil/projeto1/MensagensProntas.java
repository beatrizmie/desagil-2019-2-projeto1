package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MensagensProntas extends AppCompatActivity {
    private LinkedList<TextView> messages = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private String[] dfltMsg = {
            "SOS"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens_prontas);

        TextView writtenMessage1 = findViewById(R.id.written_message1);

        TextView chosenMessage = findViewById(R.id.chosen_message);
        Button buttonup = findViewById(R.id.buttonup);
        Button buttondown = findViewById(R.id.buttondown);
        Button buttonnext = findViewById(R.id.buttonnext);
        Button buttonback = findViewById(R.id.buttonback);


        writtenMessage1.setText(this.dfltMsg[0]);
        messages.add(writtenMessage1);
        index.add(0);
        chosenMessage.setText(dfltMsg[0]);








        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = dfltMsg[0];
                Intent intent = new Intent(MensagensProntas.this,Contatos.class);
                intent.putExtra("KeyMessage",msg);
                startActivity(intent);
            }

        });


        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MensagensProntas.this, PaginaInicial.class);
                startActivity(intent1);
            }
        });
    }








}
