package com.example.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class About extends AppCompatActivity  {
    private MenuItem logout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //  logout1 = findViewById(R.id.logoutmenu);
        // logout1.setOnCl
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cammenu:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.aboutsmenu:
                Toast.makeText(this, "about", Toast.LENGTH_LONG).show();
                break;
            case R.id.logoutmenu:
                Intent i = new Intent(this, LogInActivity.class);
                startActivity(i);
                break;


        }


        return super.onOptionsItemSelected(item);

    }

}