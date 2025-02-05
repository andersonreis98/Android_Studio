package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
//            cria banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
//            criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS PESSOAS(ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME VARCHAR,IDADE INT(3))");
//            INSERIR DADOS
//            bancoDados.execSQL("INSERT INTO PESSOAS(NOME, IDADE) VALUES ('MARIANA',20)");
//            bancoDados.execSQL("INSERT INTO PESSOAS(NOME, IDADE) VALUES ('PEDRO',30)");

//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE NOME = 'ANDERSON' AND IDADE=23";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE IDADE>=23";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE IDADE IN(20,50)";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE IDADE BETWEEN 35 AND 50";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE NOME LIKE '%AN%'";
//            String filtro = "an";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE NOME LIKE '%"+filtro+"%'";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE 1=1 ORDER BY NOME DESC";
//            String consulta = "SELECT NOME, IDADE FROM PESSOAS WHERE 1=1 ORDER BY NOME DESC LIMIT 3";
            String consulta = "SELECT ID, NOME, IDADE FROM PESSOAS";

//            atualizar registros
//            bancoDados.execSQL("UPDATE PESSOAS SET IDADE = 19 WHERE NOME = 'ANDERSON'");
//
//            deleta registros
//            bancoDados.execSQL("DELETE FROM PESSOAS WHERE ID=2");
//
//            limpar tabela
//            bancoDados.execSQL("DROP TABLE PESSOAS");

//            RECUPERA PESSOAS
            Cursor cursor = bancoDados.rawQuery(consulta, null);

//            indices da tabela
            int indiceNome = cursor.getColumnIndex("NOME");
            int indiceIdade = cursor.getColumnIndex("IDADE");
            int indiceId = cursor.getColumnIndex("ID");

            cursor.moveToFirst();

            while (cursor != null) {
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);

                Log.i("Resultado - nome", nome + " idade " + idade + " anos, ID "+id);
//                Log.i("Resultado - idade:", idade);

                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}