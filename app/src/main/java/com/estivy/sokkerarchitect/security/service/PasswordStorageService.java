package com.estivy.sokkerarchitect.security.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;

import com.estivy.sokkerarchitect.SokkerArchitectApplication;

import javax.inject.Inject;

public class PasswordStorageService {

    private static final String CREDENTIALS = "credentials";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Inject
    public PasswordStorageService() {
    }

    public Pair<String, String> getCredentials(){
        Context context = SokkerArchitectApplication.Companion.applicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(
                CREDENTIALS, Context.MODE_PRIVATE);
        return Pair.create(sharedPref.getString(USERNAME, null),
                sharedPref.getString(PASSWORD, null));
    }

    public void setCredentials(Pair<String, String> credentials){
        Context context = SokkerArchitectApplication.Companion.applicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(
                PasswordStorageService.CREDENTIALS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USERNAME, credentials.first);
        editor.putString(PASSWORD, credentials.second);
        editor.apply();
        editor.commit();
    }

    public boolean isStarted() {
        Context context = SokkerArchitectApplication.Companion.applicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(
                CREDENTIALS, Context.MODE_PRIVATE);
        return sharedPref.getString(USERNAME, null) != null;
    }
}
