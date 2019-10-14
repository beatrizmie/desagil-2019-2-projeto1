package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Tradutor extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tradutor);

    TextView romanAlphabet = findViewById(R.id.roman_alphabet);
    EditText romanDisplayer = findViewById(R.id.roman_displayer);
    TextView morseAlphabet = findViewById(R.id.morse_alphabet);
    EditText morseDisplayer = findViewById(R.id.morse_displayer);
  }
}
