package com.example.unitconvertor;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<Conversion> {
    private Context context;
    private List<Conversion> objects;
    private int resource;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Conversion> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null)
            view= LayoutInflater.from(context).inflate(resource,parent,false);
        Conversion unit =getItem(position);
        if(unit!=null){

            String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://unit-convertor-4bca3-default-rtdb.europe-west1.firebasedatabase.app/");
            DatabaseReference myRef = firebaseDatabase.getReference("Users/"+user+"/"+unit.getKey());


            TextView textViewDescription1 = view.findViewById(R.id.textViewfrom);
            TextView textViewDescription2 = view.findViewById(R.id.textviewto);
            TextView textViewDescription3 = view.findViewById(R.id.textviewresult);

            Button itemButton = view.findViewById(R.id.buttonitem);

            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    myRef.removeValue();
                    Toast.makeText(context,"This item was deleted",Toast.LENGTH_LONG).show();
                    objects.remove(position);
                    notifyDataSetChanged();
                }
            });

            textViewDescription1.setText("From:"+unit.getFrom()+"");
            textViewDescription2.setText("To:"+unit.getTo()+"");
            textViewDescription3.setText("Result:"+unit.getResult()+"");


        }
        return view;

    }

}
