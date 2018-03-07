package com.example.android.maths4app;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
                    Toast.makeText(getApplicationContext(),"Invalid N", Toast.LENGTH_SHORT).show();
                }
                else
                {
                int n=Integer.valueOf(s,10);
                dg.setText(""+n);
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
                        Toast.makeText(getApplicationContext(), "Enter the Co-efficients", Toast.LENGTH_SHORT).show();
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
                                float maxi = a[i][i];
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
                                float pivot = a[0][0];
                                for (int k = i; k < m - 1; k++) //Row echelon process
                                {
                                    pivot = a[i][i];
                                    float[] temp = new float[n];
                                    for (int j = 0; j < n; j++)
                                        temp[j] = (a[i][j] / pivot) * (-a[k + 1][i]);
                                    for (int j = 0; j < n; j++)
                                        a[k + 1][j] += temp[j];
                                }
                            }
                            float[][] b = new float[m][n];
                            for (int i = 0; i < m; i++)
                                for (int j = 0; j < n; j++)
                                    b[i][j] = a[i][j];
                            for (int i = m - 1; i >= 0; i--) {
                                float ans;
                                if (i == m - 1) {
                                    ans = b[i][n - 1] / b[i][i];
                                    t.append("\n" + ans);//anwser is here
                                } else {
                                    float sum = b[i][n - 1];
                                    for (int j = n - 2; j > i; j--)
                                        sum -= b[i][j];
                                    ans = sum / a[i][i];
                                    t.append("\n" + ans);
                                }
                                for (int j = 0; j < m; j++)
                                    b[j][i] *= ans;

                            }
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
