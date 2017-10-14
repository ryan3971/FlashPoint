package flash.point.flashpoint;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import scale.AutoResizeTextView;

import com.example.android.trivialdrivesample.util.IabHelper;
import com.example.android.trivialdrivesample.util.IabResult;
import com.example.android.trivialdrivesample.util.Inventory;
import com.example.android.trivialdrivesample.util.Purchase;
import com.google.ads.AdSize;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.plus.Plus;

import flash.point.flashpoint.R;
import game.Drawing;
import game.MovingBalls;
import Animation.animation;
import Background.BackgroundCircleBounce;
import BaseGameUtils.BaseGameActivity;
import BaseGameUtils.GameHelper;
import Runnable.runnables;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.GestureDetector.*;

public class MainActivity extends BaseGameActivity implements OnClickListener, ConnectionCallbacks, OnConnectionFailedListener, OnGestureListener		{
	
	public static AutoResizeTextView highscore; // button highscores
	public static AutoResizeTextView scoreHS;
	public static ImageButton scorePlay;
	public static ImageButton scoreLeaderboard;
	
	public static AutoResizeTextView score1, score2, score3, score4, score5; //game score
	public static AutoResizeTextView highScore1,highScore2,highScore3,highScore4,highScore5; //highScores
	
	public static AutoResizeTextView num1, num2,num3,num4,num5, numHS; //game score updates
	
	public static TextView plus1, plus2, plus3, plus4, plus5;
	public static TextView plus6, plus7, plus8, plus9;
	public static TextView plus11, plus12, plus13, plus14;
	
	static AutoResizeTextView scoreText;
	static AutoResizeTextView highscoreText;
	
	static int HS1, HS2, HS3, HS4, HS5, HS; // integer values for high scores
	static int S1,S2,S3,S4,S5, SHS;	// integer values for game scores
	public static int gameScore1,gameScore2,gameScore3,gameScore4,gameScore5,gameScoreHS = 1000000; //current score for game
  	int width, height;
  	
  	public static final int RC_SIGN_IN = 9001;

	public static boolean startGame;
  	public boolean Start = true;
  	public static boolean redo;

	public  boolean mResolvingConnectionFailure = false;
	public  boolean mAutoStartSignInflow = true;
	public  boolean mSignInClicked = false;
	static boolean fromScore;
	public static boolean newBackground;
	public static boolean gameFail;

	public static double spotX;
	public static double spotY;
      
	
	public static LinearLayout score,explain, main, background1, logoPage, settings, game, buyErasePage;
   
	public static ImageButton rate;
	public static ImageButton info;
	public static ImageButton play;
	public static ImageButton leaderboard;
	public static ImageButton scoreBack;
	public static ImageButton Redo;
    
  	static ImageView startWords;
  	public static ImageView title;
	static ImageView scorePage;

  	static Handler handler;
	
	public static  GoogleApiClient mGoogleApiClient;
	
	public final static String MY_LEADERBOARD_ID = "CgkItMaW5KgTEAIQAQ"; // your achievement ID here
    
  	static runnables runnableClass;
  	public static Drawing draw;
	public static LinearLayout menuAnimate;
	public static LinearLayout explainAnimate;
	public static LinearLayout scoreAnimate;
	public static LinearLayout settingsAnimate;

	
	LinearLayout l1;
	LinearLayout scoreTextLayout;
	LinearLayout s1Layout;
	LinearLayout scoreHSLayout;
	
	LinearLayout highScoreLayout;
	LinearLayout highScoreHSLayout;
	
	LinearLayout scrollLayout;
	

	public static LinearLayout backgroundCircleBounce;
	
	public static Animation animation1, animation2, animation3, animation4, animation5, animation6, animation7, animation8,
					animation9, animation10, animation11, animation12, animation13, animation14;
	
	static animation animationClass;
	
	public static AdView adView1 = null;
	public static AdRequest adRequest1;
	
	public static AdView adView2 = null;
	public static AdRequest adRequest2;

	public static AdView adView3 = null;
	public static AdRequest adRequest3;
	
	public static AdView adView4 = null;
	public static AdRequest adRequest4;
	
	public static AdView adView5 = null;
	public static AdRequest adRequest5;

	public static AdView adView6 = null;
	public static AdRequest adRequest6;
	
	public static AdView adView7 = null;
	public static AdRequest adRequest7;

	public static MediaPlayer menuMusic = null;
	public static MediaPlayer gameMusic;
	
	public static MediaPlayer scoreVisibleMusic1;

	public static MediaPlayer scoreInvisibleMusic1;

	public static MediaPlayer ballBounceMusic1;
	
	public static MediaPlayer ballGrow;
	public static MediaPlayer ballShrink;
	public static MediaPlayer explosion;
	public static MediaPlayer scoreErase;

	
	public static MediaPlayer targetSound;
	public static MediaPlayer targetSound2;

	public static boolean musicSoundOn;
	public static boolean effectsSoundOn;

	public static boolean menuMusicBackOn;
	public static boolean gameMusicBackOn;
	
	public static boolean soundOnPause;
	public static boolean startUpDone;
	
	public static final String achievement_1 = "CgkItMaW5KgTEAIQAw", // go by order of acievments listed on console
			achievement_2 = "CgkItMaW5KgTEAIQBA",
			achievement_3 = "CgkItMaW5KgTEAIQBQ",
			achievement_4 = "CgkItMaW5KgTEAIQBg",
			achievement_5 = "CgkItMaW5KgTEAIQBw",
			achievement_6 = "CgkItMaW5KgTEAIQCA",
			achievement_7 = "CgkItMaW5KgTEAIQCQ",
			achievement_8 = "CgkItMaW5KgTEAIQCg",
			achievement_9 = "CgkItMaW5KgTEAIQCw",
			achievement_zero = "CgkItMaW5KgTEAIQDA ",

			achievement_10 = "CgkItMaW5KgTEAIQDQ",
			achievement_100 = "CgkItMaW5KgTEAIQDg",
			achievement_1000 = "CgkItMaW5KgTEAIQDw";
	
	ImageButton MusicOffButton;
	ImageButton MusicOnButton = null;
	ImageButton EffectsOnButton;
	ImageButton EffectsOffButton;
	
	


	
	public static InterstitialAd interstitial;	
	
	static int showInterstitial;
	


	static boolean firstScore;

	public static ImageView fail;
	
	public static ImageButton explainButton;
	public static ImageButton menuSettings;
	public static ImageButton settingsButton;
	public static ImageButton buyButton;


	static boolean notGame;
	boolean effectsSoundBackOn;
	public static boolean pauseEffects = false;
	
	
	public static LinearLayout startMnuAnimate;
	public static LinearLayout BuyEraseAnimate;
	
	
	
	public static boolean isInstructions;
		

public static LinearLayout continueInstructionsLayout;
public static AutoResizeTextView continueInstructionsText; 

public static LinearLayout startMenu;

public static LinearLayout gameScoresLayout;

public static DisplayMetrics dm;	 

public static double middleY;

static MainActivity m;

public static int scoreRedoCount;


private static final String TAG = "flash.point.flashpoint";
IabHelper mHelper;
static final String ITEM_ADS = "ad_free";

static final String ITEM_REDO_1 = "erasers_5";
static final String ITEM_REDO_2 = "erasers_12";
static final String ITEM_REDO_3 = "erasers_25";
static final String ITEM_REDO_4 = "erasers_65";
static final String ITEM_REDO_5 = "erasers_140";

boolean resultIsAds;

boolean resultIsErase1;
boolean resultIsErase2;
boolean resultIsErase3;
boolean resultIsErase4;
boolean resultIsErase5;


public static AutoResizeTextView eraseDisplay;


LinearLayout touchToStartLayout;

public static int touchToStartLayoutWidth, touchToStartLayoutHeight;

public static AutoResizeTextView touchToStart;

public static NetworkInfo mWifi;

private static final int SWIPE_MIN_DISTANCE = 120;
private static final int SWIPE_MAX_OFF_PATH = 250;
private static final int SWIPE_THRESHOLD_VELOCITY = 200;

private static final String DEBUG_TAG = "Velocity";
private VelocityTracker mVelocityTracker = null;

public static boolean swipeMenu;
public boolean swipeExplain;
public boolean swipeErase;
public boolean swipeSettings;
public static boolean noSwipe, swipeScore;

AutoResizeTextView scroll;

public static boolean stopFlashAfterRedo;

public static int backPressGame = 1;


float x1 = 0, x2, y1 = 0, y2, dx, dy;
private boolean velocityY;
private boolean velocityX;

boolean swipe = false;

public static boolean growFixApp, shrinkFixApp;
public static boolean growFixAppPause, shrinkFixAppPause;

public static boolean redoPause;

static AutoResizeTextView notificationTimer;
LinearLayout notificationTimerLayout;

static long startTime;


	
	public static final String PREFS_NAME = "MyPrefsFile";
	static SharedPreferences highScorePref;
	
	public static final String HS_PREF = "HS";
	public static final String HS1_PREF = "HS1";
	public static final String HS2_PREF = "HS2";
	public static final String HS3_PREF = "HS3";
	public static final String HS4_PREF = "HS4";
	public static final String HS5_PREF = "HS5";

	
	public static final String NO_ADS = "NoAdsPref";
	static SharedPreferences noAdsPref;
	public static boolean showAd;
	
	static SharedPreferences firstScorePref;
	private static final String PREFS_FIRST_SCORE = "FirstScorePrefs";
	
	static SharedPreferences firstGamePref;
	private static final String PREFS_FIRST_GAME = "FirstGamePrefs";
	boolean firstGame;
	
	static SharedPreferences firstNotificationPref;
	private static final String PREFS_FIRST_NOTIFICATION = "FirstNotificationPrefs";
	boolean firstNotification;
	
	public static SharedPreferences buyErasePref;
	public static final String PREFS_BUY_ERASE = "BuyErasePrefs";
	public static int buyErase;
	
	
	public static SharedPreferences startTimePrefs;
	public static final String PREFS_START_TIME = "StartTimePrefs";
	
	public static SharedPreferences saveTimerPrefs;
	public static final String PREFS_SAVE_TIMER = "SaveTimerPrefs";
	static long savedTime;
	
	public static SharedPreferences giveEraseFromNotif;;	
	public static final String PREFS_ERASE_FROM_NOTIF = "EraseFromNotif";
	
	static EraseCountDown count;

  @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	     setContentView(R.layout.logo_page);	
	     	     
	     ActionBar actionBar = getActionBar();
	     actionBar.hide();
	     
	      View decorView = getWindow().getDecorView();

	     
	  // If the Android version is lower than Jellybean, use this call to hide
	        // the status bar.
	        if (Build.VERSION.SDK_INT < 16) {
	            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        }
	        
	     // Hide the status bar.
	     int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	     decorView.setSystemUiVisibility(uiOptions);
	     
	     decorView.setSystemUiVisibility(
                 View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                 | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                 | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                 | View.SYSTEM_UI_FLAG_FULLSCREEN
                 | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
  
  
	     
	        decorView.setOnSystemUiVisibilityChangeListener
	                (new View.OnSystemUiVisibilityChangeListener() {
	            @Override
	            public void onSystemUiVisibilityChange(int visibility) {
	                // Note that system bars will only be "visible" if none of the
	                // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
	                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
	                	if (Build.VERSION.SDK_INT < 16) {
	        	            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        	                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        	        }else	{
	        			
	        			View decorView = getWindow().getDecorView();
	        			// Hide the status bar.
	        			int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	        			decorView.setSystemUiVisibility(uiOptions);
	        			
	        		     decorView.setSystemUiVisibility(
	        	                 View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	        	                 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	        	                 | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	        	                 | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
	        	                 | View.SYSTEM_UI_FLAG_FULLSCREEN
	        	                 | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	        	  
	        	  
	        	        }
	                } else {
	                    // TODO: The system bars are NOT visible. Make any desired
	                    // adjustments to your UI, such as hiding the action bar or
	                    // other navigational controls.
	                }
	            }
	        });
		
	    highScorePref = getSharedPreferences(PREFS_NAME, 0);
	            
	    getGameHelper().setMaxAutoSignInAttempts(0);	// stop game services from signing in right away
				    
		
		Handler handler = new Handler();
		handler.postDelayed(runnable, 750);
}
  
  public Runnable runnable = new Runnable() {
	   @Override
	   public void run() {
		   		
		   setContentView(R.layout.full_game);
			 

			game = (LinearLayout)findViewById(R.id.game);
			score = (LinearLayout)findViewById(R.id.score);
			explain = (LinearLayout)findViewById(R.id.explain);
			main = (LinearLayout)findViewById(R.id.main_menu);
			logoPage = (LinearLayout)findViewById(R.id.logoPage);
			settings = (LinearLayout)findViewById(R.id.settingsPage);
			buyErasePage = (LinearLayout)findViewById(R.id.buyErasePage);

					
			startMenu = (LinearLayout)findViewById(R.id.startMenu);

			backgroundCircleBounce = (LinearLayout)findViewById(R.id.background);	
		
			Handler handler = new Handler();
			handler.postDelayed(runnable2, 500);
	   }
		   
 };
  
  public Runnable runnable2 = new Runnable() {
	   @Override
	   public void run() {
		   		
		   doOnCreate();
	   }
		   
  };

  
 public void doOnCreate()	{
	 
	 		notificationTimerLayout = (LinearLayout)findViewById(R.id.NotificationTimerLayout);
	 
	 		notificationTimer = (AutoResizeTextView)findViewById(R.id.NotificationTimer);
	 		notificationTimer.setText("00:00:00");
	 		notificationTimer.setTextColor(Color.rgb(107, 107, 107));
	 		notificationTimer.resizeText(notificationTimerLayout.getWidth(), notificationTimerLayout.getHeight());
	 
		 		 		 	
		 	continueInstructionsLayout = (LinearLayout)findViewById(R.id.continueInstructionsLayout);
			 
		 	continueInstructionsText = (AutoResizeTextView)findViewById(R.id.continueInstructionsText);
		 	continueInstructionsText.setText("Touch to Continue");
		 	continueInstructionsText.resizeText(continueInstructionsLayout.getWidth(), continueInstructionsLayout.getHeight());
		 	
			setVolumeControlStream(AudioManager.STREAM_MUSIC);
						
			gameMusic = MediaPlayer.create(this, R.raw.game_music_shorten);
			
			targetSound = MediaPlayer.create(this, R.raw.target_beep);
			targetSound2 = MediaPlayer.create(this, R.raw.target_beep2);
			
			scoreInvisibleMusic1 = MediaPlayer.create(this, R.raw.score_visible_five_clicks);

			scoreVisibleMusic1 = MediaPlayer.create(this, R.raw.score_invisible_five_clicks);

			ballBounceMusic1 = MediaPlayer.create(this, R.raw.balls_bouncing_quiet);

			ballGrow = MediaPlayer.create(this, R.raw.ball_grow);
			ballShrink = MediaPlayer.create(this, R.raw.ball_shrink);
			explosion = MediaPlayer.create(this, R.raw.explosion);
			scoreErase = MediaPlayer.create(this, R.raw.score_erase);

		    draw = (Drawing) findViewById(R.id.drawing1);
		    				    					    		
			rate = (ImageButton) findViewById(R.id.rate);
		  	info = (ImageButton) findViewById(R.id.explain_button);
		  	play = (ImageButton) findViewById(R.id.play);
		  	leaderboard = (ImageButton) findViewById(R.id.leaderboard);
		  	title = (ImageView) findViewById(R.id.title);
		  	
		  	explainButton = (ImageButton) findViewById(R.id.explain_button1);
		  	menuSettings = (ImageButton) findViewById(R.id.settings);
		  	settingsButton = (ImageButton) findViewById(R.id.settingsButton);
		  	buyButton = (ImageButton) findViewById(R.id.eraseBack);

		  	
		  	gameScoresLayout = (LinearLayout)findViewById(R.id.gameScoresLayout);

		    eraseDisplay = (AutoResizeTextView)findViewById(R.id.redoDisplay); 
		    
		    num1 = (AutoResizeTextView)findViewById(R.id.num1); 
		    num2 = (AutoResizeTextView)findViewById(R.id.num2);
		    num3 = (AutoResizeTextView)findViewById(R.id.num3);
		    num4 = (AutoResizeTextView)findViewById(R.id.num4);
		    num5 = (AutoResizeTextView)findViewById(R.id.num5);
		    numHS = (AutoResizeTextView)findViewById(R.id.numHS);
		    
		    plus1 = (TextView)findViewById(R.id.plus1); 
		    plus2 = (TextView)findViewById(R.id.plus2);
		    plus3 = (TextView)findViewById(R.id.plus3);
		    plus4 = (TextView)findViewById(R.id.plus4);
		    plus5 = (TextView)findViewById(R.id.plus5);
		    
		    plus6 = (TextView)findViewById(R.id.plus6); 
		    plus7 = (TextView)findViewById(R.id.plus7);
		    plus8 = (TextView)findViewById(R.id.plus8);
		    plus9 = (TextView)findViewById(R.id.plus9);
		    
		    plus11 = (TextView)findViewById(R.id.plus11); 
		    plus12 = (TextView)findViewById(R.id.plus12);
		    plus13 = (TextView)findViewById(R.id.plus13);
		    plus14 = (TextView)findViewById(R.id.plus14);
		    		    	    
		    score1 = (AutoResizeTextView)findViewById(R.id.S1);
		    score2 = (AutoResizeTextView)findViewById(R.id.S2);
		    score3 = (AutoResizeTextView)findViewById(R.id.S3);
		    score4 = (AutoResizeTextView)findViewById(R.id.S4);
		    score5 = (AutoResizeTextView)findViewById(R.id.S5);
		    scoreHS = (AutoResizeTextView)findViewById(R.id.HS);
		    
		    highScore1 = (AutoResizeTextView)findViewById(R.id.highScore1);
		    highScore2 = (AutoResizeTextView)findViewById(R.id.highScore2);
		    highScore3 = (AutoResizeTextView)findViewById(R.id.highScore3);
		    highScore4 = (AutoResizeTextView)findViewById(R.id.highScore4);
		    highScore5 = (AutoResizeTextView)findViewById(R.id.highScore5);
		    highscore = (AutoResizeTextView)findViewById(R.id.highScore);
		    
			runnableClass = new runnables();		
			handler = new Handler();	    
		    
		    Redo = (ImageButton)findViewById(R.id.redo);
		    
		    scoreText = (AutoResizeTextView)findViewById(R.id.scoreText);
		    highscoreText = (AutoResizeTextView)findViewById(R.id.highScoreText);
		    
		    scorePlay = (ImageButton) findViewById(R.id.scorePlay);
		    scoreLeaderboard = (ImageButton) findViewById(R.id.scoreLeaderboard);

		    scoreBack = (ImageButton) findViewById(R.id.scoreBack);
		    scorePage = (ImageView) findViewById(R.id.scorePage);
		    startWords = (ImageView) findViewById(R.id.imageView1);
		    
		    fail = (ImageView) findViewById(R.id.fail);
		    
		    l1 = (LinearLayout)findViewById(R.id.lll);
		    
		    scoreTextLayout = (LinearLayout)findViewById(R.id.scoreLayout);
		    s1Layout = (LinearLayout)findViewById(R.id.s1Layout);
		    scoreHSLayout = (LinearLayout)findViewById(R.id.scoreHSLayout);
		    

		    highScoreLayout = (LinearLayout)findViewById(R.id.highScoreLayout);
		    highScoreHSLayout = (LinearLayout)findViewById(R.id.highScoreHSLayout);
		    
		    BuyEraseAnimate = (LinearLayout)findViewById(R.id.layoutBuyErasePage);
		    menuAnimate = (LinearLayout)findViewById(R.id.menu);
		    explainAnimate = (LinearLayout)findViewById(R.id.explainPage);
		    scoreAnimate = (LinearLayout)findViewById(R.id.layoutScorePage);
		    settingsAnimate = (LinearLayout)findViewById(R.id.layoutSettingsPage);
		    startMnuAnimate = (LinearLayout)findViewById(R.id.touchToStartLayout);


			handler.postDelayed(runnableClass.runnable11, 0);	//disable buttons so can't click while loading
		    
		    scrollLayout = (LinearLayout)findViewById(R.id.scrollLayout);
		    scroll = (AutoResizeTextView)findViewById(R.id.scroll);
		    
		    scroll.resizeText((int)(scrollLayout.getWidth()*2), (int)(scrollLayout.getHeight()*2));
		    
		    touchToStartLayout = (LinearLayout)findViewById(R.id.touchToStartLayout);
		    touchToStartLayoutWidth = touchToStartLayout.getWidth();
		    touchToStartLayoutHeight = touchToStartLayout.getHeight();

		    touchToStart = (AutoResizeTextView)findViewById(R.id.touchToStartGame);
		    
		    touchToStart.setText("Touch to Start");
		    touchToStart.resizeText(touchToStartLayoutWidth, touchToStartLayoutHeight);
		    
	/*	    Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/liquid_crystal_normal.ttf");
	
			num1.setTypeface(custom_font);
			num2.setTypeface(custom_font);
			num3.setTypeface(custom_font);
			num4.setTypeface(custom_font);
			num5.setTypeface(custom_font);
			numHS.setTypeface(custom_font);
*/
		    num1.setText("8888");
		    num2.setText("8888");
		    num3.setText("8888");
		    num4.setText("8888");
		    num5.setText("8888");
		    numHS.setText("8888");
		    
		    num1.resizeText(l1.getWidth(), l1.getHeight());
		    num2.resizeText(l1.getWidth(), l1.getHeight());
		    num3.resizeText(l1.getWidth(), l1.getHeight());
		    num4.resizeText(l1.getWidth(), l1.getHeight());
		    num5.resizeText(l1.getWidth(), l1.getHeight());
		    numHS.resizeText(l1.getWidth(), l1.getHeight());
		    

		    plus1.setTextSize(num1.getTextSize() / 3);
		    plus2.setTextSize(num1.getTextSize() / 3);
		    plus3.setTextSize(num1.getTextSize() / 3);
		    plus4.setTextSize(num1.getTextSize() / 3);
		    plus5.setTextSize(num1.getTextSize() / 3);
		    

		    score1.setText("8888");
		    score2.setText("8888");
		    score3.setText("8888");
		    score4.setText("8888");
		    score5.setText("8888");

		    score1.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    score2.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    score3.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    score4.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    score5.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    
		    plus5.setTextSize(score1.getTextSize() / 3);
		    plus6.setTextSize(score1.getTextSize() / 3);
		    plus7.setTextSize(score1.getTextSize() / 3);
		    plus8.setTextSize(score1.getTextSize() / 3);
		    plus9.setTextSize(score1.getTextSize() / 3);
		    
		    highScore1.setText("8888");
		    highScore2.setText("8888");
		    highScore3.setText("8888");
		    highScore4.setText("8888");
		    highScore5.setText("8888");

		    highScore1.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    highScore2.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    highScore3.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    highScore4.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    highScore5.resizeText(s1Layout.getWidth(), s1Layout.getHeight());
		    

		    plus11.setTextSize(highScore1.getTextSize() / 3);
		    plus12.setTextSize(highScore1.getTextSize() / 3);
		    plus13.setTextSize(highScore1.getTextSize() / 3);
		    plus14.setTextSize(highScore1.getTextSize() / 3);

			scoreText.setTextColor(Color.rgb(51, 51, 51));
			scoreText.resizeText(scoreTextLayout.getWidth(), scoreTextLayout.getHeight());
			
			highscoreText.setTextColor(Color.rgb(51, 51, 51));
			highscoreText.resizeText(highScoreLayout.getWidth(), highScoreLayout.getHeight());
			
			highscore.setTextColor(Color.rgb(107, 107, 107));
			highscore.resizeText(highScoreHSLayout.getWidth(), highScoreHSLayout.getHeight());
			highscore.setEnabled(true);
			

			scoreHS.setTextColor(Color.rgb(107, 107, 107));
			scoreHS.resizeText(scoreHSLayout.getWidth(), scoreHSLayout.getHeight());
						
			
			scoreHS.setOnClickListener(new OnClickListener() {

		        @Override
		        public void onClick(View v) {
		    		doScoreVisible(v);

		        }
		    });
			
			highscore.setOnClickListener(new OnClickListener() {

		        @Override
		        public void onClick(View v) {
		    		doHSVisible(v);

		        }
		    });
		    	 
			
			
		    DisplayMetrics dm = new DisplayMetrics();
		    getWindowManager().getDefaultDisplay().getMetrics(dm);
		    
	        
			width = dm.widthPixels;
			height = dm.heightPixels;
			
		    middleY = (height - gameScoresLayout.getHeight()) / 2;
			
			animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_menu_down);
			animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_menu_right);
			animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_explain_right);
			animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_explain_left);
			animation5 = AnimationUtils.loadAnimation(this, R.anim.move_menu_left);
			animation6 = AnimationUtils.loadAnimation(this, R.anim.move_menu_middle_left);
			animation7 = AnimationUtils.loadAnimation(this, R.anim.move_instructions_left);
			animation8 = AnimationUtils.loadAnimation(this, R.anim.touch_to_start_shrink);
			animation9 = AnimationUtils.loadAnimation(this, R.anim.move_menu_up);
			animation10 = AnimationUtils.loadAnimation(this, R.anim.move_settings_up);
			animation11 = AnimationUtils.loadAnimation(this, R.anim.move_settings_down);
			animation12 = AnimationUtils.loadAnimation(this, R.anim.scale_fail);
			animation13 = AnimationUtils.loadAnimation(this, R.anim.fade_out);
			animation14 = AnimationUtils.loadAnimation(this, R.anim.fade_in);


			animationClass = new animation();			  
		  	newBackground = true;
			
		  	draw.newGame();
		  				
			
		
			doAds();
			
			
			
			firstScorePref = getSharedPreferences(PREFS_FIRST_SCORE, 0);

			
	    	firstScore = firstScorePref.getBoolean(PREFS_FIRST_SCORE, false);
	    	
	    	if (firstScore == false)	{
	    		
	    		SharedPreferences.Editor editor = highScorePref.edit();
		    	
		  		editor.putInt(HS_PREF, 100000);
		      	    
		  		editor.commit();

	    	}
	    	
	    	firstGamePref = getSharedPreferences(PREFS_FIRST_GAME, 0);
	    	firstGame = firstGamePref.getBoolean(PREFS_FIRST_GAME, false);
	    	
	    	notGame = true;
	    	RateThisApp.onStart(this);
	    	RateThisApp.showRateDialogIfNeeded(this);
	    	
	    	
	    	firstNotificationPref = getSharedPreferences(PREFS_FIRST_NOTIFICATION, 0);			
	    	firstNotification = firstNotificationPref.getBoolean(PREFS_FIRST_NOTIFICATION, false);
	    	
	    	DisplayNotification.NotificationErasePrefs = getSharedPreferences(DisplayNotification.PREFS_NOTIFICATION_ERASE, 0);			
	    	
	    	
	    	if (firstNotification == false)	{
	    		
	    		SetNotification n = new SetNotification(draw.getContext());
		    	n.startAlarm();
		    	
		    	
		    	
	    		SharedPreferences.Editor editor = firstNotificationPref.edit();
		  		editor.putBoolean(PREFS_FIRST_NOTIFICATION, true);
		  		editor.commit();
		  		
		  		
	    	}else if (DisplayNotification.NotificationErasePrefs.getBoolean(DisplayNotification.PREFS_NOTIFICATION_ERASE, false) == false)	{

	    		
	    		saveTimerPrefs = getSharedPreferences(PREFS_SAVE_TIMER, 0);	
				
	    	  	
	    	  	startTimePrefs = getSharedPreferences(PREFS_START_TIME, 0);	
	    		
	    		
	            long timeInMillies = SystemClock.elapsedRealtime() - startTimePrefs.getLong(PREFS_START_TIME, 0);

	            long finalTime = saveTimerPrefs.getLong(PREFS_SAVE_TIMER, 0) - timeInMillies;
	    		
	    		Log.d("", "timeInMillies " + timeInMillies);

	    		Log.d("", "finalTime " + finalTime);

	    		Log.d("", "startTimePrefs " + startTimePrefs.getLong(PREFS_START_TIME, 0));

	    		Log.d("", "saveTimerPrefs " + saveTimerPrefs.getLong(PREFS_SAVE_TIMER, 0));

	    		if (finalTime > 0)	{
	    		
	    			SetNotification n = new SetNotification(draw.getContext());
	    		
	    			count = new EraseCountDown(finalTime, 1000, null);
	    			count.start();
	    		
	    		}
	    	}
	    	
	    	 giveEraseFromNotif = getSharedPreferences(PREFS_ERASE_FROM_NOTIF, 0);
	    	 
	    	 if (giveEraseFromNotif.getBoolean(PREFS_ERASE_FROM_NOTIF, false) == true)		{
	 	    	
		    	 SharedPreferences.Editor editor = giveEraseFromNotif.edit();
		    	 editor.putBoolean(PREFS_ERASE_FROM_NOTIF, false);
		    	 editor.commit();
		    	
		    	 buyErasePref = getSharedPreferences(MainActivity.PREFS_BUY_ERASE, 0);		
		    	 buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
		    	 buyErase += 1;
				
				SharedPreferences.Editor editor1 = buyErasePref.edit();
				editor1.putInt(PREFS_BUY_ERASE, buyErase);
				editor1.commit();
	    	 }
	    	
	    	buyErasePref = getSharedPreferences(PREFS_BUY_ERASE, 0);		
    		buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
    		  
    		eraseDisplay.setText("888");
			eraseDisplay.resizeText(l1.getWidth(), l1.getHeight());
		    eraseDisplay.setTextColor(Color.GRAY);
		    eraseDisplay.setText(buyErase + "");
		    
		    if (firstScore)
		    	doHighScores();
		    else
		    	doSetHighScores();
		    
		    scoreInvisible();
		    
		    fail.setVisibility(View.INVISIBLE);
		    scoreHS.setVisibility(View.VISIBLE);
		    scoreHS.setText(" ∞ ");
		    scoreHS.setClickable(false);
		    
		    
		    
			doMainMenu();
	  }
 
 


	 public static void displayInterstitial() {
		  
		 if (interstitial.isLoaded()) {
			 interstitial.show();
		      
		 }
		 
		 AdRequest adRequest = new AdRequest.Builder().build();
			
		 interstitial.loadAd(adRequest);	
	}
      
	 public void doAds()	{
		 
		 
		 noAdsPref = getSharedPreferences(NO_ADS, 0);
		 showAd = noAdsPref.getBoolean(NO_ADS, false);
			
		 ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		 mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

			if (showAd == false && mWifi.isConnected())	{
			  	
				
				adView1 = (AdView)this.findViewById(R.id.adView1);
				adRequest1 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView1.loadAd(adRequest1);
				
				adView2 = (AdView)this.findViewById(R.id.adView2);
				adRequest2 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView2.loadAd(adRequest2);
				
				adView3 = (AdView)this.findViewById(R.id.adView3);
				adRequest3 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView3.loadAd(adRequest3);
				
				adView4 = (AdView)this.findViewById(R.id.adView4);
				adRequest4 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView4.loadAd(adRequest4);
				
				adView5 = (AdView)this.findViewById(R.id.adView5);
				adRequest5 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView5.loadAd(adRequest5);
				

				adView6 = (AdView)this.findViewById(R.id.adView6);
				adRequest6 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView6.loadAd(adRequest6);
				
				adView7 = (AdView)this.findViewById(R.id.adView7);
				adRequest7 = new AdRequest.Builder()//.addTestDevice("AB03B87F6E250E75141CC13C752E3F8B")
	//"9E3E53759C09FABCF76A7C73EC022C44")("F9530B996F1114AA29A334AB9EBAE70F")("AB03B87F6E250E75141CC13C752E3F8B")
				.build();
					    			
				adView7.loadAd(adRequest7);
	
			    interstitial = new InterstitialAd(this);
			    interstitial.setAdUnitId("ca-app-pub-7529685879445121/4780456894hide");//this toooooooooooo
		
			    AdRequest adRequest = new AdRequest.Builder().build();
		
			    interstitial.loadAd(adRequest);	
			    
			}else	{
				
				LinearLayout adLayout1 = (LinearLayout)findViewById(R.id.adLayout1);
				LinearLayout adLayout2 = (LinearLayout)findViewById(R.id.adLayout2);
				LinearLayout adLayout3 = (LinearLayout)findViewById(R.id.adLayout3);
				LinearLayout adLayout4 = (LinearLayout)findViewById(R.id.adLayout4);
				LinearLayout adLayout5 = (LinearLayout)findViewById(R.id.adLayout5);
				LinearLayout adLayout6 = (LinearLayout)findViewById(R.id.adLayout6);
				LinearLayout adLayout7 = (LinearLayout)findViewById(R.id.adLayout7);


				adLayout1.setVisibility(View.GONE);
				adLayout2.setVisibility(View.GONE);
				adLayout3.setVisibility(View.GONE);
				adLayout4.setVisibility(View.GONE);
				adLayout5.setVisibility(View.GONE);
				adLayout6.setVisibility(View.GONE);
				adLayout7.setVisibility(View.GONE);
				
				if (mWifi.isConnected() || showAd)	{
					ImageButton f = (ImageButton)findViewById(R.id.noAds);
					f.setEnabled(false);
					f.setImageAlpha(128);
				}
			}
	 }
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
    	      View decorView = getWindow().getDecorView();
        	
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }
    
    public void doMusic(View clickedButton)		{
    	
    	
    	MusicOnButton = (ImageButton)findViewById(R.id.musicSoundOn);
    	MusicOffButton = (ImageButton)findViewById(R.id.musicSoundOff);

    			
    	if (musicSoundOn)	{

    		musicSoundOn = false;
    		
    		MusicOnButton.setVisibility(View.INVISIBLE);
    		MusicOffButton.setVisibility(View.VISIBLE);
    		menuMusic.stop();
    		
    	}else{
    		
    		musicSoundOn = true;
    		
    		MusicOnButton.setVisibility(View.VISIBLE);
    		MusicOffButton.setVisibility(View.INVISIBLE);
    		
    		menuMusic();

    	}	

    		
    	}
    	
    public void doEffects(View clickedButton)		{
    	
    	EffectsOnButton = (ImageButton)findViewById(R.id.effectSoundOn);
    	EffectsOffButton = (ImageButton)findViewById(R.id.effectSoundOff);
    	
    	if (effectsSoundOn)	{

    		effectsSoundOn = false;
    		
    		EffectsOnButton.setVisibility(View.INVISIBLE);
    		EffectsOffButton.setVisibility(View.VISIBLE);
    		
    	}else 	{
    		
    		effectsSoundOn = true;
    		
    		EffectsOnButton.setVisibility(View.VISIBLE);
    		EffectsOffButton.setVisibility(View.INVISIBLE);
    		

    	}
    	}
    

    public void menuMusic()		{
    	    	    	
    	menuMusic = MediaPlayer.create(this, R.raw.menu_music);	
  		menuMusic.setLooping(true);
		menuMusic.start();    	
    }
    
    public void gameMusic()		{
    	
    	gameMusic = MediaPlayer.create(this, R.raw.game_music_shorten);		
    	gameMusic.setLooping(true);
    	gameMusic.start();
    	    	
    }
    
    
    @Override
    public void onPause()	{
    	super.onPause();
    	
    	if (musicSoundOn)	{
    		musicSoundOn = false;
    		soundOnPause = true;
    		
    		if (menuMusic != null)	{
	    		if (menuMusic.isPlaying())	{
	    			menuMusic.pause();
	        		menuMusicBackOn = true;
	    		}
    		}
    		
    		if (gameMusic.isPlaying())	{
    			gameMusic.pause();
        		gameMusicBackOn = true;
    			
    		}
    		
    	}
    	
    	pauseEffects = false;
    	
    	
    	if (growFixApp)
    		growFixAppPause = true;
    	
    	if (shrinkFixApp)
    		shrinkFixAppPause = true;
    	
    	if (redo)
    		redoPause = true;
    	
        if (startUpDone == false)	{
        	this.finish();
        	System.exit(0);
        	
        }        
    }
    
    
    @Override
    public void onResume()	{
    	super.onResume();
    	
    	
    	Handler handler = new Handler();
		handler.postDelayed(runnable1, 250);

    }
    
    public Runnable runnable1 = new Runnable() {
		   @Override
		   public void run() {
			   
			   
			   if (soundOnPause)	{
		    		musicSoundOn = true;
		    		soundOnPause = false;

		    		
		    		if (menuMusicBackOn || MusicOnButton == null && startUpDone && notGame)	{
		    			menuMusic();
		        		menuMusicBackOn = false;
		    		}
		    		
		    		if (gameMusicBackOn)	{
		    			gameMusic.start();
		        		gameMusicBackOn = false;
		    			
		    		}
		    		
		    	}
		    	
		    	if (notGame == false)	{
		    		Drawing.endGame = true;
			    	gameFail = true;    	
		    	}
		    	
		    	pauseEffects = true;
		    	    	
		    	if (growFixAppPause)	{
		    		growFixAppPause = false;
		    		growFixApp = false;
		    		
					doNewGame();
		    		
		    	}
		    	    	
		    	if (shrinkFixAppPause)	{
		    		shrinkFixAppPause = false;
		    		shrinkFixApp = false;
					backgroundCircleBounce.setVisibility(View.VISIBLE);	

		    		draw.doImplode();

		    	}
		    	
		    	if (redoPause)	{
		    		redoPause = false;
		    		redo = false;
		    		doNewGame();
		    	}
		    			   
			   View decorView = getWindow().getDecorView();
	        	
		    	 int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
			     decorView.setSystemUiVisibility(uiOptions);
			     
			     decorView.setSystemUiVisibility(
		                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
					       
		   }
		   }; 
    
    public void doMainMenu()	{	
    	
    	
		game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		logoPage.setVisibility(View.INVISIBLE);
		main.setVisibility(View.VISIBLE);
		
		backgroundCircleBounce.setVisibility(View.VISIBLE);
			
	    handler.postDelayed(runnableClass.runnable5, 0);
		
		musicSoundOn = true;
		effectsSoundOn = true;
		
	  	startUpDone = true;
	  	
	  	if (musicSoundOn)
			   menuMusic();
	  		  	
	    animation.animateMenuDown(EffectsOffButton);

		beginUserInitiatedSignIn();
		
        DisplayNotification n = new DisplayNotification();
		
		
		swipeMenu = true;
		noSwipe = false;
    	}
 
    
    
    public void doMenuToExplain(View clickedButton)	{
    	

		game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.VISIBLE);
		main.setVisibility(View.VISIBLE);
		
		backgroundCircleBounce.setVisibility(View.VISIBLE);
			
		swipeExplain = true;
		swipeMenu = false;
		
	    animation.animateMenuRight(clickedButton);
	    animation.animateExplainRight(clickedButton);	    	    
  }
    
    public void doExplainToMenu(View clickedButton)	{

		game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.VISIBLE);
		main.setVisibility(View.VISIBLE);
		
		backgroundCircleBounce.setVisibility(View.VISIBLE);
			
		swipeExplain = false;
		swipeMenu = true;
 	    		
	    animation.animateExplainLeft(clickedButton);
	    animation.animateMenuLeft(clickedButton);

  }
    
    public void doMenuToSettings(View clickedButton)	{
    	
    	game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		main.setVisibility(View.VISIBLE);
		settings.setVisibility(View.VISIBLE);

		backgroundCircleBounce.setVisibility(View.VISIBLE);
			
		swipeSettings = true;
		swipeMenu = false;
		
		animation.animateSettingsUp(clickedButton);	    
	    animation.animateMenuMiddleUp(clickedButton);
	    
    	
    }
    
 public void doSettingsToMenu(View clickedButton)	{
    	
    	game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		main.setVisibility(View.VISIBLE);
		settings.setVisibility(View.VISIBLE);

		backgroundCircleBounce.setVisibility(View.VISIBLE);
			
		swipeSettings = false;
		swipeMenu = true;
		
		animation.animateSettingsDown(clickedButton);	    
	    animation.animateMenuDown(clickedButton);
    	
    }
  
    
  
    public void doInstructions(View clickeButton)	{
    	
		settings.setVisibility(View.INVISIBLE);
		
		touchToStart.setTextColor(Color.rgb(107, 107, 107));
		touchToStartLayout.setBackgroundColor(Color.rgb(155, 235, 152));
		
		noSwipe = true;
		swipeSettings = false;
		
		isInstructions = true;
		

		game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		main.setVisibility(View.INVISIBLE);
		
		backgroundCircleBounce.setVisibility(View.VISIBLE);
					
		if (showAd == false && mWifi.isConnected())
			adView6.setVisibility(View.VISIBLE);
		
		gameScoresLayout.setVisibility(View.INVISIBLE);

    	BackgroundCircleBounce.formBall();    
    	}
    
    public void doSetGameFromScore(View clickedButton)	{
		  
    	noSwipe = true;
		swipeScore = false;
    	
    	if (firstGame == false)	{
    		
    		SharedPreferences.Editor editor = firstGamePref.edit();
	    	
	  		editor.putBoolean(PREFS_FIRST_GAME, true);
	  		
	  		editor.commit();
	  		
	  		firstGame = true;
    		
    		doInstructions(clickedButton);
    		
    	}else{
    	
    	
    	animation.animateScoreMiddleLeft(clickedButton);
    	
    	game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		main.setVisibility(View.INVISIBLE);
		
		backgroundCircleBounce.setVisibility(View.VISIBLE);
							
		if (showAd == false && mWifi.isConnected())
			adView6.setVisibility(View.VISIBLE);
		
	  	BackgroundCircleBounce.formBall();
    	}
	  }
    
    public void doSetGameFromMenu(View clickedButton)	{
    	
    	noSwipe = true;
    	swipeMenu = false;
    	
    	if (firstGame == false)	{
    		
    		SharedPreferences.Editor editor = firstGamePref.edit();
	    	
	  		editor.putBoolean(PREFS_FIRST_GAME, true);
	  		
	  		editor.commit();
	  		
	  		firstGame = true;
    		
    		doInstructions(clickedButton);
    		
    	}else{
	  		
			game.setVisibility(View.INVISIBLE);
			score.setVisibility(View.INVISIBLE);
			explain.setVisibility(View.INVISIBLE);
			main.setVisibility(View.INVISIBLE);
			
			backgroundCircleBounce.setVisibility(View.VISIBLE);
				
			animation.animateMenuMiddleLeft(clickedButton);
			
			if (showAd == false && mWifi.isConnected())
				adView6.setVisibility(View.VISIBLE);
	
	    	BackgroundCircleBounce.formBall();
    	}
  }
  
    public void doScoreAnimationToMenu(View clickedButton)	{
	  
    	game.setVisibility(View.INVISIBLE);
	    score.setVisibility(View.VISIBLE);
	    main.setVisibility(View.VISIBLE);
	    explain.setVisibility(View.INVISIBLE);
	    
	   

	    swipeScore = false;
	    swipeMenu = true;
	    
	    backgroundCircleBounce.setVisibility(View.VISIBLE);
	    	    	    	  
	    animation.animateScoreMiddleRight(clickedButton);
	    animation.animateScoreMenuRight(clickedButton);

  }
    
    public void doMenuPageToErasePage(View clickedButton)	{
    	
    	game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		settings.setVisibility(View.INVISIBLE);

		backgroundCircleBounce.setVisibility(View.VISIBLE);
    	buyErasePage.setVisibility(View.VISIBLE);
		main.setVisibility(View.VISIBLE);

		swipeErase = true;
		swipeMenu = false;
	    	    
	    animation.animateMenuMiddleDown(clickedButton);
	    animation.animateErasePageDown(clickedButton);

  }
    
    public void doErasePageToMenuPage(View clickedButton)	{
    	  
    	game.setVisibility(View.INVISIBLE);
		score.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		settings.setVisibility(View.INVISIBLE);

		backgroundCircleBounce.setVisibility(View.VISIBLE);
    	buyErasePage.setVisibility(View.VISIBLE);
		main.setVisibility(View.VISIBLE);
		
		swipeErase = false;
		swipeMenu = true;

	    animation.animateErasePageMiddleUp(clickedButton);
	    animation.animateMenuUp(clickedButton);

  }
    
    public void doMenuToScore(View clickedButton)	{
  	  
    	game.setVisibility(View.INVISIBLE);
		explain.setVisibility(View.INVISIBLE);
		settings.setVisibility(View.INVISIBLE);

		backgroundCircleBounce.setVisibility(View.VISIBLE);
		score.setVisibility(View.VISIBLE);
		main.setVisibility(View.VISIBLE);
		
		swipeMenu = false;
		swipeScore = true;

	    animation.animateMenuMiddleLeft(clickedButton);
    	animation.animateSlideScoreLeft(clickedButton);

  }
    
  
    	public void doNewGame()		{
    	    	 
 	    	game.setVisibility(View.VISIBLE);
		    score.setVisibility(View.INVISIBLE);
		    main.setVisibility(View.INVISIBLE);
		    explain.setVisibility(View.INVISIBLE);	    	
		    
		    backgroundCircleBounce.setVisibility(View.VISIBLE);	
		    handler.postDelayed(runnableClass.runnable8, 100);

			startMenu.setVisibility(View.VISIBLE);
			
			Redo.setEnabled(false);
		    
		 	runnableClass.HSVisible = false;
		 	
		 	runnableClass.SHSVisible = false;
		 	
		 	scoreInvisible();
		    
		    gameScore1 = 0;
		    gameScore2 = 0;
		    gameScore3 = 0;
		    gameScore4 = 0;
		    gameScore5 = 0;
		    gameScoreHS = 0;
		    
		    S1 = 0;
		    S2 = 0;
		    S3 = 0;
		    S4 = 0;
		    S5 = 0;
		    SHS = 0;
		    
		    num1.setText(gameScore1 +"");
		    num2.setText(gameScore2 +"");
		    num3.setText(gameScore3 +"");
		    num4.setText(gameScore4 +"");
		    num5.setText(gameScore5 +"");
		    numHS.setText(gameScoreHS +"");
		    
		    num1.setEnabled(false);
		    num2.setEnabled(false);
		    num3.setEnabled(false);
		    num4.setEnabled(false);
		    num5.setEnabled(false);

	    	numHS.setClickable(true);

		    scoreRedoCount = 0;
		    
			gameFail = false;
			notGame = false;	  
			
		    scoreHS.setClickable(true);
				
			if (isInstructions == false)	{
				
				touchToStart.setTextColor(Color.WHITE);
				startMnuAnimate.setBackgroundColor(Color.TRANSPARENT); // same as touchToStartLayout
				touchToStart.setText("Touch to Start");				
			}
					    
		    continueInstructionsText.setVisibility(View.INVISIBLE);
		    
			int buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
			eraseDisplay.setText(buyErase + "");
			
			if (showAd == false && mWifi.isConnected())
				adView6.setVisibility(View.INVISIBLE);
			
			backPressGame = 1;

			draw.newGame();
	    
	    
    }
  
    public static void gameScore()	{
	  
    	gameScoreHS = gameScore1 + gameScore2 + gameScore3 + gameScore4 + gameScore5;

    	Drawing.numScore = gameScoreHS;
	  
	  	num1.setText(gameScore1 +"");
	  	num2.setText(gameScore2 +"");
	 	num3.setText(gameScore3 +"");
	 	num4.setText(gameScore4 +"");
	 	num5.setText(gameScore5 +"");
	 	numHS.setText(" " + gameScoreHS);
}
  
    public static void doExplainPageVisible()	{
	  
    	game.setVisibility(View.INVISIBLE);
    	score.setVisibility(View.INVISIBLE);
    	main.setVisibility(View.INVISIBLE);
    	explain.setVisibility(View.VISIBLE);
	    
    	
    	backgroundCircleBounce.setVisibility(View.VISIBLE);
	    
    	animation.animateExplainRight(background1);
  }
  
    public static void scoreInvisible()	{
	  
    	score1.setVisibility(View.INVISIBLE);
    	score2.setVisibility(View.INVISIBLE);
    	score3.setVisibility(View.INVISIBLE);
    	score4.setVisibility(View.INVISIBLE);
    	score5.setVisibility(View.INVISIBLE);
	  
    	highScore1.setVisibility(View.INVISIBLE);
    	highScore2.setVisibility(View.INVISIBLE);
    	highScore3.setVisibility(View.INVISIBLE);
    	highScore4.setVisibility(View.INVISIBLE);
    	highScore5.setVisibility(View.INVISIBLE);
	  
    	plus6.setVisibility(View.INVISIBLE);
    	plus7.setVisibility(View.INVISIBLE);
    	plus8.setVisibility(View.INVISIBLE);
    	plus9.setVisibility(View.INVISIBLE);

    	plus11.setVisibility(View.INVISIBLE);
    	plus12.setVisibility(View.INVISIBLE);
    	plus13.setVisibility(View.INVISIBLE);
    	plus14.setVisibility(View.INVISIBLE);

  }
  
    public void doSetScore()		{
	    
    	game.setVisibility(View.INVISIBLE);
    	score.setVisibility(View.VISIBLE);
	  	main.setVisibility(View.INVISIBLE);
	  	explain.setVisibility(View.INVISIBLE);
	  	
	  	backgroundCircleBounce.setVisibility(View.VISIBLE);
	  		  	
	  	if (showAd == false && mWifi.isConnected())	{
	  	
	  	showInterstitial++;
	  	
	  	if (showInterstitial >= 4)	{
	  		
	  		showInterstitial = 0;
	  		displayInterstitial();
	  		
	  		}
	  	}	
	  		  
	  	SlideScore();
	    
	  	scoreInvisible();
	  	
	    notGame = true;	
	    backPressGame = 1;
	    	    
	    if (EraseCountDown.eraseDialogAfterGame)	{
	    	EraseCountDown.eraseDialogAfterGame = false;
	    	
	    	buyErasePref = draw.getContext().getSharedPreferences(PREFS_BUY_ERASE, 0);		
	    	buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
			
	    	Builder alert = new AlertDialog.Builder(draw.getContext());
			alert.setTitle("Free Eraser");
			 
			if (MainActivity.buyErase == 1)
				alert.setMessage("Here's your free Eraser. You now have " + MainActivity.buyErase + " Eraser");
			else
				alert.setMessage("Here's your free Eraser. You now have " + MainActivity.buyErase + " Erasers");
	
			alert.setPositiveButton("OK",null);
			alert.show();
	    		    	
	    }

	    // set score and high score are called at doImplode() to hide the pause that they cause.
	  	//pause is caused from setting text of score and high score.
  }
    
    public void SlideScore()	{
	  
    	fromScore = true;
    	
    	noSwipe = false;
	  	swipeScore = true;
	  	
    	animation.animateSlideScoreLeft(null);
  }
    
    
  
    public static void doHighScores()		{
		  
    	HS1 = highScorePref.getInt(HS1_PREF, 0);
    	HS2 = highScorePref.getInt(HS2_PREF, 0);
    	HS3 = highScorePref.getInt(HS3_PREF, 0);
    	HS4 = highScorePref.getInt(HS4_PREF, 0);
    	HS5 = highScorePref.getInt(HS5_PREF, 0);
    	HS = highScorePref.getInt(HS_PREF, 0);
	    
    	S1 = gameScore1;
    	S2 = gameScore2;
    	S3 = gameScore3;
    	S4 = gameScore4;
	  	S5 = gameScore5;
	  	SHS = gameScoreHS;
	  	
	  	
	  	
  		if (firstScore == false)	{
  			
  			SharedPreferences.Editor editor = firstScorePref.edit();
	    	
	  		editor.putBoolean(PREFS_FIRST_SCORE, true);
	  		
	  		editor.commit();
	  		
        	highscore.setClickable(true);
  		}
  		
  		if (firstScore == false)	
  			firstScore = firstScorePref.getBoolean(PREFS_FIRST_SCORE, false);
	  	
	  		    	   
	  	if (HS > SHS)	{
	  			    
	  		SharedPreferences.Editor editor = highScorePref.edit();
	    	
	  		editor.putInt(HS_PREF, SHS);
	  		editor.putInt(HS1_PREF, S1);
	  		editor.putInt(HS2_PREF, S2);
	  		editor.putInt(HS3_PREF, S3);
	  		editor.putInt(HS4_PREF, S4);
	  		editor.putInt(HS5_PREF, S5);
	      	    
	  		editor.commit();
	  	}
	  	doSetHighScores();
    }
	  
    public static void doSetHighScores()	{
		  
    	HS1 = highScorePref.getInt(HS1_PREF, 0);
    	HS2 = highScorePref.getInt(HS2_PREF, 0);
    	HS3 = highScorePref.getInt(HS3_PREF, 0);
    	HS4 = highScorePref.getInt(HS4_PREF, 0);
    	HS5 = highScorePref.getInt(HS5_PREF, 0);
    	HS = highScorePref.getInt(HS_PREF, 0);
		   
    	if (gameFail == false)	{
    		fail.setVisibility(View.INVISIBLE);
    		scoreHS.setVisibility(View.VISIBLE);
    		scoreHS.setText(SHS +"");
    		

    		plus6.setVisibility(View.VISIBLE);
    		plus7.setVisibility(View.VISIBLE);
    		plus8.setVisibility(View.VISIBLE);
    		plus9.setVisibility(View.VISIBLE);
    		
    	}else	{
    		fail.setVisibility(View.VISIBLE);
    		scoreHS.setVisibility(View.INVISIBLE);
    		
    		plus6.setVisibility(View.INVISIBLE);
    		plus7.setVisibility(View.INVISIBLE);
    		plus8.setVisibility(View.INVISIBLE);
    		plus9.setVisibility(View.INVISIBLE);


    	}
    	
    	score1.setText(S1 + "");
    	score2.setText(S2 + "");
    	score3.setText(S3 + "");
    	score4.setText(S4 + "");
    	score5.setText(S5 + "");
    

    	
    	if (firstScore == false)	{
    		
    		highScore1.setText("  ");
        	highScore2.setText("  ");
        	highScore3.setText("  ");
        	highScore4.setText("  ");
        	highScore5.setText("  ");
        	highscore.setText(" ∞ ");
        	
        	highscore.setClickable(false);
    		
    	}else{
		    
    	highScore1.setText(HS1 + "");
    	highScore2.setText(HS2 + "");
    	highScore3.setText(HS3 + "");
    	highScore4.setText(HS4 + "");
    	highScore5.setText(HS5 + "");
    	highscore.setText(HS + "");
    	
    	}
		   
    	if (firstScore == true)	{
    		submitScore(HS);
    	
    		if (startUpDone) // so doesnt count amount of times played by opening it
    			doAchievements(HS);
    	}
    	    	
	  }
	 
    public static void doHSVisible (View clickedButton)		{
		  
    	highscore.setEnabled(false);
	    	
    	if (runnableClass.HSVisible == false)	{
	    		
    		runnableClass.visibleHS1 = false;
    		runnableClass.visibleHS2 = false;
    		runnableClass.visibleHS3 = false;
    		runnableClass.visibleHS4 = false;
    		runnableClass.visibleHS5 = false;
	    		    		  		    		 
    		runnableClass.HSVisible = true;
	    		  
    		handler.postDelayed(runnableClass.scoreHVisible1, 100);

    	}else	{
	    	
    		runnableClass.visibleHS1 = true;
    		runnableClass.visibleHS2 = true;
    		runnableClass.visibleHS3 = true;
    		runnableClass.visibleHS4 = true;
    		runnableClass.visibleHS5 = true;
	    	
    		runnableClass.HSVisible = false;

    		handler.postDelayed(runnableClass.scoreHVisible1, 100);
    	}	
    }	
	  
    public static void doScoreVisible (View clickedButton)		{
				   
    	if (gameFail == false)	{
	    	scoreHS.setEnabled(false);
				    	
	    	if (runnableClass.SHSVisible == false)	{
					    		 
	    		runnableClass.visibleS1 = false;
	    		runnableClass.visibleS2 = false;
	    		runnableClass.visibleS3 = false;
	    		runnableClass.visibleS4 = false;
	    		runnableClass.visibleS5 = false;
					    		    		  		    		 
	    		runnableClass.SHSVisible = true;
					    		  
	    		handler.postDelayed(runnableClass.scoreVisible1, 100);
	
	    	}else	{
				    	
	    		runnableClass.visibleS1 = true;
	    		runnableClass.visibleS2 = true;
	    		runnableClass.visibleS3 = true;
	    		runnableClass.visibleS4 = true;
	    		runnableClass.visibleS5 = true;
			    	
	    		runnableClass.SHSVisible = false;
	
	    		handler.postDelayed(runnableClass.scoreVisible1, 100);
	    	}
    	}
    }
				
    public void doRedo( View clickedButton)		{
				   
    	redo = true;
    	Redo.setEnabled(false);
    	gameMusic.stop();
    	Drawing.over = true;
    	Drawing.makeFlash = false;
    	Drawing.drawFlash = false;
    	Drawing.handler8.removeCallbacks(runnableClass.drawFlashCircle2);
    	stopFlashAfterRedo = true;
    	
		backPressGame = 1;

	  	showInterstitial++;

    }
			   
    public void inGameRedo( View clickedButton)	{
    	
        DisplayNotification n = new DisplayNotification();
        
    	n.NotificationErasePrefs = getSharedPreferences(n.PREFS_NOTIFICATION_ERASE, 0);			
    	boolean redo = n.NotificationErasePrefs.getBoolean(n.PREFS_NOTIFICATION_ERASE, false);
    	
    	buyErasePref = getSharedPreferences(PREFS_BUY_ERASE, 0);		
		int buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
    	
    	if (redo == true || buyErase > 0 || isInstructions)	{
    	
    	if (draw.touchCircles == 1)	{
    		
    		gameScore1 = 0;
			MainActivity.num1.setClickable(false);

    		    	
    	}else if (draw.touchCircles == 2)	{
    		
    		gameScore2 = 0;
			MainActivity.num2.setClickable(false);

    		    	
    	}else if (draw.touchCircles == 3)	{
    		
    		gameScore3 = 0;
			MainActivity.num3.setClickable(false);


    	}else if (draw.touchCircles == 4)	{
        	
    		gameScore4 = 0;
			MainActivity.num4.setClickable(false);


    	}else if (draw.touchCircles == 5)	{
        	
    		gameScore5 = 0;
			MainActivity.num5.setClickable(false);


    	}  
    	
    	if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
			   MainActivity.scoreErase.start();
    	
				draw.touchCircles--;
				draw.scoreCount--;
				draw.ballSpeed--;
				
		    	gameScoreHS = gameScore1 + gameScore2 + gameScore3 + gameScore4 + gameScore5;
		
		    	Drawing.numScore = gameScoreHS;
			  
			  	num1.setText(gameScore1 +"");
			  	num2.setText(gameScore2 +"");
			 	num3.setText(gameScore3 +"");
			 	num4.setText(gameScore4 +"");
			 	num5.setText(gameScore5 +"");
			 	numHS.setText(" " + gameScoreHS);
			 	
		    			        
		    	
		    	buyErasePref = getSharedPreferences(PREFS_BUY_ERASE, 0);		
	    		buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
				
				if (MainActivity.isInstructions)	{
					
					game.setClickable(false);
					
					Drawing.touch5 = false;
					
				    eraseDisplay.setText("0");
				    
				    animation.fadeOut1(null);
			   		animation.fadeOut2(null);
			   		
			   		num1.clearAnimation();
			   		num1.setText("0");
			   		num1.setClickable(false);
				    
  		  			handler.postDelayed(runnables.instructions6, 500);
					
				}else{
				
				if (redo)	{


			    	SharedPreferences.Editor editor = n.NotificationErasePrefs.edit();
				  	editor.putBoolean(n.PREFS_NOTIFICATION_ERASE, false);
				  	editor.commit();
				  	
				  	SharedPreferences.Editor editor1 = buyErasePref.edit();
					buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
					buyErase -= 1;
				  	editor1.putInt(PREFS_BUY_ERASE, buyErase);
				  	editor1.commit();
				
				    eraseDisplay.setText(buyErase + "");
				    
				    SetNotification notif = new SetNotification(this);
			        notif.startAlarm();

			}	else{
				
					SharedPreferences.Editor editor = buyErasePref.edit();
					buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
					buyErase -= 1;
				  	editor.putInt(PREFS_BUY_ERASE, buyErase);
				  	editor.commit();
				
				    eraseDisplay.setText(buyErase + "");
			}
			}
    	}
    }
   
    public void rateGameURL(View clickedButton)	{
		
		 Intent intent = new Intent(Intent.ACTION_VIEW);
		 intent.setData(Uri.parse("market://details?id=flash.point.flashpoint"));
		 startActivity(intent);
				
	 }
    
    TextView scrollCredit;
    
    public void doCredits( View clickedButton )	{
    	
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setTitle("Credits")
    	        .setMessage(R.string.credits)
    	        .setCancelable(true)
    	        .setPositiveButton("Ok", null);
    	
    	AlertDialog dialog = builder.create();
    	dialog.show();
    	TextView textView = (TextView) dialog.findViewById(android.R.id.message);
    	textView.setTextSize((int)(scroll.getTextSize() / 4));
    	textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/cour.ttf"), Typeface.ITALIC);

		     	
    }
    
    public void initiateGoogleAPI()	{			

    	mGoogleApiClient = new GoogleApiClient.Builder(this)
    	.addConnectionCallbacks(this)
    	.addOnConnectionFailedListener(this)
    	.addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
    	.addApi(Games.API).addScope(Games.SCOPE_GAMES)
    	// add other APIs and scopes here as needed
    	.build();
							    
    	mGoogleApiClient.connect();
  }
						
    public void connectGameServices(View clickedButton)	{			
					    	
    	if (mGoogleApiClient.isConnected() == false){
    		beginUserInitiatedSignIn();
    	}
    	else	
    		doLeaderboard();
							
    }
						
    @Override
    public void onConnected(Bundle connectionHint) {
							
    }
						
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    	if (mResolvingConnectionFailure) {
    		// already resolving
    		return;
    	}

    	// if the sign-in button was clicked or if auto sign-in is enabled,
    	// launch the sign-in flow
    	if (mSignInClicked || mAutoStartSignInflow) {
    		mAutoStartSignInflow = false;
    		mSignInClicked = false;
    		mResolvingConnectionFailure = true;
    	}
    }

    @Override
    public void onConnectionSuspended(int i) {
    	// Attempt to reconnect
    	mGoogleApiClient.connect();
    }		
						
    
    
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
    		Intent intent) {
							
    	if (!mHelper.handleActivityResult(requestCode, 
                resultCode, intent)) {
    	
    	super.onActivityResult(requestCode, resultCode, intent);
    	}					
    					
    	if (requestCode == RC_SIGN_IN) {
    		mResolvingConnectionFailure = false;
    		if (resultCode == RESULT_OK) {
    			mGoogleApiClient.connect();
    		} 
    	}
    	
    	 // check for "inconsistent state"
        if ( resultCode == GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED && requestCode == 1337)  {  
        
           // force a disconnect to sync up state, ensuring that mClient reports "not connected"
           mGoogleApiClient.disconnect();
           GameHelper.mGoogleApiClient.disconnect();
        }
    }
    
    @Override
	public void onDestroy() {
		super.onDestroy();

		if (mHelper != null) mHelper.dispose();
		mHelper = null;
		
		
		
	}
    
    @Override
  	public void onStop() {
  		super.onStop();
  		
  		saveTimerPrefs = getSharedPreferences(PREFS_SAVE_TIMER, 0);	
		
		SharedPreferences.Editor editor = saveTimerPrefs.edit();
	  	editor.putLong(PREFS_SAVE_TIMER, EraseCountDown.millisUntilFinishedSave);
	  	editor.commit();
	  	
	  	
	  	startTimePrefs = getSharedPreferences(PREFS_START_TIME, 0);	
		
		
		SharedPreferences.Editor editor1 = startTimePrefs.edit();
	  	editor1.putLong(PREFS_START_TIME, SystemClock.elapsedRealtime());
	  	editor1.commit();
	  	
  	}
      
    
				 
    @Override
    public void onStart()	{
    	super.onStart();
							 
    	initiateGoogleAPI();
    	
    	String base64EncodedPublicKey = 
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsUUEWNHbIxGivR/LrnPrCr4o1eTytXGnM3XSuQERXgWkqrklVkRxDWDi2zed5wRtroXVK0fJl6IuIxvyBhXQTBoaDjy31kigXWvFT6918I4HXeT9pgkUjD2qC4iww9YWqA1w+Te1zP/hsasffFOm+4pAwT0cdcg42j21OMDtZuFjwYReJeHCTTjptNeW579lb1sm2z4tLDlc0ihz/F3qQiAB4vHrHxMv2Bel8k99oeDgGUXK2OQmunx6qF6afQASBqyIJWZxmaG5UneErkCdS5VJxH6XL+WcUoloHzHBClTOrkm7qTTdKQwNv9XjRiPu5QiQYuHVh5sMDYQqEFUNKQIDAQAB";

    	mHelper = new IabHelper(this, base64EncodedPublicKey);

    	mHelper.startSetup(new 
    			IabHelper.OnIabSetupFinishedListener() {
    		public void onIabSetupFinished(IabResult result) 	{
    			
    			if (!result.isSuccess()) {
    				Log.d(TAG, "In-app Billing setup failed: " + 
    						result);
    				mHelper.enableDebugLogging(true, TAG);
    			} else {             
    				Log.d(TAG, "In-app Billing is set up OK");
    			}
    		}
    	});
    }   

	public void buyAdFee(View view) {
		mHelper.launchPurchaseFlow(this, ITEM_ADS, 10001,   
				mPurchaseFinishedListener, "mypurchasetoken");
}

	public void doBuyErase1(View view) {
		mHelper.launchPurchaseFlow(this, ITEM_REDO_1, 10001,   
		mPurchaseFinishedListener, "mypurchasetoken");
	}
		
	public void doBuyErase2(View view) {
		mHelper.launchPurchaseFlow(this, ITEM_REDO_2, 10001,   
		mPurchaseFinishedListener, "mypurchasetoken");
	}	
		
	public void doBuyErase3(View view) {
		mHelper.launchPurchaseFlow(this, ITEM_REDO_3, 10001,   
		mPurchaseFinishedListener, "mypurchasetoken");
	}	
		
	public void doBuyErase4(View view) {
		mHelper.launchPurchaseFlow(this, ITEM_REDO_4, 10001,   
		mPurchaseFinishedListener, "mypurchasetoken");
	}
	
	public void doBuyErase5(View view) {
		mHelper.launchPurchaseFlow(this, ITEM_REDO_5, 10001,   
		mPurchaseFinishedListener, "mypurchasetoken");
	}

	public void consumeItem() {
		mHelper.queryInventoryAsync(mReceivedInventoryListener);
	}


	IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener 
		= new IabHelper.QueryInventoryFinishedListener() {
			public void onQueryInventoryFinished(IabResult result,
					Inventory inventory) {

   
				if (result.isFailure()) {
					// Handle failure
				} else {
					mHelper.consumeAsync(inventory.getPurchase(ITEM_ADS), 
							mConsumeFinishedListener);
				}
			}
		};


		IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
				new IabHelper.OnConsumeFinishedListener() {
				public void onConsumeFinished(Purchase purchase, 
						IabResult result) {

					if (result.isSuccess()) {		 
						
						if (resultIsAds)	{
							
							Toast.makeText(getApplicationContext(), ("In app purchase was successful!"),
									Toast.LENGTH_LONG).show();	
							
							resultIsAds = false;
	
							SharedPreferences.Editor editor = noAdsPref.edit();
	
							editor.putBoolean(NO_ADS, true);
	
							editor.commit();
	
							doAds();
							
						}else if (resultIsErase1)	{
														
							SharedPreferences.Editor editor1 = buyErasePref.edit();
							buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
							buyErase += 5;
				    		
							SharedPreferences.Editor editor = buyErasePref.edit();
							editor.putInt(PREFS_BUY_ERASE, buyErase);
							editor.commit();
							
						    eraseDisplay.setText(buyErase + "");
						    
						    Toast.makeText(getApplicationContext(), ("In app purchase was successful! You now have " + buyErase + " Erasers"),
									Toast.LENGTH_LONG).show();	

						}else if (resultIsErase2)	{
							
							SharedPreferences.Editor editor1 = buyErasePref.edit();
							buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
							buyErase += 12;
				    		
							SharedPreferences.Editor editor = buyErasePref.edit();
							editor.putInt(PREFS_BUY_ERASE, buyErase);
							editor.commit();
							
						    eraseDisplay.setText(buyErase + "");
						    
						    Toast.makeText(getApplicationContext(), ("In app purchase was successful! You now have " + buyErase + " Erasers"),
									Toast.LENGTH_LONG).show();
						    
						}else if (resultIsErase3)	{
							
							SharedPreferences.Editor editor1 = buyErasePref.edit();
							buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
							buyErase += 25;
				    		
							SharedPreferences.Editor editor = buyErasePref.edit();
							editor.putInt(PREFS_BUY_ERASE, buyErase);
							editor.commit();
							
						    eraseDisplay.setText(buyErase + "");
						    
						    Toast.makeText(getApplicationContext(), ("In app purchase was successful! You now have " + buyErase + " Erasers"),
									Toast.LENGTH_LONG).show();
						    
						}else if (resultIsErase4)	{
							
							SharedPreferences.Editor editor1 = buyErasePref.edit();
							buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
				    		buyErase += 65;
				    		
							SharedPreferences.Editor editor = buyErasePref.edit();
							editor.putInt(PREFS_BUY_ERASE, buyErase);
							editor.commit();
							
						    eraseDisplay.setText(buyErase + "");
						    
						    Toast.makeText(getApplicationContext(), ("In app purchase was successful! You now have " + buyErase + " Erasers"),
									Toast.LENGTH_LONG).show();
						    
						}else if (resultIsErase5)	{
							
							SharedPreferences.Editor editor1 = buyErasePref.edit();
							buyErase = buyErasePref.getInt(PREFS_BUY_ERASE, 0);
				    		buyErase += 140;
				    		
							SharedPreferences.Editor editor = buyErasePref.edit();
							editor.putInt(PREFS_BUY_ERASE, buyErase);
							editor.commit();
							
						    eraseDisplay.setText(buyErase + "");
						    
						    Toast.makeText(getApplicationContext(), ("In app purchase was successful! You now have " + buyErase + " Erasers"),
									Toast.LENGTH_LONG).show();
						    
						}
						
					} else {
						// handle error
					}
				}
		};


		IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener 
			= new IabHelper.OnIabPurchaseFinishedListener() {
			public void onIabPurchaseFinished(IabResult result, 
					Purchase purchase) 		{

				if (result.isFailure()) {
					// Handle error
					return;
				}      

				else if (purchase.getSku().equals(ITEM_ADS)) {
					resultIsAds = true;
					consumeItem();								// cant do both untill have id for them
					
				}else if (purchase.getSku().equals(ITEM_REDO_1))	{
					resultIsErase1 = true;
					consumeItem();
					
				}else if (purchase.getSku().equals(ITEM_REDO_2))	{
					resultIsErase2 = true;
					consumeItem();
					
				}else if (purchase.getSku().equals(ITEM_REDO_3))	{
					resultIsErase3 = true;
					consumeItem();
					
				}else if (purchase.getSku().equals(ITEM_REDO_4))	{
					resultIsErase4 = true;
					consumeItem();

				}else if (purchase.getSku().equals(ITEM_REDO_5))	{
					resultIsErase5 = true;
					consumeItem();

				}
			}
	};



 public static void submitScore(long score)	{
		
    	if (mGoogleApiClient.isConnected()){		
    		Games.Leaderboards.submitScore(mGoogleApiClient, MY_LEADERBOARD_ID, (score));		
    	}
    }

    @Override
    public void onSignInFailed() {
    	// TODO Auto-generated method stub		
    }

    @Override
    public void onSignInSucceeded() {
    	
    	HS1 = highScorePref.getInt(HS_PREF, 0);
    	
    	doAchievements(HS1);
    	
    }
    
								
    public void doLeaderboard()	{
							
    	if (mGoogleApiClient.isConnected()){
    		startActivityForResult(Games.Leaderboards.getLeaderboardIntent
    				(mGoogleApiClient, MY_LEADERBOARD_ID), 1337);
    	}	
    }
    
    public void doShowAchievements(View clickedButton)		{
    	
    	if (mGoogleApiClient.isConnected() == false){
    		beginUserInitiatedSignIn();
    	}
    	else	
    		doAchievements();
    }
	
    public void doAchievements()		{
    	
    	if (mGoogleApiClient.isConnected()){
    		startActivityForResult(Games.Achievements.getAchievementsIntent
    				(mGoogleApiClient), 1337);
    	}
    	
    }
	
    
	 public static void doAchievements(int score)	{			
				
	    if (mGoogleApiClient.isConnected()){
		 
		 Games.Achievements.increment(mGoogleApiClient, achievement_10, 1);

		 Games.Achievements.increment(mGoogleApiClient, achievement_100, 1);
				
		 Games.Achievements.increment(mGoogleApiClient, achievement_1000, 1);

		 if (score <= 700)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_1);

		 if (score <= 500)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_2);
				
		 if (score <= 300)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_3);
				
		 if (score <= 200)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_4);
				
		 if (score <= 150)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_5);
		 
		 if (score <= 100)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_6);
		 
		 if (score <= 50)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_7);
		 
		 if (score <= 25)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_8);
		 
		 if (score == 0)
			 Games.Achievements.unlock(mGoogleApiClient, achievement_9);
		 
		 if ( gameScore1 == 0 || gameScore2 == 0 || gameScore3 == 0 || gameScore4 == 0 || gameScore5 == 0 )
			 Games.Achievements.unlock(mGoogleApiClient, achievement_zero);

	    }
	}	

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean dispatchTouchEvent(MotionEvent event) {
		   

	    // Grab two events located on the plane at e1=(x1, y1) and e2=(x2, y2)
	    // Let e1 be the initial event
	    // e2 can be located at 4 different positions, consider the following diagram
	    // (Assume that lines are separated by 90 degrees.)
	    //
	    //
	    //         \ A  /
	    //          \  /
	    //       D   e1   B
	    //          /  \
	    //         / C  \
	    //
	    // So if (x2,y2) falls in region:
	    //  A => it's an UP swipe
	    //  B => it's a RIGHT swipe
	    //  C => it's a DOWN swipe
	    //  D => it's a LEFT swipe
	    //
  		  
	 int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);

        switch(action) {
            case MotionEvent.ACTION_DOWN:
            	
            	
                if(mVelocityTracker == null) {
                    // Retrieve a new VelocityTracker object to watch the velocity of a motion.
                    mVelocityTracker = VelocityTracker.obtain();
                }
                
                else {
                    // Reset the velocity tracker back to its initial state.
                    mVelocityTracker.clear();
                }
                
                x1 = event.getX();
		        y1 = event.getY();
                
                // Add a user's movement to the tracker.
                mVelocityTracker.addMovement(event);
                break;
                
                
            case MotionEvent.ACTION_MOVE:
            	            	
            	if (buttonsClicked())
            		swipe = true;
            	else
            		swipe = false;
            	
                mVelocityTracker.addMovement(event);
                
                // When you want to determine the velocity, call 
                // computeCurrentVelocity(). Then call getXVelocity() 
                // and getYVelocity() to retrieve the velocity for each pointer ID. 
                mVelocityTracker.computeCurrentVelocity(1000);
                
                // Log velocity of pixels per second
                // Best practice to use VelocityTrackerCompat where possible.
                        
                if (VelocityTrackerCompat.getXVelocity(mVelocityTracker, 
                        pointerId) >= 3000 || VelocityTrackerCompat.getXVelocity(mVelocityTracker, // may need to fix
    	                        pointerId) <= -3000)
                	velocityX = true;
                
                if (VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                        pointerId) >= 3000 || VelocityTrackerCompat.getYVelocity(mVelocityTracker, // may need to fix
    	                        pointerId) <= -3000)
                	velocityY = true;

                
                break;
                
            case MotionEvent.ACTION_UP:
            	
            	x2 = event.getX();
		        y2 = event.getY();
		        
	//	        Log.d("", "X velocity: " + 
    //                    VelocityTrackerCompat.getXVelocity(mVelocityTracker, 
    //                    pointerId));
    //            Log.d("", "Y velocity: " + 
    //                    VelocityTrackerCompat.getYVelocity(mVelocityTracker,
    //                    pointerId));
                
		        mVelocityTracker.recycle();
                mVelocityTracker = null;
                
                if (noSwipe == false && swipe == false)	{
                	
		          
			        switch (getDirection(x1,y1,x2,y2)) {
			        
		            	case down:
		            		
		            		if (velocityY)	{
		            			
		            			velocityY = false;
		            			velocityX = false;
		            			
		            			if (swipeMenu)
		            				doMenuPageToErasePage(EffectsOffButton);
		            			
		            			else if (swipeSettings)
		            				doSettingsToMenu(EffectsOffButton);

							break;

		            	}
	            	
		            	case up:
		            		
		            		if (velocityY)	{
		            			
		            			velocityY = false;
		            			velocityX = false;
		            			
		            			if (swipeErase)
		            				doErasePageToMenuPage(EffectsOffButton);
		            			
		            			else if (swipeMenu)
		            				doMenuToSettings(EffectsOffButton);
		            			
							break;

		            	}
		            		
		            	case right:
		            		
		            		if (velocityX)	{
		            			
		            			velocityY = false;
		            			velocityX = false;
		            			
		            			if (swipeScore)
		            				doScoreAnimationToMenu(EffectsOffButton);
		            			
		            			else if (swipeMenu)
		            				doMenuToExplain(EffectsOffButton);
		            			
		            		break;
		            		}
		            		
		            	case left:	
		            		
		            		if (velocityX)	{

		            			velocityY = false;
		            			velocityX = false;
		            			
		            			if (swipeExplain)	
		            				
		            				doExplainToMenu(EffectsOffButton);
		            				
		            			else if (swipeMenu)	
		            				
		            				doMenuToScore(EffectsOffButton);
		            			
            				break;
            				

		           		}
		            	
					default:
						break;
						
			        }
		        }
		       
	  	    
	  }
	    return super.dispatchTouchEvent(event);
		
		}
	
	public boolean buttonsClicked()	{
		
		ImageButton home1 = null;
		ImageButton home2 = null;
		ImageButton home3 = null;
		ImageButton home4 = null;
		ImageButton explain = null;
		ImageButton erase = null;
		ImageButton settings = null;
		
			home1 = (ImageButton)findViewById(R.id.eraseBack);
			home2 = (ImageButton)findViewById(R.id.explain_button1);
			home3 = (ImageButton)findViewById(R.id.settingsButton);
			home4 = (ImageButton)findViewById(R.id.scoreBack);
			explain = (ImageButton)findViewById(R.id.explain_button);
			erase = (ImageButton)findViewById(R.id.erase_button);
			settings = (ImageButton)findViewById(R.id.settings);
			
		if (home1.isPressed() ||
				home2.isPressed() ||
				home3.isPressed() ||
				home4.isPressed() ||
				explain.isPressed() ||
				erase.isPressed() ||
				settings.isPressed())
		return true;
		
		else
			return false;

	}
	
	/**
	 * Given two points in the plane p1=(x1, x2) and p2=(y1, y1), this method
	 * returns the direction that an arrow pointing from p1 to p2 would have.
	 * @param x1 the x position of the first point
	 * @param y1 the y position of the first point
	 * @param x2 the x position of the second point
	 * @param y2 the y position of the second point
	 * @return the direction
	 */
	public Direction getDirection(float x1, float y1, float x2, float y2){
	    double angle = getAngle(x1, y1, x2, y2);
	    return Direction.get(angle);
	}

	/**
	 *
	 * Finds the angle between two points in the plane (x1,y1) and (x2, y2)
	 * The angle is measured with 0/360 being the X-axis to the right, angles
	 * increase counter clockwise.
	 *
	 * @param x1 the x position of the first point
	 * @param y1 the y position of the first point
	 * @param x2 the x position of the second point
	 * @param y2 the y position of the second point
	 * @return the angle between two points
	 */
	public double getAngle(float x1, float y1, float x2, float y2) {

	    double rad = Math.atan2(y1-y2,x2-x1) + Math.PI;
	    return (rad*180/Math.PI + 180)%360;
	}


	public enum Direction{
	    up,
	    down,
	    left,
	    right;

	    /**
	     * Returns a direction given an angle.
	     * Directions are defined as follows:
	     *
	     * Up: [45, 135]
	     * Right: [0,45] and [315, 360]
	     * Down: [225, 315]
	     * Left: [135, 225]
	     *
	     * @param angle an angle from 0 to 360 - e
	     * @return the direction of an angle
	     */
	    public static Direction get(double angle){
	        if(inRange(angle, 45, 135)){
	            return Direction.up;
	        }
	        else if(inRange(angle, 0,45) || inRange(angle, 315, 360)){
	            return Direction.right;
	        }
	        else if(inRange(angle, 225, 315)){
	            return Direction.down;
	        }
	        else{
	            return Direction.left;
	        }

	    }

	    /**
	     * @param angle an angle
	     * @param init the initial bound
	     * @param end the final bound
	     * @return returns true if the given angle is in the interval [init, end).
	     */
	    private static boolean inRange(double angle, float init, float end){
	        return (angle >= init) && (angle < end);
	    }
	}


	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void onBackPressed()	{
		
		
		if (backPressGame == 2)	{
	    	Drawing.endGame = true;
	    	Drawing.makeFlash = false;
	    	Drawing.drawFlash = false;
	    	Drawing.handler8.removeCallbacks(runnableClass.drawFlashCircle2);
	    	
	    	spotX = MovingBalls.x;
	    	spotY = MovingBalls.y;
	    	
 	    	MainActivity.gameFail = true;
 	    	
 	    	backPressGame = 1;

		}else if (backPressGame == 3)	{
			  
				Drawing.shrinkInstructions = true;
				Drawing.doInstructionsImplode = true;
			  
				touchToStart.setVisibility(View.INVISIBLE);
				continueInstructionsText.setVisibility(View.INVISIBLE);
				startMnuAnimate.setBackgroundColor(Color.TRANSPARENT);
			  
				spotX = MovingBalls.x; 
				spotY = MovingBalls.y;
				
				
		    	Drawing.handler1.removeCallbacks(runnableClass.drawFlashCircle1);
		    	Drawing.instructionsCircle = false;

			
		}
		else 	{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure you want to exit?")
			   .setCancelable(false)
			   .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			       public void onClick(DialogInterface dialog, int id) {
			    	   doCloseApp();
			       }
			   })
			   .setNegativeButton("No", new DialogInterface.OnClickListener() {
			       public void onClick(DialogInterface dialog, int id) {
			            dialog.cancel();
			       }
			   });
			AlertDialog alert = builder.create();
			alert.show();
		}
	    }
	
	public void doCloseApp()	{
		
		this.finish();
    	System.exit(0);
		
	}
	
}


//Toast.makeText(getApplicationContext(), ("1"),
//	Toast.LENGTH_LONG).show();

// issue when signing out of account for game center, then signing back in

// maybe have score submitted when connected to wifi

// ad placement may be issue, will need to see how looks on larger screens

// status bar shows when use volume

// may destroy app if exit while it still loads
// game continues playing after turning device off
// game goes funny when exit and open app

// redo, shrink, then grow from center/ done
//button click sounds
// instruction, explain why target move
// dont need to make ad invisible, just refresh
// distance using pixals errors
// remove starmenu, have game for start
// ask j if bouncing balls go behind ad or not
// can kindof see outline of square for rotating circle
// after perchuse issue doing instructions right after
//gameScoresLayout.getHeight() / 2  find, figure out, fix
// disable no ads button after purchase
//game music off, may fix
// vibrate for notification
//game music may not be long enough with redos
//sound effect for redo score
// make startup better? look better?
//action bar - see manifest//
//Interstitial
//exmeriment with views
// change time notification issue?? test to see
//no wifi, get rid of ad space
//notification vibrate

//instructions issue at end when tap alot//
// try buying ads, then transfering apk to other device
// redo issue again//fixed by stopping first flash, shoud be good for now, maybe. Also, change direction also affected, think is fixed by removing callback
//back press//
//flash longer?
//delete efficent mode
//crash on my phone issue
//stop using static!!!! eveil, search if forget
//swipe score issue after back button
// space between instruction words and top
//may say have fun while shrinking for instructions
//notification timer start after use redo//
//lolipop code stuff
//music issue where exit game open, menu and game music play//only on justyns phone
//velocity//good - issue was only should velocity when lifted finger - just had to increase velocity amount
//glich when shrink or grow ball and lock screen// shrink//done
//flash score in instructions
//slow start issue - so many layouts in full game that it took time to load - solution was to set layout to logo page, then switch to full game so it di loading while logo was showing
// ball slows from sound effect when hit wall//
// Integrate erase timer
//notification alarm on shutdown
//back button loading screen
//back button during instructions??

//logo page load issue????? - look down
//investigate shutdoen for noti and countdown//done
//try changing clock again
//alarm manager force stop - investigate//think is equivalent to reboot - go through same process
//instructions need fix - go fast and glitch, like score keeps flashing

//redo text may be to big

//ball glitch sound happened//
//counter after device locked//
//dialog come up when click bavk button ask if exit, have back button variable change right after click back button, not after shrink
//eraser dialogur randomly poped up, saying 0 erasers when should be one - shouldnt have come up at all though, must be from calling in MAINACTIVITY
//stop dialog during game
//logo glitch after start up - think from broadcast
//latter if feel like it - have second notification come up after first - asking if want to use redo - like crossy road
//encrypte code and other stuff
//change price of 5 erasers in console
//score and leaderboard button
//show ads again