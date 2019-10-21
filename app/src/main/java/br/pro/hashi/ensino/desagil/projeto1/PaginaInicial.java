package br.pro.hashi.ensino.desagil.projeto1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class PaginaInicial extends AppCompatActivity {

  private LinkedList<TextView> pagina = new LinkedList<>();
  private LinkedList<Integer> index = new LinkedList<>();
  private String[] pageName = {
    "Escrever mensagem",
    "SOS",
    "Dicionario",
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pagina_inicial);

    TextView writeMsg = findViewById(R.id.writeMsg);
    TextView defaultMsg = findViewById(R.id.defaultMsg);
    TextView dictionaire = findViewById(R.id.dictionaire);
    Button buttonup = findViewById(R.id.buttonup);
    Button buttonok = findViewById(R.id.buttonok);
    Button buttondown = findViewById(R.id.buttondown);


    writeMsg.setText(this.pageName[0]);
    pagina.add(writeMsg);
    index.add(0);

    defaultMsg.setText(this.pageName[1]);
    pagina.add(defaultMsg);
    index.add(1);

    dictionaire.setText(this.pageName[2]);
    pagina.add(dictionaire);
    index.add(2);


    buttonup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        up();
      }
    });

    buttonok.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getMsg() == "Escrever mensagem") {
          Intent intent = new Intent(PaginaInicial.this, EscreverMensagens.class);
          startActivity(intent);
        } else if (getMsg() == "SOS") {
          Intent intent = new Intent(PaginaInicial.this, MensagensProntas.class);
          startActivity(intent);
        } else if (getMsg() == "Dicionario") {
          Intent intent = new Intent(PaginaInicial.this, Tradutor.class);
          startActivity(intent);
        }
      }
    });

    buttondown.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        down();
      }
    });

  }

  private String getMsg() {
    return this.pageName[this.index.get(1)];
  }

  private void up() {

    for (int i = 0; i <= this.pagina.size() - 1; i++) {
      TextView text = this.pagina.get(i);
      int paginaIndex = this.index.get(i);

      if (paginaIndex - 1 >= 0) {
        text.setText(this.pageName[paginaIndex - 1]);
        this.index.set(i, paginaIndex - 1);
      } else {
        text.setText(this.pageName[this.pageName.length - 1]);
        this.index.set(i, this.pageName.length - 1);
      }
    }
  }

  private void down() {
    for (int i = 0; i <= this.pagina.size() - 1; i++) {
      TextView text = this.pagina.get(i);
      int paginaIndex = this.index.get(i);

      if (paginaIndex + 1 <= this.pageName.length - 1) {
        text.setText(this.pageName[paginaIndex + 1]);
        this.index.set(i, paginaIndex + 1);
      } else {
        text.setText(this.pageName[0]);
        this.index.set(i, 0);
      }
    }
  }

}
