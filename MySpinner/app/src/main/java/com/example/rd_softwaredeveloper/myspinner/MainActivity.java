package com.example.rd_softwaredeveloper.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //关联控件
        spinner = (Spinner) findViewById(R.id.spinner1);

        // 将可选内容与ArrayAdapter连接起来
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.RadioMode, android.R.layout.simple_spinner_item);
        // 第一个参数为Context对象
        // 第二个参数为要显示的数据源,也就是在string.xml配置的数组列表
        // 第三个参数为设置Spinner的样式

        // 设置Spinner中每一项的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 设置Spinner数据来源适配器
        spinner.setAdapter(adapter);

        // 使用内部类形式来实现事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                /*
                 * 第一个参数parent是你当前所操作的Spinner，可根据parent.getId()与R.id.
                 * currentSpinner是否相等，来判断是否你当前操作的Spinner,一般在onItemSelected
                 * 方法中用switch语句来解决多个Spinner问题。
                 * 第二个参数view一般不用到；
                 * 第三个参数position表示下拉中选中的选项位置，自上而下从0开始；
                 * 第四个参数id表示的意义与第三个参数相同。
                 */

                //对选中项进行显示
                //Toast用于临时信息的显示
                //第一个参数是上下文环境，可用this；
                //第二个参数是要显示的字符串；
                //第三个参数是显示的时间长短；
                String str = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "您选择的国家是："+str, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // TODO Auto-generated method stub
            }
        });
    }
}
