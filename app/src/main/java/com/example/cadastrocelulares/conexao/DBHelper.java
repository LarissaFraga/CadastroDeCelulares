package com.example.cadastrocelulares.conexao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.cadastrocelulares.modelos.Celular;
import com.example.cadastrocelulares.modelos.Marca;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Larissa FragaW
 */
public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "empresa.db";

    //Tabelas
    public static final String TABLE_NAME_CELULAR = "celular";
    private static final String TABLE_NAME_MARCA = "marca";

    // TABELA CELULAR
    public static final String COLUMN_ID_CELULAR = "id";
    private static final String COLUMN_MARCA_ID = "marca_id";
    private static final String COLUMN_MODELO = "modelo";

    // TABELA MARCA
    private static final String COLUMN_ID_MARCA = "id";
    private static final String COLUMN_MARCA = "marca";

    SQLiteDatabase db;


    // CREATE CELULAR
    private static final String TABLE_CREATE_CELULAR = "create table " + TABLE_NAME_CELULAR + " ("
            + COLUMN_ID_CELULAR + " integer primary key autoincrement, "
            + COLUMN_MARCA_ID + " integer not null, "
            + COLUMN_MODELO + " text not null, "
            + "FOREIGN KEY ( " + COLUMN_MARCA_ID + " ) REFERENCES " + TABLE_NAME_MARCA + "(" + COLUMN_ID_MARCA + "))";

    // CREATE MARCA
    private static final String TABLE_CREATE_MARCA = "create table " + TABLE_NAME_MARCA + " ("
            + COLUMN_ID_MARCA + " integer primary key autoincrement, "
            + COLUMN_MARCA + " text not null ); ";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_MARCA);
        db.execSQL(TABLE_CREATE_CELULAR);
        //db.execSQL(INSERT_MANGA);
        this.db = db;
    }

    // inserir uma marca
    public String insereMarca(Marca marca) {



        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        long resultado;

        values.put(COLUMN_MARCA, marca.getMarca());
        resultado = db.insert(TABLE_NAME_MARCA, null, values);
        db.close();

        if (resultado == -1)
            return "Erro no cadastro!";
        else {
            return "Salvo com sucesso!";
        }

    }

    // alterar uma marca
    public void alterarMarca(Marca marca) {
        long resultado;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_MARCA, marca.getMarcaId());
        values.put(COLUMN_MARCA, marca.getMarca());

        resultado = db.update(TABLE_NAME_MARCA, values, "id = " + marca.getMarca(), null);
        db.close();
    }

    // buscar todas as marcas
    public List<Marca> buscarMarcas() {
        List<Marca> listaMarcas = new ArrayList<Marca>();

        db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME_MARCA + " ORDER BY " + COLUMN_MARCA;

        try {
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    Marca marca = new Marca();
                    marca.setMarcaId(cursor.getInt(0));
                    marca.setMarca(cursor.getString(1));

                    listaMarcas.add(marca);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return listaMarcas;
    }

    //deletar marca 
    public void deletarMarca(Marca marca) {
        try {
            db.execSQL("DELETE FROM " + TABLE_NAME_MARCA + " WHERE " + COLUMN_ID_MARCA + " = " + marca.getMarcaId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // inserir celular
    public String insereCelular(Celular celular) {
        db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        long resultado;

        values.put(COLUMN_MARCA_ID, celular.getMarcaId());
        values.put(COLUMN_MODELO, celular.getModelo());

        resultado = db.insert(TABLE_NAME_CELULAR, null, values);
        db.close();

        if (resultado == -1)
            return "Erro no cadastro!";
        else {
            return "Salvo com sucesso!";
        }
    }


    // alterar celular
    public void alterarCelular(Celular celular) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_CELULAR, celular.getIdCelular());
        values.put(COLUMN_MARCA_ID, celular.getMarcaId());
        values.put(COLUMN_MARCA_ID, celular.getMarcaId());

        db.update(TABLE_NAME_CELULAR, values, "id = " + celular.getIdCelular(), null);
        db.close();
    }

    // buscar celulares
    public List<Celular> buscarCelulares() {
        List<Celular> listaCelulares = new ArrayList<Celular>();

        db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME_CELULAR + " ORDER BY " + COLUMN_MODELO;

        try {
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    Celular celular = new Celular();
                    celular.setIdCelular(cursor.getInt(0));
                    celular.setMarcaId(cursor.getInt(1));
                    celular.setModelo(cursor.getString(2));

                    listaCelulares.add(celular);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return listaCelulares;
    }
       
    //deletar celular 
    public void deletarCelular(Celular celular) {
        try {
            db.execSQL("DELETE FROM " + TABLE_NAME_CELULAR + " WHERE " + COLUMN_ID_CELULAR + " = " + celular.getIdCelular());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CELULAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MARCA);
        this.onCreate(db);
    }
}
