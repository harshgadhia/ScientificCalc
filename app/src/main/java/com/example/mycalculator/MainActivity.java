package com.example.mycalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private String txt = "0";
    private Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, divide, multiply, dot, equals, bkpspace, clear;
    private TextView textView;
    private String operator = "";
    private ArrayList<String> values = new ArrayList<String>();
    DecimalFormat df = new DecimalFormat( "#0.00000000" );
    private double displayTxt = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.calcText);
        initializeCalc();
        Intent intent = getIntent();
        if( intent.hasExtra("value") )
        txt = intent.getExtras().get("value").toString();
        handleDisplay();
    }

    public void initializeCalc() {
        zero = (Button) findViewById(R.id.btn_0);
        one = (Button) findViewById(R.id.btn_1);
        two = (Button) findViewById(R.id.btn_2);
        three = (Button) findViewById(R.id.btn_3);
        four = (Button) findViewById(R.id.btn_4);
        five = (Button) findViewById(R.id.btn_5);
        six = (Button) findViewById(R.id.btn_6);
        seven = (Button) findViewById(R.id.btn_7);
        eight = (Button) findViewById(R.id.btn_8);
        nine = (Button) findViewById(R.id.btn_9);
        plus = (Button) findViewById(R.id.btn_plus);
        minus = (Button) findViewById(R.id.btn_minus);
        multiply = (Button) findViewById(R.id.btn_multiply);
        divide = (Button) findViewById(R.id.btn_divide);
        equals = (Button) findViewById(R.id.btn_equals);
        dot = (Button) findViewById(R.id.btn_dot);
        bkpspace = (Button) findViewById(R.id.btn_delete);
        clear = (Button) findViewById(R.id.btn_ac);

        setListenerOnButton(zero);
        setListenerOnButton(one);
        setListenerOnButton(two);
        setListenerOnButton(three);
        setListenerOnButton(four);
        setListenerOnButton(five);
        setListenerOnButton(six);
        setListenerOnButton(seven);
        setListenerOnButton(eight);
        setListenerOnButton(nine);
        setListenerOnButton(plus);
        setListenerOnButton(minus);
        setListenerOnButton(divide);
        setListenerOnButton(multiply);
        setListenerOnButton(dot);
        setListenerOnButton(bkpspace);
        setListenerOnButton(equals);
        setListenerOnButton(clear);
    }

    public void setListenerOnButton(Button btn) {

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch(v.getId()) {

                    case R.id.btn_0 :
                        txt+="0";
                        handleDisplay();
                        break;
                    case R.id.btn_1 :
                        txt+="1";
                        handleDisplay();
                        break;
                    case R.id.btn_2 :
                        txt+="2";
                        handleDisplay();
                        break;
                    case R.id.btn_3 :
                        txt+="3";
                        handleDisplay();
                        break;
                    case R.id.btn_4 :
                        txt+="4";
                        handleDisplay();
                        break;
                    case R.id.btn_5 :
                        txt+="5";
                        handleDisplay();
                        break;
                    case R.id.btn_6 :
                        txt+="6";
                        handleDisplay();
                        break;
                    case R.id.btn_7 :
                        txt+="7";
                        handleDisplay();
                        break;
                    case R.id.btn_8 :
                        txt+="8";
                        handleDisplay();
                        break;
                    case R.id.btn_9 :
                        txt+="9";
                        handleDisplay();
                        break;
                    case R.id.btn_dot :
                        if(txt.indexOf(".") < 0)
                            txt+=".";
                        handleDisplay();
                        break;
                    case R.id.btn_delete :
                        txt = (txt.length() > 1) ? txt.substring(0, txt.length()-1) : "0";
                        handleDisplay();
                        if(txt == "0")
                            txt = "";
                        break;
                    case R.id.btn_plus :
                        operator = "+";
                        processOperation();
                        break;
                    case R.id.btn_minus :
                        operator = "-";
                        processOperation();
                        break;
                    case R.id.btn_divide :
                        operator = "/";
                        processOperation();
                        break;
                    case R.id.btn_multiply :
                        operator = "x";
                        processOperation();
                        break;
                    case R.id.btn_equals :
                        operator = "=";
                        processOperation();
                        break;
                    case R.id.btn_ac :
                        txt = "0";
                        handleDisplay();
                        break;
                }
            }
        });
    }

    public void processOperation() {
        txt = textView.getText().toString();
        values.add(txt);
        values.add(operator);

        if( values.size() > 3 || operator == "=" ) {
            String operation = values.get(1);
            Double total = 0.0;

            //double op1 = new Double(df.format(values.get(0))).doubleValue();
            //double op2 = new Double(df.format(values.get(2))).doubleValue();

            double op1 = Double.parseDouble(values.get(0));
            double op2 = Double.parseDouble(values.get(2));

            if(operation == "+") {
                total = op1 + op2;
            }
            else if(operation == "-") {
                total = op1 - op2;
            }
            else if(operation == "x") {
                total = op1 * op2;
            }
            else if(operation == "/") {
                if(op2 != 0) {
                    total = op1 / op2;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Cannot divide by 0", Toast.LENGTH_LONG).show();
                    values = new ArrayList<String>();
                    txt = "0";
                    handleDisplay();
                    return;
                }
            }

            values = new ArrayList<String>();
            if(operator != "=" ) {
                values.add(String.valueOf(total));
                values.add(operator);
            }
            else {
                // values.add(String.valueOf(total));
            }
            txt = String.valueOf(total);
        }

        handleDisplay();
        txt = "0";
    }


    public void handleDisplay() {
        if(txt == "")
            txt = "0";

        displayTxt = Double.parseDouble(txt);
        // double dd2dec = new Double(df.format(displayTxt)).doubleValue();
        textView.setText(fmt(displayTxt));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_advanced) {
            txt = textView.getText().toString();
            Intent intent = new Intent(MainActivity.this, Advanced.class);
            intent.putExtra("value", txt);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String fmt(double d)
    {
        // Log.i("POINT : ------>", String.valueOf(d));
        d = Double.parseDouble(df.format(d));
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}