package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private Spinner spinner1,spinner2;
    private EditText amountet;
    private Button convertbtn,tablebtn;
    private String from,to;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1=findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Currency,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2=findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        amountet=findViewById(R.id.amounet);
        amountet.setOnClickListener(this);
        convertbtn=findViewById(R.id.convertbtn);
        convertbtn.setOnClickListener(this);
        tablebtn=findViewById(R.id.tablecombbtn);
        tablebtn.setOnClickListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView==spinner1) {
            String text = adapterView.getItemAtPosition(i).toString();
            from=text;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        if(adapterView==spinner2){
            String text = adapterView.getItemAtPosition(i).toString();
            to=text;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }






    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if(convertbtn==view) {
            if(amountet.getText().toString().equals(""))
                Toast.makeText(this,"the amount is required",Toast.LENGTH_LONG).show();
            else {
                Intent intent = new Intent(this, ResultActivity.class);
                final double EUR=4.06523598,USD=3.46189663,CAD=2.60393479, GBP=4.42989486,ILS=1;
                double fromValue = 0,toValue=1;
                if(from.equals("EUR"))
                    fromValue=EUR;
                if(from.equals("USD"))
                    fromValue=USD;
                if(from.equals("CAD"))
                    fromValue=CAD;
                if(from.equals("GBP"))
                    fromValue=GBP;
                if(from.equals("ILS"))
                    fromValue=ILS;

                if(to.equals("EUR"))
                    toValue=EUR;
                if(to.equals("USD"))
                    toValue=USD;
                if(to.equals("CAD"))
                    toValue=CAD;
                if(to.equals("GBP"))
                    toValue=GBP;
                if(to.equals("ILS"))
                    toValue=ILS;

                double result=Double.parseDouble(amountet.getText().toString())*fromValue/toValue;
                Currency currency = new Currency(from, to, Double.parseDouble(amountet.getText().toString()), result);
                intent.putExtra("currency", currency);
                startActivity(intent);
            }
        }
        if (tablebtn==view){
            Intent intent = new Intent(this, TableCombination.class);
            startActivity(intent);


        }




    }
}