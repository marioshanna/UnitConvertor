package com.example.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryArrayList extends AppCompatActivity  {

    //the object of view-design
    private ListView myListView;

    //the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;

    //object containing the items the be displayed-data
    private ArrayList<unit> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_array_list);

        list=new ArrayList<>();
        list.add(new unit("first item",R.drawable.ic_launcher_background,true,50));
        list.add(new unit("second item",R.drawable.ic_launcher_background,false,100));
        list.add(new unit("third item",R.drawable.ic_launcher_background,false,75));
        list.add(new unit("fourth item",R.drawable.ic_launcher_background,true,25));
        list.add(new unit("fifth item",R.drawable.ic_launcher_background,false,125));

        //reference to the list view so it can be programmed
        myListView= findViewById(R.id.myListView);
        //connect adapter with data
        myAdapter=new CustomAdapter(this,R.layout.row,list);
        //connect adapter with view
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();
            }
        });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }}