package top.a0x16.firstandroiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 获取上一个页面的传值
        final Intent intent = getIntent();
        String extra_data = intent.getStringExtra("extra_data");
        Toast.makeText(this, extra_data, Toast.LENGTH_LONG).show();

        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("data_return", "Hello from SecondActivity");
                // 返回值给上一个页面
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}
