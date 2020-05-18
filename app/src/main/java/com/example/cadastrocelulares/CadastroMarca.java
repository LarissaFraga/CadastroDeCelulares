package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastrocelulares.conexao.DBHelper;
import com.example.cadastrocelulares.modelos.Marca;

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

    private TextView textView2;
    private Button btnCadastrarMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_marca);

        btnCadastrarMarca = (Button) findViewById(R.id.btnCadastrarMarca);



        //clique no botão
        btnCadastrarMarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper bdController = new DBHelper(getBaseContext());
                EditText nomeMarca =(EditText) findViewById(R.id.edtNomeMarca);
                String marcaString = nomeMarca.getText().toString();

                Marca marca = new Marca();
                marca.setMarca(marcaString);
                bdController.insereMarca(marca);

                Toast.makeText(getApplicationContext(),"Salvo com sucesso!", Toast.LENGTH_LONG).show();


            }
        });

    }
}
