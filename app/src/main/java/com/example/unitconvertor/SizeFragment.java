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
import android.widget.Toast;
import android.widget.Toast;

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
        button.setOnClickListener(this);


        return rootView;


    }

    private void initspinnerfooter() {
        String[] items = new String[]{"Meter", "Centimeter", "Inch", "Feet","Yard","Kilometer","Mile"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinnerfrom.setAdapter(adapter1);
        spinnerfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent1, View view1, int position1, long id1) {
                double from=0.0;
                Log.v("item", (String) parent1.getItemAtPosition(position1));
                ((TextView) parent1.getChildAt(0)).setTextColor(Color.BLACK);

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

    @Override
    public void onClick(View view) {
        if(!fromEditText.getText().toString().equals("")) {
            double dub = Double.parseDouble(fromEditText.getText().toString()) * 6;
            String tot = new Double(dub).toString();
            result.setText(tot);
        }
    }
    public double same(EditText fromEditText){
        double num;
        num =Double.parseDouble(fromEditText.getText().toString());
        return num;
    }
    public double metercenti(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*100;
        return num;
    }
    public double meterinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*39.37;
        return num;
    }
    public double meterfeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*3.281;
        return num;
    }
    public double meterkilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/1000;
        return num;
    }
    public double metermile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/1609;
        return num;
    }
    public double centimeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/100;
        return num;
    }
    public double centiinch(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/2.54;
        return num;
    }
    public double centifeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/30.48;
        return num;
    }
    public double centikilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/100000;
        return num;
    }
    public double centimile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/160934;
        return num;
    }
    public double inchmeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/39.37;
        return num;
    }
    public double inchcenti(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*2.54;
        return num;
    }
    public double inchfeet(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/12;
        return num;
    }
    public double inchkilo(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/39370;
        return num;
    }
    public double inchmile(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/63360;
        return num;
    }
    public double feetmeter(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())/3.281;
        return num;
    }
    public double feetcenti(EditText fromEditText){
        double num;
        num= Double.parseDouble(fromEditText.getText().toString())*30.;
        return num;
    }


}