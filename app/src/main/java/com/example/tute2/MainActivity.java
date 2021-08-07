package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    RadioButton rd_btn_c;
    RadioButton rd_btn_f;
    Button btn_cal;
    TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.ET);
        rd_btn_c=findViewById(R.id.rdbtn_c);
        rd_btn_f=findViewById(R.id.rdbtn_f);
        btn_cal=findViewById(R.id.btncal);
    }

    @Override
   protected void onResume() {
        super.onResume();//this is used when the btn_cal is clicked..this is implemented
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){
        calculations cal=new calculations();
        String value=et.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();
        }
        else{
            float temp=Float.parseFloat(value);

            if(rd_btn_c.isChecked()){
                temp=cal.convertCelciusToFahrenheit(temp);
            }
            else if(rd_btn_f.isChecked()){
               temp=cal.convertFahrenheitToCelcius(temp);
            }
            else {
                Toast.makeText(this, "Select Celcius or Farenheite", Toast.LENGTH_SHORT).show();
                temp= 0.0f;
            }
            tw.setText(new Float(temp).toString());
        }
    }

}