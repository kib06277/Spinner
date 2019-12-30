package com.hfad.spinnerdropdownview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
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
        final ViewHolder holder;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.myspinner, parent, false);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.textView);
            holder.tv.setText(spinerData[position]);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    //Spinner 下拉內容
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.myspinner, parent, false);
            holder = new ViewHolder();
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            holder.tv = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        if(position == 0)
        {
            holder.linearLayout.setBackgroundResource(R.drawable.spinnerbg_top_50);
        }
        else if(position == (spinerData.length - 1) )
        {
            holder.linearLayout.setBackgroundResource(R.drawable.spinnerbg_bottom_50);
        }
        else
        {
            holder.linearLayout.setBackgroundResource(R.drawable.spinnerbg_center_50);
        }
        holder.tv.setText(spinerData[position]);

        return convertView;
    }

    private static class ViewHolder
    {
        TextView tv;
        LinearLayout linearLayout;
    }
}
