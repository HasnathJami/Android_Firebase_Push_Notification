package com.example.android_firebase_push_notification;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        getFirebaseMeesage(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void getFirebaseMeesage(String title , String msg)
    {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"myChannelForPushNotificationDemo")
                                                  .setSmallIcon(R.drawable.notification_icon)
                                                  .setContentTitle(title)
                                                  .setContentText(msg)
                                                  .setAutoCancel(true);


        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(1,builder.build());
    }
}
