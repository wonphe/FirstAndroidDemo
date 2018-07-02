package top.a0x16.firstandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import top.a0x16.firstandroiddemo.bean.Fruit;

public class FruitActivity extends AppCompatActivity {
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear"
            , "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"
            , "Apple", "Banana", "Orange", "Watermelon", "Pear"
            , "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                FruitActivity.this, android.R.layout.simple_list_item_1, data);
        ListView list_view = findViewById(R.id.list_view);
        list_view.setAdapter(adapter);
    }
}
