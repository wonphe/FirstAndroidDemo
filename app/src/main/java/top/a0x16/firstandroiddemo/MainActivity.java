package top.a0x16.firstandroiddemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_intent = findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式Intent
                // Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // 隐式Intent
                Intent intent = new Intent("top.a0x16.activitytest.ACTION_START");
                intent.addCategory("top.a0x16.activitytest.MY_CATEGORY");
                // 页面间传输数据
                intent.putExtra("extra_data", "Hello from MainActivity");
                startActivityForResult(intent, 100);
            }
        });

        Button btn_uri = findViewById(R.id.btn_uri);
        btn_uri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 隐式打开浏览器
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button btn_phone = findViewById(R.id.btn_phone);
        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 100:
                if (resultCode == RESULT_OK) {
                    String data_return = data.getStringExtra("data_return");
                    Toast.makeText(this, data_return, Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
}
