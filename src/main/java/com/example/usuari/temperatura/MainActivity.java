package com.example.usuari.temperatura;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void registrar(View v){
        SharedPreferences sp = this.getSharedPreferences("temperatura",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        EditText mes = (EditText) this.findViewById(R.id.edtmes);
        EditText temp = (EditText) this.findViewById(R.id.edttemp);
        String vMes = mes.getText().toString();
        int vTemp = Integer.parseInt(temp.getText().toString());
        editor.putInt(vMes,vTemp);
        editor.commit();
        //editor.apply();
        Toast.makeText(this,"Se ha guardado correctamente ", Toast.LENGTH_LONG).show();
        mes.setText("");
        temp.setText("");
        mes.requestFocus();
    }
    public void mostrar(View v){
        Intent i = new Intent(this,TempActivity.class);
        this.startActivity(i);
    }
    public void limpiar(View v){
        SharedPreferences sp = this.getSharedPreferences("temperatura",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}
