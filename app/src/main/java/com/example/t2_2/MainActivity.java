package com.example.t2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GoodsAdapter adt;
    List<Goods> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        listView = findViewById(R.id.lvgoods);

        goodsList = new ArrayList<>();
        goodsList.add(new Goods(R.drawable._69f471bc89e07c05e8f,"Kinh A",10,"For man"));
        goodsList.add(new Goods(R.drawable._810558dda0815564c19,"Kinh B",10,"For woman"));
        goodsList.add(new Goods(R.drawable._69f471bc89e07c05e8f,"Kinh C",10,"for children"));
        goodsList.add(new Goods(R.drawable.c320f3b27c37b369ea26,"Kinh D",10,"For man"));
        goodsList.add(new Goods(R.drawable._69f471bc89e07c05e8f,"Kinh E",10,"for children"));


        adt = new GoodsAdapter(this,R.layout.listview_item,goodsList);
        listView.setAdapter(adt);

        Button btnman = findViewById(R.id.btnman);
        Button btnwon = findViewById(R.id.btnwon);
        Button btnchi = findViewById(R.id.btnchi);
        Button btnall = findViewById(R.id.btnall);

        btnman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.findByButton("for man");
                adt.activeButton(btnman,btnall,btnwon,btnchi);
            }
        });

        btnwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.findByButton("for woman");
                adt.activeButton(btnwon,btnall,btnman,btnchi);
            }
        });

        btnchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.findByButton("for children");
                adt.activeButton(btnchi,btnall,btnman,btnwon);
            }
        });

        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.findAll();
                adt.activeButton(btnall,btnchi,btnman,btnwon);
            }
        });


    }
}