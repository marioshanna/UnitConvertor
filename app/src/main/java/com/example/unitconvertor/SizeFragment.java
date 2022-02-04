package com.example.unitconvertor;

import android.content.Intent;
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
    private double res=0;



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        button.setOnClickListener(this);
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



//{"Meter", "Centimeter", "Inch", "Feet","Kilometer","Mile"}
    @Override
    public void onClick(View view) {
        if(!fromEditText.getText().toString().equals("")) {

            if(from==0){
                switch (to){
                    case 0:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(metercenti(fromEditText));
                        result.setText(metercenti(fromEditText));
                        break;
                    case 2:
                        res=Double.parseDouble(meterinch(fromEditText));
                        result.setText(meterinch(fromEditText));
                        break;
                    case 3:
                        res=Double.parseDouble(meterfeet(fromEditText));
                        result.setText(meterfeet(fromEditText));
                        break;
                    case 4:
                        res=Double.parseDouble(meterkilo(fromEditText));
                        result.setText(meterkilo(fromEditText));
                        break;
                    case 5:
                        res=Double.parseDouble(metermile(fromEditText));
                        result.setText(metermile(fromEditText));
                        break;
                }
            }
            if(from==1){
                switch (to){
                    case 0:
                        res=Double.parseDouble(centimeter(fromEditText));
                        result.setText(centimeter(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                    case 2:
                        res=Double.parseDouble(centiinch(fromEditText));
                        result.setText(centiinch(fromEditText));
                        break;
                    case 3:
                        res=Double.parseDouble(centifeet(fromEditText));
                        result.setText(centifeet(fromEditText));
                        break;
                    case 4:
                        res=Double.parseDouble(centikilo(fromEditText));
                        result.setText(centikilo(fromEditText));
                        break;
                    case 5:
                        res=Double.parseDouble(centimile(fromEditText));
                        result.setText(centimile(fromEditText));
                        break;
                }
            }
            if(from==2){
                switch (to){
                    case 0:
                        res=Double.parseDouble(inchmeter(fromEditText));
                        result.setText(inchmeter(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(inchcenti(fromEditText));
                        result.setText(inchcenti(fromEditText));
                        break;
                    case 2:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                    case 3:
                        res=Double.parseDouble(inchfeet(fromEditText));
                        result.setText(inchfeet(fromEditText));
                        break;
                    case 4:
                        res=Double.parseDouble(inchkilo(fromEditText));
                        result.setText(inchkilo(fromEditText));
                        break;
                    case 5:
                        res=Double.parseDouble(inchmile(fromEditText));
                        result.setText(inchmile(fromEditText));
                        break;
                }
            }
            if(from==3){
                switch (to){
                    case 0:
                        res=Double.parseDouble(feetmeter(fromEditText));
                        result.setText(feetmeter(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(feetcenti(fromEditText));
                        result.setText(feetcenti(fromEditText));
                        break;
                    case 2:
                        res=Double.parseDouble(feetinch(fromEditText));
                        result.setText(feetinch(fromEditText));
                        break;
                    case 3:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                    case 4:
                        res=Double.parseDouble(feetkilo(fromEditText));
                        result.setText(feetkilo(fromEditText));
                        break;
                    case 5:
                        res=Double.parseDouble(feetmile(fromEditText));
                        result.setText(feetmile(fromEditText));
                        break;
                }
            }
            if(from==4){
                switch (to){
                    case 0:
                        res=Double.parseDouble(kilometer(fromEditText));
                        result.setText(kilometer(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(kilocm(fromEditText));
                        result.setText(kilocm(fromEditText));
                        break;
                    case 2:
                        res=Double.parseDouble(kiloinch(fromEditText));
                        result.setText(kiloinch(fromEditText));
                        break;
                    case 3:
                        res=Double.parseDouble(kilofeet(fromEditText));
                        result.setText(kilofeet(fromEditText));
                        break;
                    case 4:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                    case 5:
                        res=Double.parseDouble(kilomile(fromEditText));
                        result.setText(kilomile(fromEditText));
                        break;
                }
            }
            if(from==5){
                switch (to){
                    case 0:
                        res=Double.parseDouble(milemeter(fromEditText));
                        result.setText(milemeter(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(milecm(fromEditText));
                        result.setText(milecm(fromEditText));
                        break;
                    case 2:
                        res=Double.parseDouble(mileinch(fromEditText));
                        result.setText(mileinch(fromEditText));
                        break;
                    case 3:
                        res=Double.parseDouble(milefeet(fromEditText));
                        result.setText(milefeet(fromEditText));
                        break;
                    case 4:
                        res=Double.parseDouble(milekm(fromEditText));
                        result.setText(milekm(fromEditText));
                        break;
                    case 5:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                }
            }



        }

        addToHistory("Size", from, to, res);

    }
    public void addToHistory(String conversion, int from, int to, double result){
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://unit-convertor-4bca3-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = firebaseDatabase.getReference("Users/"+conversion);
        Conversion conversion1 = new Conversion(conversion, from, to, result);
        myRef.push().setValue(conversion1);
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