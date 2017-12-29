package de.mchllngr.androidplayground.module.foregroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import de.mchllngr.androidplayground.BuildConfig;
import de.mchllngr.androidplayground.R;
import timber.log.Timber;

import static android.os.Build.*;

public class ForegroundService extends Service {

    public static final int NOTIFICATION_ID = 55342;
    public static final String START_ACTION = BuildConfig.APPLICATION_ID + ".foregroundservice.start";
    public static final String STOP_ACTION = BuildConfig.APPLICATION_ID + ".foregroundservice.stop";
    public static final String NOTIFICATION_DEFAULT_CHANNEL_ID = BuildConfig.APPLICATION_ID + ".foregroundservice.default";
    public static final String NOTIFICATION_DEFAULT_CHANNEL_NAME = "Foreground Service Default";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.d("ForegroundService created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.d("ForegroundService destroyed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (START_ACTION.equals(intent.getAction())) {
            Notification notification = getNotification();
            if (notification != null)
                startForeground(NOTIFICATION_ID, notification);
            else
                Timber.w("Could not show notification");
        } else if (STOP_ACTION.equals(intent.getAction())) {
            stopForeground(true);
            stopSelf();
        }
        return START_STICKY;
    }

    @Nullable
    private Notification getNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager == null) {
            return null;
        }

        if (VERSION.SDK_INT >= VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_DEFAULT_CHANNEL_ID, NOTIFICATION_DEFAULT_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(false);
            channel.enableVibration(false);
            channel.setShowBadge(false);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            notificationManager.createNotificationChannel(channel);
        }

        return new NotificationCompat.Builder(this, NOTIFICATION_DEFAULT_CHANNEL_ID)
                .setContentTitle("Title")
                .setTicker("Ticker")
                .setContentText("Content")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .build();
    }
}
