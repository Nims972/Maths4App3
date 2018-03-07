package com.example.android.maths4app;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button Solve=(Button) findViewById(R.id.solve);
        Button sub=(Button) findViewById(R.id.submit);
        Button reset=(Button) findViewById(R.id.reset);
        final EditText dg=(EditText) findViewById(R.id.editText);
        final TextView t=(TextView) findViewById(R.id.textView);
        final EditText vEditText =(EditText) findViewById(R.id.editText2);
        t.setText("Answer");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=dg.getText().toString();
                if(s.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid N",Toast.LENGTH_SHORT).show();
                }
                else {
                    int n = Integer.valueOf(s, 10);
                    dg.setText("" + n);
                }
            }
        });
        Solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s3=dg.getText().toString();
                if(s3.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Enter N First", Toast.LENGTH_SHORT).show();
                }
                else {
                    int m = Integer.valueOf(s3, 10);
                    int n = m + 1;
                    String enteredText = vEditText.getText().toString();
                    if (enteredText.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Enter Co-efficients", Toast.LENGTH_SHORT).show();
                    } else {
                        String[] s1 = enteredText.split("\\n");
                        if (s1.length != m * n) {
                            Toast.makeText(getApplicationContext(), "Invalid Co-efficients", Toast.LENGTH_SHORT).show();
                        } else {
                            String s;
                            int c = 0;
                            t.setText("");
                            float[][] a = new float[10][10];
                            for (int i = 0; i < m; i++) {
                                for (int j = 0; j < n; j++, c++) {
                                    s = s1[c];
                                    a[i][j] = Float.valueOf(s);
                                }
                            }
                            for (int i = 0; i < m - 1; i++) {
                                int pi = i;
                                boolean flag = false;
                                float sum = 0, maxi = a[i][i];
                                for (int j = 0; j < n - 1; j++) {
                                    sum += a[i][j];
                                }
                                if ((sum - a[i][i]) > a[i][i])
                                    flag = true;
                                if (flag) {
                                    for (int x = i; x < m; x++) //Finding maximum
                                    {
                                        if (a[x][i] > maxi) {
                                            maxi = a[x][i];
                                            pi = x;
                                        }
                                    }
                                    for (int y = 0; y < n; y++) //swapping
                                    {
                                        float temp = a[i][y];
                                        a[i][y] = a[pi][y];
                                        a[pi][y] = temp;
                                    }
                                }
                            }
                            float[] init = new float[m];
                            for (int i = 0; i < m; i++)
                                init[i] = 0;
                            int x = 1;
                            while (x <= 5) {
                                for (int i = 0; i < m; i++) {
                                    float sum = 0;
                                    for (int j = 0; j < n - 1; j++) {
                                        sum += a[i][j] * init[j];
                                    }
                                    sum -= a[i][i] * init[i];
                                    init[i] = (a[i][n - 1] - sum) / a[i][i];
                                }
                                x++;
                            }
                            for (int i = 0; i < m; i++)
                                t.append("\n" + init[i]);
                        }
                    }
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dg.setText("");
                vEditText.setText("");
                t.setText("Answer");
            }
        });
    }
}

