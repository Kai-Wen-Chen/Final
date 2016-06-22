package com.example.kelvin.wheretoeat;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Integer firstTime=0;
    //----------------Opening Image-------------------//
    private static final int STOPSPLASH = 0;
    //time in milliseconds
    private static long SPLASHTIME = 2000;
    private ImageView splash;
    private Handler splashHandler = new Handler() {
        /* (non-Javadoc)
         * @see android.os.Handler#handleMessage(android.os.Message)
         */
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STOPSPLASH:
                    //remove SplashScreen from view
                    splash.setVisibility(View.GONE);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle(R.string.my_tb_title);
        getSupportActionBar().setIcon(R.drawable.ic_action_name);

        if(firstTime==0){
            splash = (ImageView) findViewById(R.id.splashscreen);
            Message msg = new Message();
            msg.what = STOPSPLASH;
            splashHandler.sendMessageDelayed(msg, SPLASHTIME);
            firstTime=1;
            SPLASHTIME=0;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainpage, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
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
