package com.hfad.repeatselectspinner;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

@SuppressLint("AppCompatCustomView")
public class ReSpinner extends Spinner
{
    public boolean isDropDownMenuShown = false; //下拉列表是否在顯示

    public ReSpinner(Context context)
    {
        super(context);
    }

    public ReSpinner(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ReSpinner(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public void
    setSelection(int position, boolean animate)
    {
        boolean sameSelected = position == getSelectedItemPosition();
        super.setSelection(position, animate);
        if (sameSelected)
        {
            //如果選擇項目是 spinner 當前已選擇的項目，則 OnItemSelectedListener 並不會被呼叫，因此這手動呼叫
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }

    @Override
    public boolean performClick()
    {
        this.isDropDownMenuShown = true;
        return super.performClick();
    }

    public boolean isDropDownMenuShown()
    {
        return isDropDownMenuShown;
    }

    public void setDropDownMenuShown(boolean isDropDownMenuShown)
    {
        this.isDropDownMenuShown=isDropDownMenuShown;
    }

    @Override
    public void
    setSelection(int position)
    {
        boolean sameSelected = position == getSelectedItemPosition();
        super.setSelection(position);
        if (sameSelected)
        {
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }

    @Override
    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }
}