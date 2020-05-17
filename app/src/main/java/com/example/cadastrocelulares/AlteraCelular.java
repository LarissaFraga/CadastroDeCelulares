package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author Larissa Fraga
 */
public class AlteraCelular extends AppCompatActivity {

    /**
     * LOGICA :
     * Atividade que irá alterar um celular e a marca vinculada a ele no banco
     * OBS: O primeiro spinner é a lista de celulares que estão cadastrados no banco.
     * Ao clicar em um celular, ele deverá carregar os campos abaixo.
     * O segundo spinner mostra a lista de marcas.
     * Ao clicar em alterar, deverá alterar o celular e sua marca
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_celular);
    }
}
