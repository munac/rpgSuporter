package com.freehands.rpgsup.rpgsuporter;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.freehands.rpgsup.rpgsuporter.DAO.MonstrosDAO;
import com.freehands.rpgsup.rpgsuporter.Helpers.MonstrosHelper;
import com.freehands.rpgsup.rpgsuporter.Modelo.Monstro;

import java.util.List;


public class MonstrosActivity extends AppCompatActivity {

    private ListView listaMonstros;
    private ArrayAdapter adapter;
    private MonstrosHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monstros);


        helper = new MonstrosHelper(this);

        Intent intent = getIntent();
        Monstro mob = (Monstro) intent.getSerializableExtra("monstro");

        if (mob != null){
            helper.geraMonstro();
        }

        carregaListaMonstros();

        Button addMontro = findViewById(R.id.act_monstros_botao_add);
        addMontro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(MonstrosActivity.this, AddMonstro.class);
                startActivity(intentAdd);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaMonstros();
    }

    public void carregaListaMonstros(){

        MonstrosDAO dao = new MonstrosDAO(this);
        List<Monstro> monstros = dao.buscaMonstros();
        dao.close();

        ListView listaMobs = findViewById(R.id.act_monstros_lista);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monstros);
        listaMobs.setAdapter(adapter);
    }

}