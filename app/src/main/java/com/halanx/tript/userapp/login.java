package com.halanx.tript.userapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    Button login, signup;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public static final int RC_SIGN_IN=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*mAuth= FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d("SIGNIN_ACT", "onAuthStateChanged:signed_in:"+user.getUid()); //user signed in
                }
                else {
                    Log.d("SIGNIN_ACT", "onAuthStatteChanged:signed_out");
                    startActivityForResult(
                            // Get an instance of AuthUI based on the default app
                            AuthUI.getInstance().createSignInIntentBuilder().setIsSmartLockEnabled(false).build(),
                            RC_SIGN_IN);
                }
            }
        };*/
        login = (Button) findViewById(R.id.button);
        signup= (Button) findViewById(R.id.sign_up);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(login.this,Home.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent intent2= new Intent(login.this,signup.class);
                startActivity(intent2);
            }
        });

        Button vibrate= (Button) findViewById(R.id.vibrate);
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,Vibrate.class);
                startActivity(intent);
            }
        });

        Button pop = (Button) findViewById(R.id.PopUp);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Call_Popups.class));
            }
        });
    }
    public void onResume(){
        super.onResume();
       // mAuth.addAuthStateListener(mAuthListener);
    }
    public void onPause(){
        super.onPause();
       // if(mAuthListener != null)
       // mAuth.removeAuthStateListener(mAuthListener);
    }
}
