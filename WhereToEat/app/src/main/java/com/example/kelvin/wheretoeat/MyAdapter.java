package com.example.kelvin.wheretoeat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Kelvin on 2016/6/22.
 */
public class MyAdapter extends RecyclerView.Adapter{
    private String[] list_dish;

    public MyAdapter(String[] list_dish){ //這邊是接 MainActivity 傳進來的值
        this.list_dish = list_dish;
    }



    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dish_name, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView text_dish = (TextView) holder.itemView.findViewById(R.id.dish);
        text_dish.setText(list_dish[position]);
    }

    @Override
    public int getItemCount() {
        // 顯示的數量
        return list_dish.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            // 設定 textView 為 item_title 這個 layout 物件

            textView = (TextView) itemView.findViewById(R.id.dish);
        }

    }
}
