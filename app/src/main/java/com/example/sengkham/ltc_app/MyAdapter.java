package com.example.sengkham.ltc_app;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Sengkham on 16/12/2016.
 */



public class MyAdapter extends BaseAdapter {
    private Context context;
    private  String[] nameStrings,latStrings,lngStrings,iconStrings;

    public MyAdapter(Context context, String[] nameStrings, String[] latStrings, String[] lngStrings, String[] iconStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        this.latStrings = latStrings;
        this.lngStrings = lngStrings;
        this.iconStrings = iconStrings;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup,false);

        TextView nameTextView = (TextView) view1.findViewById(R.id.textView9);
        TextView latTextView = (TextView) view1.findViewById(R.id.textView8);
        TextView lngTextView = (TextView) view1.findViewById(R.id.textView7);
        return null;
    }
}
