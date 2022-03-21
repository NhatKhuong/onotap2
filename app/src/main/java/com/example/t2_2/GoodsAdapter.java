package com.example.t2_2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GoodsAdapter extends BaseAdapter {

    private Context ctx;
    private int layoutitem;
    private List<Goods> goodsList;
    private List<Goods> listFilter;

    public GoodsAdapter(Context ctx, int layoutitem, List<Goods> goodsList) {
        this.ctx = ctx;
        this.layoutitem = layoutitem;
        this.goodsList = goodsList;
        this.listFilter = goodsList;
    }

    @Override
    public int getCount() {
        if(listFilter.size() != 0 && !listFilter.isEmpty()){
            return listFilter.size();
        }
        return  0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(ctx).inflate(layoutitem,viewGroup,false);

        ImageView img = view.findViewById(R.id.img);
        TextView name = view.findViewById(R.id.name);
        TextView price = view.findViewById(R.id.price);
        TextView forn = view.findViewById(R.id.forn);

        img.setImageResource(listFilter.get(i).getImg());
        name.setText(listFilter.get(i).getName());
        price.setText("$ "+listFilter.get(i).getPrice());
        forn.setText(listFilter.get(i).getForn());


        return  view;
    }

    public void findByButton(String txt){
        listFilter = new ArrayList<>();
        for(Goods item : goodsList){
            if(item.getForn().toLowerCase().indexOf(txt) != -1){
                listFilter.add(item);
            }
        }
        notifyDataSetChanged();
    }

    public  void activeButton(Button btn1,Button btn2,Button btn3,Button btn4){
        btn1.setBackgroundColor(Color.parseColor("#f1b000"));
        btn2.setBackgroundColor(Color.parseColor("#f5f5f5"));
        btn3.setBackgroundColor(Color.parseColor("#f5f5f5"));
        btn4.setBackgroundColor(Color.parseColor("#f5f5f5"));

    }

    public void findAll(){
        listFilter = goodsList;
        notifyDataSetChanged();
    }
}
