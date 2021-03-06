package com.example.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.unitconvertor.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnLongClickListener, DialogInterface.OnClickListener, View.OnClickListener {
    private static final String TAG ="FIREBASE" ;
    private EditText editTextTextPassword1, editTextTextEmailAddress1;
    private Button buttonLogIn;
    private TextView signupTextView;
    private FirebaseAuth mAuth;
    private Intent musicIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();

        editTextTextEmailAddress1 = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword1 = findViewById(R.id.editTextTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnLongClickListener(this);


        signupTextView = findViewById(R.id.text_viewSignup);
        signupTextView.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        String email = sp.getString("email", "");
        String password = sp.getString("password", "");

        if (!email.equals("") && !password.equals("")) {
            editTextTextEmailAddress1.setText(email);
            editTextTextPassword1.setText(password);

        }
        musicIntent = new Intent(this,MusicService.class);
        startService(musicIntent);



    }


    //clears email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextTextEmailAddress1.setText("");
        editTextTextPassword1.setText("");
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


    public void login2 (View view){
        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("email",editTextTextEmailAddress1.getText().toString());
        editor.putString("password",editTextTextPassword1.getText().toString());
        editor.commit();
        login(editTextTextEmailAddress1.getText().toString(),editTextTextPassword1.getText().toString());

    }


public void login(String email,String password){
    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent i =new Intent(LogInActivity.this,MainActivity.class);
                        startActivity(i);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(LogInActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                    }


                }
            });
}

}



