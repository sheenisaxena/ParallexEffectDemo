package com.weatherdesigndemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CollapseModeParallex extends AppCompatActivity {

    CollapsingToolbarLayout collapsingLayout;
    Toolbar toolbar;
    TextView tv_collapse;
    RecyclerView recyclerView;
    RecyclerAdapter rcvAdapter;
    ArrayList<Integer> imagesModeList;
    List<String> hourList, tempList;
    ArrayList<String> dayItems, arrMaxTempItems, arrMinTempItems;
    ListView lst_day_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapse_mode_parallex);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //if you are using collapsingToolbarlayout along with Toolbar layout then you need to add properties like contentScrim & title to CollapsingToolbarlayout itself instead of Toolbar layout
        collapsingLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingLayout);

        // recyclerview code
        imagesModeList = new ArrayList<>();
        hourList = new ArrayList<>();
        tempList = new ArrayList<>();
        dayItems = new ArrayList<>();
        arrMaxTempItems = new ArrayList<>();
        arrMinTempItems = new ArrayList<>();

        tv_collapse = (TextView) findViewById(R.id.tv_collapse);
//        tv_collapse.setText(Html.fromHtml("X<sup>"+ 0 +"</sup>"));
        tv_collapse.setText("42");

        for (int i = 0; i < 24; i++) {
            imagesModeList.add(R.drawable.sun);
            hourList.add("10");
            tempList.add("23c");
        }

        recyclerView = (RecyclerView) findViewById(R.id.rcv_horizontal);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        rcvAdapter = new RecyclerAdapter(this, imagesModeList, hourList, tempList);
        recyclerView.setAdapter(rcvAdapter);

        // listview code
        dayItems.add("Monday");
        dayItems.add("Tuesday");
        dayItems.add("Wednesday");
        dayItems.add("Thursday");
        dayItems.add("Friday");
        dayItems.add("Saturday");
        dayItems.add("Sunday");

        for (int i = 0; i < 7; i++) {
            arrMaxTempItems.add("24");
            arrMinTempItems.add("12");
        }
        lst_day_view = (ListView) findViewById(R.id.lst_day_view);
        lst_day_view.setAdapter(new ItemListAdapter(CollapseModeParallex.this, dayItems, imagesModeList, arrMaxTempItems, arrMinTempItems));
    }
}
