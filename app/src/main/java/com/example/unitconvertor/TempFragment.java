package com.example.unitconvertor;

import android.graphics.Color;
import android.os.Bundle;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TempFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TempFragment extends Fragment implements View.OnClickListener{
    private Spinner spinnerfrom;
    private Spinner spinnerto;
    private EditText fromEditText;
    private TextView result;
    private Button button;
    private int from=0, to=0;
    private double res=0;
    private String fromtype;
    private String totype;
    private String[] items = new String[]{"fehrenheit","celsius"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TempFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TempFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TempFragment newInstance(String param1, String param2) {
        TempFragment fragment = new TempFragment();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_temp, container, false);
        spinnerfrom = rootView.findViewById(R.id.spinnerfromtemp);
        fromEditText =rootView.findViewById(R.id.fromtexttemp);
        spinnerto = rootView.findViewById(R.id.spinnertotemp);
        result = rootView.findViewById(R.id.Resulttemp);
        button = rootView.findViewById(R.id.convertor_buttontemp);
        initspinnerfooter();
        initspinnerfooter1();
        // Write a message to the database
        button.setOnClickListener(this);
        return rootView;

    }
    private void initspinnerfooter() {
        String[] items = new String[]{"fehrenheit","celsius"};
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
        String[] items1 = new String[]{"fehrenheit","celsius"};
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
    @Override
    public void onClick(View view) {
        fromtype=items[from];
        totype=items[to];
        if(!fromEditText.getText().toString().equals("")) {

            if(from==0){
                switch (to){
                    case 0:
                        res=Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;
                    case 1:
                        res=Double.parseDouble(fercel(fromEditText));
                        result.setText(fercel(fromEditText));
                        break;
                }
            }
            if(from==1) {
                switch (to) {
                    case 0:
                        res = Double.parseDouble(celfer(fromEditText));
                        result.setText(celfer(fromEditText));
                        break;
                    case 1:
                        res = Double.parseDouble(same(fromEditText));
                        result.setText(same(fromEditText));
                        break;

                }
            }}
        addToHistory("Size", from, to, res,Double.parseDouble((fromEditText.getText().toString())),fromtype,totype);
    }

    public void addToHistory(String conversion, int from, int to, double result,double fromnum,String fromtype,String totype){
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://unit-convertor-4bca3-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = firebaseDatabase.getReference("Users/"+user);
        Conversion conversion1 = new Conversion(conversion, from, to, result,fromnum,fromtype,totype);
        String key = myRef.push().getKey();//.setValue(conversion1);
        myRef = firebaseDatabase.getReference("Users/"+user+"/"+key);
        conversion1.setKey(key);
        myRef.setValue(conversion1);}
    public String same(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString());
        String tot = new Double(num).toString();
        return tot;
    }
    public String fercel(EditText fromEditText){
        double num;
        num= (Double.parseDouble(fromEditText.getText().toString())-32)/1.8;
        String tot = new Double(num).toString();
        return tot;
    }
    public String celfer(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*1.8+32;
        String tot = new Double(num).toString();
        return tot;
    }

}