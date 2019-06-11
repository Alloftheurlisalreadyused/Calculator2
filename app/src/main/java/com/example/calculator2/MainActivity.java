package com.example.calculator2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button Calculate;
    private EditText val1,val2;
    private Spinner spinner;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        Calculate=findViewById(R.id.calculate);
        val1=findViewById(R.id.v1);
        val2=findViewById(R.id.v2);
        spinner=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.operators,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display();
            }
        });
    }

    private void Display(){
        double v1=0;
        double v2=0;

        v1= Double.parseDouble(val1 .getText().toString());
        v2= Double.parseDouble(val2 .getText().toString());

        if(spinner.getSelectedItemPosition()==3&v2==0){
            result.setText("Can't divide by zero");
        }

        else result.setText(String.valueOf(Calculate(spinner.getSelectedItemPosition(),v1,v2)));
    }

    private double Calculate(int operator,double a,double b){
        double tmp=0;
        if(operator==0)tmp=a+b;
        else if(operator==1)tmp=a-b;
        else if(operator==2)tmp=a*b;
        else if(operator==3)tmp=a/b;

        return Double.parseDouble(new DecimalFormat("#.#####").format(tmp));
    }
}
