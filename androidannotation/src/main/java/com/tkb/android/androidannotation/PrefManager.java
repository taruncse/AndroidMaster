package com.tkb.android.androidannotation;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref
public interface PrefManager {
    // The field name will have default value "John"
    @DefaultString("Tarun")
    String name();

    // The field age will have default value 42
    @DefaultInt(30)
    int age();

    // The field lastUpdated will have default value 0
    long lastUpdated();
}
