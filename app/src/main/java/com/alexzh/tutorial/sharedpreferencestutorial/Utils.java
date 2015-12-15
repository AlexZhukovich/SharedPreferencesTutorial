package com.alexzh.tutorial.sharedpreferencestutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utils {
    private final static String MY_PREF = "my_pref";

    private final static String NAME = "name";
    private final static String AGE = "age";

    public final static void saveSharedPreferences(Context context, Person person) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(NAME, person.getName());
        edit.putInt(AGE, person.getAge());
        edit.commit();
    }

    public final static Person restoreSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        Person person = new Person(sharedPreferences.getString(NAME, ""), sharedPreferences.getInt(AGE, -1));
        return person;
    }

    public final static void saveDefaultSharedPreferences(Context context, Person person) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(NAME, person.getName());
        edit.putInt(AGE, person.getAge());
        edit.commit();
    }

    public final static Person restoreDefaultSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Person person = new Person(sharedPreferences.getString(NAME, ""), sharedPreferences.getInt(AGE, -1));
        return person;
    }
}
