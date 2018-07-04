package top.a0x16.firstandroiddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import top.a0x16.firstandroiddemo.bean.Fruit;

public class FruitRecyclerActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_recycler);

        initFruitList();
        FruitAdapter adapter = new FruitAdapter(fruitList);
        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adapter);
    }

    private void initFruitList() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple512);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana512);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange512);
            fruitList.add(orange);
            Fruit apricot = new Fruit(getRandomLengthName("Apricot"), R.drawable.apricot512);
            fruitList.add(apricot);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear512);
            fruitList.add(pear);
            Fruit kiwi = new Fruit(getRandomLengthName("Kiwi"), R.drawable.kiwi512);
            fruitList.add(kiwi);
            Fruit peach = new Fruit(getRandomLengthName("Peach"), R.drawable.peach512);
            fruitList.add(peach);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry512);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry512);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango512);
            fruitList.add(mango);
            Fruit tomato = new Fruit(getRandomLengthName("Tomato"), R.drawable.tomato512);
            fruitList.add(tomato);
            Fruit lemon = new Fruit(getRandomLengthName("Lemon"), R.drawable.lemon512);
            fruitList.add(lemon);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    private class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
        private List<Fruit> mFruitList;

        FruitAdapter(List<Fruit> fruitList) {
            mFruitList = fruitList;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView fruitImage;
            TextView fruitName;

            ViewHolder(View itemView) {
                super(itemView);
                fruitImage = itemView.findViewById(R.id.fruit_image);
                fruitName = itemView.findViewById(R.id.fruit_name);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,
                    parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Fruit fruit = mFruitList.get(position);
            holder.fruitImage.setImageResource(fruit.getImageId());
            holder.fruitName.setText(fruit.getName());
        }

        @Override
        public int getItemCount() {
            return mFruitList.size();
        }
    }
}
