package flash.point.flashpoint;

import Background.BackgroundCircleBounce;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import flash.point.flashpoint.R;

public class StartMenu extends View	{
  

  static int height;
  static int width;
  float rotation, rotation1;
  
  
  public StartMenu(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
  
  public StartMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
  
  
	  public void onDraw(Canvas canvas)		{
	    super.onDraw(canvas);

		if (BackgroundCircleBounce.background1)
		    setBackgroundResource(R.drawable.game_background);
		
		else if (BackgroundCircleBounce.background2)
		    setBackgroundResource(R.drawable.game_background1);
		
		else if (BackgroundCircleBounce.background3)
		    setBackgroundResource(R.drawable.game_background2);
		
		
		width = getWidth();
	    height = getHeight();
	   
	    innerCircle(canvas);
	    outerCircle(canvas);
	   
	    invalidate();
	  }
 public void innerCircle(Canvas canvas)	{
		  
		  Bitmap circle =  BitmapFactory.decodeResource(getResources(), R.drawable.circle_in_good);
		  
		  int w = getWidth() / 24;
		  int h = getWidth() / 24;
		  
		  Bitmap resized = Bitmap.createScaledBitmap(circle, w, h, true);

		  Matrix matrix = new Matrix();
		  		  
		  rotation += 10;
		  double px = getWidth() / 2;
		  double py = getHeight() / 2;
		  matrix.postTranslate(-resized.getWidth()/2, -resized.getHeight()/2);
		  matrix.postRotate(rotation);
		  matrix.postTranslate((float)px, (float)py);
		  canvas.drawBitmap(resized, matrix, null);
		  
		 
	  }
	  
public void outerCircle(Canvas canvas)	{
		  
		  Bitmap circle =  BitmapFactory.decodeResource(getResources(), R.drawable.circle_out_good);
		  
		  int w = getWidth() / 12;
		  int h = getWidth() / 12;
		  
		  Bitmap resized = Bitmap.createScaledBitmap(circle, w, h, true);

		  Matrix matrix = new Matrix();
		  		  
		  rotation1 -= 5;
		  double px = getWidth() / 2;
		  double py = getHeight() / 2;
		  matrix.postTranslate(-resized.getWidth()/2, -resized.getHeight()/2);
		  matrix.postRotate(rotation1);
		  matrix.postTranslate((float)px, (float)py);
		  canvas.drawBitmap(resized, matrix, null);
		  
		 
	  }
	}
