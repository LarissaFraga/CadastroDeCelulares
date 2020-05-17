package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * @author Larissa Fraga
 */
public class ExclusaoMarca extends AppCompatActivity {

    /**
     * LOGICA :
     * Atividade que irá excluir uma marca da tabela marca do banco
     * OBS: Ao excluir a marca, exclua todos os celulares vinculados a ela
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusao_marca);
    }
}
