package com.facomobile.ui.main;

import androidx.lifecycle.ViewModel;

import com.facomobile.data.AppRepository;


class MainActivityViewModel extends ViewModel {
    // private static final String LOG_TAG = MainActivityViewModel.class.getSimpleName();
    private final AppRepository mRepository;

    MainActivityViewModel(AppRepository repository) {
        mRepository = repository;
    }
}