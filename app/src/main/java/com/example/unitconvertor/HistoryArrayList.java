package com.example.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Unit;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryArrayList extends AppCompatActivity  {

    //the object of view-design
    private ListView myListView;

    //the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;

    //object containing the items the be displayed-data
    private ArrayList<Conversion> list;

    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();

    private Button button;


    public void Unit (){}
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_array_list);

        list=new ArrayList<>();
        button = findViewById(R.id.buttonitem);



      //list.add(new Conversion("first item",1,1,1.0));
      //  list.add(new unit("second item",R.drawable.sun,false,100));
       // list.add(new unit("third item",R.drawable.sun,false,75));
       // list.add(new unit("fourth item",R.drawable.sun,true,25));
       // list.add(new unit("fifth item",R.drawable.sun,false,125));

       //reference to the list view so it can be programmed
        myListView= findViewById(R.id.myListView);
        //connect adapter with data
        myAdapter=new CustomAdapter(this,R.layout.row,list);
        //connect adapter with view
        myListView.setAdapter(myAdapter);
        
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://unit-convertor-4bca3-default-rtdb.europe-west1.firebasedatabase.app/");
        String UID= mFirebaseAuth.getUid();
        DatabaseReference myRef = database.getReference("Users/"+UID);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                  Conversion unit = dataSnapshot.getValue(Conversion.class);
                  list.add(unit);

                  myAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




}