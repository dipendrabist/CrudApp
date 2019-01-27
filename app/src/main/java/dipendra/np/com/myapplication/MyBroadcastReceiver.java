package dipendra.np.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;


public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator=(Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);

        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone ringtone=RingtoneManager.getRingtone(context,uri);
        ringtone.play();


    }



}
