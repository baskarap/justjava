package com.gojek.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Item> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView listHome = (RecyclerView) findViewById(R.id.list_home);

        setDummyTitles();

        OnItemClick itemClick = new OnItemClick() {
            @Override
            public void onClick(int position) {
                navigateToMain(position);
            }
        };

        HomeAdapter adapter = new HomeAdapter(titleList, itemClick);
        listHome.setAdapter(adapter);
        listHome.setLayoutManager(new LinearLayoutManager(this));

        Log.e("ERROR", "OK");
        Log.d("DEBUG", "OK");
        Log.v("VERBOSE", "OK");
        Log.i("I", "OK");
    }

    private void navigateToMain(int position) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ITEM_NAME", titleList.get(position).getTitle());
        startActivity(intent);
        finish();
    }

    public void setDummyTitles() {
        titleList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Item item = new Item();
            item.setTitle("Food No. " + i);
            item.setSubtitle("Sub No. " + i);
            titleList.add(item);
        }
    }
}
