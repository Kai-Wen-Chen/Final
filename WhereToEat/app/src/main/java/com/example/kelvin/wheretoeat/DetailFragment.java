package com.example.kelvin.wheretoeat;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private int position;
    private String[] dish_IDoSakura = new String[]{
            "香烤戰斧豬排--------------------------360",
            "雙醬佐牛排----------------------------360",
            "芥末椒鹽魷魚--------------------------280",
            "酸甜南蠻雞腿--------------------------260",
            "泡菜豬肉燒----------------------------250",
            "番茄玉子烏龍麵------------------------240",
            "日式炒烏龍麵--------------------------200",
            "豚骨拉麵佐里肌豬排--------------------260",
            "醬油拉麵佐日式炸雞--------------------250",
            "味噌拉麵佐蔬菜天婦羅----------240",
            "藍帶豬排炸雞組合餐--------------------310",
            "海陸組合餐----------------------------310",
            "海味組合餐----------------------------290",
            "炸蝦天婦羅----------------------------240",
            "里肌肉炸豬排--------------------------210",
            "腰內肉炸豬排--------------------------220",
            "炸起司豬排----------------------------260",
            "滑蛋豬排煮----------------------------250",
            "炭香炸魚排----------------------------230",
            "香酥炸雞腿----------------------------210",
            "南瓜蔬食煲----------------------------250",
            "香草烤魚排----------------------------250",
            "鹽烤鯖魚------------------------------280",
            "元氣兒童餐----------------------------180",
            "牛肉壽喜丼飯--------------------------200",
            "豬肉壽喜丼飯--------------------------190",
            "親子雞肉丼飯--------------------------190"
    };

    private String[] dish_McDonald = new String[]{
            "大麥克---------------------------------69",
            "雙層牛肉吉士堡-------------------------59",
            "四盎司牛肉堡---------------------------79",
            "雙層四盎司牛肉堡----------------------109",
            "1995美式培根牛肉堡---------------------99",
            "麥香魚---------------------------------49",
            "麥香雞---------------------------------49",
            "6塊麥克雞塊----------------------------59",
            "9塊麥克雞塊----------------------------89",
            "勁辣雞腿堡-----------------------------69",
            "板烤雞腿堡-----------------------------79",
            "胡麻豬排堡-----------------------------59",
            "麥脆雞--------------------------------100"
    };

    private String[] dish_GanChuang = new String[]{
            "招牌甘泉魚麵-----------------------------125",
            "醋溜鮮魚煨麵-----------------------------125",
            "釜山泡菜炙麵(海鮮)-----------------125",
            "龍王海鮮湯麵-----------------------------125",
            "泰式酸辣海鮮麵---------------------------125",
            "韓式泡菜拌麵-----------------------------120",
            "老四川椒麻雙寶拌麵-----------------120",
            "方便素隨緣麵-----------------------------110",
            "川味麻辣湯麵-----------------------------120",
            "漢方豚肉片麵-----------------------------125",
            "獅城肉骨茶豬肉片麵-----------------125",
            "東北酸菜白肉麵---------------------------120",
            "東京都叉燒麵-----------------------------120",
            "日式味噌豬肉片麵-------------------120",
            "九州蒜味白湯叉燒麵-----------------125",
            "醬燒豬腱腿麵-----------------------------150",
            "原味牛肉片麵-----------------------------125",
            "釜山泡菜炙麵(牛)-------------------------125",
            "茄汁牛肉片麵-----------------------------125",
            "經典羊肉片麵-----------------------------120",
            "京饌羊肉片麵-----------------------------125",
            "辣味大千雞麵-----------------------------125",
            "香茅蛤蜊雞肉片麵-------------------125"
    };

    private String[] dish_OhOhYes = new String[]{
            "大腸臭臭鍋-------------------------------120",
            "海鮮豆腐鍋-------------------------------120",
            "泡菜鍋-----------------------------------120",
            "泡菜臭臭鍋-------------------------------120",
            "養生素食鍋-------------------------------120",
            "鴨寶鍋-----------------------------------120",
            "腸旺鴨血鍋-------------------------------130",
            "養生菇菇鍋-------------------------------130",
            "麻辣鍋-----------------------------------130",
            "咖哩鍋-----------------------------------130",
            "醬燒牛肉鍋-------------------------------130",
            "醬燒羊肉鍋-------------------------------130",
            "醬燒豬肉鍋-------------------------------130"
    };

    private String[] dish_MrRaindeer = new String[]{
            "麥年鱸魚--------------------------------200",
            "炙烤豬肩--------------------------------200",
            "深海魷魚--------------------------------200",
            "原肉牛排--------------------------------200",
            "羅馬半雞--------------------------------250",
            "馴鹿烤半雞------------------------------250",
            "海陸雙拼--------------------------------250",
            "戰斧豬排--------------------------------250",
            "碳烤肋排--------------------------------250",
            "德國豬腳--------------------------------280"
    };

    private String[] dish_Malaysia = new String[]{
            "肉絲炒粿條------------------------------50",
            "牛肉炒粿條------------------------------65",
            "海鮮炒粿條------------------------------65",
            "肉絲炒麵--------------------------------50",
            "牛肉炒麵--------------------------------65",
            "海鮮炒麵--------------------------------65",
            "肉絲炒蘿蔔糕----------------------------65",
            "牛肉炒蘿蔔糕----------------------------65",
            "海鮮炒蘿蔔糕----------------------------65",
            "肉絲炒飯--------------------------------50",
            "牛肉蛋炒飯------------------------------65",
            "海鮮蛋炒飯------------------------------65",
            "咖哩蛋炒飯------------------------------65",
            "咖哩飯(不加肉)--------------------------50",
            "咖哩雞飯--------------------------------65",
            "咖哩牛肉飯------------------------------65",
            "咖哩湯麵(雞肉/牛肉)---------------------65",
            "咖哩湯河粉(雞肉/牛肉)-------------------65",
            "滑蛋豬肉飯/麵/河粉----------------------65",
            "滑蛋牛肉飯/麵/河粉----------------------70",
            "滑蛋海鮮飯/麵/河粉----------------------70",
            "海南雞飯--------------------------------75",
            "馬來飯----------------------------------65",
            "娘惹炒飯--------------------------------65",
            "蝦麵(米粉)------------------------------75",
            "Sinti飯/粿條/麵-------------------------65",
            "福建炒麵--------------------------------65",
            "RENDANG(飯/麵/雞肉/牛肉)-----80"
    };

    private String[] dish_LiGing = new String[]{

    };

    private String[] dish_GuoBaoBao = new String[]{

    };

    private String[] dish_Mony = new String[]{

    };

    private String[] dish_no = new String[]{

    };

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

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_dish);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ImageView shop_image = (ImageView) view.findViewById(R.id.shop_image);

        /*if (position == 0) {
            MyAdapter myAdapter = new MyAdapter(dish_IDoSakura);

            recyclerView.setAdapter(myAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }*/

        MyAdapter myAdapter;

        switch(position){
            case 0:
                shop_image.setImageResource(R.drawable.idosakura);
                myAdapter = new MyAdapter(dish_IDoSakura);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 1:
                shop_image.setImageResource(R.drawable.mcdonald);
                myAdapter = new MyAdapter(dish_McDonald);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 2:
                shop_image.setImageResource(R.drawable.ganchuang);
                myAdapter = new MyAdapter(dish_GanChuang);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 3:
                shop_image.setImageResource(R.drawable.ohohyes);
                myAdapter = new MyAdapter(dish_OhOhYes);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 4:
                shop_image.setImageResource(R.drawable.mrraindeer);
                myAdapter = new MyAdapter(dish_MrRaindeer);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 5:
                shop_image.setImageResource(R.drawable.malaysia);
                myAdapter = new MyAdapter(dish_Malaysia);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 6:
                //shop_image.setImageResource(R.drawable.malaysia);
                myAdapter = new MyAdapter(dish_LiGing);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 7:
                //shop_image.setImageResource(R.drawable.malaysia);
                myAdapter = new MyAdapter(dish_GuoBaoBao);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 8:
                //shop_image.setImageResource(R.drawable.malaysia);
                myAdapter = new MyAdapter(dish_Mony);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            case 9:
                //shop_image.setImageResource(R.drawable.malaysia);
                myAdapter = new MyAdapter(dish_no);

                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                break;
            default:
                break;
        }
        return view;
    }

}
