package game;

import java.lang.ref.WeakReference;

import Animation.animation;
import Background.BackgroundCircleBounce;
import Runnable.runnables;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import flash.point.flashpoint.MainActivity;
import flash.point.flashpoint.R;

public class Drawing extends View	{
  

  public static int height;
  static int width;
  
  public static int scoreCount;
  public static int scoreRemember;
  public static int scoreRemember2;

  
  public static int touchCircles;
  static int circleWidth;
  static int circleHeight;
  static int g = 0;
  
  public static double flashX;
  public static double flashY;
  static double distanceScore;
  
  public static boolean drawFlash;
  public static boolean makeFlash = true;
  public static boolean touchScreen;
  public static boolean endGame, endGame1;
  static boolean changeDir = true;
  public static boolean over = false;
  
  public static MainActivity main = new MainActivity();
        
  public static float touchX;
  public static float touchY;
  public static boolean switchRotation;
  
  static float rotation;
static float rotation1;
    
  public static MovingBalls balls = null;
  
	static double x;
	static double y;
	static double x1;
	static double y1;
	
	static double X;
	static double Y;
	
	static boolean doTargetMove;
		
	static int rotateTarget;
	static int targetRotatesDone;
  
	static MovingBallsTarget targetBall;
	
	static boolean initiateTargetMove;
	
	public static boolean targetStop;
	
	static int circleWidth1;
	static int circleHeight1;
	static int g1 = 0;
	
	public static double flashX2, flashY2;
	
	static double X3;
	static double Y3;
	
	static boolean doTargetMove2;
	
	static int rotateTarget2;
	static int targetRotatesDone2;
  
	static MovingBallsTarget2 targetBall2;
	
	static boolean initiateTargetMove2;
	
	public static boolean targetStop2;
	
	static int circleWidth2;
	static int circleHeight2;
	static int g2 = 0;
	
	static runnables runnableClass;
	    
    public static int ballSpeed;
    
    public static int num;
	public static int num2;
	public static int numScore;
	
	static boolean endGameTarget, endGameTarget2;
	static boolean d;
	public static boolean f;	
	static int target1Freeze;
	static int target2Freeze;
	
	public static boolean startMenu;
	public static boolean startGame;
	
	public static boolean doingInstructions;
	public static boolean touch1;
	public static boolean instructionsMoveBall;
	public static boolean instructionsCircle;

	public static boolean touch;
	public static boolean touch2;
	public static boolean touch3;
	public static boolean touch4;
	public static boolean touch5;
	public static boolean touch6;

	public static boolean instructionsTestRedo;
	public static boolean shrinkInstructions;
	public static boolean doInstructionsImplode;
	
	public static Handler handler1, handler2, handler3, handler4, handler5,  handler6, handler7, handler8, handler9, handler10, handler11, handler12,
	handler13, handler14, handler15, handler16;
	
	
	Bitmap circleIn;
	  int wIn;
	  int hIn;
	  Bitmap resizedIn;
	  
	  Bitmap circleOut;
	  Bitmap resizedOut;
	  int wOut;
	  int hOut;
	  
	  
		  
	  Bitmap resizedShrinkAllCircle;
	  
	  Bitmap target;
	  Bitmap resizedTarget;
	  int wTarget;
	  int hTarget;
	  int wTargetHalf;
	  int hTargetHalf;
	  Bitmap target2;
	  Bitmap resizedTarget2;
	  int wTarget2;
	  int hTarget2;
	  int wTargetHalf2;
	  int hTargetHalf2;
	  
	  boolean keepFlash;
	  
	  Bitmap circleAll;
	
  public Drawing(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
  
  public Drawing(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
  
public void test()	{
	  
	  circleIn =  BitmapFactory.decodeResource(getResources(), R.drawable.circle_in_good);

	  wIn = getWidth() / 24;
	  hIn = getWidth() / 24;
	  
	  resizedIn = Bitmap.createScaledBitmap(circleIn, wIn, hIn, true);
	  
	  circleOut =  BitmapFactory.decodeResource(getResources(), R.drawable.circle_out_good);
	  
	  wOut = getWidth() / 12;
	  hOut = getWidth() / 12;
	  
	  resizedOut = Bitmap.createScaledBitmap(circleOut, wOut, hOut, true);
	  
	  
	  
	  target =  BitmapFactory.decodeResource(getResources(), R.drawable.target_improved);
	  
	  wTarget = (getWidth() / 12);
	  hTarget = (getWidth() / 12);
	  
	  wTargetHalf = (getWidth() / 12) / 2;
	  hTargetHalf = (getWidth() / 12) / 2;
	  
	  resizedTarget = Bitmap.createScaledBitmap(target, wTarget, hTarget, true);

	  
	  circleHeight = getWidth() / 10;
	  circleWidth = getWidth() / 10;
	  
	  x1 = (getWidth() / 10) / 2;
	  y1 = (getWidth() / 10) / 2;
	  
	  x = 0;
	  y = 0;
	 
	  circleAll =  BitmapFactory.decodeResource(getResources(), R.drawable.circle_all_good);
	  
		
	target2 =  BitmapFactory.decodeResource(getResources(), R.drawable.target_improved);
	
	wTarget2 = getWidth() / 12;
	hTarget2 = getWidth() / 12;
	
	resizedTarget2 = Bitmap.createScaledBitmap(target2, wTarget2, hTarget2, true);

	 wTargetHalf2 = (getWidth() / 12) / 2;
	 hTargetHalf2 = (getWidth() / 12) / 2;
	 
	 
  }
  
	  public /*static*/ void newGame()		{
		 		  
		  
	    scoreCount = 0;
	    drawFlash = false;
	    makeFlash = true;
	    endGame = false;
	    changeDir = true;
	    balls = null;
	    over = false;
	    touchScreen = false;
	    g = 0;
	    g1 = 0;
	    
	    touchCircles = 0;
	    doTargetMove = false;
	    doTargetMove2 = false;
	    g2 = 0;
	    
	    rotateTarget = 0;
	    targetRotatesDone = 0;
	    
	    rotateTarget2 = 0;
	    targetRotatesDone2 = 0;
	    
	    handler1 = new Handler();
	    handler2 = new Handler();
	    handler3 = new Handler();
	    handler4 = new Handler();
	    handler5 = new Handler();
	    handler6 = new Handler();
	    handler7 = new Handler();
	    handler8 = new Handler();
	    handler9 = new Handler();
	    handler10 = new Handler();
	    handler11 = new Handler();
	    handler12 = new Handler();
	    handler13 = new Handler();
	    handler14 = new Handler();
	    handler15 = new Handler();
	    handler16 = new Handler();
	    
	    runnableClass = new runnables();
	    	    	    
	    ballSpeed = 0;
	    endGameTarget = false;
	    endGameTarget2 = false;
	    d = false;
	    
	    numScore = 0;
	    
	    switchRotation = false;
	    	    
		moveBall(null); // stops a brief flash of where the ball was in the past game
	    
	    MainActivity.Redo.setVisibility(View.VISIBLE);
	    
	    height = 0;
	    width = 0;
	    	    
	    scoreRemember = 0;
	    scoreRemember2 = 0;
	    
	    circleWidth = 0;
	    circleHeight = 0;
	    
	    circleWidth1 = 0;
	    circleHeight1 = 0;
	    
	    circleWidth2 = 0;
	    circleHeight2 = 0;

	    flashX = 0;
	    flashY = 0;
	    
	    flashX2 = 0;
	    flashY2 = 0;
	    
	    touchX = 0;
	    touchY = 0;
	    
	    distanceScore = 0;
	    
	    rotation = 0;
	    rotation1 = 0;
	    

		x = 0;
		y = 0;
		x1 = 0;
		y1 = 0;
		
		X = 0;
		Y = 0;
		
		X3 = 0;
		Y3 = 0;
		
		targetStop2 = false;
		
		
		targetBall = null;
		targetBall2 = null;
		
		initiateTargetMove = false;
		
		targetStop = false;
		
		initiateTargetMove2 = false;
		
		num = 0;
		num = 0;
		numScore = 0;
		
		target1Freeze = 0;
		target2Freeze = 0;
		
		test();
		
		MovingBalls.setSpeed(width / 128);
		
		 doingInstructions = true;
	    	
		 touch = true;
		 instructionsMoveBall = false;
		 instructionsTestRedo = false;
		 shrinkInstructions = false;
		 doInstructionsImplode = false;
		 
		 
		 if (MainActivity.isInstructions)	{
		 	MainActivity.touchToStart.setVisibility(View.VISIBLE);
			MainActivity.continueInstructionsText.setVisibility(View.VISIBLE);
		    
			animation.continueInstructionsLayout.clearAnimation();
		    MainActivity.touchToStart.setText("Welcome to FlashPoint!");
		    
		    makeFlash = false;
		    
		    MainActivity.backPressGame = 3;

		 }
		
		
	    if (f){
	    	MainActivity.draw.invalidate();
			handler1.postDelayed(runnableClass.runnable6, 500);
		    startMenu = true;

	    }
	    f = true;
	    
  }
  
	  public void onDraw(Canvas canvas)		{
	    super.onDraw(canvas);
	   	   
	    width = getWidth();
	    height = getHeight();
	    
		if (BackgroundCircleBounce.background1)
		    setBackgroundResource(R.drawable.game_background);
		
		else if (BackgroundCircleBounce.background2)
		    setBackgroundResource(R.drawable.game_background1);
		
		else if (BackgroundCircleBounce.background3)
		    setBackgroundResource(R.drawable.game_background2);

		
		if (MainActivity.isInstructions)	{
			
			 if (d)	{
				 doImplodeInstructions();	    
				 return;
		    }
		    			    	
		   
		    	
			
			if (instructionsCircle)	{
				   
				   ShapeDrawable shape = new ShapeDrawable(new OvalShape());
				   shape.getPaint().setColor(Color.rgb(254, 70, 57));
				    
				   int size = width / (int)12.8;
				   shape.setBounds(0, 0, size, size);
				   shape.draw(canvas);
				   
			   }
			
			if (doTargetMove)	{
	    		
				touchScreen = false;
				makeFlash = false;
				handler3.removeCallbacks(runnableClass.drawFlashCircle1);
				
	    		if (initiateTargetMove){
	    			
	    			doInitiateMoveTarget(canvas);
	    			
	    		}	else if (targetStop == false) {
	    				
	    			doMoveTarget(canvas);
	    	
	    		}else if (targetRotatesDone <= 20)	{//30
	    			
	    			doTargetRotate(canvas);
	    		}else	{
	    			
	    			doTargetShrink(canvas);
	    			
	    			if (target1Freeze >= 20)	{  //(circleHeight1 <= 5 || circleWidth1 <= 5)	{
	      		  		doTargetMove = false;
	      		  		g1 = 0;
	      		  		rotateTarget = 0;
	      		  		targetRotatesDone = 0;
	      		  		targetStop = false;
	      		  		
	      		  		target1Freeze = 0;
	      		  		
	      		  		if (instructionsTestRedo)	{
	      		  			instructionsTestRedo = false;
	      		  			instructionsMoveBall = false;
	      		  			touchScreen = false;
	      		  			makeFlash = false;
	      		  			drawFlash = false;
	      		  			
	      		  			animation.fadeIn1(null);
	      		  			animation.animateFlashing(null);
	      	//	  			animation.fadeIn2(null);
	      			  
	      		  		MainActivity.touchToStart.setTextSize(100);
      		  			MainActivity.touchToStart.setText("Good job. Not happy with that score? Simply erase it by tapping on it.");
						MainActivity.touchToStart.resizeText(MainActivity.touchToStartLayoutWidth,  MainActivity.touchToStartLayoutHeight);												   		
						  	
	      		  			
	      		  		}
	    	    	}	    		
	    		}
	    	}
			
			if (makeFlash)		 {
		    	
		    	int e = (int)((3000 * Math.random()) + 5000);
		    	
		    	handler3.postDelayed(runnableClass.drawFlashCircle1, e);
		    	makeFlash = false;
		    }
		    
		   		    	   
		    if (drawFlash)		{
		     
		    	drawFlashCircle(canvas);
		    	drawFlash = false;
		    	if (doTargetMove)	{
		    		flashX2 = MovingBalls.x;
	    			flashY2 = MovingBalls.y;
		    	}else	{
		    		flashX = MovingBalls.x;
		    		flashY = MovingBalls.y;
		    	}
		    }
		    
		    
		    if (changeDir)	{
		    	handler4.postDelayed(change, 3000);
		    	changeDir = false;
		    	
		    }
		   
		    if (shrinkInstructions)	{
				MainActivity.num1.clearAnimation();
				doShrink(canvas);
		   }else{
		    
	    	if (instructionsMoveBall)	{

	    		moveBall(canvas);
	    	}
		    innerCircle(canvas);
	   		outerCircle(canvas);
		   }
		    
		    if (circleWidth <= 4 && doInstructionsImplode|| circleHeight <= 4 && doInstructionsImplode)	{
	    		doInstructionsImplode = false;
	    		d = true;
	    	}
		    
	   	 if (endGame1)	{
	   		instructionsMoveBall = false;
	   		
			handler6.postDelayed(runnables.instructions5, 0);
			endGame1 = false;
	   	 }
	   	 
	   	 
	    invalidate();
			
			
		}else{
		

	    if (startMenu)	{

		    innerCircle(canvas);
		    outerCircle(canvas);
		    
		    invalidate();
	    }else{
	    	
	    	    
	    if (d && MainActivity.shrinkFixAppPause == false)	{
	    		doImplode();	    
			return;
	    	
	    }else if (MainActivity.shrinkFixAppPause)	// stops two sets of balls from appearing after locking game during shrinking, then unlocking
	    	return;
	    	
	    if (over)	{
	    	
			doShrink(canvas);
	    	
	    	if (circleWidth <= 4|| circleHeight <= 4){
				MainActivity.backgroundCircleBounce.setVisibility(View.VISIBLE);	
				
				MainActivity.shrinkFixApp = false;

	    		d = true;
		  }
	    				  
		  invalidate();
	    
	    }  else	if (MainActivity.redo == false){	    
	    	
	    innerCircle(canvas);
	    outerCircle(canvas);
	    	    
	    if (makeFlash && endGameTarget == false && endGameTarget2 == false)		 {
	    	
	    	handler8.removeCallbacks(runnableClass.drawFlashCircle2);// this placed in many places stops redo issue
	    	
	    	int e = (int)((3000 * Math.random()) + 5000);
	    	
	    	handler8.postDelayed(runnableClass.drawFlashCircle2, e);
	    	makeFlash = false;
	    }

	   
	    moveBall(canvas);
	    	   
	    if (drawFlash && endGameTarget == false && endGameTarget2 == false)		{
	    	
	    	if (MainActivity.stopFlashAfterRedo)	{//prevents flash after doing a redo.
	    		MainActivity.stopFlashAfterRedo = false;
		    	drawFlash = false;
	    		invalidate();
	    		return;
	    	}
		    	drawFlashCircle(canvas);
		    	drawFlash = false;
		    	if (doTargetMove)	{
		    		flashX2 = MovingBalls.x;
	    			flashY2 = MovingBalls.y;
		    	}else	{
		    		flashX = MovingBalls.x;
		    		flashY = MovingBalls.y;
		    }
	    }
	    
	    
	    if (changeDir && endGameTarget == false && endGameTarget2 == false)	{
	    	handler9.removeCallbacks(change);
	    	handler9.postDelayed(change, 3000);
	    	changeDir = false;
	    	
	    }

	    	if (doTargetMove)	{
	    		
	    		if (initiateTargetMove){
	    			
	    			doInitiateMoveTarget(canvas);
	    			scoreCount += 1;
	    			scoreRemember = scoreCount;
	    			
	    		}	else if (targetStop == false) {
	    				
	    			doMoveTarget(canvas);
	    	
	    		}else if (targetRotatesDone <= 20)	{//30
	    			
	    			doTargetRotate(canvas);
	    		}else	{
	    			
	    			doTargetShrink(canvas);
	    			
	    			if (target1Freeze >= 20)	{  //(circleHeight1 <= 5 || circleWidth1 <= 5)	{
	      		  		doTargetMove = false;
	      		  		g1 = 0;
	      		  		rotateTarget = 0;
	      		  		targetRotatesDone = 0;
	      		  		targetStop = false;
	      		  		
	      		  		flashX = flashX2;
	      		  		flashY = flashY2;
	      		  		
	      		  		endGameTarget = false;
	      		  		
	      		  		target1Freeze = 0;
	    	    	}	    		
	    		}
	    	}
	    	
	    	if (doTargetMove2)	{
	    		
	    		if (initiateTargetMove2){
	    			
	    			doInitiateMoveTarget2(canvas);
	    			scoreCount += 1;
	    			scoreRemember2 = scoreCount;
	    			
	    		}	else if (targetStop2 == false) {
	    				
	    			doMoveTarget2(canvas);
	    	
	    		}else if (targetRotatesDone2 <= 20)	{//30
	    			
	    			doTargetRotate2(canvas);
	    		}else	{
	    			
	    			doTargetShrink2(canvas);
	    			
	    			if (target2Freeze >= 20)	{  //(circleHeight1 <= 5 || circleWidth1 <= 5)	{
	      		  		doTargetMove2 = false;
	      		  		g2 = 0;
	      		  		rotateTarget2 = 0;
	      		  		targetRotatesDone2 = 0;
	      		  		targetStop2 = false;
	      		  		
	      		  		endGameTarget2 = false;
	      		  		
	      		  		target2Freeze = 0;

	    	    	}	    		
	    		}
	    	}
	    	
	    if (touchCircles < 5 && endGame == false || endGameTarget || endGameTarget2)	{
	      invalidate();
	      
	  }	else	{
		  over = true;
		  MainActivity.spotX = MovingBalls.x;
		  MainActivity.spotY = MovingBalls.y;
		  
		  MainActivity.shrinkFixApp = true;
		  
		  invalidate();
	   		 
		 
	  }	
	    }else	{
	    	
	    	innerCircle(canvas);
	    	outerCircle(canvas);
		    moveBall(canvas);
	    	
	    	invalidate();
	    }
	  }
	    }
	  }
	  
	  
	  
	  public void doImplodeInstructions()	{
		  
		  		BackgroundCircleBounce.newBallWhite();
		  		BackgroundCircleBounce.newBallBlack();
		  

				MainActivity.game.setVisibility(View.INVISIBLE);
				MainActivity.score.setVisibility(View.INVISIBLE);
				MainActivity.explain.setVisibility(View.INVISIBLE);
				MainActivity.main.setVisibility(View.INVISIBLE);
				MainActivity.backgroundCircleBounce.setVisibility(View.VISIBLE);
		  
		  	 if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
				   MainActivity.explosion.start();
			  
		  	MainActivity.touchToStart.setTextSize(100);
			MainActivity.touchToStart.setVisibility(View.VISIBLE);
		    MainActivity.touchToStart.setText("Touch to Start");
		    MainActivity.touchToStart.resizeText(MainActivity.touchToStartLayoutWidth,  MainActivity.touchToStartLayoutHeight);
			MainActivity.continueInstructionsText.setVisibility(View.VISIBLE);

		  Handler handler = new Handler();
		  handler.postDelayed(runnables.doneInstructions, 2000);
			  
	  }
	  	  
	  public void doShrink(Canvas canvas)	{
	  		

		  if (g == 0)	{
			  
			  if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	// calls this multiple times
				   MainActivity.ballShrink.start();
			  
		  }else	{
			  
			  if (MainActivity.redo)	{
				  circleHeight -= 4;
				  circleWidth -= 4;
				  
			  }else{
				  circleHeight -= 2;
				  circleWidth -= 2;
				  
			  }			  
		  }

		  if (circleHeight < 4)
			  circleHeight = 4;
		  
		  if (circleWidth < 4)
			  circleWidth = 4;
		  
		  g = 1;
		  
		  resizedShrinkAllCircle = Bitmap.createScaledBitmap(circleAll, circleWidth, circleHeight, true);
		  
		  Matrix matrix = new Matrix();
		  
		  
		  if (MainActivity.redo)	{
			  x += 1.5; 
			  y += 1.5;
			  
		  }else{
			  x += 0.75; // if 1, the image would shrink into the bottom right corner.
			  y += 0.75; // the 0.5 evens it out so it shrinks into the center
			  
		  }		   
		  		  
		  double px = (MovingBalls.x - x1) + x; // in brackets is to prevent the image from moving so that
		  double py = (MovingBalls.y - y1) + y;	//the left corner of it is where the center of the image
		  										//used to be. the variable after is to make it shrink in
		  										//the middle, not into the left corner
		  
		  matrix.postTranslate((float)px, (float)py);
		  canvas.drawBitmap(resizedShrinkAllCircle, matrix, null);
		  
		 
		  
	  }
	  
	  
	  
	  public void doImplode()	{
		  
		  if (MainActivity.redo == false)	{
		  		BackgroundCircleBounce.newBallWhite();
		  		BackgroundCircleBounce.newBallBlack();
		  }

			MainActivity.game.setVisibility(View.INVISIBLE);
			MainActivity.score.setVisibility(View.INVISIBLE);
			MainActivity.explain.setVisibility(View.INVISIBLE);
			MainActivity.main.setVisibility(View.INVISIBLE);
			
			MainActivity.backgroundCircleBounce.setVisibility(View.VISIBLE);
			
			  if (MainActivity.redo)	{
				  
				  BackgroundCircleBounce.g = 0;
				  BackgroundCircleBounce.over = true;
				  

					if (MainActivity.showAd == false && MainActivity.mWifi.isConnected())
						MainActivity.adView6.setVisibility(View.VISIBLE);

				  				  
			  }else{


		  	if (endGame == false)
		    	MainActivity.doHighScores();
		    else
		    	MainActivity.doSetHighScores();
		  	
		  	if (MainActivity.musicSoundOn)	{
		    	MainActivity.gameMusic.reset();
		  		menuMusic();
				
			}	
	    	
		  	 if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
				   MainActivity.explosion.start();
			  
		  Handler handler = new Handler();
		  handler.postDelayed(score, 2000);
			  }
	  }
	  
	  public void menuMusic()		{
		  
	    	Context context=getContext();
	    	MainActivity.menuMusic = MediaPlayer.create(context, R.raw.menu_music);		
	  		MainActivity.menuMusic.setLooping(true);
			MainActivity.menuMusic.start();    	
	    }
	    

	    public void gameMusic()		{
	    	
	    	Context context=getContext();
	    	MainActivity.gameMusic = MediaPlayer.create(context, R.raw.game_music_shorten);		
	    	MainActivity.gameMusic.setLooping(true);
	    	MainActivity.gameMusic.start();
	    	    	
	    }
	  
	  Runnable score = new Runnable() {
		   @Override
		   public void run() {
			   		    
				  main.doSetScore();   			    	
		   }
		   };
		   
  
			  Runnable change = new Runnable() {
				   @Override
				   public void run() {
					   
					   if (MainActivity.redo == false)
						   MovingBalls.headTowards(Math.random()*width, Math.random()*height);
					   
					   changeDir = true;
				   }
			  };
			  
			  public Runnable drawFlashCircle = new Runnable() {
				   @Override
				   public void run() {
					   		    
					   Drawing.drawFlash = true;
				   }
			   }; 				   
				  
	  public void drawFlashCircle(Canvas canvas)	{
		  
		  ShapeDrawable shapeFlash = new ShapeDrawable(new OvalShape());
		  shapeFlash.getPaint().setColor(Color.rgb(254, 70, 57));

		  int flashHeight = height - MainActivity.gameScoresLayout.getHeight();
		  int sizeFlash = width / (int)12.8;
			
	    switch ((int)(4 * Math.random()))	{
	     
	    case 0:
	    	shapeFlash.setBounds(0, 0, sizeFlash, sizeFlash);
	      break;
	      
	    case 1:
	    	shapeFlash.setBounds(width - sizeFlash, 0, width, sizeFlash);
	      break;
	      
	    case 2:
	    	shapeFlash.setBounds(0, flashHeight - sizeFlash, sizeFlash, flashHeight);
	      break;
	      
	    case 3:
	    	shapeFlash.setBounds(width - sizeFlash, flashHeight - sizeFlash, width, flashHeight);
	      break;
	      
	    }
	    shapeFlash.draw(canvas);
	    
	    if (MainActivity.isInstructions == false)	{
	    
	    ballSpeed++;
	    
	    if (ballSpeed == 1)
	    	MovingBalls.setSpeed(width / 123);
	    	
	    else if (ballSpeed == 2)
	    	MovingBalls.setSpeed(width / 118);
	    	
	    else if (ballSpeed == 3)
	    	MovingBalls.setSpeed(width / 110);
	    	
	    else if (ballSpeed == 4)
	    	MovingBalls.setSpeed(width / 105);
	    
	    }
	    	
	    if (MainActivity.isInstructions)	{
	    	
	    	 if (touchScreen)	{
	 	    	endGame1 = true;
		     	drawFlash = false;
		     	touchScreen = false;
	 	    	
	 	    }else{
		     	drawFlash = false;
		     	touchScreen = true;
		 	    makeFlash = true;

	 	    }
	    }else{
	    	
	    	 if (touchScreen)	{
	 	    	endGame = true;
	 	    	MainActivity.gameFail = true;
	 	    }
	     	drawFlash = false;
	 	    makeFlash = true;
	 	    touchScreen = true;
	    	
	    }
	
	   
	  }
	  
	  
	  public static void moveBall(Canvas canvas)		{
	   
		  if (balls == null) {
			  balls = new MovingBalls(0, MainActivity.draw.getWidth(), 0, (MainActivity.draw.getHeight() - (MainActivity.gameScoresLayout.getHeight()))); 
	    }else	{
		  
		  balls.travel();
		  balls.draw(canvas);
	    }
	  }
	  
	  
	  public void doScore(int flashX, int flashY, int touchX, int touchY, int scoreCount)	{
		    		    
		  distanceScore = Math.sqrt(Math.pow(flashX - touchX, 2) + Math.pow(flashY - touchY, 2));
		  
		  double density = getResources().getDisplayMetrics().density;
		  
		   		  
		  if (scoreCount == 1) {
			  MainActivity.gameScore1 = (int)(distanceScore / density);
		    		
		  }	else if (scoreCount == 2) {
			  MainActivity.gameScore2 = (int)(distanceScore / density);
		    		
		  } else if (scoreCount == 3) {
			  MainActivity.gameScore3 = (int)(distanceScore / density);
		    	  	
		  } else if (scoreCount == 4) {
			  MainActivity.gameScore4 = (int)(distanceScore / density);
		    	  	
		  } else if (scoreCount == 5) {
			  MainActivity.gameScore5 = (int)(distanceScore / density);
		      
		    }
		   MainActivity.gameScore();
		   
		   if (touchCircles == 1)	{
	      		
	      		MainActivity.num1.setEnabled(true);
				MainActivity.num1.setClickable(true);

				
	      	}else if (touchCircles == 2)	{
	      		
	      		MainActivity.num1.setEnabled(false);
				MainActivity.num2.setEnabled(true);
				MainActivity.num2.setClickable(true);

				
	      	}else if (touchCircles == 3)	{
	      		
	      		MainActivity.num2.setEnabled(false);
				MainActivity.num3.setEnabled(true);
				MainActivity.num3.setClickable(true);

				
	      	}else if (touchCircles == 4)	{
	      		
	      		MainActivity.num3.setEnabled(false);
				MainActivity.num4.setEnabled(true);
				MainActivity.num4.setClickable(true);

				
	      	}else if (touchCircles == 5)	{
	      		
	      		MainActivity.num4.setEnabled(false);
				
	      	}
		  }
	  
	    
	  
	  public boolean onTouchEvent(MotionEvent evt)		{
	   
		  if (evt.getAction() == MotionEvent.ACTION_DOWN)	{
			  
			  
			  if (MainActivity.isInstructions)	{
				  
				  if (touch)	{
					  handler10.postDelayed(runnables.instructions, 1000);
						instructionsMoveBall = true;
					    touch = false;
					    				
					    animation.fadeOut1(null);
					    animation.fadeOut2(null);

						  
				  }else	if (touch1)	{
					  handler11.postDelayed(runnables.instructions1, 3000);
					  touch1 = false;
					  
					  animation.fadeOut1(null);
					  animation.fadeOut2(null);

					  
				  }else if (touch2)	{
					  handler12.postDelayed(runnables.instructions2, 2000);
	
					  instructionsMoveBall = true;
					  instructionsCircle = false;
					  touch2 = false;
					  
					  animation.fadeOut1(null);
					  animation.fadeOut2(null);

					  
				  }else if (touch3)	{
	
					  handler13.postDelayed(runnables.instructions3, 2250);
					  instructionsMoveBall = true;
					  touch3 = false;
					  
					  animation.fadeOut1(null);
					  animation.fadeOut2(null);
	
				  }else if (touch4)	{
					  
					  handler14.postDelayed(runnables.instructions4, 500);

					  touch4 = false;
				  
					  animation.fadeOut1(null);
					  animation.fadeOut2(null);
					  
				  }else if (touch5)	{
					  touch5 = false;
					  endGame1 = false;
					  instructionsMoveBall = true;
					  scoreRemember = 1;
					  touchCircles = 1;
					  touchScreen = false;
					  
					  makeFlash = true;
					  animation.fadeOut1(null);
					  animation.fadeOut2(null);
				  
				  }else if (touch6)	{
					  touch6 = false;
					  
					  MainActivity.touchToStart.setVisibility(View.INVISIBLE);
					  MainActivity.continueInstructionsText.setVisibility(View.INVISIBLE);
					  
					  shrinkInstructions = true;
					  doInstructionsImplode = true;
					  
					  MainActivity.touchToStart.setVisibility(View.INVISIBLE);
					  MainActivity.startMnuAnimate.setBackgroundColor(Color.TRANSPARENT);
					  
					  MainActivity.spotX = MovingBalls.x; 
					  MainActivity.spotY = MovingBalls.y;
					  
					  MainActivity.num1.clearAnimation();
					  
					  handler1.removeCallbacks(runnables.instructions4);
					  handler1.removeCallbacks(runnables.instructions5);
					  handler1.removeCallbacks(runnables.instructions6);

				  }
				  
				  if (touchScreen)	{
					  
				      handler15.postDelayed(runnables.runnable9, 0);

				      touchX = evt.getX();
				      touchY = evt.getY();
				      touchScreen = false;
				      
					  doTargetMove = true;
				      initiateTargetMove = true;
				      
				      if (touchCircles == 1)	{
				      		
				      		MainActivity.num1.setEnabled(true);
				      		MainActivity.num1.setClickable(false);

				      }
				  }		
			  
			  }else{
			  
			  if (startGame) {	

				    if (MainActivity.musicSoundOn && MainActivity.startUpDone)	{
				    	MainActivity.menuMusic.reset();
				    	gameMusic();
				  	}
		    		startMenu = false;
		    		startGame = false;
					MainActivity.redo = false;
					
					MainActivity.startMenu.setVisibility(View.INVISIBLE);
					MainActivity.startMnuAnimate.setBackgroundColor(Color.TRANSPARENT);
					MainActivity.continueInstructionsText.setVisibility(View.INVISIBLE);
					
		    		MainActivity.Redo.setEnabled(true);
		    		
					MainActivity.backPressGame = 2;
															
				}else if (touchScreen && over == false){
			  
					handler16.postDelayed(runnableClass.runnable9, 0);
					
					touchX = evt.getX();
			      	touchY = evt.getY();
			      	touchCircles++;
			      	touchScreen = false;
			      				      	
			      	if (touchCircles == 1)	{
			      		
			      		MainActivity.num1.setEnabled(true);

						
			      	}else if (touchCircles == 2)	{
			      		
			      		MainActivity.num1.setEnabled(false);
						MainActivity.num2.setEnabled(true);

						
			      	}else if (touchCircles == 3)	{
			      		
			      		MainActivity.num2.setEnabled(false);
						MainActivity.num3.setEnabled(true);

						
			      	}else if (touchCircles == 4)	{
			      		
			      		MainActivity.num3.setEnabled(false);
						MainActivity.num4.setEnabled(true);

						
			      	}else if (touchCircles == 5)	{
			      		
			      		MainActivity.num4.setEnabled(false);
						
			      	}
			      				      
			      	if (doTargetMove)	{
			      		doTargetMove2 = true;
			      		initiateTargetMove2 = true;
			      	
			      	if (touchCircles == 5 && doTargetMove)
					  endGameTarget2 = true;
	
			      }	else	{
				  
			    	  doTargetMove = true;
			    	  initiateTargetMove = true;
			  }		      		      
			      if (touchCircles == 5)
			    	  endGameTarget = true;
					}
		    }
		  }
		  return true;
		  }
	  
  public void innerCircle(Canvas canvas)	{
	  
	  
	  Matrix matrix = new Matrix();


			  if (switchRotation)
				  rotation -= 10;
			  else
				  rotation += 10;
		  
	    	double px = MovingBalls.x;
			double py = MovingBalls.y;
	    	
		  matrix.postTranslate(-resizedIn.getWidth()/2, -resizedIn.getHeight()/2);
		  matrix.postRotate(rotation);
		  matrix.postTranslate((float)px, (float)py);
		  canvas.drawBitmap(resizedIn, matrix, null);
		  
	  }
  
  
  
	  public void outerCircle(Canvas canvas)	{		  
		  
		  Matrix matrix = new Matrix();
		  		  
			  if (switchRotation)
				  rotation1 += 5;
			  else
				  rotation1 -= 5;
		  
		  double px = MovingBalls.x;
		  double py = MovingBalls.y;
		  
		  matrix.postTranslate(-resizedOut.getWidth()/2, -resizedOut.getHeight()/2);
		  matrix.postRotate(rotation1);
		  matrix.postTranslate((float)px, (float)py);
		  canvas.drawBitmap(resizedOut, matrix, null);
		  
	  }
	  
	  
	  public void doInitiateMoveTarget(Canvas canvas)	{
		  
		  initiateTargetMove = false;
		  
		  targetBall = new MovingBallsTarget(0, getWidth(), 0, getHeight());
		  		  
		  targetBall.headTowards(flashX, flashY);
		  
		  canvas.drawBitmap(resizedTarget, (float)(MovingBallsTarget.x) - wTargetHalf, (float)MovingBallsTarget.y - hTargetHalf, null);
		  
	  }
	  
	  
	  public void doMoveTarget( Canvas canvas)	{
		  
		  		  
		  
		  targetBall.headTowards(flashX, flashY);
		  
		  targetBall.travel();
		  targetBall.draw(canvas);

		  if (targetStop == false){
			  num += 10;
			  numScore += 10;
			  
		  if (scoreRemember == 1) {
			  MainActivity.num1.setText(num + "");
			  MainActivity.numHS.setText(numScore + "");
		    		
		  }	else if (scoreRemember == 2) {
			  MainActivity.num2.setText(num + "");
			  MainActivity.numHS.setText(numScore + "");

		  } else if (scoreRemember == 3) {
			  MainActivity.num3.setText(num + "");
			  MainActivity.numHS.setText(numScore + "");

		  } else if (scoreRemember == 4) {
			  MainActivity.num4.setText(num + "");
			  MainActivity.numHS.setText(numScore + "");

		  } else if (scoreRemember == 5) {
			  MainActivity.num5.setText(num + "");
			  MainActivity.numHS.setText(numScore + "");

		    }
		  }
		  
		  
		  
		  canvas.drawBitmap(resizedTarget, (float)(MovingBallsTarget.x) - wTargetHalf, (float)MovingBallsTarget.y - hTargetHalf, null);
		  
	  }
	  
	  
	  public void doTargetRotate( Canvas canvas)	{
		  
		  
		  		  
		  Matrix matrix = new Matrix();
		  
		  if (targetRotatesDone <= 10)	{
			  targetRotatesDone++;
			  		  
			  rotateTarget -= 10;
			  
			  matrix.postTranslate(-resizedTarget.getWidth()/2, -resizedTarget.getHeight()/2);
			  matrix.postRotate(rotateTarget);
			  matrix.postTranslate((float)flashX, (float)flashY);
			  canvas.drawBitmap(resizedTarget, matrix, null);
			  
		  } else	{
			  targetRotatesDone++;
	  		  
			  rotateTarget += 10;

			  matrix.postTranslate(-resizedTarget.getWidth()/2, -resizedTarget.getHeight()/2);
			  matrix.postRotate(rotateTarget);
			  matrix.postTranslate((float)flashX, (float)flashY);
			  canvas.drawBitmap(resizedTarget, matrix, null);
		  
		  }
	  }
	  
	  
	  public void doTargetShrink( Canvas canvas)	{
  		  		  
		  if (g1 == 0)	{
			  
			  circleHeight1 = getWidth() / 12;
			  circleWidth1 = getWidth() / 12;
			  
			  X = 0;
			  Y = 0;

		  }
		  
		  g1 = 1;
		  
		  if ((circleHeight1 >= getWidth() / 15 || circleWidth1 >= getWidth() / 15))		{
			  
			  circleHeight1 -= 4;
			  circleWidth1 -= 4;
			  
			  Bitmap resized = Bitmap.createScaledBitmap(target, circleWidth1, circleHeight1, true);
			  
			  Matrix matrix = new Matrix();
			  
			   X -= 0.1; // if 1, the image would shrink into the bottom right corner.
			   Y -= 0.1; // the 0.5 evens it out so it shrinks into the center
			  		  
			  double px = (flashX ) + X; // in brackets is to prevent the image from moving so that
			  double py = (flashY ) + Y;	//the left corner of it is where the center of the image
			  										//used to be. the variable after is to make it shrink in
			  										//the middle, not into the left corner
			  
			  matrix.postTranslate(-resized.getWidth()/2, -resized.getHeight()/2);
			  matrix.postTranslate((float)px, (float)py);
			  canvas.drawBitmap(resized, matrix, null);
			  
		  }  else	{
			  
			  target1Freeze++;
			  
			  Bitmap resized = Bitmap.createScaledBitmap(target, circleWidth1, circleHeight1, true);
			  
			  Matrix matrix = new Matrix();

			  double px = (flashX ) + X;
			  double py = (flashY ) + Y;
			  
			  matrix.postTranslate(-resized.getWidth()/2, -resized.getHeight()/2);
			  matrix.postTranslate((float)px, (float)py);
			  canvas.drawBitmap(resized, matrix, null);
		  }
		  
	  }
	  
	  
	  
	  
	  public void doInitiateMoveTarget2(Canvas canvas)	{
		  		  
		  initiateTargetMove2 = false;

		  targetBall2 = new MovingBallsTarget2(0, getWidth(), 0, getHeight());
		  		  
		  targetBall2.headTowards(flashX2, flashY2);
		  		  		  
		  canvas.drawBitmap(resizedTarget2, (float)(MovingBallsTarget2.x) - wTargetHalf2, (float)MovingBallsTarget2.y - hTargetHalf2, null);
		  
	  }
	  
	  
	  public void doMoveTarget2( Canvas canvas)	{
		  
		  targetBall2.travel();
		  targetBall2.draw(canvas);
		  
		  if (targetStop2 == false){
			  num2 += 10;
			  numScore += 10;
			  
		  if (scoreRemember2 == 1) {
			  MainActivity.num1.setText(num2 + "");
			  MainActivity.numHS.setText(numScore + "");

		  }	else if (scoreRemember2 == 2) {
			  MainActivity.num2.setText(num2 + "");
			  MainActivity.numHS.setText(numScore + "");

		  } else if (scoreRemember2 == 3) {
			  MainActivity.num3.setText(num2 + "");
			  MainActivity.numHS.setText(numScore + "");

		  } else if (scoreRemember2 == 4) {
			  MainActivity.num4.setText(num2 + "");
			  MainActivity.numHS.setText(numScore + "");

		  } else if (scoreRemember2 == 5) {
			  MainActivity.num5.setText(num2+ "");
			  MainActivity.numHS.setText(numScore + "");

		  }
		    }
		  
		  canvas.drawBitmap(resizedTarget2, (float)(MovingBallsTarget2.x) - wTargetHalf2, (float)MovingBallsTarget2.y - hTargetHalf2, null);
		  
	  }
	  
	  
	  public void doTargetRotate2( Canvas canvas)	{
		  
		  
		  Matrix matrix = new Matrix();
		  
		  if (targetRotatesDone2 <= 10)	{
			  targetRotatesDone2++;
			  		  
			  rotateTarget2 -= 10;
			  
			  matrix.postTranslate(-resizedTarget2.getWidth()/2, -resizedTarget2.getHeight()/2);
			  matrix.postRotate(rotateTarget2);
			  matrix.postTranslate((float)flashX2, (float)flashY2);
			  canvas.drawBitmap(resizedTarget2, matrix, null);
			  
		  } else	{
			  targetRotatesDone2++;
	  		  
			  rotateTarget2 += 10;

			  matrix.postTranslate(-resizedTarget2.getWidth()/2, -resizedTarget2.getHeight()/2);
			  matrix.postRotate(rotateTarget2);
			  matrix.postTranslate((float)flashX2, (float)flashY2);
			  canvas.drawBitmap(resizedTarget2, matrix, null);
		  
		  }
	  }
	  
	  
	  public void doTargetShrink2( Canvas canvas)	{
  		  
		  Bitmap circle =  BitmapFactory.decodeResource(getResources(), R.drawable.target_improved_2);
		  
		  if (g2 == 0)	{
			  
			  circleHeight2 = getWidth() / 12;
			  circleWidth2 = getWidth() / 12;
			  
			  X3 = 0;
			  Y3 = 0;

		  }
		  
		  g2 = 1;
		  
		  if ((circleHeight2 >= getWidth() / 15 || circleWidth2 >= getWidth() / 15))		{
			  
			  circleHeight2 -= 4;
			  circleWidth2 -= 4;
			  
			  Bitmap resized = Bitmap.createScaledBitmap(circle, circleWidth2, circleHeight2, true);
			  
			  Matrix matrix = new Matrix();
			  
			   X3 -= 0.1; // if 1, the image would shrink into the bottom right corner.
			   Y3 -= 0.1; // the 0.5 evens it out so it shrinks into the center
			  		  
			  double px = (flashX2 ) + X3; // in brackets is to prevent the image from moving so that
			  double py = (flashY2 ) + Y3;	//the left corner of it is where the center of the image
			  										//used to be. the variable after is to make it shrink in
			  										//the middle, not into the left corner
			  
			  matrix.postTranslate(-resized.getWidth()/2, -resized.getHeight()/2);
			  matrix.postTranslate((float)px, (float)py);
			  canvas.drawBitmap(resized, matrix, null);
			  
		  }  else	{
			  
			  target2Freeze++;
			  
			  Bitmap resized = Bitmap.createScaledBitmap(circle, circleWidth2, circleHeight2, true);
			  
			  Matrix matrix = new Matrix();

			  double px = (flashX2 ) + X3;
			  double py = (flashY2 ) + Y3;
			  
			  matrix.postTranslate(-resized.getWidth()/2, -resized.getHeight()/2);
			  matrix.postTranslate((float)px, (float)py);
			  canvas.drawBitmap(resized, matrix, null);
		  }
	  }
	}
