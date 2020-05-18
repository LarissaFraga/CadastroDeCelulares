package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cadastrocelulares.conexao.DBHelper;

/**
 * @author Larissa Fraga
 */
public class ExclusaoCelular extends AppCompatActivity {

    /**
     * LOGICA :
     * Atividade que irá excluir um celular da tabela celular do banco
     *
     */

    private Button btnExcluirCelular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusao_celular);



    }
}
