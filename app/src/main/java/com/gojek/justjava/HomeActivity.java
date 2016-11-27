package com.gojek.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements OnItemClick {

    List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView listItem = (RecyclerView) findViewById(R.id.list_item_to_show);

        createList();

        HomeAdapter adapter = new HomeAdapter(itemList, this);
        listItem.setLayoutManager(new LinearLayoutManager(this));
        listItem.setAdapter(adapter);
    }

    private void createList() {
        itemList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            itemList.add("Item no. " + (i + 1));
        }
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
