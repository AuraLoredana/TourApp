package com.example.popescu.tourapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ClujEvents extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluj_events);


        context = this;
        String[] items = {"1", "2"};
        final String[] web = {
                getString(R.string.electric),
                getString(R.string.untold)
        };
        ListView lstview = (ListView) findViewById(R.id.listev);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Events in Cluj-Napoca", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(ClujEvents.this, ElectricCastle.class);
                //Get the value of the item you clicked
                String itemClicked = web[0];
                intent1.putExtra("web", itemClicked);
                startActivity(intent1);

                Intent intent2 = new Intent(ClujEvents.this, Untold.class);
                //Get the value of the item you clicked
                String itemClicked2 = web[1];
                intent2.putExtra("web", itemClicked2);
                startActivity(intent2);


            }
        });
        Integer[] imageId = {
                R.drawable.electriccastle, R.drawable.untold
        };
        LstViewAdapter adapter = new LstViewAdapter(this, R.layout.list_item, R.id.txt, items, imageId, web);
        // Bind data to the ListView
        lstview.setAdapter(adapter);
    }

    public void clickMe(View view) {
        Button bt = (Button) view;
        Toast.makeText(this, "Cluj Events" + bt.getText().toString(), Toast.LENGTH_LONG).show();
    }


}

