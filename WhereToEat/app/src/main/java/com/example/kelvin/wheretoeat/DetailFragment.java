package com.example.kelvin.wheretoeat;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private int position;

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
        return view;
    }

}
