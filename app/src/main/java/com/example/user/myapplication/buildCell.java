package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class buildCell extends AppCompatActivity {

    private List<home> IsbuildCell;
    private List<Integer> imageSoucre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildcell);

        imageSoucre = new ArrayList<Integer>();
        imageSoucre.add(R.drawable.a1);
        imageSoucre.add(R.drawable.a2);
        imageSoucre.add(R.drawable.a3);
        imageSoucre.add(R.drawable.a4);
        imageSoucre.add(R.drawable.a5);
        imageSoucre.add(R.drawable.a6);
        imageSoucre.add(R.drawable.a7);

        IsbuildCell = new ArrayList<home>();

        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(0)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(1)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(2)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(3)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(4)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(5)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",imageSoucre.get(6)));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a8));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a9));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a10));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a11));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a12));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a13));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a14));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a15));
        IsbuildCell.add(new home("The XXX","Categorl","Desc HA",R.drawable.a16));

        RecyclerView mrecyclerView =  (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter mAdapter  = new RecyclerViewAdapter(this,IsbuildCell);
        mrecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mrecyclerView.setAdapter(mAdapter);
    }

}
