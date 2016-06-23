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
    private String[] dish_LiGing = new String[]{
            "主廚特餐－－－－－－－－－65",
            "豚丼－－－－－－－－－－－80",
            "雞排丼－－－－－－－－－－85",
            "牛丼－－－－－－－－－－－90",
            "黃金豬排丼－－－－－－－－95",
            "起司豬排丼－－－－－－－－95",
            "韓式泡菜豬肉丼－－－－－－80",
            "韓式泡菜牛肉丼－－－－－－90",
            "咖哩丼－－－－－－－－－－50",
            "咖哩豬肉丼－－－－－－－－80",
            "咖哩雞肉丼－－－－－－－－80",
            "川辣豬肉丼－－－－－－－－70",
            "川辣雞排丼－－－－－－－－70",
            "川辣牛肉丼－－－－－－－－80",
            "川辣豬排丼－－－－－－－－80",
            "川辣雞腿丼－－－－－－－－85",
            "上湯拉麵－－－－－－－－－60",
            "海苔拉麵－－－－－－－－－65",
            "韓式泡菜拉麵－－－－－－－75",
            "招牌叉燒拉麵－－－－－－－80",
            "雞排拉麵－－－－－－－－－85",
            "可樂餅拉麵－－－－－－－－90",
            "黃金豬排拉麵－－－－－－－95",
            "起司豬排拉麵－－－－－－－95"
    };

    private String[] dish_GuoBaoBao = new String[]{
            "家傳焢肉刈包－－－－－－－45",
            "京醬焢肉刈包－－－－－－－45",
            "招牌嫩骨刈包－－－－－－－45",
            "家傳豬腳飯－－－－－－－－60",
            "香煎雞腿肉飯－－－－－－－55",
            "香煎排骨飯－－－－－－－－55",
            "招牌嫩骨飯－－－－－－－－55",
            "家傳焢肉飯－－－－－－－－55",
            "泰式鴨香飯－－－－－－－－55",
            "梅干肉燥飯+瓜仔鮮雞盅－－75",
            "梅干肉燥飯+人蔘雞腿盅－－80",
            "梅干肉燥飯+藥燉排骨盅－－75",
            "藥燉排骨盅－－－－－－－－45",
            "瓜仔鮮雞盅－－－－－－－－45",
            "人蔘鮮雞盅－－－－－－－－50"
    };

    private String[] dish_Mony = new String[]{
            "牛丼－－－－－－－－－－－80",
            "雙倍牛丼－－－－－－－－－120",
            "炸雞牛丼－－－－－－－－－110",
            "炸豬排牛丼－－－－－－－－120",
            "魚排牛丼－－－－－－－－－110",
            "三種起司牛丼－－－－－－－100",
            "咖哩牛丼－－－－－－－－－90",
            "泡菜牛丼－－－－－－－－－90",
            "炸豬排丼－－－－－－－－－80",
            "炸雞丼－－－－－－－－－－70",
            "魚排丼－－－－－－－－－－70",
            "德式香腸丼－－－－－－－－70",
            "咖哩豬排丼－－－－－－－－80",
            "咖哩炸雞丼－－－－－－－－70",
            "咖哩魚排丼－－－－－－－－70",
            "德式香腸咖哩飯－－－－－－70",
            "韓式泡菜咖哩飯－－－－－－70",
            "四種起司肉醬飯－－－－－－90",
            "德腸起司肉醬飯－－－－－－100",
            "泡菜起司肉醬飯－－－－－－80",
            "起司肉醬飯－－－－－－－－70",
            "印度拉茶－－－－－－－－－30",
            "蘋果紅茶－－－－－－－－－25",
            "濃味綠茶－－－－－－－－－25"
    };

    private String[] dish_porridge = new String[]{
            "廣東粥－－－－－－－－－－55",
            "海鮮粥－－－－－－－－－－55",
            "玉米瘦肉粥－－－－－－－－55",
            "皮蛋瘦肉粥－－－－－－－－55",
            "香菇瘦肉粥－－－－－－－－55",
            "蔬菜瘦肉粥－－－－－－－－55",
            "花枝瘦肉粥－－－－－－－－55",
            "蝦仁瘦肉粥－－－－－－－－55",
            "豬肝瘦肉粥－－－－－－－－55",
            "吻仔魚瘦肉粥－－－－－－－55",
            "招牌粥－－－－－－－－－－65",
            "鮑魚粥－－－－－－－－－－65",
            "魚片粥－－－－－－－－－－65",
            "生滾牛肉粥－－－－－－－－65",
            "奶油蟹肉粥－－－－－－－－75",
            "蒜味牛肉炒麵－－－－－－－60",
            "蒜味豬肉炒麵－－－－－－－60",
            "沙茶牛肉炒麵－－－－－－－60",
            "沙茶豬肉炒麵－－－－－－－60",
            "沙茶豬肝炒麵－－－－－－－60",
            "豬肝鍋燒麵－－－－－－－－65",
            "牛肉鍋燒麵－－－－－－－－65",
            "豬肉鍋燒麵－－－－－－－－65",
            "海鮮鍋燒麵－－－－－－－－65",
            "泡菜鍋燒麵－－－－－－－－65"
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

        //搜尋
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
        for(i=0; i<dish_LiGing.length; i++)
        {
            if(dish_LiGing[i].contains(query))
            {
                searchResults.add("利竫和食");
                break;
            }
        }
        for(i=0; i<dish_GuoBaoBao.length; i++)
        {
            if(dish_GuoBaoBao[i].contains(query))
            {
                searchResults.add("嫩寶包");
                break;
            }
        }
        for(i=0; i<dish_Mony.length; i++)
        {
            if(dish_Mony[i].contains(query))
            {
                searchResults.add("墨尼捲餅");
                break;
            }
        }
        for(i=0; i<dish_porridge.length; i++)
        {
            if(dish_porridge[i].contains(query))
            {
                searchResults.add("珍御品廣東粥");
                break;
            }
        }

        //建立搜尋到的結果
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
                    case "利竫和食":
                        position = 6;
                        break;
                    case "嫩寶包":
                        position = 7;
                        break;
                    case "墨尼捲餅":
                        position = 8;
                        break;
                    case "珍御品廣東粥":
                        position = 9;
                        break;
                    default:
                        break;
                }
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
}
