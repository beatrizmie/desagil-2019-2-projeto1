package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PaginaInicial extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pagina_inicial);

//    Button button1Example = findViewById(R.id.button1_example);
    Button button2Example = findViewById(R.id.button2_example);
//    Button button3Example = findViewById(R.id.button3_example);

//    button1Example.setOnClickListener(v -> {
//      Intent intent = new Intent(PaginaInicial.this, EscreverMensagens.class);
//      startActivity(intent);
//    });

    button2Example.setOnClickListener(v -> {
      Intent intent1 = new Intent(PaginaInicial.this, MensagemDeEmergencia.class);
      startActivity(intent1);
    });

//    button3Example.setOnClickListener(v -> {
//      Intent intent2 = new Intent(PaginaInicial.this, Tradutor.class);
//      startActivity(intent2);
//    });
  }
}
