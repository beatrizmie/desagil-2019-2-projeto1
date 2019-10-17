package br.pro.hashi.ensino.desagil.projeto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Collections;

public class Tradutor extends AppCompatActivity {

    private ListView RomanoAlfabetica;
    private ListView MorseAlfabetica;

    private final Translator translator = new Translator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradutor);

        this.RomanoAlfabetica = findViewById(R.id.RomanoAlfabetica);
        this.MorseAlfabetica = findViewById(R.id.MorseAlfabetica);

        ArrayList DicionarioRomanoMorse = translator.DicionarioRomanoMorse();
        ArrayList DicionarioMorseRomano = translator.DicionarioMorseRomano();

        Collections.sort(DicionarioRomanoMorse);

        ArrayAdapter<String> arrayAdapterRomanToMorse = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                DicionarioRomanoMorse );

        this.RomanoAlfabetica.setAdapter(arrayAdapterRomanToMorse);

        ArrayAdapter<String> arrayAdapterMorseToAlpha = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                DicionarioMorseRomano );

        this.MorseAlfabetica.setAdapter(arrayAdapterMorseToAlpha);


    }
}

