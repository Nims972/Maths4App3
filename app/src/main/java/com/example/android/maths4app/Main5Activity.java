package com.example.android.maths4app;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        TextView t=(TextView) findViewById(R.id.about);
        t.setText("Created BY:\nNirmal Patel\nLak Hinsu");
    }
}
