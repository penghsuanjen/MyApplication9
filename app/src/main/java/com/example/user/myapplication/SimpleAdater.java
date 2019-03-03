package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;



public class SimpleAdater extends RecyclerView.Adapter<SimpleAdater.SimpleViewHolder> {
    private List<Integer> dataSource;

    public SimpleAdater(){
        dataSource = new ArrayList<>();
        for(int i =0;i<=3;i++){
            dataSource.add(i);
        }

    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item,viewGroup,false);

        return new SimpleViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SimpleViewHolder simpleViewHolder,final int i) {
        if(i==0){
            simpleViewHolder.button.setText(R.string.button);
        }
        else if(i==1){
            simpleViewHolder.button.setText(R.string.button1);
        }
        else if(i==2){
            simpleViewHolder.button.setText(R.string.button2);
        }
        else if(i==3){
            simpleViewHolder.button.setText(R.string.button3);
        }
        simpleViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(i==0){
                   Log.i("1",String.valueOf(i));
               }
               else if(i==1){
                   Intent intent = new Intent(v.getContext(),buildfirst_all.class);
                   simpleViewHolder.itemView.getContext().startActivity(intent);
               }
               else if(i==2){
                   Log.i("1",String.valueOf(i));
               }
               else if(i==3){
                   Log.i("1",String.valueOf(i));
               }
            }
        });
    }



    @Override
    public int getItemCount() {
        return this.dataSource.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        private Button button;
        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            button = (Button)itemView.findViewById(R.id.button);
        }
    }
}
