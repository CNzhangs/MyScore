package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll1, ll2, ll3;
    private EditText et;
    private Button bt1, bt2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);
        et = findViewById(R.id.et);
        ll1 = findViewById(R.id.ll_1);
        ll2 = findViewById(R.id.ll_2);
        ll3 = findViewById(R.id.ll3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.GONE);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll2.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.GONE);
            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = et.getText().toString();
                try {
                    if (text.isEmpty()) {
                        return;
                    }
                    int score = Integer.parseInt(text) / 10;
                    score = Math.min(score, 100);
                    ll3.removeAllViews();
                    ll3.setOrientation(LinearLayout.VERTICAL);
                    for (int j = 0; j < score; j++) {
                        TextView textView = new TextView(MainActivity.this);
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100));
                        textView.setText((j + 1) * 10 + "个积分");
                        textView.setGravity(Gravity.CENTER);
                        ll3.addView(textView);
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "请输入数字", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
