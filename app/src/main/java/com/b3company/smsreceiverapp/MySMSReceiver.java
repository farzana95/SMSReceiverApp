package com.b3company.smsreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {

    String msgFrom = "";
    String msgBody = "";
    String timeStamp = "";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle data = intent.getExtras();

        //SmsMessage message = SmsMessage.createFromPdu()

        Object[] pduData = (Object[]) data.get("pdus");

        for(int i = 0; i < pduData.length; i++){
            SmsMessage message = SmsMessage.createFromPdu( (byte[]) pduData[i]);

            msgFrom = message.getDisplayOriginatingAddress();
            msgBody = msgBody = message.getMessageBody();
        }

        MainActivity.tvMessage.setText(
                "From: " + msgFrom + "\n\n"
                + "Message:\n" + msgBody
        );

        Toast.makeText(context, "I will receive here...", Toast.LENGTH_LONG).show();
        Log.d(MainActivity.TAG, "I will receive here...");
    }
}
