package com.example.kimbum.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Option0Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option0);


    }
    private EditText etInput;
    private TextView tvOutput;
    private Button btnProcess , btnBack , btnNext;






    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_0);
        tvOutput = (TextView) findViewById(R.id.tv_body_0);
        btnProcess = (Button) findViewById(R.id.btn_process_0);
        btnBack = (Button) findViewById(R.id.btn_back);
        btnNext =(Button) findViewById(R.id.btn_next);



    }

    // This "process" method MUST be bound in the layout XML file, "android:onClick="process""
    public void process(View v) {
        // Do we really need to compare view objects?
        if (v == btnProcess) {
            greet();
        }
        else if ( v == btnBack) {
            back();
        }
        else if (v == btnNext){
            next();
        }
        hideKeyboardInput(v);
    }

    public void next() {
        Intent i  = new Intent(getApplicationContext(), Option1Activity.class);
        startActivity(i);
    }

    public void back() {
        Intent i  = new Intent(getApplicationContext() , Option5Activity.class);
        startActivity(i);
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }



    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
