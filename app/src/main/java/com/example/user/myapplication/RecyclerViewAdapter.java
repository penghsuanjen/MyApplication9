package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyviewHolder>{

     private Context mContext;
     private List<home> mData;


    public RecyclerViewAdapter(Context mContext, List<home> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_bokk,viewGroup,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder,final int i) {

        myviewHolder.home_hardware_title.setText(mData.get(i).getTitle());
        myviewHolder.img_home_thumbnail.setImageResource(mData.get(i).getThumbnail());
        myviewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent icell = new Intent(mContext,cell.class);
                icell.putExtra("Title",mData.get(i).getTitle());
                icell.putExtra("Description",mData.get(i).getDescription());
                icell.putExtra("Thumbnail",mData.get(i).getThumbnail());
                mContext.startActivity(icell);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
         TextView home_hardware_title;
         ImageView img_home_thumbnail;
         CardView cardView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            home_hardware_title =(TextView) itemView.findViewById(R.id.hardware_title_id);
            img_home_thumbnail =(ImageView) itemView.findViewById(R.id.home_img_id) ;
            cardView = (CardView)  itemView.findViewById(R.id.cardview_id);
        }
    }
}
