package com.example.kelvin.wheretoeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawLots2Activity extends AppCompatActivity {
    TextView result;
    TextView text;
    TextView Pnum;
    EditText restaurant;
    EditText number;
    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_lots2);
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.draw_lots2_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle(R.string.my_tb_title);
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        restaurant=(EditText) findViewById(R.id.editText);
        number=(EditText) findViewById(R.id.editText2);
        text = (TextView) findViewById(R.id.textView2);
        result = (TextView) findViewById(R.id.textView3);
        Pnum = (TextView) findViewById(R.id.textView4);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
    }
    String input;
    int times=0;
    public void myFancyMethod(View v){
        //---------------Get User input---------------------//
        if(restaurant.getText().length()!=0) {
            if (times > 0 && times<5)
                input = input + "\n" + restaurant.getText().toString();
            else if(times==0)
                input = restaurant.getText().toString();
            times++;
            if(times>=5)
            {
                times=5;
            }
            text.setText(input);
            result.setText("最多5家");
        }
    }
    List<Integer> list = new ArrayList();
    String numInput;
    int btn2Times=0;
    public void myFancyMethod2(View v){
        //---------------Get User input---------------------//
        Integer num=0;
        if(number.getText().length()!=0) {
            num = Integer.parseInt(number.getText().toString());
            Toast.makeText(this, "add " + num.toString() + " successfully", Toast.LENGTH_SHORT).show();
            if(btn2Times>0&&btn2Times<5)
                numInput = numInput + "\n" + number.getText().toString();
            else if(btn2Times==0)
                numInput = number.getText().toString();
            if(btn2Times>=5)
            {
                btn2Times=5;
            }else{
                list.add(num);
            }
            btn2Times++;
            Pnum.setText(numInput);
            result.setText("最多5家");
        }
    }
    public void myFancyMethod3(View v){
        //---------------Get User input---------------------//
        int total=0;
        int rand;
        int sum=0;
        if(list.size()!=0&&times!=0&&list.size()==times)
        {
            for(int i:list)
            {
                total = total+i;
            }
            Random run = new Random();
            rand=run.nextInt(total);
            int j=0;
            String[] restaurantList;
            String output="?";
            for(int i:list)
            {
                sum +=i;
                if(rand<sum)
                {
                    restaurantList=text.getText().toString().split("\n");
                    output=restaurantList[j];
                    result.setText(output);
                    break;
                }
                j++;
            }
        }else{
            result.setText("Wrong input");
        }
    }
    public void myFancyMethod4(View v){
        if(list!=null)
            list.clear();
        text.setText(R.string.restaurant_name);
        Pnum.setText("0");
        result.setText("");
        times=0;
        btn2Times=0;
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
