package com.example.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[]={
            "Nepal","Kathmandu",
            "India", "New Dehli",
            "China", "BEijing",
            "UK","london",
            "US","wasington",
            "Canada","Ottawa"
    };
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView Countries=findViewById(R.id.lstcountries);

        dictionary= new HashMap<>();
        for(int i=0;i<countries.length;i+=2){
            dictionary.put(countries[i],countries[i+1]);
        }

        ArrayAdapter countryAdapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        Countries.setAdapter(countryAdapter);
        Countries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          String Country=parent.getItemAtPosition(position).toString();
          String Capital=dictionary.get(Country);
                Toast.makeText(getApplicationContext(), Capital.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }

}
