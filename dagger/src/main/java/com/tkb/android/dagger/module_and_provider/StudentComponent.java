package com.tkb.android.dagger.module_and_provider;

import dagger.Component;

@Component
public interface StudentComponent {
    Student getStudent();
}
