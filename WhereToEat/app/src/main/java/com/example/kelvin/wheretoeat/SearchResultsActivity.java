package com.example.kelvin.wheretoeat;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    int position;
    private String[] dish_IDoSakura = new String[]{
            "香烤戰斧豬排－－－－－－60",
            "雙醬佐牛排－－－－－－－360",
            "芥末椒鹽魷魚－－－－－－280",
            "酸甜南蠻雞腿－－－－－－260",
            "泡菜豬肉燒－－－－－－－250",
            "番茄玉子烏龍麵－－－－－240",
            "日式炒烏龍麵－－－－－－200",
            "豚骨拉麵佐里肌豬排－－－260",
            "醬油拉麵佐日式炸雞－－－50",
            "味噌拉麵佐蔬菜天婦羅－－240",
            "藍帶豬排炸雞組合餐－－－310",
            "海陸組合餐－－－－－－－310",
            "海味組合餐－－－－－－－290",
            "炸蝦天婦羅－－－－－－－240",
            "里肌肉炸豬排－－－－－－210",
            "腰內肉炸豬排－－－－－－220",
            "炸起司豬排－－－－－－－260",
            "滑蛋豬排煮－－－－－－－250",
            "炭香炸魚排－－－－－－－230",
            "香酥炸雞腿－－－－－－－210",
            "南瓜蔬食煲－－－－－－－250",
            "香草烤魚排－－－－－－－250",
            "鹽烤鯖魚－－－－－－－－280",
            "元氣兒童餐－－－－－－－180",
            "牛肉壽喜丼飯－－－－－－200",
            "豬肉壽喜丼飯－－－－－－190",
            "親子雞肉丼飯－－－－－－190"
    };

    private String[] dish_McDonald = new String[]{
            "大麥克－－－－－－－－－－69",
            "雙層牛肉吉士堡－－－－－－59",
            "四盎司牛肉堡－－－－－－－79",
            "雙層四盎司牛肉堡－－－－－109",
            "1995美式培根牛肉堡－－－－99",
            "麥香魚－－－－－－－－－－49",
            "麥香雞－－－－－－－－－－49",
            "6塊麥克雞塊－－－－－－－－59",
            "9塊麥克雞塊－－－－－－－－89",
            "勁辣雞腿堡－－－－－－－－69",
            "板烤雞腿堡－－－－－－－－79",
            "胡麻豬排堡－－－－－－－－59",
            "麥脆雞－－－－－－－－－－100"
    };

    private String[] dish_GanChuang = new String[]{
            "招牌甘泉魚麵－－－－－－－125",
            "醋溜鮮魚煨麵－－－－－－－125",
            "釜山泡菜炙麵(海鮮)－－－－125",
            "龍王海鮮湯麵－－－－－－－125",
            "泰式酸辣海鮮麵－－－－－－125",
            "韓式泡菜拌麵－－－－－－－120",
            "老四川椒麻雙寶拌麵－－－－120",
            "方便素隨緣麵－－－－－－－110",
            "川味麻辣湯麵－－－－－－－120",
            "漢方豚肉片麵－－－－－－－125",
            "獅城肉骨茶豬肉片麵－－－－125",
            "東北酸菜白肉麵－－－－－－120",
            "東京都叉燒麵－－－－－－－120",
            "日式味噌豬肉片麵－－－－－120",
            "九州蒜味白湯叉燒麵－－－－125",
            "醬燒豬腱腿麵－－－－－－－150",
            "原味牛肉片麵－－－－－－－125",
            "釜山泡菜炙麵(牛)－－－－－125",
            "茄汁牛肉片麵－－－－－－－125",
            "經典羊肉片麵－－－－－－－120",
            "京饌羊肉片麵－－－－－－－125",
            "辣味大千雞麵－－－－－－－125",
            "香茅蛤蜊雞肉片麵－－－－－125"
    };

    private String[] dish_OhOhYes = new String[]{
            "大腸臭臭鍋－－－－－－－－120",
            "海鮮豆腐鍋－－－－－－－－120",
            "泡菜鍋－－－－－－－－－－120",
            "泡菜臭臭鍋－－－－－－－－120",
            "養生素食鍋－－－－－－－－120",
            "鴨寶鍋－－－－－－－－－－120",
            "腸旺鴨血鍋－－－－－－－－130",
            "養生菇菇鍋－－－－－－－－130",
            "麻辣鍋－－－－－－－－－－130",
            "咖哩鍋－－－－－－－－－－130",
            "醬燒牛肉鍋－－－－－－－－130",
            "醬燒羊肉鍋－－－－－－－－130",
            "醬燒豬肉鍋－－－－－－－－130"
    };

    private String[] dish_MrRaindeer = new String[]{
            "麥年鱸魚－－－－－－－－－200",
            "炙烤豬肩－－－－－－－－－200",
            "深海魷魚－－－－－－－－－200",
            "原肉牛排－－－－－－－－－200",
            "羅馬半雞－－－－－－－－－250",
            "馴鹿烤半雞－－－－－－－－250",
            "海陸雙拼－－－－－－－－－250",
            "戰斧豬排－－－－－－－－－250",
            "碳烤肋排－－－－－－－－－250",
            "德國豬腳－－－－－－－－－280"
    };

    private String[] dish_Malaysia = new String[]{
            "肉絲炒粿條－－－－－－－－50",
            "牛肉炒粿條－－－－－－－－65",
            "海鮮炒粿條－－－－－－－－65",
            "肉絲炒麵－－－－－－－－－50",
            "牛肉炒麵－－－－－－－－－65",
            "海鮮炒麵－－－－－－－－－65",
            "肉絲炒蘿蔔糕－－－－－－－65",
            "牛肉炒蘿蔔糕－－－－－－－65",
            "海鮮炒蘿蔔糕－－－－－－－65",
            "肉絲炒飯－－－－－－－－－50",
            "牛肉蛋炒飯－－－－－－－－65",
            "海鮮蛋炒飯－－－－－－－－65",
            "咖哩蛋炒飯－－－－－－－－65",
            "咖哩飯(不加肉)－－－－－－50",
            "咖哩雞飯－－－－－－－－－65",
            "咖哩牛肉飯－－－－－－－－65",
            "咖哩湯麵(雞肉/牛肉)－－－－65",
            "咖哩湯河粉(雞肉/牛肉)－－－65",
            "滑蛋豬肉飯/麵/河粉－－－－65",
            "滑蛋牛肉飯/麵/河粉－－－－70",
            "滑蛋海鮮飯/麵/河粉－－－－70",
            "海南雞飯－－－－－－－－－75",
            "馬來飯－－－－－－－－－－65",
            "娘惹炒飯－－－－－－－－－65",
            "蝦麵(米粉)－－－－－－－－75",
            "Sinti飯/粿條/麵－－－－－－65",
            "福建炒麵－－－－－－－－－65",
            "RENDANG(飯/麵/雞肉/牛肉)－80"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.search_results_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_action_search);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String query = new String();
        Intent searchIntent = getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction()))
        {
            query = searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle("Search Result : "+query);
        }
        ArrayList<String> searchResults = new ArrayList<String>();
        int i;
        for(i=0; i<dish_IDoSakura.length; i++)
        {
            if(dish_IDoSakura[i].contains(query))
            {
                searchResults.add("伊藤櫻");
                break;
            }
        }
        for(i=0; i<dish_McDonald.length; i++)
        {
            if(dish_McDonald[i].contains(query))
            {
                searchResults.add("麥當勞");
                break;
            }
        }
        for(i=0; i<dish_GanChuang.length; i++)
        {
            if(dish_GanChuang[i].contains(query))
            {
                searchResults.add("甘泉魚麵");
                break;
            }
        }
        for(i=0; i<dish_OhOhYes.length; i++)
        {
            if(dish_OhOhYes[i].contains(query))
            {
                searchResults.add("大呼過癮");
                break;
            }
        }
        for(i=0; i<dish_MrRaindeer.length; i++)
        {
            if(dish_MrRaindeer[i].contains(query))
            {
                searchResults.add("馴鹿先生與女士");
                break;
            }
        }
        for(i=0; i<dish_Malaysia.length; i++)
        {
            if(dish_Malaysia[i].contains(query))
            {
                searchResults.add("馬來老爹");
                break;
            }
        }
        ListView listView_search = (ListView) findViewById(R.id.listView_search_result);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listitem, searchResults);
        listView_search.setAdapter(adapter);
        listView_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                TextView tv = (TextView) view;
                switch(tv.getText().toString()) {
                    case "伊藤櫻":
                        position = 0;
                        break;
                    case "麥當勞":
                        position = 1;
                        break;
                    case "甘泉魚麵":
                        position = 2;
                        break;
                    case "大呼過癮":
                        position = 3;
                        break;
                    case "馴鹿先生與女士":
                        position = 4;
                        break;
                    case "馬來老爹":
                        position = 5;
                        break;
                    default:
                        break;
                }
                showDetail(position);
            }
        });
    }

    void showDetail(int position){
        this.position = position;
        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
