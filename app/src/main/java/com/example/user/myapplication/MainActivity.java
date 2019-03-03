package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

   // private ImageButton button1,button2,button3;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // init();
      // application();
        // excelDataDownlaod();

        mDrawerLayout =  (DrawerLayout) this.findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        NavigationView nv = (NavigationView)findViewById(R.id.nv);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.flcontent, Index.class.newInstance()).commit();
        }
        catch(Exception e){
         e.printStackTrace();
        }
        setupDrawerContent(nv);
    }




    private void excelDataDownlaod(){

        InputStream ExcelFileToRead = null;
        try {
            ExcelFileToRead = new FileInputStream("D:\\testxls");
            HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
            HSSFSheet sheet=wb.getSheetAt(0);
            HSSFCell cell;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private void init() {
        /*
        button1= (ImageButton)findViewById(R.id.imageButton1);
        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button1.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                View toastView = getLayoutInflater().inflate(R.layout.custom_toasy_layout,null);
                Toast toast = new Toast(getApplicationContext());
                TextView text = toastView.findViewById(R.id.customToastText);
                text.setTypeface(text.getTypeface(), Typeface.BOLD_ITALIC);
                text.setTextColor(Color.RED);
                text.setText("213");
                toast.setView(toastView);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show()
                Intent sendfirst = new Intent(v.getContext(),buildfirst_all.class);
                startActivity(sendfirst);
                MainActivity.this.finish();
                }});}
                */
    }

       public void selectIterDrawer(MenuItem menuItem){
           Fragment myFragment = null;
           Class fragmentClass;
           switch (menuItem.getItemId()){
               case R.id.indx:
                   fragmentClass = Index.class;
                       break;
               case R.id.frowardpage:
                   fragmentClass = Frowardpage.class;
                       break;
               case R.id.search:
                   fragmentClass = Setting_activity.class;
                        break;
               case R.id.settings:
                   fragmentClass = Setting_activity.class;
                        break;
               case R.id.activities:
                   fragmentClass = Setting_activity.class;
                        break;
               case R.id.logout:
                   fragmentClass = Setting_activity.class;
                        break;
                default:
                    fragmentClass = Setting_activity.class;
           }
         try {
             myFragment = (Fragment) fragmentClass.newInstance();
             FragmentManager fragmentManager  = getSupportFragmentManager();
             fragmentManager.beginTransaction().replace(R.id.flcontent,myFragment).commit();
             menuItem.setChecked(true);
             setTitle(menuItem.getTitle());
             mDrawerLayout.closeDrawers();
         }
         catch(Exception e){
             e.printStackTrace();
         }

         }

        private void setupDrawerContent(NavigationView navigationView){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    selectIterDrawer(menuItem);
                    return true;
                }
            });
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void application() {

    }
}
