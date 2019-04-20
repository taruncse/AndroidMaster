package com.tkb.android.dagger.module_and_provider;

import javax.inject.Inject;

public class Student {
    public static String TAG = Student.class.getSimpleName();

    @Inject
    public StudentName studentName;

    @Inject
    public StudentBasicInformations basicInformations;

    @Inject
    public Student (){

    }
}
