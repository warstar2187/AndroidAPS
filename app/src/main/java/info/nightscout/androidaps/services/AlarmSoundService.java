package info.nightscout.androidaps.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.R;
import info.nightscout.androidaps.logging.L;

public class AlarmSoundService extends Service {
<<<<<<< HEAD
    private static Logger log = LoggerFactory.getLogger(L.ALARM);
=======
    private static Logger log = LoggerFactory.getLogger(L.CORE);
>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde

    MediaPlayer player;
    int resourceId = R.raw.error;

    public AlarmSoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
<<<<<<< HEAD
        if (L.isEnabled(L.ALARM))
=======
        if (L.isEnabled(L.CORE))
>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde
            log.debug("onCreate");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player != null && player.isPlaying())
            player.stop();
<<<<<<< HEAD
        if (L.isEnabled(L.ALARM))
=======
        if (L.isEnabled(L.CORE))
>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde
            log.debug("onStartCommand");
        if (intent != null && intent.hasExtra("soundid"))
            resourceId = intent.getIntExtra("soundid", R.raw.error);

        player = new MediaPlayer();
        AssetFileDescriptor afd = MainApp.sResources.openRawResourceFd(resourceId);
        if (afd == null)
            return START_STICKY;
        try {
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
        } catch (IOException e) {
            log.error("Unhandled exception", e);
        }
        player.setLooping(true); // Set looping
        AudioManager manager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        if (manager == null || !manager.isMusicActive()) {
            player.setVolume(100, 100);
        }

        try {
            player.prepare();
            player.start();
        } catch (IOException e) {
            log.error("Unhandled exception", e);
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
<<<<<<< HEAD
        if (L.isEnabled(L.ALARM))
=======
        if (L.isEnabled(L.CORE))
>>>>>>> 7a175e48d808b820c6359357518ef9bd2fd1afde
            log.debug("onDestroy");
    }
}
