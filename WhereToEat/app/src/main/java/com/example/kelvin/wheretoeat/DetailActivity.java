package com.example.kelvin.wheretoeat;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        DetailFragment detailFragment = new DetailFragment(position);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, detailFragment).commit();
    }
}
