package top.a0x16.firstandroiddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import top.a0x16.firstandroiddemo.bean.Fruit;

public class FruitActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        initFruitList();
        FruitAdapter adapter = new FruitAdapter(getApplicationContext(),
                R.layout.fruit_item, fruitList);
        ListView list_view = findViewById(R.id.list_view);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(getApplicationContext(), fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initFruitList() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple512);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana512);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange512);
            fruitList.add(orange);
            Fruit apricot = new Fruit("Apricot", R.drawable.apricot512);
            fruitList.add(apricot);
            Fruit pear = new Fruit("Pear", R.drawable.pear512);
            fruitList.add(pear);
            Fruit kiwi = new Fruit("Kiwi", R.drawable.kiwi512);
            fruitList.add(kiwi);
            Fruit peach = new Fruit("Peach", R.drawable.peach512);
            fruitList.add(peach);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry512);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry512);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango512);
            fruitList.add(mango);
            Fruit tomato = new Fruit("Tomato", R.drawable.tomato512);
            fruitList.add(tomato);
            Fruit lemon = new Fruit("Lemon", R.drawable.lemon512);
            fruitList.add(lemon);
        }
    }

    private class FruitAdapter extends ArrayAdapter<Fruit> {
        private int resourceId;

        FruitAdapter(Context context, int resource, List<Fruit> objects) {
            super(context, resource, objects);
            resourceId = resource;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            Fruit fruit = getItem(position);
            View view;
            ViewHolder viewHolder;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(resourceId, null);
                viewHolder = new ViewHolder();
                viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
                viewHolder.fruitName = view.findViewById(R.id.fruit_name);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.fruitImage.setImageResource(fruit.getImageId());
            viewHolder.fruitName.setText(fruit.getName());
            return view;
        }

        private class ViewHolder {
            ImageView fruitImage;
            TextView fruitName;
        }
    }
}
