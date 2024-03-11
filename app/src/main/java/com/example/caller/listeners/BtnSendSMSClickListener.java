package com.example.caller.listeners;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class BtnSendSMSClickListener implements View.OnClickListener {

    private static final int REQUEST_SEND_SMS = 2;
    private Activity activity;
    private String phoneNumber = "+380800300466"; // Phone number to send an SMS to (Kyivstar customer support number)
    private String message = "Hello, Kyivstar!"; // Message to send

    public BtnSendSMSClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
        } else {
            sendSMS();
        }
    }

    private void sendSMS() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(activity, "Message sent", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(activity, "Failed to send message", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
