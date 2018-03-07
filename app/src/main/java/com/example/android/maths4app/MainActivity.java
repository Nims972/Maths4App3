package com.example.android.maths4app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Pivot=(Button) findViewById(R.id.pivot);
        Button Gauss=(Button) findViewById(R.id.gauss);
        Button Seidal=(Button) findViewById(R.id.seidal);
        Button About=(Button) findViewById(R.id.about);

        Pivot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });
        Gauss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });
        Seidal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(intent);
            }
        });

    }
}


