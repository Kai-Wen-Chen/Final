package com.example.kelvin.wheretoeat;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DrawLots1Activity extends AppCompatActivity {
    int position;
    Button btn;
    TextView restaurant;
    MediaPlayer randomEffect;
    //SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_lots1);

        //建立音效
        randomEffect = MediaPlayer.create(this, R.raw.chorus_of_angels1);

        //建立工具列
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.draw_lots1_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle(R.string.my_tb_title);
        getSupportActionBar().setIcon(R.drawable.ic_action_name);

        //建立按鈕
        btn = (Button) findViewById(R.id.button5);
    }

    boolean isBtnClick = false; //預設按鈕沒被按

    //抽籤程式，隨機產生一個0~9的數字，及撥放音效
    public void getRandomRestaurant(View v){
        int rand,total;
        total = 10;
        Random run = new Random();
        rand=run.nextInt(total);
        Shop result = ShopList.shopList[rand];
        restaurant = (TextView) findViewById(R.id.RandRestaurant);
        restaurant.setText(result.getName()+"\n就決定是你了");
        isBtnClick = true;
        position = rand;
        randomEffect.start();

        //查看詳細資料
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetail(position);
            }
        });
    }

    //建立詳細資料
    void showDetail(int position){
        this.position = position;
        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    //建立選單
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainpage, menu);
        return true;
    }

    //選擇選單選項
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        switch (item_id){
            case R.id.main_page:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.draw_lots1: break;
            case R.id.draw_lots2:
                startActivity(new Intent(this, DrawLots2Activity.class));
                break;
            default: return false;
        }
        return true;
    }
}
