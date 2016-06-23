package com.example.kelvin.wheretoeat;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends ListFragment {
    int position;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //載入店家名單
        ArrayList<String> shopNames = new ArrayList<>();
        for (Shop shop : ShopList.shopList){
            shopNames.add(shop.getName());
        }

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, shopNames));

        if(savedInstanceState != null){
            position = savedInstanceState.getInt("position", 0);
        }
    }

    //記錄目前選到的店家
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        showDetail(position);
    }

    //建立詳細資料
    void showDetail(int position){
        this.position = position;
        Intent intent = new Intent();
        intent.setClass(getActivity(), DetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
