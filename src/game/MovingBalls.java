package game;

import java.io.IOException;

import flash.point.flashpoint.MainActivity;
import flash.point.flashpoint.R;
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

	public class MovingBalls  {

	   private double xmin, xmax;  // The horizontal limits on the ball's position.
	                               //    The x-coordinate of the ball satisfies
	                               //    xmin <= x <= xmax.
	                               
	   public static double ymin, ymax;  // The vertical limits on the ball's position.
	                               //    The y-coordinate of the ball satisfies
	                               //    ymin <= y <= ymax.
	   
	   public static double x;      // Current position of the ball.

	public static double y;
	   
	   private static double dx,dy;    // The velocity (speed + direction) of the ball.
	                            //   When the travel() method is called, the
	                            //   ball moves dx pixels horizontally and dy
	                            //   pixels vertically.
	   
	   private double radius;   // The radius of the ball.
	   public static double middleX;

	   public static double middleY;
	   static boolean smallBall;
	   static double speed;
	   
	   MainActivity main;

	   MediaPlayer ballBounceMusic;
	   MediaPlayer ballBounceMusic1;

	   Context context;

	   /**
	    * Create a ball that moves within the specified limits,
	    * left <= x <= right and top <= y <= bottom.  The ball is initially
	    * located in the middle of this range.  It has a random speed
	    * between 4 and 12 and a random direction.  Its radius is 5
	    * and its color is red.
	    */
	   public MovingBalls(double left, double right, double top, double bottom) {
		   
		   double width = right;
		   
	      xmin = left;
	      xmax = right;
	      ymin = top;
	      ymax = bottom;
	      x = (xmin + xmax) / 2;
	      y = (ymin + ymax) / 2;
	      radius = width / 24;
	      double angle = 2 * Math.PI * Math.random();  // Random direction.
	      speed = width / 128;          // Random speed.
	      dx = Math.cos(angle) * speed;
	      dy = Math.sin(angle) * speed;
	      middleX = x;
		  middleY = y;
		  
		  main = new MainActivity();
		  
		  context = MainActivity.draw.getContext();
		  
		   ballBounceMusic1 = MediaPlayer.create(context, R.raw.balls_bouncing_quiet2);	
		   ballBounceMusic = MediaPlayer.create(context, R.raw.balls_bouncing_quiet);	

		  }
	   

	   /**
	    * Draw the ball in the graphics context g.  Note: The drawing color
	    * in g is changed to the color of the ball.
	    * 
	    */
	   public void draw(Canvas canvas) {
		   		   
		   ShapeDrawable shape = new ShapeDrawable(new OvalShape());
		    shape.getPaint().setColor(Color.rgb(50, 50, 50));
		    shape.setBounds((int)(x-radius), (int)(y-radius), (int)(x+radius), (int)(y+radius));
		    
		    if (shape.getBounds().contains((int)middleX, (int)middleY) && MainActivity.redo)	{
		    	main.doNewGame();
		    }
//		    main.spotX = x;
	//		  main.spotY = y;
		    		    
	//	    shape.draw(canvas);
		    
	//	    if (shape.getBounds().contains((int)middleX, (int)middleY) && Drawing.over)
	//	    	center = true;
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
	         
	         if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
	        	 ballBounceEffect();
	         
	         if (Drawing.switchRotation)
	 	    	Drawing.switchRotation = false;
	 	    else
	 	    	Drawing.switchRotation = true;
	      }
	      else if (newy > ymax - radius) {
	         newy = 2*(ymax-radius) - newy;
	         dy = -Math.abs(dy);
	         
	         if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
	        	 ballBounceEffect();
	         
	         if (Drawing.switchRotation)
		 	    	Drawing.switchRotation = false;
		 	    else
		 	    	Drawing.switchRotation = true;
	      }
	      else if (newx < xmin + radius) {
	         newx = 2*(xmin+radius) - newx;
	         dx = Math.abs(dx);
	         
	         if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
	        	 ballBounceEffect();
	         
	         if (Drawing.switchRotation)
		 	    	Drawing.switchRotation = false;
		 	    else
		 	    	Drawing.switchRotation = true;
	      }
	      else if (newx > xmax - radius) {
	         newx = 2*(xmax-radius) - newx;
	         dx = -Math.abs(dx);
	         
	         if (MainActivity.effectsSoundOn && MainActivity.pauseEffects)
	        	 ballBounceEffect();
	         
	         if (Drawing.switchRotation)
		 	    	Drawing.switchRotation = false;
		 	    else
		 	    	Drawing.switchRotation = true;
	      }
	      
	      /* We have the new values for x and y. */
	      
	      x = newx;
	      y = newy;
	      
	    	  
	      
	      
	   } // end travel()
	   
	   public void ballBounceEffect()		{
	    	
	//	   if (ballBounceMusic.isPlaying())	{
			   
	//		   ballBounceMusic1 = MediaPlayer.create(context, R.raw.balls_bouncing_quiet2);	
	//		   ballBounceMusic1.start(); 
			   
	//	  }else	{
			  
			  ballBounceMusic = MediaPlayer.create(context, R.raw.balls_bouncing_quiet);	
			  try {
				ballBounceMusic.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  ballBounceMusic.start();    	
	//	   }
	    }
	   
	   /**
	    * Set the radius of the ball.  Adjust the radius, if necessary,
	    * so the diameter of the ball is at least one pixel.
	    */
	   public void setRadius(int r) {
	      radius = r;
	      if (radius < 0.5)
	         radius = 0.5;
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
	      MovingBalls.x = x;
	      MovingBalls.y = y;
	   }
	   

	   /**
	    * Set the speed of the ball, if speed > 0.  The speed is
	    * restricted to being strictly positive.  (If you want the
	    * ball to stay still, don't call the travel() method!)
	    */
	   public static void setSpeed(double speed) {
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
	   public static void headTowards(double d, double e) {
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
	         MovingBalls.dx = dx;
	         MovingBalls.dy = dy;
	      }
	   }
	   

	}  // end class MovingBall

