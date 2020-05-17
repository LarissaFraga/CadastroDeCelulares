package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cadastrocelulares.conexao.DBHelper;

/**
 * @author Larissa Fraga
 */
public class CadastroMarca extends AppCompatActivity {

    /**
     * LOGICA :
     * Atividade que irá cadastrar na tabela marca do banco
     *
     */

    public final DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_marca);

    }
}
