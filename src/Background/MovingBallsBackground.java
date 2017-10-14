package Background;

import flash.point.flashpoint.MainActivity;
import flash.point.flashpoint.R;
import game.Drawing;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.MediaPlayer;


	/**
	 * An object of type MovingBall holds data about a "ball" that has
	 * a color, radius, position, speed, and direction.  The ball is restricted
	 * to moving around inside a rectangle in the xy-plane.  The ball can draw
	 * itself in a graphics context and will move when it is told to move.
	 * This class uses some trigonometry and vector math in its implementation.
	 */

	public class MovingBallsBackground  {

	   private double xmin, xmax;  // The horizontal limits on the ball's position.
	                               //    The x-coordinate of the ball satisfies
	                               //    xmin <= x <= xmax.
	                               
	   public static double ymin, ymax;  // The vertical limits on the ball's position.
	                               //    The y-coordinate of the ball satisfies
	                               //    ymin <= y <= ymax.
	   
	   double x,y;      // Current position of the ball.
	   
	   private double dx,dy;    // The velocity (speed + direction) of the ball.
	                            //   When the travel() method is called, the
	                            //   ball moves dx pixels horizontally and dy
	                            //   pixels vertically.
	   
	   static double radius;   // The radius of the ball.
	   public static double middleX, middleY;
	   static boolean smallBall;
	   double speed;
	   
	   double r, rSmall, r2;
	   
	   MainActivity main;

		static double radiusBlack;
		static double radiusWhite;
		static double radiusWhiteSmall;

		BackgroundCircleBounce background;
		
		double shrink;
	   /**
	    * Create a ball that moves within the specified limits,
	    * left <= x <= right and top <= y <= bottom.  The ball is initially
	    * located in the middle of this range.  It has a random speed
	    * between 4 and 12 and a random direction.  Its radius is 5
	    * and its color is red.
	    */
	   public MovingBallsBackground(double left, double right, double top, double bottom, double X, double Y) {
		   
		   double width = right;
		   		   
	      xmin = left;
	      xmax = right;
	      ymin = top;
	      ymax = bottom;
	      x = X;
		  y = Y;
	      radius = width / 35;
	      double angle = 2 * Math.PI * Math.random();  // Random direction.
	      speed = width / 128;          // Random speed.
	      dx = Math.cos(angle) * speed;
	      dy = Math.sin(angle) * speed;
	      
	      middleX = (xmin + xmax) / 2;
		  middleY = (ymin + ymax) / 2;
		  
		  main = new MainActivity();
		  
		  shrink = width / 10000;
		  
		  radiusBlack = radius - (radius / 5);
		  radiusWhite = radius;
		  radiusWhiteSmall = radius - (radius / 3);
	   }
	   

	   /**
	    * Draw the ball in the graphics context g.  Note: The drawing color
	    * in g is changed to the color of the ball.
	    * 
	    */
	   public void draw(Canvas canvas) {
		  
		   ShapeDrawable shape = new ShapeDrawable(new OvalShape());
		    shape.setBounds((int)(1), (int)(1), (int)(1), (int)(1));
		    		    
		    shape.draw(canvas);
		   
	   }
	   
	   public void drawBlack(Canvas canvas) {
		   
		   if (BackgroundCircleBounce.middle)			   
			   radiusBlack -= shrink;
		   
		   if (radiusBlack < 6)
			   radiusBlack = 6;
		   
		    ShapeDrawable shape = new ShapeDrawable(new OvalShape());
		    shape.getPaint().setColor(Color.rgb(51, 51, 51));
		    shape.setBounds((int)(x- radiusBlack), (int)(y-radiusBlack), (int)(x+radiusBlack), (int)(y+radiusBlack));

		    shape.draw(canvas);
		    
		    ShapeDrawable shape1 = new ShapeDrawable(new OvalShape());
		    shape1.setBounds((int)(x-40), (int)(y-40), (int)(x+40), (int)(y+40));
		    		    		    
		    
		    double s = 0;
			   			   
			  
					s = MainActivity.gameScoresLayout.getHeight() / 2;

				   if (MainActivity.showAd == false)	{
					    if (shape1.getBounds().contains((int)middleX , (int)(((ymax - MainActivity.gameScoresLayout.getHeight()) / 2))) && BackgroundCircleBounce.middle)	{
					    	BackgroundCircleBounce.ballsBlack.remove(BackgroundCircleBounce.count);
					    	BackgroundCircleBounce.countGoneBlack++;		    	
				    }
				    }else	{
				    	if (shape1.getBounds().contains((int)middleX , (int)(middleY - s)) && BackgroundCircleBounce.middle)	{
					    	BackgroundCircleBounce.ballsBlack.remove(BackgroundCircleBounce.count);
					    	BackgroundCircleBounce.countGoneBlack++;
				    	}
				    
			   }
		    
		    
	   }
	   
	   public void drawWhite(Canvas canvas) {
		   
		   if (smallBall)	{
		   
		   if (BackgroundCircleBounce.middle)	
			   radiusWhiteSmall -= shrink;
		   
		   if (radiusWhiteSmall < 6)
			   radiusWhiteSmall = 6;
			   
			   ShapeDrawable shape = new ShapeDrawable(new OvalShape());
			    shape.getPaint().setColor(Color.WHITE);
			    shape.setBounds((int)(x-radiusWhiteSmall), (int)(y-radiusWhiteSmall), (int)(x+radiusWhiteSmall), (int)(y+radiusWhiteSmall));
			    shape.draw(canvas);
			    
		   }    else	{
			   
			   if (BackgroundCircleBounce.middle)	
				   radiusWhite -= shrink;
			   
			   if (radiusWhite < 6)
				   radiusWhite = 6;
			   
			   	ShapeDrawable shape = new ShapeDrawable(new OvalShape());
			    shape.getPaint().setColor(Color.WHITE);
			    shape.setBounds((int)(x-radiusWhite), (int)(y-radiusWhite), (int)(x+radiusWhite), (int)(y+radiusWhite));
			    shape.draw(canvas);
			   
		   }
		   
		    ShapeDrawable shape1 = new ShapeDrawable(new OvalShape());
		    shape1.setBounds((int)(x-40), (int)(y-40), (int)(x+40), (int)(y+40));
		    
		    double s = 0;
			   		    
			 
				   
					s = MainActivity.gameScoresLayout.getHeight() / 2;
				   
				   if (MainActivity.showAd == false)	{
					    if (shape1.getBounds().contains((int)middleX , (int)(((ymax - MainActivity.gameScoresLayout.getHeight()) / 2))) && BackgroundCircleBounce.middle)	{
					    	BackgroundCircleBounce.ballsWhite.remove(BackgroundCircleBounce.count2);
					    	BackgroundCircleBounce.countGoneWhite++;		    	
				    }
				    }else	{
				    	if (shape1.getBounds().contains((int)middleX , (int)(middleY - s)) && BackgroundCircleBounce.middle)	{
					    	BackgroundCircleBounce.ballsWhite.remove(BackgroundCircleBounce.count2);
					    	BackgroundCircleBounce.countGoneWhite++;
				    	}
			   }			
	   }
	   
	   /**
	    * Move the ball by one time unit.  The ball moves in its current
	    * direction for a number of pixels equal to its current speed.
	    * That is, speed is given in terms of pixels per time unit.
	    * Note:  The ball won't move at all if the width or height
	    * of the rectangle is smaller than the ball's diameter.
	    */
	   public void travel() {
	      travel(1.0);
	   }
	   
	   
	   /**
	    * Move the ball for the specified number of time units.
	    * The ball is restricted to the specified rectangle.
	    * Note:  The ball won't move at all if the width or height
	    * of the rectangle is smaller than the ball's diameter.
	    */
	   public void travel(double time) {
	          
	      /* Don't do anything if the rectangle is too small. */
	          
	      if (xmax - xmin < 2*radius || ymax - ymin < 2*radius)
	         return;

	      /* First, if the ball has gotten outside its rectangle, move it
	         back.  (This will only happen if the rectangle was changed
	         by calling the setLimits() method or if the position of 
	         the ball was changed by calling the setLocation() method.)
	      */
	      
	      if (x-radius < xmin)
	         x = xmin + radius;
	      else if (x+radius > xmax)
	         x = xmax - radius;
	      if (y - radius < ymin)
	         y = ymin + radius;
	      else if (y + radius > ymax)
	         y = ymax - radius;
	         
	      /* Compute the new position, possibly outside the rectangle. */
	         
	      double newx = x + dx*time;
	      double newy = y + dy*time;
	      
	      /* If the new position lies beyond one of the sides of the rectangle,
	         "reflect" the new point through the side of the rectangle, so it
	         lies within the rectangle. */
	      
	      if (newy < ymin + radius) {
	         newy = 2*(ymin+radius) - newy;
	         dy = Math.abs(dy);
	         
	        	 
	 //       	 if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	
	//	        	 ballBounceMusic1.start(); 
	      }
	      else if (newy > ymax - radius) {
	         newy = 2*(ymax-radius) - newy;
	         dy = -Math.abs(dy);
	         
	        	 
	//        	 if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	
	//	        	 ballBounceMusic2.start(); 
	      }
	      if (newx < xmin + radius) {
	         newx = 2*(xmin+radius) - newx;
	         dx = Math.abs(dx);
	         
	 //        if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	
	 //       	 ballBounceMusic3.start(); 
	         
	      }
	      else if (newx > xmax - radius) {
	         newx = 2*(xmax-radius) - newx;
	         dx = -Math.abs(dx);
	         
	 //        if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)	
	  //      	 ballBounceMusic4.start();    	

	         
	      }
	      
	      /* We have the new values for x and y. */
	      
	      x = newx;
	      y = newy;
	      
	   } // end travel()
	   
	   
	   /**
	    * Set the radius of the ball.  Adjust the radius, if necessary,
	    * so the diameter of the ball is at least one pixel.
	    */
	   public void setRadius(int r) {
	      radius = r;
	      if (radius < 6)
	         radius = 6;		// may need to change
	   }
	   

	   /**
	    * Set the horizontal and vertical limits on the motion of the ball.
	    */
	   public void setLimits(double left, double right, double top, double bottom) {
	      xmin = left;
	      xmax = right;
	      ymin = top;
	      ymax = bottom;
	   }
	   

	   /**
	    * Set the position of the ball.
	    */
	   public void setLocation(double x, double y) {
	      this.x = x;
	      this.y = y;
	   }
	   

	   /**
	    * Set the speed of the ball, if speed > 0.  The speed is
	    * restricted to being strictly positive.  (If you want the
	    * ball to stay still, don't call the travel() method!)
	    */
	   public void setSpeed(double speed) {
	      if (speed > 0) {
	          double currentSpeed = Math.sqrt(dx*dx + dy*dy);
	          dx = dx * speed / currentSpeed;
	          dy = dy * speed / currentSpeed;
	      }
	   }
	   

	   /**
	    * Adjust the direction of motion of the ball so that it is
	    * headed towards the point (a,b).  If the ball happens to
	    * lie exactly at the point (a,b) already, this operation is
	    * undefined, so nothing is done.
	    */
	   public void headTowards(double d, double e) {
	      double vx = d - x;
	      double vy = e - y;
	      double dist = Math.sqrt(vx*vx + vy*vy);
	      if (dist > 0) {
	         double speed = Math.sqrt(dx*dx + dy*dy);
	         dx = vx / dist * speed;
	         dy = vy / dist * speed;
	      }
	   }
	   

	   /**
	    * Set the velocity of the ball.  At least one of dx and
	    * dy must be non-zero, so that the speed will be positive.
	    */
	   public void setVelocity(double dx, double dy) {
	      if (dx != 0 || dy != 0) {
	         this.dx = dx;
	         this.dy = dy;
	      }
	   }
	   

	}  // end class MovingBall

