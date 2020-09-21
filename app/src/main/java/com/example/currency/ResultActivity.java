package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private Button resultbtn,backbtn;
    private TextView tvresult;
    private Dialog d;
    private Button nobtn,yesbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultbtn=findViewById(R.id.resultbtn);
        resultbtn.setOnClickListener(this);
        tvresult=findViewById(R.id.tvresult);
        backbtn=findViewById(R.id.backbtn);
        backbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(resultbtn==view){
            if(!tvresult.getText().toString().equals(""))
                tvresult.setText("");
            else{
        Intent intent=getIntent();
        Currency currency=(Currency) intent.getSerializableExtra("currency");
        tvresult.setText(currency.getFrom()+" "+currency.getAmount()+"\n\n"+"to "+currency.getTo()+"\n\n"+"= "+currency.getResult());

        }
    }
        else if (backbtn==view){
            d= new Dialog(this);
            d.setContentView(R.layout.back);
            nobtn=d.findViewById(R.id.nobtn);
            nobtn.setOnClickListener(this);
            yesbtn=d.findViewById(R.id.yesbtn);
            yesbtn.setOnClickListener(this);

            d.show();



        }
        if (nobtn==view){
            d.dismiss();
        }
        if (yesbtn==view){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}