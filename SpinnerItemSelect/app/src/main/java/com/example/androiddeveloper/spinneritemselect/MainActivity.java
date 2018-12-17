package com.example.androiddeveloper.spinneritemselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int currentItem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final String[] lunch = {"雞腿飯", "魯肉飯", "排骨飯", "水餃", "陽春麵"};
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, lunch);
        spinner.setAdapter(lunchList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(currentItem == position)
                {

                }
                else
                {
                    Toast.makeText(MainActivity.this, "你選的是" + lunch[position], Toast.LENGTH_SHORT).show();
                }
                currentItem = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}
