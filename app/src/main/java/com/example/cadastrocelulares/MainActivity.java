package com.example.cadastrocelulares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Larissa Fraga
 */
public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarMarca;  // direcionar para cadastro de marca
    private Button btnCadastrarCelular; // direcionar para cadastro de celular

    private Button btnExcluirMarca; // direcionar para excluir marca
    private Button btnExcluirCelular; // direcionar para excluir celular

    private Button btnAlterarMarca; // direcionar para alterar marca
    private Button btnAlterarCelular; // direcionar para alterar celular

    private Button btnListarCelulares; // direcionar para lista de celulares

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarMarca = findViewById(R.id.btnCadastrarMarca);
        btnCadastrarCelular = findViewById(R.id.btnCadastrarCelular);

        btnExcluirMarca = findViewById(R.id.btnExcluirMarca);
        btnExcluirCelular = findViewById(R.id.btnExcluirCelular);

        btnAlterarMarca = findViewById(R.id.btnAlterarMarca);
        btnAlterarCelular =  findViewById(R.id.btnAlterarCelular);

        btnListarCelulares = findViewById(R.id.btnListarCelulares);

        btnCadastrarMarca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroMarca.class);
                startActivity(intent);
            }
        });

        btnCadastrarCelular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroCelular.class);
                startActivity(intent);
            }
        });

        btnExcluirMarca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExclusaoMarca.class);
                startActivity(intent);
            }
        });

        btnExcluirCelular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExclusaoCelular.class);
                startActivity(intent);
            }
        });

        btnAlterarMarca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlteraMarca.class);
                startActivity(intent);
            }
        });

        btnAlterarCelular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlteraCelular.class);
                startActivity(intent);
            }
        });

        btnListarCelulares.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaCelulares.class);
                startActivity(intent);
            }
        });
    }
}