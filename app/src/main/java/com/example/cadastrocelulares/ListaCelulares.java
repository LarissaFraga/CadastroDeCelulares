package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.cadastrocelulares.conexao.DBHelper;

import java.util.ArrayList;


/**
 * @author Larissa Fraga
 */
public class ListaCelulares extends AppCompatActivity {

    private ListView listaCelulares;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_celulares);

        DBHelper bdController = new DBHelper(getBaseContext());
        final Cursor cursor = (Cursor) bdController.buscarCelulares();

        String[] nomeCampos = new String[]{DBHelper.TABLE_NAME_CELULAR};
        int[] idViews = new int[]{R.id.edtNomeCelular};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_cadastro_celular,cursor,nomeCampos,idViews,0);
        listaCelulares = (ListView) findViewById(R.id.listaCelulares);
        listaCelulares.setAdapter(adaptador);



    }
}
