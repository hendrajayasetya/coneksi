package com.onenet.ccc.eanet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    eaNet connn;
    static TextView mText;
    static EditText mEdit;
    private Spinner mSpin;
    String isi;
    private String[] www = {
            "http://",
            "https://" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView)findViewById(R.id.myResult);
        mEdit = (EditText)findViewById(R.id.t_input);
        mSpin = (Spinner) findViewById(R.id.spinner);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,www);
        mSpin.setAdapter(adapter);

        mSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                isi = mSpin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void doSomething(View view) {
        ConnectivityManager con = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netfo = con.getActiveNetworkInfo();
        if(netfo !=null && netfo.isConnected()){
            connn = new eaNet(this);
            String input = mEdit.getText().toString();
            String asss = isi.concat(input);
            connn.execute(asss);
        }
        else{
            Toast.makeText(getApplication(),"You don't have connection", Toast.LENGTH_SHORT).show();
        }
    }
}