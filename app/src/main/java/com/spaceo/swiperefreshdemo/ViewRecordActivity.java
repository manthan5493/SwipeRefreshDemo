package com.spaceo.swiperefreshdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SpaceO on 14/9/16.
 */
public class ViewRecordActivity extends AppCompatActivity {


    ListView mListViewName;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ArrayList<String> nameList;

    private ArrayAdapter<String>  adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_viewrecord);




        initControls();

    }

    private void initControls() {



        Bundle b = getIntent().getExtras();

        if(b!=null){
            nameList = (ArrayList<String>)b.getStringArrayList("array_list");
            System.out.println(nameList);
        }



        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

//        mListViewName = (ListView)findViewById(R.id.listViewName);
        mListViewName = (ListView) findViewById(R.id.listViewName);



        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {

                refreshContent();


            }
        });

    }




    private void refreshContent(){
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {


                                          adapter=  new ArrayAdapter<String>(ViewRecordActivity.this, android.R.layout.simple_list_item_1, getNames());
//                                          adapter = new ArrayAdapter<String>(ViewRecordActivity.this, android.R.layout.simple_list_item_1, getNames());

                                          mListViewName.setAdapter(adapter);
                                          mListViewName.setAdapter(adapter);
                                          mSwipeRefreshLayout.setRefreshing(false);
                                      };
                                  },100);

    }

    private List<String> getNames() {

        List<String> newNames = new ArrayList<String>();
        for (int i = 0; i < nameList.size(); i++) {

            newNames.add(nameList.get(i));
        }

        return newNames;

    }



   /* private void refreshContent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter = new ArrayAdapter<String>(ViewRecordActivity.this, android.R.layout.simple_list_item_1, getNewTweets());
                mListView.setAdapter(mAdapter);
                mSwipeRefreshLayout.setRefreshing(false);
            });
        }


}*/




    }
