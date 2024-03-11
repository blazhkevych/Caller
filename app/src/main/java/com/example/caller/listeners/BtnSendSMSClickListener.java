package com.example.caller.listeners;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class BtnSendSMSClickListener implements View.OnClickListener {

    private Activity activity;

    public BtnSendSMSClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        /*Intent intent = new Intent(Intent.);
        intent.setData(Uri.parse("tel:+380800300466")); // Kyivstar customer support number
        activity.startActivity(intent);*/
    }
}
