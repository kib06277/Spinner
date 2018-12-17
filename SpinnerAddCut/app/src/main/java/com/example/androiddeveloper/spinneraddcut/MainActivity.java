package com.example.androiddeveloper.spinneraddcut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private String[] city = { "高雄", "台北", "台中", "屏東" };
    private TextView tv;
    private EditText et;
    private Button add, delete;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private List<String> all;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.cut);

        //將資料導入 list 中才能進行動態控制
        all = new ArrayList<String>();
        for (int i = 0; i < city.length; i++)
        {
            all.add(city[i]);
        }

        adapter = new ArrayAdapter<String>(this, R.layout.myspinner, all);
        adapter.setDropDownViewResource(R.layout.myspinner);

        spinner = (Spinner) findViewById(R.id.my_spinner);
        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String newString = et.getText().toString();

                //如果已經存在的則不在輸入
                for (int i = 0; i < adapter.getCount(); i++)
                {
                    if (newString.equals(adapter.getItem(i)))
                    {
                        return;
                    }
                }

                if (!newString.equals(""))
                {
                    adapter.add(newString); //新增資料到 adapter 中
                    int position = adapter.getPosition(newString); //取得新值的位置
                    spinner.setSelection(position); //將 Spinner 定位新值
                    et.setText("");
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //如果 spinner 不是空的
                if (spinner.getSelectedItem() != null)
                {
                    adapter.remove(spinner.getSelectedItem().toString());
                    et.setText("");

                    if (adapter.getCount() == 0)
                    {
                        tv.setText("");
                    }
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //將點選的顯示在 Textview
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                tv.setText(arg0.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
        });
    }
}
