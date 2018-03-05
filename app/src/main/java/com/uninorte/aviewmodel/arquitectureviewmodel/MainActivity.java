package com.uninorte.aviewmodel.arquitectureviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyViewModel model;
    private List<User> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textNumber);

        model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getUsers().observe(this, users -> {
            data=users;
            tv.setText(data.size()+"");
        });

        /*MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getUsers().observe(this, users -> {
            data=users;
            Log.d("ThisIsLife","Activity onCreate "+data.size());
        });*/


    }

    public void onClickAdd(View view) {
        data.add(new User(1));
        model.getUsers().setValue(data);// aqui se actualiza y notifica los cambios
    }
}
