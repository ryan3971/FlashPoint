package flash.point.flashpoint;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;

public class EraseCountDown extends CountDownTimer{
	
//	Context context;
	static long millisUntilFinishedSave;
	public static boolean eraseDialogAfterGame;


	public EraseCountDown(long millisInFuture, long countDownInterval, Context context) {
		super(millisInFuture, countDownInterval);
       // this.context = context;
	}
	public void onTick(long millisUntilFinished) {

		 millisUntilFinishedSave = millisUntilFinished;
		 
		 long seconds = millisUntilFinished / 1000;
		 long just_hours = seconds / 3600;
		 long just_minutes = (seconds/60) % 60;
		 long just_seconds = seconds % 60;
		 
		 MainActivity.notificationTimer.setText("" + String.format("%02d", just_hours) + ":" +  String.format("%02d", just_minutes) + ":" + String.format("%02d", just_seconds) );
	 }

	 public void onFinish() {
		 
	        SetNotification.stopAlarm();
	        
		 
		 MainActivity.notificationTimer.setText("00:00:00");
		
		 DisplayNotification.NotificationErasePrefs = MainActivity.draw.getContext().getSharedPreferences(DisplayNotification.PREFS_NOTIFICATION_ERASE, 0);			

	    	boolean NotificationErase = DisplayNotification.NotificationErasePrefs.getBoolean(DisplayNotification.PREFS_NOTIFICATION_ERASE, false);
	    	
	    	if (NotificationErase == false)	{
	    	
   	    	SharedPreferences.Editor editor = DisplayNotification.NotificationErasePrefs.edit();
		    	editor.putBoolean(DisplayNotification.PREFS_NOTIFICATION_ERASE, true);
		    	editor.commit();
		    	
		    	MainActivity.buyErasePref = MainActivity.draw.getContext().getSharedPreferences(MainActivity.PREFS_BUY_ERASE, 0);		
		    	MainActivity.buyErase = MainActivity.buyErasePref.getInt(MainActivity.PREFS_BUY_ERASE, 0);
		    	MainActivity.buyErase += 1;
				
				SharedPreferences.Editor editor1 = MainActivity.buyErasePref.edit();
				editor1.putInt(MainActivity.PREFS_BUY_ERASE, MainActivity.buyErase);
				editor1.commit();
		 
	    	}
	    	
	    	if (MainActivity.notGame == false)		
	    		eraseDialogAfterGame = true;
	    	else	{
		 
				 Builder alert = new AlertDialog.Builder(MainActivity.draw.getContext());
				 alert.setTitle("Free Eraser");
				 
				 if (MainActivity.buyErase == 1)
					 alert.setMessage("Here's your free Eraser. You now have " + MainActivity.buyErase + " Eraser");
				 else
					 alert.setMessage("Here's your free Eraser. You now have " + MainActivity.buyErase + " Erasers");
		
				 alert.setPositiveButton("OK",null);
				 alert.show();
	    	}
		 }
	}

