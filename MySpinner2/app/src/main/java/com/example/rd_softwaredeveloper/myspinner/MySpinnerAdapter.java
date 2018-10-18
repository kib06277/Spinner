package com.example.rd_softwaredeveloper.myspinner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MySpinnerAdapter extends BaseAdapter
{
    String[] spinerData;
    private LayoutInflater mInflater;

    public MySpinnerAdapter(Context context , String[] spinerData)
    {
        mInflater = LayoutInflater.from(context);
        this.spinerData = spinerData;

        for(int i = 0 ; i < spinerData.length ; i++)
        {
            Log.i("EE", "meinv[" + i + "] = " + spinerData[i]);
        }
    }

    @Override
    public int getCount()
    {
        return spinerData.length;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final MySpinnerAdapter.CouponVH couponVH;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.myspinner, parent, false);
            couponVH = new MySpinnerAdapter.CouponVH();
            couponVH.text1 = (TextView) convertView.findViewById(R.id.text1);
            couponVH.text1.setText(spinerData[position]);
        }
        else
        {
            couponVH = (MySpinnerAdapter.CouponVH) convertView.getTag();
        }
        return convertView;
    }

    public static class CouponVH
    {
        private TextView text1;
    }
}
