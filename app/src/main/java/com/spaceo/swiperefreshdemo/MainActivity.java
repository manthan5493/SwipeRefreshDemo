package com.spaceo.swiperefreshdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


/**
 * Created by  SpaceO on 14/9/16.
 */



public class MainActivity extends AppCompatActivity {


    private Button btnaddrecord;

    private Button btnviewrecord;

    ArrayList<String> nameList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      // Declare view in initControls()
        initControls();

    }

    private void initControls() {



        Bundle b = getIntent().getExtras();

        if(b!=null){
            nameList = (ArrayList<String>)b.getStringArrayList("array_list");
            System.out.println(nameList);
        }



        btnaddrecord = (Button)findViewById(R.id.btnaddrecord);


        btnviewrecord = (Button)findViewById(R.id.btnviewrecord);



        btnaddrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    Intent addrecord = new Intent(MainActivity.this, AddRecordActivity.class);
                    startActivity(addrecord);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });








        btnviewrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {


                    Intent viewrecord = new Intent(MainActivity.this, ViewRecordActivity.class);
                    viewrecord.putExtra("array_list", nameList);
                    startActivity(viewrecord);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });




    }
}
