package com.soho.yvtc.yvn110101a;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int tmp = -1, ch = -1;
    boolean b[] = new boolean[5];
    boolean chks[] = new boolean[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("對話框測試");
        builder.setMessage("這是對話框內容\n第二行");

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "確定被按下", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消被按下", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "HA HA HA", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "忽略被按下", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

    public void click2(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("輸入對話框測試");
        builder.setMessage("請輸入你的暱稱");
        final EditText ed = new EditText(MainActivity.this);
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv = (TextView) findViewById(R.id.textView);
                String str = ed.getText().toString();
                tv.setText(str);
            }
        });
        builder.show();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選項對話框測試");
        builder.setSingleChoiceItems(R.array.drinks, ch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = which;
             }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            ch = tmp;
                if (ch >= 0){
                    String[] drinks = getResources().getStringArray(R.array.drinks);
                    TextView tv2 = (TextView) findViewById(R.id.textView2);
                    tv2.setText(drinks[ch]);
                    Toast.makeText(MainActivity.this, "確定被按下", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = ch;
                Toast.makeText(MainActivity.this, "取消被按下", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選項對話框測試");
        builder.setItems(R.array.drinks, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] drinks = getResources().getStringArray(R.array.drinks);
                TextView tv3 = (TextView)findViewById(R.id.textView3);
                tv3.setText(drinks[which]);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    public void click5(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選項對話框測試");
        b = chks.clone();
        builder.setMultiChoiceItems(R.array.drinks, b, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder sb = new StringBuilder();
                chks = b.clone();
                for (int i=0;i<=3;i++)
                {
                    if (b[i])
                    {
                        sb.append(String.valueOf(i + ","));
                    }
                }
                TextView tv4 = (TextView) findViewById(R.id.textView4);
                tv4.setText(sb.toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                b = chks.clone();
            }
        });
        builder.show();
    }

    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("輸入對話框測試");
        builder.setMessage("請輸入你的暱稱");

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View myv = inflater.inflate(R.layout.myview, null);

        final TextView tt = (TextView) myv.findViewById(R.id.textView6);
        Button bb = (Button) myv.findViewById(R.id.button7);
        Button bb2 = (Button) myv.findViewById(R.id.button8);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tt.setText("Click!! Click!!");
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tt.setText("Click2!! Click2!!");
            }
        });

        builder.setView(myv);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
}
