package com.uninorte.aviewmodel.arquitectureviewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erwin on 3/4/2018.
 */

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public MyViewModel() {
        Log.d("ThisIsLife","ViewModel constructor");
        if (users == null){
            Log.d("ThisIsLife","ViewModel constructor null data");
            users = new MutableLiveData<>();
        }
        List<User> theList = new ArrayList<>();
        for (int i =0; i<10;i++){
            theList.add(new User(i));
        }
        users.setValue(theList);
    }

    public MutableLiveData<List<User>> getUsers(){
        return users;
    }
}
