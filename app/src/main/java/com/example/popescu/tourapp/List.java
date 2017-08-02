package com.example.popescu.tourapp;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by POPESCU on 7/16/2017.
 */

public class List extends ListFragment {


    Intent i;
    String[] listitems = {
            "Top Attractions",
            "Restaurans",
            "Cluj Events"
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listitems));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                i = new Intent(getActivity(), TopAttractions.class);
                break;
            case 1:
                i = new Intent(getActivity(), Restaurants.class);
                break;
            case 2:
                i = new Intent(getActivity(), ClujEvents.class);
                break;
        }
        startActivity(i);
    }
}
