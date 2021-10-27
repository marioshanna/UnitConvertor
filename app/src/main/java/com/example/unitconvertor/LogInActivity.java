package com.example.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitconvertor.SignUpActivity;

public class LogInActivity extends AppCompatActivity implements View.OnLongClickListener, DialogInterface.OnClickListener, View.OnClickListener {
    private EditText editTextTextPassword, editTextTextEmailAddress;
    private Button buttonLogIn;
    private TextView signupTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnLongClickListener(this);


        signupTextView = findViewById(R.id.text_viewSignup);
        signupTextView.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        String email = sp.getString("email", "");
        String password = sp.getString("password", "");

        if (!email.equals("") && !password.equals("")) {
            editTextTextEmailAddress.setText(email);
            editTextTextPassword.setText(password);

        }

    }


    public void login(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        if (!editTextTextEmailAddress.getText().toString().equals("")) {
            //saving email and password of user in a local file for future use
            //create sp file
            SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor = sp.edit();
            //write the wanted settings
            editor.putString("email", editTextTextEmailAddress.getText().toString());
            editor.putString("password", editTextTextPassword.getText().toString());
            //save and close file
            editor.commit();
            intent.putExtra("email", editTextTextEmailAddress.getText().toString());
            startActivity(intent);
        }

    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    //clears email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextTextEmailAddress.setText("");
        editTextTextPassword.setText("");
        return true;
    }


    public void  onClick(DialogInterface dialog,int which){
        if (which==dialog.BUTTON_POSITIVE){
            super.onBackPressed();
            dialog.cancel();
        }
        if (which==dialog.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES",this);
        builder.setNegativeButton("NO",this);
        AlertDialog dialog=builder.create();
        dialog.show();

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutsmenu:
                Toast.makeText(this, "settings", Toast.LENGTH_LONG).show();
                break;

            case R.id.exitmenu:
                //closeApplication();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}



