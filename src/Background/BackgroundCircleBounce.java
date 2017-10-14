package Background;

import java.util.ArrayList;

import flash.point.flashpoint.MainActivity;
import flash.point.flashpoint.R;
import game.Drawing;
import game.MovingBalls;
import Animation.animation;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.ShapeDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class BackgroundCircleBounce extends View	{
	
	static int middleX;
	static int middleY;
	static int count, count2;
	
	static boolean middle = false;
	public static boolean over;
	
	float rotation, rotation1;
	
	int circleWidth, circleHeight, circleWidth1, circleHeight1;
	  public static int g = 0;
	int g1 = 0;
	  
	  static Bitmap circleIn;
	  	  
	  static int countGoneWhite, countGoneBlack;
	  
	  public static boolean background1, background2, background3;
	  

	static ArrayList<MovingBallsBackground> ballsBlack = new ArrayList<MovingBallsBackground>();
	static ArrayList<MovingBallsBackground> ballsWhite = new ArrayList<MovingBallsBackground>();
	static ArrayList<Double> shrinkBlack = new ArrayList<Double>();
	static ArrayList<Double> shrinkWhite = new ArrayList<Double>();


	 	 
	 static double distanceShrink;
	 
	 static MainActivity main = new MainActivity();
	 
	 boolean shrinkArryayBlack, shrinkArryayWhite;
	 
	 static double height;
	 
	  Bitmap circleAllGrow;

	public BackgroundCircleBounce(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public BackgroundCircleBounce(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void test()	{
		  
		  middleX = getWidth() / 2;
	    	middleY = getHeight() / 2;
	    	
	    	height = getHeight();
		  
		  
	  }
	
	  public void onDraw(Canvas canvas)		{
	    super.onDraw(canvas);
	    
	    middleX = getWidth() / 2;
    	middleY = getHeight() / 2;
    	
    	height = getHeight();
	    
		if (MainActivity.newBackground)	{
			MainActivity.newBackground = false;
												  
		    switch ((int)(3 * Math.random()))	{
		     
		    case 0:
		    	background1 = true;
		      break;
		      
		    case 1:
		    	background2 = true;
		      break;
		      
		    case 2:
		    	background3 = true;
		      break;    
	    
		}
		}
		
		if (background1)
		    setBackgroundResource(R.drawable.game_background);
		
		else if (background2)
		    setBackgroundResource(R.drawable.game_background1);
		
		else if (background3)
		    setBackgroundResource(R.drawable.game_background2);
		
	    if (over)	{
	    	
			  int h = getWidth() / 10; 
			  int w = getWidth() / 10;
			  			  
			  doGrow(canvas);
			  
			  if (circleHeight >= h || circleWidth >= w)	{
				  
				  ballsBlack.removeAll(ballsBlack);
				  ballsWhite.removeAll(ballsWhite);
				  
				  shrinkBlack.removeAll(shrinkBlack);
				  shrinkWhite.removeAll(shrinkWhite);

				  test();
				  
				  middle = false;
				  over = false;
				  countGoneWhite = 0;
				  countGoneBlack = 0;
				  g = 0;
				  g1 = 0;
				  count = 0;
				  count2 = 0;
				  
				  shrinkArryayBlack = false;
				  shrinkArryayWhite = false;
				  
				  MovingBallsBackground.radiusBlack = MovingBallsBackground.radius - (MovingBallsBackground.radius / 5);
				  MovingBallsBackground.radiusWhite = MovingBallsBackground.radius;
				  MovingBallsBackground.radiusWhiteSmall = MovingBallsBackground.radius - (MovingBallsBackground.radius / 3);
				  				  
				  MainActivity.growFixApp = false;
				  
				  main.doNewGame();				  
				  
			  }
	    		    	
	 }	else	{
	    	
		 if (main.Start)	{	// only used so when game first starts, the balls appear.
			 
			 test();
			 newBallWhite();
			 newBallBlack();
			 main.Start = false;
		 }
		 
		    	moveBallWhite(canvas);
		    	moveBallBlack(canvas);

		    
		    if (countGoneWhite > 8 && countGoneBlack > 5)	{
		    	over = true;
				animation.fadeIn3(null);
				MainActivity.growFixApp = true;
		    }
		 		}
		    invalidate();
	  }
	  
	  
	  public void doGrow(Canvas canvas)	{
		  		  
		  if (MainActivity.redo)	{
			  circleHeight += 4;
			  circleWidth += 4;
			  
		  }else{
			  circleHeight += 2;
			  circleWidth += 2;
			  
		  }

		  if (g == 0)	{
			  
			  circleHeight = 1;
			  circleWidth = 1;
			  
			  if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
				   MainActivity.ballGrow.start();
			  
		  }
		  g = 1;
		  
		  circleAllGrow =  BitmapFactory.decodeResource(getResources(), R.drawable.circle_all_good);
		  
		  Bitmap resizedGrowCircle = Bitmap.createScaledBitmap(circleAllGrow, circleWidth, circleHeight, true);

		  Matrix matrix = new Matrix();
		  
		  double x = resizedGrowCircle.getWidth() / 2; // allows the circle to appear as if its 
		  double y = resizedGrowCircle.getHeight() / 2;// growing from the center out
		  
		   double px = middleX - x;
		   double py = 0;
		   		   
		   
			   if (MainActivity.showAd == false)	
				   py = ((height - MainActivity.gameScoresLayout.getHeight()) / 2) - y;
			   else
				   py = ((height - MainActivity.gameScoresLayout.getHeight()) / 2) - y;
			   
		   
		   
		   matrix.postTranslate((float)px, (float)py);	// with the x and y variables, the left corner would
		   canvas.drawBitmap(resizedGrowCircle, matrix, null);     // be at the center of the screen
		   
		  
	  }
	  
	  
	  
	  public void moveBallBlack(Canvas canvas)		{
		  
		  if (ballsBlack.size() > 0)	{

		  					
			for (count = 0; count < ballsBlack.size(); count++)		{
								
				ballsBlack.get(count).travel();
				ballsBlack.get(count).drawBlack(canvas);
			
			}
			
			}
		  if (middle)
			  shrinkArryayBlack = true;

	  }
	  
	  public void moveBallWhite(Canvas canvas)		{		  
					
		  if (ballsWhite.size() > 0)	{
		  
			for (count2 = 0; count2 < ballsWhite.size(); count2++)		{
				
				 if (count2 == 8)
					  MovingBallsBackground.smallBall = true;

				ballsWhite.get(count2).travel();
				ballsWhite.get(count2).drawWhite(canvas);
				
			}
		}
		  if (middle)
			  shrinkArryayWhite = true;
		  
		  MovingBallsBackground.smallBall = false;

	 }
	  
	 
	  public static void formBall()	{
		  		  
		  double s = 0;
		   		  
		  for (int j = 0; j < ballsWhite.size(); j++)	{
			  
			  
				   s = MainActivity.gameScoresLayout.getHeight() / 2;
				  
				  if (MainActivity.showAd == false)			  
					  ballsWhite.get(j).headTowards(MovingBallsBackground.middleX
						  ,((height - MainActivity.gameScoresLayout.getHeight()) / 2));
			 	else
			 			ballsWhite.get(j).headTowards(MovingBallsBackground.middleX
						  ,MovingBallsBackground.middleY - s);
			  
			  	 
}
		  
		  for (int k = 0; k < ballsBlack.size(); k++)	{
			  
			 
				   s = MainActivity.gameScoresLayout.getHeight() / 2;
				  
				  if (MainActivity.showAd == false)			  
					  ballsBlack.get(k).headTowards(MovingBallsBackground.middleX
						  ,((height - MainActivity.gameScoresLayout.getHeight()) / 2));
			 	else
			 		ballsBlack.get(k).headTowards(MovingBallsBackground.middleX
						  ,MovingBallsBackground.middleY - s);
			  
			  }		

		  middle = true;
		  
		  
	  }

	  public static void newBallWhite()	{
		  								  
			  for (int count = 0; count < 9; count++)		{
				  
				  
				  if (MainActivity.spotX == 0 && MainActivity.spotY == 0)	{
					  MainActivity.spotX = middleX;
					  MainActivity.spotY = middleY;
					  
				  }
				  
				  
				  if (count == 8)
					  MovingBallsBackground.smallBall = true;

					  ballsWhite.add(new MovingBallsBackground( 0, middleX * 2, 0, middleY * 2 , MainActivity.spotX, MainActivity.spotY));

				  
			  }
			  				  
	  }
	  public static void newBallBlack()	{		  
				
			  for (int count = 0; count < 6; count++)		{
				  
				  
				  if (MainActivity.spotX == 0 && MainActivity.spotY == 0)	{
					  MainActivity.spotX = middleX;
					  MainActivity.spotY = middleY;
					  
				  }

					  ballsBlack.add(new MovingBallsBackground( 0, middleX * 2, 0, middleY * 2 , MainActivity.spotX, MainActivity.spotY));
			  }
			  }		  
	  	  }
	  
	  
	 

