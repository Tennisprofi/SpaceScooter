package at.htlle.shooter.gameobjects;

import javafx.scene.canvas.GraphicsContext;

public class Rocket 
{
	private int x;
	private int y;
	private String rocketString ="~->";
	
	/**
	 * ctor
	 * @param x Startposition X 
	 * @param y Startposition Y
	 */
	public Rocket(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void move()
	{
		this.x = this.x + 1;
	}

	/**
	 * �berschreiben der toString Methode, damit wir den Asteroiden bequem
	 * ausgeben k�nnen
	 */
	public String toString()
	{
		return "Rocket(" + this.x + "|" + this.y + ")";
	}
	
	/**
	 * Gibt true zur�ck wenn der Asteroid zerst�rt werden kann weil er nicht
	 * mehr sichtbar ist
	 * @return
	 */
	public boolean isVisible()
	{
		return (this.x < 1000);
	}
	
	/**
	 * Zeichnet die Rakete in den �bergebenen GraphicsContext
	 * @param gc
	 */
	public void paint(GraphicsContext gc)
	{
		gc.fillText(this.rocketString, this.x, this.y);
	}
}
