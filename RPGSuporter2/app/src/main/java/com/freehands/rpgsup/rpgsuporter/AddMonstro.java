package com.freehands.rpgsup.rpgsuporter;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddMonstro extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monstro);

        Button btnSalvar = findViewById(R.id.act_add_monstros_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddMonstro.this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
