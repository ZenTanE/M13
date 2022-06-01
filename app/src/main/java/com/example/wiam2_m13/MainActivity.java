package com.example.wiam2_m13;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private SignInButton googleSignInButton;

    GoogleSignInOptions gso;
    GoogleSignInClient signInClient;
    private static final int GOOGLE_SING_IN_CODE = 10005;

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btHome).setOnClickListener(this::onclick);
        findViewById(R.id.btnLocalInf).setOnClickListener(this::onclick);
        findViewById(R.id.btnfoodDesc).setOnClickListener(this::onclick);
        findViewById(R.id.btnLogin).setOnClickListener(this::onclick);
        mFirebaseAuth = FirebaseAuth.getInstance();
/*
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)) //firebase id
                .requestEmail() //demanem mail usuari
                .build();

        signInClient = GoogleSignIn.getClient(this,gso);
*/
    }
    private void onclick(View view) {

        switch (view.getId()){
            case R.id.btHome:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                break;
            case R.id.btnLocalInf:
                startActivity(new Intent(getApplicationContext(), LocalinfoActivity.class));
                break;
            case R.id.btnfoodDesc:
                startActivity(new Intent(getApplicationContext(), FoodDescriptionActivity.class));
                break;
            case R.id.btnLogin:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.login_dialog);
                //acciones dentro de dialog

               googleSignInButton = dialog.findViewById(R.id.googleSignInButton);
               googleSignInButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //accederConGoogle();
                    }
                });

                dialog.show();
                break;




        }
    }

    private void accederConGoogle() {
        /*
        GoogleSignInClient googleSignInClient;
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build());



        startActivityForResult(googleSignInClient.getSignInIntent(), 12345);
*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SING_IN_CODE) {
            Task<GoogleSignInAccount> signInTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount signInAcc = signInTask.getResult(ApiException.class);
                //Part final
                AuthCredential authCredential=
                        GoogleAuthProvider.getCredential(signInAcc.getIdToken(), null);
                mFirebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new
                     OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             Toast.makeText(getApplicationContext(), "Your google account is connected toour aplication", Toast.LENGTH_LONG).show();
                             //data();
                         }
                     }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //showAlert();
                        Log.e("ERROR_LOGIN_GOOGLE", "signInWithCredential firebase: ",e );
                    }
                });
                //Toast.makeText(this, "Your google account is Connected to Our Application",Toast.LENGTH_LONG).show();
                //startActivity(new Intent(this, Login.class));
            } catch (ApiException e) {
                //showAlert();
                Log.e("ERROR_LOGIN_GOOGLE", "onActivityResult: ",e );
            }

        }
    }
}