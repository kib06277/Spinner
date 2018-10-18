package com.example.rd_softwaredeveloper.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);

        //资源转[]
        String meinv[] = getResources().getStringArray(R.array.RadioMode);
        
        MySpinnerAdapter spinnerAdapter = new MySpinnerAdapter(this , meinv);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

            }
        });
    }
}
