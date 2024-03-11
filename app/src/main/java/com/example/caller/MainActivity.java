package com.example.caller;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.caller.listeners.BtnCallClickListener;
import com.example.caller.listeners.BtnDialClickListener;
import com.example.caller.listeners.BtnSendSMSClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set the click listener for the button to dial the number
        findViewById(R.id.button_dial).setOnClickListener(new BtnDialClickListener(this));
        // Set the click listener for the button to call the number
        findViewById(R.id.button_call).setOnClickListener(new BtnCallClickListener(this));
        // Set the click listener for the button to send an SMS to the number
        findViewById(R.id.button_sms).setOnClickListener(new BtnSendSMSClickListener(this));
    }
}