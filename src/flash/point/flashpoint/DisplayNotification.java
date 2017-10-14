package flash.point.flashpoint;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class DisplayNotification extends BroadcastReceiver {
	
	  
	static SharedPreferences NotificationErasePrefs;
  	static final String PREFS_NOTIFICATION_ERASE = "NotificationErasePrefs";
  	static final int NotifID = 1;

  //	SharedPreferences NotificationEraseDialogPrefs;
  //	final String PREFS_NOTIFICATION_ERASE_DIALOG = "NotificationEraseDialogPrefs";

		
    @Override
    public void onReceive(Context context, Intent intent) {
    	
    	
        	sendNotification(null, context);
    }
    
    public void sendNotification(View view, Context c) {
    	
//    	 MainActivity.notificationOrDialogPrefs = c.getSharedPreferences(MainActivity.PREFS_NOTIFICATION_OR_DIALOG, 0);
 //   	 boolean notificationOrDialog = MainActivity.notificationOrDialogPrefs.getBoolean(MainActivity.PREFS_NOTIFICATION_OR_DIALOG, false); 
    	 
    	
    	
    	// Use NotificationCompat.Builder to set up our notification.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(c);

        //icon appears in device notification bar and right hand corner of notification
        
        builder.setSmallIcon(R.drawable.notification_icon); // put image of redo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        builder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
        builder.setAutoCancel(true);

        
        // This intent is fired when notification is clicked
        Intent intent = new Intent(c, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(c, 0, intent, 0);

        // Set the intent that will fire when the user taps the notification.
        builder.setContentIntent(pendingIntent);

        // Large icon appears on the left of the notification
        builder.setLargeIcon(BitmapFactory.decodeResource(c.getResources(), R.drawable.eraser_button));

        // Content title, which appears in large type at the top of the notification
        builder.setContentTitle("FlashPoint");

        // Content text, which appears in smaller text below the title
        builder.setContentText("Your Free Erase Is Here!!!");
        // The subtext, which appears under the text on newer devices.
        // This will show-up in the devices with Android 4.2 and above only
  //      builder.setSubText("Tap to view documentation about notifications.");

        NotificationManager notificationManager = (NotificationManager) c.getSystemService(c.NOTIFICATION_SERVICE);
      //  Notification notification = builder;
        // Will display the notification in the notification bar
        notificationManager.notify(NotifID, builder.build());
        
            	
        NotificationErasePrefs = c.getSharedPreferences(PREFS_NOTIFICATION_ERASE, 0);			

    	SharedPreferences.Editor editor = NotificationErasePrefs.edit();
    	    	
	    	editor.putBoolean(PREFS_NOTIFICATION_ERASE, true);
	    	editor.commit();
	    	
	    	 MainActivity.giveEraseFromNotif = c.getSharedPreferences(MainActivity.PREFS_ERASE_FROM_NOTIF, 0);			
 	    	
	    	 SharedPreferences.Editor editor3 = MainActivity.giveEraseFromNotif.edit();
	    	 editor3.putBoolean(MainActivity.PREFS_ERASE_FROM_NOTIF, true);
	    	 editor3.commit();
	    				
    	}
    
}