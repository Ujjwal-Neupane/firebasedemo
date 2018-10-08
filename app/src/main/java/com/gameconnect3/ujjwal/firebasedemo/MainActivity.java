package com.gameconnect3.ujjwal.firebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_token, from, message;
    EditText text_message;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_token = findViewById(R.id.textview_token);
        from = findViewById(R.id.from);
        message = findViewById(R.id.message);

        text_message = findViewById(R.id.text_message);
        btn_send = findViewById(R.id.btn_send);

        txt_token.setText(SharedPrefManager.getInstance(getApplicationContext()).getToken());


        from.setText("AA");
        message.setText("aa");

        Log.d("token", SharedPrefManager.getInstance(getApplicationContext()).getToken());

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });


    }

    public void sendMessage(){

        String phoneNo = "9860999594";
        String msg = text_message.getText().toString();


            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();


    }
}
