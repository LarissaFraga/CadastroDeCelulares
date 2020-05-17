package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cadastrocelulares.conexao.DBHelper;

/**
 * @author Larissa Fraga
 */
public class CadastroCelular extends AppCompatActivity {

    /**
     * LOGICA :
     * Atividade que irá cadastrar na tabela celular do banco
     * Lembrando que um celular é vinculado a uma marca.
     * O spinner devera mostrar a lista de marcas cadastradas no banco.
     */

    public final DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_celular);
    }
}
