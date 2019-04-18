package com.tkb.android.dagger.field_injection;

import com.tkb.android.dagger.DaggerActivity;

import javax.inject.Inject;

import dagger.Component;

@Component
public interface CarComponent {
    void inject (DaggerActivity daggerActivity);
}
