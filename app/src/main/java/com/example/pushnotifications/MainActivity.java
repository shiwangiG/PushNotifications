package com.example.pushnotifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    public EditText mTitle, mMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.title);
        mMessage = findViewById(R.id.msg);

        //Device 1 to Device 2 Notification sending

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitle.getText().toString().trim();
                String message = mMessage.getText().toString().trim();
                if (!title.equals("") && !message.equals("")) {
                    FCMSend.pushNotification(MainActivity.this,
                            "dPZAM3mtR6-D7niwSzZJHw:APA91bF0VLQWeZ8GUqIDme_IKtlWrzCm4rjhsHU-vI1aLhygbsmvjH07qPB8f-CLrEcC92pDaqqtzp4gsQ3SdShmrUvj5nudyqUMFyO2lNNntks4uvat4Vkkmra2xOWrkgdxTYZHOnOp",
                            title,
                            message);
                }
                Log.e(String.valueOf(this), "Testing log for push notification");}
        }
);



        //Device Id

//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        String token = task.getResult();
//                        System.out.println("TOKEN = " + token);
//                    }
//                });



    }
}