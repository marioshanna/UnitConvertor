package com.example.unitconvertor;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.InvocationTargetException;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SizeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SizeFragment<adapter> extends Fragment implements View.OnClickListener{
    private Spinner spinnerfrom;
    private Spinner spinnerto;
    private EditText fromEditText;
    private TextView result;
    private Button button;
    private int from=0, to=0;
    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    int sw=0;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SizeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SizeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SizeFragment newInstance(String param1, String param2) {
        SizeFragment fragment = new SizeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_size, container, false);
        spinnerfrom = rootView.findViewById(R.id.spinnerfrom);
        fromEditText =rootView.findViewById(R.id.fromtext);
        spinnerto = rootView.findViewById(R.id.spinnerto);
        result = rootView.findViewById(R.id.Result);
        button = rootView.findViewById(R.id.convertor_button);
        initspinnerfooter();
        initspinnerfooter1();
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://unit-convertor-4bca3-default-rtdb.europe-west1.firebasedatabase.app/");
        String UID= mFirebaseAuth.getUid();
        DatabaseReference myRef = database.getReference("users"+UID);
        myRef.push().setValue(from);
        button.setOnClickListener(this);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    double from = (double) dataSnapshot.getValue();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return rootView;


    }

    private void initspinnerfooter() {
        String[] items = new String[]{"Meter", "Centimeter", "Inch", "Feet","Kilometer","Mile"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinnerfrom.setAdapter(adapter1);
        spinnerfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent1, View view1, int position1, long id1) {
                double from=0.0;
                Log.v("item", (String) parent1.getItemAtPosition(position1));
                ((TextView) parent1.getChildAt(0)).setTextColor(Color.BLACK);
                from = position1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }


    private void initspinnerfooter1() {
        String[] items1 = new String[]{"Meter", "Centimeter", "Inch", "Feet","Kilometer","Mile"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items1);
        spinnerto.setAdapter(adapter2);
        spinnerto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent2, View view2, int position2, long id2) {

                Log.v("item", (String) parent2.getItemAtPosition(position2));
                ((TextView) parent2.getChildAt(0)).setTextColor(Color.BLACK);
                to=position2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }
    public void change(){
        if(!fromEditText.getText().toString().equals("")) {
            double dub = Double.parseDouble(fromEditText.getText().toString()) * 6;
            String tot = new Double(dub).toString();
            result.setText(tot);
        }

    }
//{"Meter", "Centimeter", "Inch", "Feet","Kilometer","Mile"}
    @Override
    public void onClick(View view) {
        if(!fromEditText.getText().toString().equals("")) {
            if(from==0){
                switch (to){
                    case 0:
                        result.setText(same(fromEditText));
                        break;
                    case 1:
                        result.setText(metercenti(fromEditText));
                        break;
                    case 2:
                        result.setText(meterinch(fromEditText));
                        break;
                    case 3:
                        result.setText(meterfeet(fromEditText));
                        break;
                    case 4:
                        result.setText(meterkilo(fromEditText));
                        break;
                    case 5:
                        result.setText(metermile(fromEditText));
                        break;
                }
            }
            if(from==1){
                switch (to){
                    case 0:
                        result.setText(centimeter(fromEditText));
                        break;
                    case 1:
                        result.setText(same(fromEditText));
                        break;
                    case 2:
                        result.setText(centiinch(fromEditText));
                        break;
                    case 3:
                        result.setText(centifeet(fromEditText));
                        break;
                    case 4:
                        result.setText(centikilo(fromEditText));
                        break;
                    case 5:
                        result.setText(centimile(fromEditText));
                        break;
                }
            }
            if(from==2){
                switch (to){
                    case 0:
                        result.setText(inchmeter(fromEditText));
                        break;
                    case 1:
                        result.setText(inchcenti(fromEditText));
                        break;
                    case 2:
                        result.setText(same(fromEditText));
                        break;
                    case 3:
                        result.setText(inchfeet(fromEditText));
                        break;
                    case 4:
                        result.setText(inchkilo(fromEditText));
                        break;
                    case 5:
                        result.setText(inchmile(fromEditText));
                        break;
                }
            }
            if(from==3){
                switch (to){
                    case 0:
                        result.setText(feetmeter(fromEditText));
                        break;
                    case 1:
                        result.setText(feetcenti(fromEditText));
                        break;
                    case 2:
                        result.setText(feetinch(fromEditText));
                        break;
                    case 3:
                        result.setText(same(fromEditText));
                        break;
                    case 4:
                        result.setText(feetkilo(fromEditText));
                        break;
                    case 5:
                        result.setText(feetmile(fromEditText));
                        break;
                }
            }
            if(from==4){
                switch (to){
                    case 0:
                        result.setText(kilometer(fromEditText));
                        break;
                    case 1:
                        result.setText(kilocm(fromEditText));
                        break;
                    case 2:
                        result.setText(kiloinch(fromEditText));
                        break;
                    case 3:
                        result.setText(kilofeet(fromEditText));
                        break;
                    case 4:
                        result.setText(same(fromEditText));
                        break;
                    case 5:
                        result.setText(kilomile(fromEditText));
                        break;
                }
            }
            if(from==5){
                switch (to){
                    case 0:
                        result.setText(milemeter(fromEditText));
                        break;
                    case 1:
                        result.setText(milecm(fromEditText));
                        break;
                    case 2:
                        result.setText(mileinch(fromEditText));
                        break;
                    case 3:
                        result.setText(milefeet(fromEditText));
                        break;
                    case 4:
                        result.setText(milekm(fromEditText));
                        break;
                    case 5:
                        result.setText(same(fromEditText));
                        break;
                }
            }


        }
    }
    public String same(EditText fromEditText){
        double num;
        num =Double.parseDouble(fromEditText.getText().toString());
        String tot = new Double(num).toString();
        return tot;
    }
    public String metercenti(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*100;
        String tot = new Double(num).toString();
        return tot;
    }
    public String meterinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*39.37;
        String tot = new Double(num).toString();
        return tot;
    }
    public String meterfeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*3.281;
        String tot = new Double(num).toString();
        return tot;
    }
    public String meterkilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/1000;
        String tot = new Double(num).toString();
        return tot;
    }
    public String metermile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/1609;
        String tot = new Double(num).toString();
        return tot;
    }
    public String centimeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/100;
        String tot = new Double(num).toString();
        return tot;
    }
    public String centiinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/2.54;
        String tot = new Double(num).toString();
        return tot;
    }
    public String centifeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/30.48;
        String tot = new Double(num).toString();
        return tot;
    }
    public String centikilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/100000;
        String tot = new Double(num).toString();
        return tot;
    }
    public String centimile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/160934;
        String tot = new Double(num).toString();
        return tot;
    }
    public String inchmeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/39.37;
        String tot = new Double(num).toString();
        return tot;
    }
    public String inchcenti(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*2.54;
        String tot = new Double(num).toString();
        return tot;
    }
    public String inchfeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/12;
        String tot = new Double(num).toString();
        return tot;
    }
    public String inchkilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/39370;
        String tot = new Double(num).toString();
        return tot;
    }
    public String inchmile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/63360;
        String tot = new Double(num).toString();
        return tot;
    }
    public String feetmeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/3.281;
        String tot = new Double(num).toString();
        return tot;
    }
    public String feetcenti(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*30.48;
        String tot = new Double(num).toString();
        return tot;
    }
    public String feetkilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/3281;
        String tot = new Double(num).toString();
        return tot;
    }
    public String feetinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*12;
        String tot = new Double(num).toString();
        return tot;
    }
    public String feetmile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/5280;
        String tot = new Double(num).toString();
        return tot;
    }
    public String kilometer(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*1000;
        String tot = new Double(num).toString();
        return tot;
    }
    public String kilocm(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*100000;
        String tot = new Double(num).toString();
        return tot;
    }
    public String kiloinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*39370;
        String tot = new Double(num).toString();
        return tot;
    }
    public String kilofeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*3281;
        String tot = new Double(num).toString();
        return tot;
    }
    public String kilomile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/1.609;
        String tot = new Double(num).toString();
        return tot;
    }
    public String milemeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*1609;
        String tot = new Double(num).toString();
        return tot;
    }
    public String milecm(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*160934;
        String tot = new Double(num).toString();
        return tot;
    }
    public String mileinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*63360;
        String tot = new Double(num).toString();
        return tot;
    }
    public String milefeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*5280;
        String tot = new Double(num).toString();
        return tot;
    }
    public String milekm(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*1.609;
        String tot = new Double(num).toString();
        return tot;
    }


}

//{"Meter", "Centimeter", "Inch", "Feet","Kilometer","Mile"};