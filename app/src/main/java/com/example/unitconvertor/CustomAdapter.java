package com.example.unitconvertor;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<unit> {
    private Context context;
    private int resource;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<unit> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null)
            view= LayoutInflater.from(context).inflate(resource,parent,false);
        unit unit =getItem(position);
        if(unit!=null){
            ImageView imageView= view.findViewById(R.id.imageItem);
            TextView textViewDescription = view.findViewById(R.id.textViewDesc);
            Button itemButton = view.findViewById(R.id.itemButton);
            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"this item was added to cart",Toast.LENGTH_LONG).show();
                }
            });
            imageView.setImageResource(unit.getResid());
            textViewDescription.setText(unit.getDescription());

        }
        return view;

    }
}
