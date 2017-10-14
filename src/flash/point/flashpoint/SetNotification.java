package flash.point.flashpoint;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class SetNotification {

	private static Context context;
    static PendingIntent mAlarmSender;
    public SetNotification(Context context) {
        this.context = context;
        mAlarmSender = PendingIntent.getBroadcast(context, 0, new Intent(context, DisplayNotification.class), 0);
    }

    static SharedPreferences timePrefs;
	static final String PREFS_TIME = "TimePrefs";
	
	int time;
	
	EraseCountDown count;
    public void startAlarm(){
    	
    	DisplayNotification.NotificationErasePrefs = context.getSharedPreferences(DisplayNotification.PREFS_NOTIFICATION_ERASE, 0);			

        if (DisplayNotification.NotificationErasePrefs.getBoolean(DisplayNotification.PREFS_NOTIFICATION_ERASE, false) == false)	{
    	
		timePrefs = context.getSharedPreferences(PREFS_TIME, 0);			
    	time = timePrefs.getInt(PREFS_TIME, 0);
    	
    	if (time == 0)
    		time = 300;
    	else if (time == 300)
    		time = 600;
    	else if (time == 600)
    		time = 900;
    	else if (time == 900)
    		time = 1800;
    	else if (time == 1800)
    		time = 3600;
    	else if (time == 3600)
    		time = 7200;
    	else if (time == 7200)
    		time = 10800;
    	else if (time == 10800)
    		time = 14400;
    	else if (time == 14400)
    		time = 18000;
    	else if (time == 18000)
    		time = 21600;
    	else if (time == 21600)
    		time = 25200;
    	else if (time == 25200)
    		time = 28800;
    	else if (time == 28800)
    		time = 32400;
    	else if (time == 32400)
    		time = 36000;
    	else if (time == 36000)
    		time = 39600;
    	else if (time == 39600)
    		time = 43200;
    	else if (time == 43200)
    		time = 46800;
    	else if (time == 46800)
    		time = 50400;
    	else
    		time = 54000;
    	 
    	
    	SharedPreferences.Editor editor = timePrefs.edit();
	  	editor.putInt(PREFS_TIME, time);
	  	editor.commit();
	  	
    	time = timePrefs.getInt(PREFS_TIME, 0);
    	
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, time);
        
        Log.d("", "" + c.get(Calendar.SECOND));
        
        long firstTime = c.getTimeInMillis();
        // Schedule the alarm!
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, firstTime, mAlarmSender);

        long millTime = (time - 1)  * 1000;
        
        if (MainActivity.count != null)
        	MainActivity.count.cancel();
        
        	count = new EraseCountDown(millTime, 1000, null);
        	count.start();
        }    
    }
    
    public static void stopAlarm()	{
    	        
    	AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(mAlarmSender);
    }
	
}
