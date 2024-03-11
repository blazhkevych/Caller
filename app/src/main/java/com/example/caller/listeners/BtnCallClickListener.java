package com.example.caller.listeners;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class BtnCallClickListener implements View.OnClickListener {

    private static final int REQUEST_CALL_PHONE = 1;
    private Activity activity;

    public BtnCallClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        } else {
            call();
        }
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+380800300466")); // Kyivstar customer support number
        activity.startActivity(intent);
    }
}
