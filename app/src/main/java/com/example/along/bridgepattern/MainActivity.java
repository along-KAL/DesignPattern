package com.example.along.bridgepattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setListView();

    }

    private void setListView() {
        ListView lv = (MListView) findViewById(R.id.lv_content);
        String[] strs = new String[]{"aaa", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs"
                , "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs"
                , "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd", "dfs", "dfsd"};
        List<String> data = new ArrayList<>();
        data = Arrays.asList(strs);
        final List<String> finalData = data;

        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return finalData.size();
            }

            @Override
            public Object getItem(int position) {
                return finalData.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View inflate = null;

                if (convertView == null) {
                    inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.listitem, null);
                } else {
                    inflate = convertView;
                }

                return inflate;
            }
        });
    }
}
