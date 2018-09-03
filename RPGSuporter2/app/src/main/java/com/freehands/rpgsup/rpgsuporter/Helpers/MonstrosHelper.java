package com.freehands.rpgsup.rpgsuporter.Helpers;

import android.app.Activity;
import android.text.Editable;
import android.widget.EditText;

import com.freehands.rpgsup.rpgsuporter.Modelo.Monstro;
import com.freehands.rpgsup.rpgsuporter.R;

public class MonstrosHelper {


    private final EditText campoMonstroVida;
    private final EditText campoMonstroNome;

    public MonstrosHelper (Activity activity) {

        campoMonstroNome = (EditText) activity.findViewById(R.id.add_monstros_nome);
        campoMonstroVida = (EditText) activity.findViewById(R.id.add_monstros_vida);
    }


    public Monstro geraMonstro(){
        Monstro mob = new Monstro();
        mob.setNome(campoMonstroNome.getText().toString());
        mob.setPontosDeVida(campoMonstroVida.getText().toString());
        return mob;
    }


}
