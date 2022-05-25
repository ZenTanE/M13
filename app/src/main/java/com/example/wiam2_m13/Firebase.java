package com.example.wiam2_m13;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.AccountPicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

/**
 * The Firebase class takes care of any business involving any interaction w/ the Firebase database
 */
public class Firebase {

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();



}
