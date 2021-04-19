package com.example.aleem.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText a;
    public String op = "";
    public String oldNumber = "";
    public Boolean isNew = true;
    public String newNumber = "";
    public Double finalNumber;
    public String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClicked(View view) {
        a = findViewById(R.id.result);
        if (isNew){
            a.setText("");
        }
        isNew = false;
        Button b = (Button) view;
        String s = a.getText().toString();
        switch(b.getId()){
            case R.id.btn0:
                s += "0";
                break;
            case R.id.btn1:
                s += "1";
                break;
            case R.id.btn2:
                s += "2";
                break;
            case R.id.btn3:
                s += "3";
                break;
            case R.id.btn4:
                s += "4";
                break;
            case R.id.btn5:
                s += "5";
                break;
            case R.id.btn6:
                s += "6";
                break;
            case R.id.btn7:
                s += "7";
                break;
            case R.id.btn8:
                s += "8";
                break;
            case R.id.btn9:
                s += "9";
                break;
            case R.id.btnpm:
                s = "-" + s;
                break;
        }
        a.setText(s);
    }

    public void btnOpt(View view){
        Button b = (Button) view;
        switch(b.getId()) {
            case R.id.btnplus:
                op = "+";
                break;
            case R.id.btnminus:
                op = "-";
                break;
            case R.id.btnmul:
                op = "*";
                break;
            case R.id.btndiv:
                op = "/";
                break;
        }
        oldNumber = a.getText().toString();
        isNew = true;
    }


    public void btnEqual(View view){
        newNumber = a.getText().toString();
        switch (op){
            case "+":
                finalNumber = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                finalNumber = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                finalNumber = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                finalNumber = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        a.setText(finalNumber.toString());
        isNew = true;
    }


    public void btnClean(View view){
        a.setText("");
        isNew = true;
    }

    public void btnCut(View view){
        str = a.getText().toString();
        if (str.length() >=1 ) {
            str = str.substring(0, str.length() - 1);
            a.setText(str);
        }
        else if (str.length() <=1 ){
            a.setText("");
        }
    }

    public void btnDot(View view){
        if (!a.getText().toString().contains(".")) {
            a.setText(a.getText() + ".");
        }
    }

}
