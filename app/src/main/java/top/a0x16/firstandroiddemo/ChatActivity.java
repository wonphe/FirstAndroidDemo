package top.a0x16.firstandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import top.a0x16.firstandroiddemo.bean.Msg;

public class ChatActivity extends AppCompatActivity {
    private List<Msg> mMsgList = new ArrayList<>();
    private EditText txt_msg;
    private Button btn_send;
    private RecyclerView chat_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initMessages();
        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);
        chat_view = findViewById(R.id.chat_view);

        chat_view.setLayoutManager(new LinearLayoutManager(this));
        final MsgAdapter adapter = new MsgAdapter(mMsgList);
        chat_view.setAdapter(adapter);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = txt_msg.getText().toString();
                if (!TextUtils.isEmpty(message)) {
                    Msg msg = new Msg(message, Msg.TYPE_SENT);
                    Switch sw_type = findViewById(R.id.sw_type);
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        boolean checked = sw_type.isChecked();
                        msg = checked ? new Msg(message, Msg.TYPE_SENT) : new Msg(message, Msg.TYPE_RECEIVED);
                    }
                    mMsgList.add(msg);
                    adapter.notifyItemInserted(mMsgList.size() - 1);
                    chat_view.scrollToPosition(mMsgList.size() - 1);
                    txt_msg.setText("");
                }
            }
        });
    }

    private void initMessages() {
        mMsgList.add(new Msg("Hello guy.", Msg.TYPE_RECEIVED));
        mMsgList.add(new Msg("Hello. Who is that?", Msg.TYPE_SENT));
        mMsgList.add(new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED));
    }

    class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
        private List<Msg> mMsgList;

        MsgAdapter(List<Msg> msgList) {
            this.mMsgList = msgList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,
                    parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Msg msg = mMsgList.get(position);
            if (msg.getType() == Msg.TYPE_RECEIVED) {
                holder.left_layout.setVisibility(View.VISIBLE);
                holder.right_layout.setVisibility(View.GONE);
                holder.msg_left.setText(msg.getContent());
            } else if (msg.getType() == Msg.TYPE_SENT) {
                holder.left_layout.setVisibility(View.GONE);
                holder.right_layout.setVisibility(View.VISIBLE);
                holder.msg_right.setText(msg.getContent());
            }
        }

        @Override
        public int getItemCount() {
            return mMsgList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            LinearLayout left_layout;
            LinearLayout right_layout;
            TextView msg_left;
            TextView msg_right;

            ViewHolder(View view) {
                super(view);
                left_layout = view.findViewById(R.id.left_layout);
                right_layout = view.findViewById(R.id.right_layout);
                msg_left = view.findViewById(R.id.msg_left);
                msg_right = view.findViewById(R.id.msg_right);
            }
        }
    }
}
