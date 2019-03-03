package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class cell extends AppCompatActivity {

      private TextView title,description,category;
      private ImageView img ,photo;

      private boolean isOpen = false;
      private ConstraintSet layout1 ,layout2 ;
      private ConstraintLayout  constraintLayout ;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.cell);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        layout1 = new ConstraintSet();
        layout2 = new ConstraintSet();
        photo = (ImageView)findViewById(R.id.photo);
        constraintLayout =findViewById(R.id.ConstraintLayout);
        layout2.clone(this,R.layout.profile_expanded);
        layout1.clone(constraintLayout);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout2.applyTo(constraintLayout);
                    isOpen = !isOpen;

                }
                else {
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout1.applyTo(constraintLayout);
                    isOpen = !isOpen;
                }
            }
        });


        title = (TextView)findViewById(R.id.txttitle);
        category = (TextView)findViewById(R.id.txtCat);
        description = (TextView)findViewById(R.id.txtDesc);

        img = (ImageView)findViewById(R.id.cellThumbnail);

        Intent intent =this.getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int imgT = intent.getExtras().getInt("Thumbnail");


        title.setText(Title);
        description.setText(Description);
        img.setImageResource(imgT);



    }
}
