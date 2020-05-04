package com.example.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> arrayList;
    ListView lvInfo;
    ArrayAdapter adapter;
    EditText edName, edPhone;
    Button btADD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvInfo.setAdapter(adapter);

    }

    public void setControl() {
        lvInfo = findViewById(R.id.lvInfo);
        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        btADD = findViewById(R.id.btnSave);
    }

    public void setEvent() {
        btADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = edName.getText().toString() + "[" + edPhone.getText().toString() + "]";
                if (edName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy nhập tên !", Toast.LENGTH_SHORT).show();
                    edName.requestFocus();
                } else if (edPhone.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy nhập sdt !", Toast.LENGTH_SHORT).show();
                    edPhone.requestFocus();
                } else {
                    arrayList.add(info);
                    Collections.sort(arrayList);
                    adapter.notifyDataSetChanged();
                    edName.setText("");
                    edPhone.setText("");
                    edName.requestFocus();
                    Toast.makeText(MainActivity.this, "Thêm thông tin thành công ! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
