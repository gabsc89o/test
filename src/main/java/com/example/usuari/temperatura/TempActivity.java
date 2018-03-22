package com.example.usuari.temperatura;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        mostrarTemp();
    }
    public void mostrarTemp(){
        SharedPreferences sp = this.getSharedPreferences("temperatura",MODE_PRIVATE);
        Map<String, ?> todas = sp.getAll();
        Collection<?> values = todas.keySet();
        Collection<?> values2 = todas.values();
        for(Map.Entry<String, ?> t : todas.entrySet()){
            //t.getKey();
            System.out.println(t.getValue());
        }
        /*final Collection planets = new ArrayList<Integer>((Collection<? extends Integer>) todas.values());
        System.out.println(planets);
        System.out.println(planets.getClass());
        final ArrayList<Integer> b = (ArrayList<Integer>) planets;
        System.out.println(b);*/
        String[] temps = values.toArray(new String[0]);
        ListView lvtemp = (ListView) this.findViewById(R.id.lvTemperatura);
        ArrayAdapter<String> adapter= new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temps);
        lvtemp.setAdapter(adapter);
        /*lvtemp.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void
                    onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
                        Toast.makeText(TempActivity.this, b.get(position), Toast.LENGTH_LONG).show();
                    }
                });*/
    }
    public void cerrar(View v){
        this.finish();
    }
}
