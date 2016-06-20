package com.example.kelvin.wheretoeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainpage, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        switch (item_id){
            case R.id.main_page: break;
            case R.id.draw_lots1:
                startActivity(new Intent(this, DrawLots1Activity.class));
                break;
            case R.id.draw_lots2:
                startActivity(new Intent(this, DrawLots2Activity.class));
                break;
            default: return false;
        }
        return true;
    }

    public void onItemSelected(View v){
        if (v.getId() == R.id.main_page)
            startActivity(new Intent(this, DetailActivity.class));
    }
}
