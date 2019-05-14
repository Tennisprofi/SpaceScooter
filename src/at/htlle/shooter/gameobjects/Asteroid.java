package at.htlle.shooter.gameobjects;

import javafx.scene.canvas.GraphicsContext;

public class Asteroid 
{
	private int x;
	private int y;
	private int speed;
	private String asteroidString ="*";
	
	/**
	 * ctor
	 * @param x Startposition X 
	 * @param y Startposition Y
	 * @param speed Geschwindigkeit des Asteroiden 
	 */
	public Asteroid(int x, int y, int speed)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public void move()
	{
		this.x = (int) ((this.x*50.0 - this.speed)/50.0);
	}

	/**
	 * �berschreiben der toString Methode, damit wir den Asteroiden bequem
	 * ausgeben k�nnen
	 */
	public String toString()
	{
		return "Asteroid(" + this.x + "|" + this.y + ")";
	}
	
	/**
	 * Gibt true zur�ck wenn der Asteroid zerst�rt werden kann weil er nicht
	 * mehr sichtbar ist
	 * @return
	 */
	public boolean isVisible()
	{
		return (this.x > 0);
	}
	
	/**
	 * Zeichnet den Asteroiden in den �bergebenen GraphicsContext
	 * @param gc
	 */
	public void paint(GraphicsContext gc)
	{
		gc.fillText(this.asteroidString, this.x, this.y);
	}

}

