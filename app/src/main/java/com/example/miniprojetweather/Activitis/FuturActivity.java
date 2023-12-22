package com.example.miniprojetweather.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.miniprojetweather.Adapters.FutureAdapters;
import com.example.miniprojetweather.Domains.FutureDomain;
import com.example.miniprojetweather.R;

import java.util.ArrayList;

public class FuturActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterTomorrow;

    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futur);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        @SuppressLint("WrongViewCast")
        ConstraintLayout backBtn= findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FuturActivity.this,MainActivity.class));

            }
        });
    }

    private void initRecyclerView(){
        ArrayList<FutureDomain> items= new ArrayList<>();

        items.add(new FutureDomain("Sat","storm","storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","cloudy",24,16));
        items.add(new FutureDomain("Mon","windy","windy",29,15));
        items.add(new FutureDomain("Tus","cloudy_sunny","cloudy_sunny",22,13));
        items.add(new FutureDomain("Wen","sun","sunny",28,11));
        items.add(new FutureDomain("Thu","rainy","rainy",23,12));

        recyclerView= findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTomorrow= new FutureAdapters(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}