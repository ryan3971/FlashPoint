package flash.point.flashpoint;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationAfterReboot extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
            	SetNotification n = new SetNotification(context);
		    	n.startAlarm();
    }
}
