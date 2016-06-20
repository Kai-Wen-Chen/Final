package com.example.kelvin.wheretoeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DrawLots2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_lots2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainpage, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        switch (item_id){
            case R.id.main_page:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.draw_lots1:
                startActivity(new Intent(this, DrawLots1Activity.class));
                break;
            case R.id.draw_lots2: break;
            default: return false;
        }
        return true;
    }
}
