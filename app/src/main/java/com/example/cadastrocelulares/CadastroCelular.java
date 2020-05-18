package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastrocelulares.conexao.DBHelper;
import com.example.cadastrocelulares.modelos.Celular;
import com.example.cadastrocelulares.modelos.Marca;

import java.util.List;

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

    private TextView textView2;
    private Button btnCadastrarCelular;
    private Spinner spinner;



    protected void onCreate(Bundle savedInstanceState) {
        DBHelper bdController = new DBHelper(getBaseContext());
        final List<Marca> listaMarca =  (List<Marca>) bdController.buscarMarcas();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_celular);
        spinner = findViewById(R.id.spinner_cel);

        ArrayAdapter<Marca> adapter = new ArrayAdapter<Marca>(getBaseContext(), android.R.layout.simple_expandable_list_item_1,listaMarca);
        spinner.setAdapter(adapter);


        //chamar a listagem de marcas


        btnCadastrarCelular = (Button) findViewById(R.id.btnCadastrarCelular);

        //clique no botão
        btnCadastrarCelular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper bdController = new DBHelper(getBaseContext());

                String spinners = spinner.getSelectedItem().toString();


                EditText nome = (EditText) findViewById(R.id.edtNomeCelular);


                String stringNome = nome.getText().toString();

                Celular cel = new Celular();
                cel.setModelo(stringNome);
                bdController.insereCelular(cel);

                Toast.makeText(getApplicationContext(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();


            }
        });
    }
}
