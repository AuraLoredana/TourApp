package com.example.popescu.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by POPESCU on 7/15/2017.
 */

public class LstViewAdapter extends ArrayAdapter<String> {
    int groupid;
    String[] item_list;
    ArrayList<String> desc;
    Context context;
    Integer[] imageId;
    final String[] web;

    public LstViewAdapter(Context context, int vg, int id, String[] item_list, Integer[] imageId, String[] web) {
        super(context, vg, id, item_list);
        this.context = context;
        groupid = vg;
        this.item_list = item_list;
        this.imageId = imageId;
        this.web = web;


    }

    // Hold views of the ListView to improve its scrolling performance
    static class ViewHolder {
        public TextView textview;
        public Button button;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        // Inflate the list_item.xml file if convertView is null
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(groupid, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textview = (TextView) rowView.findViewById(R.id.txt);
            viewHolder.button = (Button) rowView.findViewById(R.id.bt);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
            imageView.setImageResource(imageId[position]);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
            txtTitle.setText(web[position]);
            rowView.setTag(viewHolder);

        }
        // Set text to each TextView of ListView item
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textview.setText(item_list[position]);
        holder.button.setText(web[position]);

        return rowView;
    }
}

