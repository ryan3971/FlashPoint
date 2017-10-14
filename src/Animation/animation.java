package Animation;

import scale.AutoResizeTextView;
import flash.point.flashpoint.MainActivity;
import flash.point.flashpoint.R;
import Runnable.runnables;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class animation {
	
	static Animation animation1, animation2, animation3, animation4, animation5, animation6, animation7, animation8,
				animation9, animation10, animation11, animation12, animation13, animation14;
	
	public static LinearLayout menuAnimate;
	public static LinearLayout explainAnimate;

	public static LinearLayout scoreAnimate;
	
	static Handler handler;
	public static LinearLayout settingsAnimate;

	static runnables runnableClass;
	
	static ImageView fail; 
	
	static MainActivity main;

	public static LinearLayout continueInstructionsLayout;

	public static LinearLayout touchToStartLayout;
	
	public static LinearLayout startMnuAnimate;
	
	public static LinearLayout BuyEraseAnimate;
	
	static AutoResizeTextView num1;

	public animation()	{
		
		animation1 = MainActivity.animation1;
		animation2 = MainActivity.animation2;
		animation3 = MainActivity.animation3;
		animation4 = MainActivity.animation4;
		animation5 = MainActivity.animation5;
		animation6 = MainActivity.animation6;
		animation7 = MainActivity.animation7;
		animation8 = MainActivity.animation8;
		animation9 = MainActivity.animation9;
		animation10 = MainActivity.animation10;
		animation11= MainActivity.animation11;
		animation12= MainActivity.animation12;
		animation13= MainActivity.animation13;
		animation14= MainActivity.animation14;

		BuyEraseAnimate = MainActivity.buyErasePage;
		
		fail = MainActivity.fail;

		menuAnimate = MainActivity.main;
		
		explainAnimate = MainActivity.explain;

		scoreAnimate = MainActivity.score;
		settingsAnimate = MainActivity.settings;
		
		
		handler = new Handler();
		
		runnableClass = new runnables();

		continueInstructionsLayout = MainActivity.continueInstructionsLayout;
		
		startMnuAnimate = MainActivity.startMnuAnimate;
		
		num1 = MainActivity.num1;
		
		main = new MainActivity();
	}

	
	 public static void animateMenuDown(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation1.setDuration(500);
	        menuAnimate.setAnimation(animation1);
	        menuAnimate.animate();
	        animation1.start();
	        
		    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateMenuRight(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation2.setDuration(500);
	    	menuAnimate.setAnimation(animation2);
	    	menuAnimate.animate();
	    	animation2.start();
	      
	    	handler.postDelayed(runnableClass.runnable1, 500);
	      
	    	disableButtonsAndAds();
	    	handler.postDelayed(runnableClass.runnable5, 500);

		    handler.postDelayed(runnableClass.runnable7, 500);

	   }
	    
	    public static void animateExplainRight(View view){
	    	explainAnimate.clearAnimation();
	    	explainAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation3.setDuration(500);
	    	explainAnimate.setAnimation(animation3);
	    	explainAnimate.animate();
	    	animation3.start();
	      
	    	disableButtonsAndAds();
	    	handler.postDelayed(runnableClass.runnable5, 500);
	      
		    handler.postDelayed(runnableClass.runnable7, 500);

	   }
	    
	    public static void animateExplainLeft(View view){
	    	explainAnimate.clearAnimation();
	    	explainAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation4.setDuration(500);
	    	explainAnimate.setAnimation(animation4);
	    	explainAnimate.animate();
	    	animation4.start();
	      
	    	handler.postDelayed(runnableClass.runnable2, 500);
	      
	    	disableButtonsAndAds();
	    	handler.postDelayed(runnableClass.runnable5, 500);
	      
		    handler.postDelayed(runnableClass.runnable7, 500);


	   }
	    
	    public static void animateMenuLeft(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation5.setDuration(500);
	        menuAnimate.setAnimation(animation5);
	        menuAnimate.animate();
	        animation5.start();
	        
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);  
			  handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateMenuMiddleLeft(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation6.setDuration(500);
	        menuAnimate.setAnimation(animation6);
	        menuAnimate.animate();
	        animation6.start();
	        
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
			  handler.postDelayed(runnableClass.runnable1, 500);
			    handler.postDelayed(runnableClass.runnable7, 500);
			    
			    

	     }
	    
	    public static void animateSlideScoreLeft(View view){
	    	scoreAnimate.clearAnimation();
	    	scoreAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation5.setDuration(500);
	        scoreAnimate.setAnimation(animation5);
	        scoreAnimate.animate();
	        animation5.start();
	        
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
		      
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateScoreMiddleLeft(View view){
	    	scoreAnimate.clearAnimation();
	    	scoreAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation4.setDuration(500);
	        scoreAnimate.setAnimation(animation4);
	        scoreAnimate.animate();
	        animation4.start();
	                
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
		      
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateScoreMiddleRight(View view){
	    	scoreAnimate.clearAnimation();
	    	scoreAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation2.setDuration(500);
	        scoreAnimate.setAnimation(animation2);
	        scoreAnimate.animate();
	        animation2.start();
	                
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
		      
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateScoreMenuRight(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation3.setDuration(500);
	        menuAnimate.setAnimation(animation3);
	        menuAnimate.animate();
	        animation3.start();
	        
	        handler.postDelayed(runnableClass.runnable4, 500);
	                
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
		      
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateMenuMiddleUp(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation9.setDuration(500);
	        menuAnimate.setAnimation(animation9);
	        menuAnimate.animate();
	        animation9.start();
	        
		    handler.postDelayed(runnableClass.runnable1, 500);
	                
		    disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
		      
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateSettingsUp(View view){
	    	settingsAnimate.clearAnimation();
	    	settingsAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation10.setDuration(500);
	        settingsAnimate.setAnimation(animation10);
	        settingsAnimate.animate();
	        animation10.start();
	        
	        disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
	                
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    
	    public static void animateSettingsDown(View view){
	    	settingsAnimate.clearAnimation();
	    	settingsAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation11.setDuration(500);
	        settingsAnimate.setAnimation(animation11);
	        settingsAnimate.animate();
	        animation11.start();
	        
		      handler.postDelayed(runnableClass.runnable3, 500);

		      disableButtonsAndAds();
		      handler.postDelayed(runnableClass.runnable5, 500);
		      
			    handler.postDelayed(runnableClass.runnable7, 500);

	     }
	    

	    public static void fadeOut1(View view){
	    	startMnuAnimate.clearAnimation();
	    	startMnuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation13.setDuration(1000);
	        animation13.setFillAfter(true);
	        startMnuAnimate.setAnimation(animation13);
	        startMnuAnimate.animate();
	        animation13.start();
	        

	        		      
	     }
	    

	    public static void fadeIn1(View view){
	    	startMnuAnimate.clearAnimation();
	    	startMnuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation14.setDuration(1000);
	        animation14.setFillAfter(true);
	        startMnuAnimate.setAnimation(animation14);
	        startMnuAnimate.animate();
	        animation14.start();
	        		      

	     }
	    
	    public static void fadeOut2(View view){
	    	continueInstructionsLayout.clearAnimation();
	    	continueInstructionsLayout.setVisibility(LinearLayout.VISIBLE);
	        animation13.setDuration(750);
	        animation13.setFillAfter(true);
	        continueInstructionsLayout.setAnimation(animation13);
	        continueInstructionsLayout.animate();
	        animation13.start();
	        

	        		      
	     }
	    

	    public static void fadeIn2(View view){
	    	continueInstructionsLayout.clearAnimation();
	    	continueInstructionsLayout.setVisibility(LinearLayout.VISIBLE);
	        animation14.setDuration(750);
	        animation14.setFillAfter(true);
	        continueInstructionsLayout.setAnimation(animation14);
	        continueInstructionsLayout.animate();
	        animation14.start();
	        		      

	     }

	    public static void fadeIn3(View view){
	    	startMnuAnimate.clearAnimation();
	    	startMnuAnimate.setVisibility(LinearLayout.VISIBLE);
	        animation14.setDuration(500);
	        animation14.setFillAfter(true);
	        startMnuAnimate.setAnimation(animation14);
	        startMnuAnimate.animate();
	        animation14.start();
	        		      

	     }
	    public static void animateMenuMiddleDown(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation11.setDuration(500);
	    	menuAnimate.setAnimation(animation11);
	    	menuAnimate.animate();
	    	animation11.start();
	      
	    	disableButtonsAndAds();
		    handler.postDelayed(runnableClass.runnable1, 500);

	    	handler.postDelayed(runnableClass.runnable5, 500);
	      
		    handler.postDelayed(runnableClass.runnable7, 500);

	   }
	    
	    public static void animateErasePageDown(View view){
	    	BuyEraseAnimate.clearAnimation();
	    	BuyEraseAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation1.setDuration(500);
	    	BuyEraseAnimate.setAnimation(animation1);
	    	BuyEraseAnimate.animate();
	    	animation1.start();
	      	      
	    	disableButtonsAndAds();
	    	handler.postDelayed(runnableClass.runnable5, 500);

		    handler.postDelayed(runnableClass.runnable7, 500);

	   }
	    
	    public static void animateErasePageMiddleUp(View view){
	    	BuyEraseAnimate.clearAnimation();
	    	BuyEraseAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation9.setDuration(500);
	        BuyEraseAnimate.setAnimation(animation9);
	        BuyEraseAnimate.animate();
	        animation9.start();
	        
	        disableButtonsAndAds();
	        
		    handler.postDelayed(runnableClass.runnable12, 500);

		    handler.postDelayed(runnableClass.runnable5, 500);
			handler.postDelayed(runnableClass.runnable7, 500);
			    
	     }
	    
	    public static void animateMenuUp(View view){
	    	menuAnimate.clearAnimation();
	    	menuAnimate.setVisibility(LinearLayout.VISIBLE);
	    	animation10.setDuration(500);
	    	menuAnimate.setAnimation(animation10);
	    	menuAnimate.animate();
	    	animation10.start();
	      	      
	    	disableButtonsAndAds();
	    	handler.postDelayed(runnableClass.runnable5, 500);
	      
		    handler.postDelayed(runnableClass.runnable7, 500);


	   }
	    
	    public static void animateFlashing(View view)	{
	    	
	    	Animation anim = new AlphaAnimation(0.0f, 1.0f);
	    	anim.setDuration(500); //You can manage the blinking time with this parameter
	    	anim.setStartOffset(20);
	    	anim.setRepeatMode(Animation.REVERSE);
	    	anim.setRepeatCount(Animation.INFINITE);
	    	num1.startAnimation(anim);
	    	
	    }
	    	    
	    
	    public static void disableButtonsAndAds()	{
	    	
	    	MainActivity.rate.setEnabled(false);
	    	MainActivity.info.setEnabled(false);
	    	MainActivity.play.setEnabled(false);
	    	MainActivity.leaderboard.setEnabled(false);
	    	
	    	MainActivity.scorePlay.setEnabled(false);
	    	MainActivity.scoreLeaderboard.setEnabled(false);
	    	
	    	MainActivity.scoreBack.setEnabled(false);
	    	
	    	MainActivity.scoreHS.setEnabled(false);
	    	MainActivity.highscore.setEnabled(false);
	    	
	    	MainActivity.explainButton.setEnabled(false);
	    	MainActivity.menuSettings.setEnabled(false);
	    	MainActivity.settingsButton.setEnabled(false);
	    	MainActivity.buyButton.setEnabled(false);	    	
	    	
	    	if (main.noSwipe == false)	{
	    		main.noSwipe = true;
	    		handler.postDelayed(runnableClass.runnable13, 500);
	    	}

	    	if (MainActivity.showAd == false && MainActivity.mWifi.isConnected())	{
	    		
	    		MainActivity.adView1.setVisibility(View.INVISIBLE);
	    		MainActivity.adView2.setVisibility(View.INVISIBLE);
	    		MainActivity.adView3.setVisibility(View.INVISIBLE);
	    		MainActivity.adView4.setVisibility(View.INVISIBLE);
	    		MainActivity.adView5.setVisibility(View.INVISIBLE);
	    		MainActivity.adView6.setVisibility(View.INVISIBLE);
	    		MainActivity.adView7.setVisibility(View.INVISIBLE);
	    	}
	    	
	    	
	    }
	    
	  
	
}
