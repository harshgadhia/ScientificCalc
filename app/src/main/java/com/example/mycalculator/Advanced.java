package com.example.mycalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Advanced extends ActionBarActivity {
    private String txt = "";
    private Button sin, cos, tan, ln, log, e, i, sqrt, power, pie, perc, fact, square, cube, bkpspace;
    private TextView textView;
    DecimalFormat df = new DecimalFormat( "#0.00000000" );
    private double displayTxt = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        textView = (TextView) findViewById(R.id.calcText);
        initializeCalc();
        Intent intent = getIntent();
        txt = intent.getExtras().get("value").toString();
        handleDisplay();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_advanced, menu);
        return true;
    }


    public void initializeCalc() {
        sin = (Button) findViewById(R.id.btn_sin);
        cos = (Button) findViewById(R.id.btn_cos);
        tan = (Button) findViewById(R.id.btn_tan);
        ln = (Button) findViewById(R.id.btn_ln);
        log = (Button) findViewById(R.id.btn_log);
        sqrt = (Button) findViewById(R.id.btn_sqrt);
        pie = (Button) findViewById(R.id.btn_pie);
        i = (Button) findViewById(R.id.btn_i);
        fact = (Button) findViewById(R.id.btn_fact);
        power = (Button) findViewById(R.id.btn_power);
        perc = (Button) findViewById(R.id.btn_percent);
        e = (Button) findViewById(R.id.btn_exp);
        square = (Button) findViewById(R.id.btn_square);
        cube = (Button) findViewById(R.id.btn_cube);
        bkpspace = (Button) findViewById(R.id.btn_delete);

        setListenerOnButton(sin);
        setListenerOnButton(cos);
        setListenerOnButton(tan);
        setListenerOnButton(ln);
        setListenerOnButton(log);
        setListenerOnButton(pie);
        setListenerOnButton(sqrt);
        setListenerOnButton(i);
        setListenerOnButton(fact);
        setListenerOnButton(power);
        setListenerOnButton(perc);
        setListenerOnButton(square);
        setListenerOnButton(cube);
        setListenerOnButton(e);
        setListenerOnButton(bkpspace);
    }

    public void setListenerOnButton(Button btn) {

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch(v.getId()) {

                    case R.id.btn_sin :
                        try {
                            txt = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(txt))));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_cos :
                        try {
                            txt = String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(txt))));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_tan :
                        try {
                            txt = String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(txt))));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_pie :
                        txt = String.valueOf(Math.PI);
                        handleDisplay();
                        break;
                    case R.id.btn_i :
                        //txt+="4";
                        handleDisplay();
                        break;
                    case R.id.btn_exp :
                        txt = String.valueOf(Math.E);
                        handleDisplay();
                        break;
                    case R.id.btn_ln :
                        try {
                            txt = String.valueOf(Math.log(Double.parseDouble(txt)));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_log :
                        try {
                            txt = String.valueOf(Math.log10(Double.parseDouble(txt)));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_fact :
                        try {
                            txt = String.valueOf(factorial(Double.parseDouble(txt)));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_sqrt :
                        try {
                            txt = String.valueOf(Math.sqrt(Double.parseDouble(txt)));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_square :
                        try {
                            txt = String.valueOf((Double.parseDouble(txt)*(Double.parseDouble(txt))));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_cube :
                        try {
                            txt = String.valueOf((Double.parseDouble(txt)*(Double.parseDouble(txt)*Double.parseDouble(txt))));
                        }
                        catch (NumberFormatException nfe) {
                            txt = textView.getText().toString();
                            Toast.makeText(getApplicationContext(), "Too Big Number", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
                        }
                        handleDisplay();
                        break;
                    case R.id.btn_percent :
                        txt = String.valueOf(Double.parseDouble(txt) / 100);
                        handleDisplay();
                        break;
                    case R.id.btn_delete :
                        txt = (txt.length() > 1) ? txt.substring(0, txt.length()-1) : "0";
                        handleDisplay();
                        if(txt == "0")
                            txt = "0";
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_basic) {
            Intent intent = new Intent(Advanced.this, MainActivity.class);
            intent.putExtra("value", txt);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void handleDisplay() {
        if(txt == "")
            txt = "0";
        displayTxt = Double.parseDouble(txt);
        // double dd2dec = new Double(df.format(displayTxt)).doubleValue();
        textView.setText(fmt(displayTxt));
    }

    public double factorial(double n){
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public String fmt(double d)
    {
        d = Double.parseDouble(df.format(d));
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}
