package com.example.kelvin.wheretoeat;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private int position;
    private String[] dish_IDoSakura = new String[]{
            "香烤戰斧豬排--------------------------360",
            "雙醬佐牛排----------------------------360",
            "芥末椒鹽魷魚--------------------------280",
            "酸甜南蠻雞腿--------------------------260",
            "泡菜豬肉燒----------------------------250",
            "番茄玉子烏龍麵------------------------240",
            "日式炒烏龍麵--------------------------200",
            "豚骨拉麵佐里肌豬排--------------------260",
            "醬油拉麵佐日式炸雞--------------------250",
            "味噌拉麵佐蔬菜天婦羅------------------240",
            "藍帶豬排炸雞組合餐--------------------310",
            "海陸組合餐----------------------------310",
            "海味組合餐----------------------------290",
            "炸蝦天婦羅----------------------------240",
            "里肌肉炸豬排--------------------------210",
            "腰內肉炸豬排--------------------------220",
            "炸起司豬排----------------------------260",
            "滑蛋豬排煮----------------------------250",
            "炭香炸魚排----------------------------230",
            "香酥炸雞腿----------------------------210",
            "南瓜蔬食煲----------------------------250",
            "香草烤魚排----------------------------250",
            "鹽烤鯖魚------------------------------280",
            "元氣兒童餐----------------------------180",
            "牛肉壽喜丼飯--------------------------200",
            "豬肉壽喜丼飯--------------------------190",
            "親子雞肉丼飯--------------------------190"
    };

    private String[] dish_McDonald = new String[]{

    };

    public DetailFragment() {
        // Required empty public constructor
    }

    public DetailFragment(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        if (container == null) return null;

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView text_name = (TextView) view.findViewById(R.id.text_name);
        TextView text_address = (TextView) view.findViewById(R.id.text_address);
        TextView text_phone = (TextView) view.findViewById(R.id.text_phone);

        text_name.setText(ShopList.shopList[position].getName());
        text_address.setText(ShopList.shopList[position].getAddress());
        text_phone.setText(ShopList.shopList[position].getPhone());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_dish);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (position == 0) {
            MyAdapter myAdapter = new MyAdapter(dish_IDoSakura);

            recyclerView.setAdapter(myAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        return view;
    }

}
