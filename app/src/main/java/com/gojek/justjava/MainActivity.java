package com.gojek.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_PRICE = 10000;
    private static final int WHIPPED_CREAM_PRICE = 200;
    private static final int CHOCOLATE_PRICE = 400;

    private int itemQtt;
    private TextView textItemQtt;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonOrder;
    private AppCompatCheckBox checkBoxItem1;
    private AppCompatCheckBox checkBoxItem2;
    private EditText inputItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String foodName = getIntent().getStringExtra("ITEM_NAME");

        initViews();
        inputItemName.setText(foodName);

        itemQtt = 0;
        textItemQtt.setText(String.valueOf(itemQtt));

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemQtt++;
                textItemQtt.setText(String.valueOf(itemQtt));
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemQtt > 0) {
                    itemQtt--;
                    textItemQtt.setText(String.valueOf(itemQtt));
                }
            }
        });
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countOrder();
            }
        });
    }

    private void initViews() {
        textItemQtt = (TextView) findViewById(R.id.text_item_qtt);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonOrder = (Button) findViewById(R.id.button_order);
        checkBoxItem1 = (AppCompatCheckBox) findViewById(R.id.check_item1);
        checkBoxItem2 = (AppCompatCheckBox) findViewById(R.id.check_item2);
        inputItemName = (EditText) findViewById(R.id.input_item_name);
    }

    private void countOrder() {
        String itemName = inputItemName.getText().toString();

        int price = DEFAULT_PRICE * itemQtt;
        String message= "Harga: " + itemName;
        if (checkBoxItem1.isChecked()) {
            price += WHIPPED_CREAM_PRICE;
            message += " + Whipped cream";
        }
        if (checkBoxItem2.isChecked()) {
            price += CHOCOLATE_PRICE;
            message += " + Choco";
        }
        message += ": Rp " + price;

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
