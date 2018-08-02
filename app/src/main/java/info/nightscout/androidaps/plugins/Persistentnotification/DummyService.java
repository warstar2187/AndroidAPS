package info.nightscout.androidaps.plugins.Persistentnotification;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

<<<<<<< HEAD
=======
import com.squareup.otto.Subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.events.EventAppExit;
import info.nightscout.androidaps.logging.L;

>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde
/**
 * Keeps AndroidAPS in foreground state, so it won't be terminated by Android nor get restricted by the background execution limits
 */
public class DummyService extends Service {
<<<<<<< HEAD
=======
    private static Logger log = LoggerFactory.getLogger(L.CORE);

>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notification notification = PersistentNotificationPlugin.getPlugin().updateNotification();
        if (notification != null)
            startForeground(PersistentNotificationPlugin.ONGOING_NOTIFICATION_ID, notification);
        return START_STICKY;
    }

<<<<<<< HEAD
    @Override
    public void onDestroy() {
=======
    @Subscribe
    public void onStatusEvent(EventAppExit event) {
        if (L.isEnabled(L.CORE))
            log.debug("EventAppExit received");

        stopSelf();
    }

    @Override
    public void onCreate() {
        MainApp.bus().register(this);
    }

    @Override
    public void onDestroy() {
        if (L.isEnabled(L.CORE))
            log.debug("onDestroy");
        MainApp.bus().unregister(this);
>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde
        stopForeground(true);
    }
}
