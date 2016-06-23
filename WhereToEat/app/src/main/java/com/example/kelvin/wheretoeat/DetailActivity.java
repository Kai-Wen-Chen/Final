package com.example.kelvin.wheretoeat;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //接收從MainActivity傳來的資料(bundle)並從中取出position
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");

        //建立DetailFragment，對應fragment_detail.xml
        DetailFragment detailFragment = new DetailFragment(position);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, detailFragment).commit();
    }
}
