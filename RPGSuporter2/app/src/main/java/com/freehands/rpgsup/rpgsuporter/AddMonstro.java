package com.freehands.rpgsup.rpgsuporter;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.freehands.rpgsup.rpgsuporter.DAO.MonstrosDAO;
import com.freehands.rpgsup.rpgsuporter.Helpers.MonstrosHelper;
import com.freehands.rpgsup.rpgsuporter.Modelo.Monstro;

public class AddMonstro extends AppCompatActivity {

    private MonstrosHelper helper;
    private MonstrosDAO dao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monstro);

        helper = new MonstrosHelper(this);
        dao = new MonstrosDAO(this);

        Button btnSalvar = findViewById(R.id.act_add_monstros_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monstro mob = helper.geraMonstro();
                dao.insereMonstro(mob);
                dao.close();
                Toast.makeText(AddMonstro.this, mob.getNome() + " foi salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
