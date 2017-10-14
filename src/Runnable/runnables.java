package Runnable;

import flash.point.flashpoint.EraseCountDown;
import flash.point.flashpoint.MainActivity;
import flash.point.flashpoint.R;
import game.Drawing;
import game.MovingBalls;
import Animation.animation;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class runnables {
	
	Handler handler;
	static TextView highScore1,highScore2,highScore3,highScore4,highScore5;
	static TextView score1, score2, score3, score4, score5;
	public boolean SHSVisible, HSVisible; // shoes add up for scores
	
	public boolean visibleS1, visibleS2, visibleS3, visibleS4, visibleS5;
	public boolean visibleHS1, visibleHS2, visibleHS3, visibleHS4, visibleHS5;
	static MainActivity main;

	public static MediaPlayer scoreVisibleMusic1;
	public static MediaPlayer scoreVisibleMusic3;
	public static MediaPlayer scoreVisibleMusic4;
	public static MediaPlayer scoreVisibleMusic5;

	public static MediaPlayer scoreInvisibleMusic1;
	public static MediaPlayer scoreInvisibleMusic2;
	public static MediaPlayer scoreInvisibleMusic3;
	public static MediaPlayer scoreInvisibleMusic4;
	public static MediaPlayer scoreInvisibleMusic5;

			
	public runnables()	{
				
		handler = new Handler();
		highScore1 = MainActivity.highScore1;
		highScore2 = MainActivity.highScore2;
		highScore3 = MainActivity.highScore3;
		highScore4 = MainActivity.highScore4;
		highScore5 = MainActivity.highScore5;
		
		score1 = MainActivity.score1;
		score2 = MainActivity.score2;
		score3 = MainActivity.score3;
		score4 = MainActivity.score4;
		score5 = MainActivity.score5;
		
		scoreVisibleMusic1 = MainActivity.scoreVisibleMusic1;
		
		scoreInvisibleMusic1 = MainActivity.scoreInvisibleMusic1;

		
		
		main = new MainActivity();
				
	}			   
					   public Runnable runnable6 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							    Drawing.startGame = true;
						   }
					   }; 
					   
					   public Runnable drawFlashCircle1 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   Drawing.drawFlash = true;
						   }
					   }; 
					   
					   public Runnable drawFlashCircle2 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   Drawing.drawFlash = true;
						   }
					   }; 
					   
					   public Runnable scoreVisible1 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleS1)	{
								   MainActivity.score1.setVisibility(View.INVISIBLE);
								   MainActivity.plus6.setVisibility(View.INVISIBLE);

								   
							         if (MainActivity.effectsSoundOn)
									   scoreInvisibleMusic1.start();
								   
							   }else	{
								   MainActivity.score1.setVisibility(View.VISIBLE);
								   MainActivity.plus6.setVisibility(View.VISIBLE);

								   
							         if (MainActivity.effectsSoundOn)
									   scoreVisibleMusic1.start();
							   }
					    		handler.postDelayed(scoreVisible2, 200);

						   }
					   }; 
					   
					   public Runnable scoreVisible2 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleS2)	{
								   MainActivity.score2.setVisibility(View.INVISIBLE);
								   MainActivity.plus7.setVisibility(View.INVISIBLE);

								   
							   }else	{
								   MainActivity.score2.setVisibility(View.VISIBLE);
								   MainActivity.plus7.setVisibility(View.VISIBLE);

								   
							   }
					    		handler.postDelayed(scoreVisible3, 200);

							   }
					   }; 
					   
					   public Runnable scoreVisible3 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleS3)	{
								   MainActivity.score3.setVisibility(View.INVISIBLE);
								   MainActivity.plus8.setVisibility(View.INVISIBLE);

								   
								   
							   }else	{
								   MainActivity.score3.setVisibility(View.VISIBLE);
								   MainActivity.plus8.setVisibility(View.VISIBLE);

							   }
					    		handler.postDelayed(scoreVisible4, 200);

							   }
					   }; 
					   
					   public Runnable scoreVisible4 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleS4)	{
								   MainActivity.score4.setVisibility(View.INVISIBLE);
								   MainActivity.plus9.setVisibility(View.INVISIBLE);

								   
							   }else	{
								   MainActivity.score4.setVisibility(View.VISIBLE);
								   MainActivity.plus9.setVisibility(View.VISIBLE);

							   }
					    		handler.postDelayed(scoreVisible5, 200);

							   }
					   }; 
					   
					   public Runnable scoreVisible5 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleS5)	{
								   MainActivity.score5.setVisibility(View.INVISIBLE);
								   
								   
							   }else	{
								   MainActivity.score5.setVisibility(View.VISIBLE);
								   
							   }							   
							   MainActivity.scoreHS.setEnabled(true);

							   
							   }
					   }; 
					   
					   
					   public Runnable scoreHVisible1 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleHS1)	{
								   MainActivity.highScore1.setVisibility(View.INVISIBLE);
								   MainActivity.plus11.setVisibility(View.INVISIBLE);

								   
							         if (MainActivity.effectsSoundOn)
									   scoreInvisibleMusic1.start();
								   
							   }else	{
								   MainActivity.highScore1.setVisibility(View.VISIBLE);
								   MainActivity.plus11.setVisibility(View.VISIBLE);

								   
							         if (MainActivity.effectsSoundOn)
									   scoreVisibleMusic1.start();
							   }
					    		handler.postDelayed(scoreHVisible2, 200);

						   }
					   }; 
					   
					   public Runnable scoreHVisible2 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleHS2)	{
								   MainActivity.highScore2.setVisibility(View.INVISIBLE);
								   MainActivity.plus12.setVisibility(View.INVISIBLE);

								   
							   }else	{
								   MainActivity.highScore2.setVisibility(View.VISIBLE);
								   MainActivity.plus12.setVisibility(View.VISIBLE);

							   }
					    		handler.postDelayed(scoreHVisible3, 200);

							   }
					   }; 
					   
					   public Runnable scoreHVisible3 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleHS3)	{
								   MainActivity.highScore3.setVisibility(View.INVISIBLE);
								   MainActivity.plus13.setVisibility(View.INVISIBLE);

								   
							   }else	{
								   MainActivity.highScore3.setVisibility(View.VISIBLE);
								   MainActivity.plus13.setVisibility(View.VISIBLE);
								   
							   }
					    		handler.postDelayed(scoreHVisible4, 200);

							   }
					   }; 
					   
					   public Runnable scoreHVisible4 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleHS4)	{
								   MainActivity.highScore4.setVisibility(View.INVISIBLE);
								   MainActivity.plus14.setVisibility(View.INVISIBLE);

								   
							   }else	{
								   MainActivity.highScore4.setVisibility(View.VISIBLE);
								   MainActivity.plus14.setVisibility(View.VISIBLE);

							   }
					    		handler.postDelayed(scoreHVisible5, 200);

							   }
					   }; 
					   
					   public Runnable scoreHVisible5 = new Runnable() {
						   @Override
						   public void run() {
							   		    
							   if (visibleHS5)	{
								   MainActivity.highScore5.setVisibility(View.INVISIBLE);
								   
								   
							   }else	{
								   MainActivity.highScore5.setVisibility(View.VISIBLE);
								   
							   }							   
							   MainActivity.highscore.setEnabled(true);

							   
							   }
					   }; 
					   					   
					   public Runnable runnable1 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.main.setVisibility(View.INVISIBLE);

							   }
					   }; 
					   
					   public Runnable runnable2 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.explain.setVisibility(View.INVISIBLE);
							   }
					   }; 
					   
					   public Runnable runnable3 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.settings.setVisibility(View.INVISIBLE);
							   }
					   }; 
					  
					   public Runnable runnable4 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.score.setVisibility(View.INVISIBLE);
							   }
					   }; 
					   
					   public Runnable runnable8 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.backgroundCircleBounce.setVisibility(View.INVISIBLE);	

							   }
					   }; 
					   
					   public Runnable runnable12 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.buyErasePage.setVisibility(View.INVISIBLE);	

							   }
					   }; 
					   
					   public Runnable runnable7 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   animation.scoreAnimate.clearAnimation();
							   animation.settingsAnimate.clearAnimation();
							   animation.explainAnimate.clearAnimation();
							   animation.menuAnimate.clearAnimation();
							   animation.startMnuAnimate.clearAnimation();
							   animation.BuyEraseAnimate.clearAnimation();


							   }
					   }; 
					   
					   public Runnable runnable11 = new Runnable() {
						   @Override
						   public void run() {
							   
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

						    	
						    	if (MainActivity.showAd == false  && MainActivity.mWifi.isConnected())	{
						    		
						    		MainActivity.adView1.setVisibility(View.INVISIBLE);
						    		MainActivity.adView2.setVisibility(View.INVISIBLE);
						    		MainActivity.adView3.setVisibility(View.INVISIBLE);
						    		MainActivity.adView4.setVisibility(View.INVISIBLE);
						    		MainActivity.adView5.setVisibility(View.INVISIBLE);
						    		MainActivity.adView6.setVisibility(View.INVISIBLE);
						    		MainActivity.adView7.setVisibility(View.INVISIBLE);

						    	}
						   }
					   };
					   
					   public Runnable runnable5 = new Runnable() {
						   @Override
						   public void run() {
							   
							   
							   MainActivity.rate.setEnabled(true);
						    	MainActivity.info.setEnabled(true);
						    	MainActivity.play.setEnabled(true);
						    	MainActivity.leaderboard.setEnabled(true);
						    	
						    	MainActivity.scorePlay.setEnabled(true);
						    	MainActivity.scoreLeaderboard.setEnabled(true);
						    	
						    	MainActivity.scoreBack.setEnabled(true);
						    	
						    	MainActivity.scoreHS.setEnabled(true);
						    	MainActivity.highscore.setEnabled(true);
						    	
						    	MainActivity.explainButton.setEnabled(true);
						    	MainActivity.menuSettings.setEnabled(true);
						    	MainActivity.settingsButton.setEnabled(true);					
						    	MainActivity.buyButton.setEnabled(true);	    	

						    	
						    	if (MainActivity.showAd == false && MainActivity.mWifi.isConnected())	{
						    		
						    		MainActivity.adView1.setVisibility(View.VISIBLE);
						    		MainActivity.adView2.setVisibility(View.VISIBLE);
						    		MainActivity.adView3.setVisibility(View.VISIBLE);
						    		MainActivity.adView4.setVisibility(View.VISIBLE);
						    		MainActivity.adView5.setVisibility(View.VISIBLE);
						    		MainActivity.adView6.setVisibility(View.VISIBLE);
						    		MainActivity.adView7.setVisibility(View.VISIBLE);
						    		
						    	}
							   }
					   }; 
					   
					   public static Runnable runnable9 = new Runnable() {
						   @Override
						   public void run() {
							   						
								  if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	
									  MainActivity.targetSound.start();    	

							   }
					   }; 
					   
					   public static Runnable runnable10 = new Runnable() {
						   @Override
						   public void run() {
							   						
								  if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	
									  MainActivity.targetSound2.start();    	

							   }
					   }; 
					   
					  			   
					   public void menuMusic()		{
	    	    	    	
					    	Context context= MainActivity.draw.getContext();
						   
					    	MainActivity.menuMusic = MediaPlayer.create(context, R.raw.menu_music);		
					    	MainActivity.menuMusic.setLooping(true);
					    	MainActivity.menuMusic.start();    	
					    }
					   
					   
						   public static Runnable instructions = new Runnable() {
							   @Override
							   public void run() {
								   
									animation.fadeIn1(null);
									animation.fadeIn2(null);
	
								   
								    MainActivity.touchToStart.setText("To play, watch the ball, but keep an eye on the corners.");
								    Drawing.touch1 = true;
							   }
							   };  
					  
						   public static Runnable instructions1 = new Runnable() {
							   @Override
							   public void run() {
								   
								   Drawing.instructionsCircle = true;
								   Drawing.touch2 = true;
								   Drawing.instructionsMoveBall = false;
								   Drawing.flashX = MovingBalls.x;
								   Drawing.flashY = MovingBalls.y;
								   
								   animation.fadeIn1(null);
								   animation.fadeIn2(null);
								   
								   MainActivity.touchToStart.setTextSize(100);
								   MainActivity.touchToStart.setText("There it is!");
								   MainActivity.touchToStart.resizeText(MainActivity.touchToStartLayoutWidth,  MainActivity.touchToStartLayoutHeight);


						   }
						   };  
						   
						   public static Runnable instructions2 = new Runnable() {

								@Override
								   public void run() {
									   
										Drawing.touch3 = true;
										Drawing.touchScreen = true;
										Drawing.instructionsMoveBall = false;
									   
									   animation.fadeIn1(null);
									   animation.fadeIn2(null);
	
									   MainActivity.touchToStart.setText("Now tap where the ball was when the red dot appeared.");
									   
								   }
								   };  
								   
								   public static Runnable instructions3 = new Runnable() {

										@Override
										   public void run() {
											   
											  MainActivity.touchToStart.setText("Nice! Your score is based on how " +
											  		"close you get, a smaller score is better. Remember, if you miss tapping the ball for one of the flashes, it's an automatic failure. "// +
											  	/*	"Remember, if two red dots flash before you tap the screen, its an automatic failure. "*/);
											  Drawing.touch4 = true;
											  
											  animation.fadeIn1(null);
											  animation.fadeIn2(null);
	
										   }
										   };  
										   
										   public static Runnable instructions4 = new Runnable() {

												@Override
												   public void run() {
													   
													  MainActivity.touchToStart.setTextSize(100);
													  MainActivity.touchToStart.setText("Lets try it one more time, with a twist. Watch for the flash.");
													  MainActivity.touchToStart.resizeText(MainActivity.touchToStartLayoutWidth,  MainActivity.touchToStartLayoutHeight);

													  Drawing.touch5 = true;
													  
													  animation.fadeIn1(null);
													  animation.fadeIn2(null);
													  
													  MainActivity.gameScoresLayout.setVisibility(View.VISIBLE);
													  MainActivity.Redo.setEnabled(false);
													  
													  Drawing.instructionsTestRedo = true;
													  
													  MainActivity.eraseDisplay.setText("1");

												   }
										   };  
										   public static Runnable instructions5 = new Runnable() {

												@Override
												   public void run() {
													   

													  MainActivity.touchToStart.setTextSize(100);
													  MainActivity.touchToStart.setText("You missed the flash. Try Again.");
													  MainActivity.touchToStart.resizeText(MainActivity.touchToStartLayoutWidth,  MainActivity.touchToStartLayoutHeight);


														Drawing.touch5 = true;

												   		animation.fadeIn1(null);
												   		animation.fadeIn2(null);
												   }
										   };  	   
											
										   public static Runnable instructions6 = new Runnable() {

												@Override
												   public void run() {
													   													  
													Drawing.touch6 = true;
													  
											   		animation.fadeIn1(null);
											   		animation.fadeIn2(null);
											   		
												    MainActivity.num1.clearAnimation();
											   		
											   		MainActivity.touchToStart.setTextSize(100);
													MainActivity.touchToStart.setText("Have fun!");
													MainActivity.touchToStart.resizeText(MainActivity.touchToStartLayoutWidth,  MainActivity.touchToStartLayoutHeight);												   		
													  			
												   }
										   }; 
										   
										   
										   
										  
										   public static Runnable doneInstructions = new Runnable() {
											   @Override
											   public void run() {
												   
												   	MainActivity.game.setVisibility(View.INVISIBLE);
												   	MainActivity.score.setVisibility(View.INVISIBLE);
												   	MainActivity.explain.setVisibility(View.INVISIBLE);
												   	MainActivity.logoPage.setVisibility(View.INVISIBLE);
												   	MainActivity.main.setVisibility(View.VISIBLE);
													
												   	MainActivity.backgroundCircleBounce.setVisibility(View.VISIBLE);
													
												    animation.animateMenuDown(null);

												    MainActivity.isInstructions = false;
												    MainActivity.noSwipe = false;
												    MainActivity.swipeMenu = true;
												    
												    MainActivity.gameScoresLayout.setVisibility(View.VISIBLE);
												    
												    MainActivity.num1.clearAnimation();
												    												    
												    if (EraseCountDown.eraseDialogAfterGame)	{
												    	EraseCountDown.eraseDialogAfterGame = false;
												    	
												    	MainActivity.buyErasePref = MainActivity.draw.getContext().getSharedPreferences(MainActivity.PREFS_BUY_ERASE, 0);		
												    	MainActivity.buyErase = MainActivity.buyErasePref.getInt(MainActivity.PREFS_BUY_ERASE, 0);
														
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
										   }; 
										   
										   public static Runnable runnable13 = new Runnable() {
											   @Override
											   public void run() {
												   
												   MainActivity.noSwipe = false; 
												   
											   }
										   }; 					   
				}




