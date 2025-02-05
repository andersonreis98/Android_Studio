package com.example.atmconsultoria.ui.Inicial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InicialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InicialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}