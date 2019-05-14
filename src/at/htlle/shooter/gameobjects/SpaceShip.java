package at.htlle.shooter.gameobjects;

import javafx.scene.canvas.GraphicsContext;

public class SpaceShip 
{
	private int x;
	private int y;
	private String shipString ="=8[]>";
	
	/**
	 * ctor
	 * @param x Startposition X 
	 * @param y Startposition X 
	 */
	public SpaceShip(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Bewegt das Schiff nach Oben
	 * @param delta Anzahl Pixel
	 */
	public void moveUp(int delta)
	{
		this.y = this.y - delta;
	}
	
	/**
	 * Bewegt das Schiff nach Unten
	 * @param delta Anzahl Pixel
	 */
	public void moveDown(int delta)
	{
		this.y = this.y + delta;
	}

	/**
	 * Bewegt das Schiff nach Links
	 * @param delta Anzahl Pixel
	 */
	public void moveLeft(int delta)
	{
		this.x = this.x - delta;
	}

	/**
	 * Bewegt das Schiff nach Rechts
	 * @param delta Anzahl Pixel
	 */
	public void moveRight(int delta)
	{
		this.x = this.x + delta;
	}

	/**
	 * Überschreiben der toString Methode, damit wir das RS bequem
	 * ausgeben können
	 */
	public String toString()
	{
		return "SpaceShip(" + this.x + "|" + this.y + ")";
	}
	
	/**
	 * Zeichnet das Raumschiff in den übergebenen GraphicsContext
	 * @param gc
	 */
	public void paint(GraphicsContext gc)
	{
		gc.fillText(this.shipString, this.x, this.y);
	}
	
	/**
	 * Feuert eine Rakete ab
	 * @return
	 */
	public Rocket fireRocket()
	{
		return new Rocket(this.x, this.y);
	}
	 
}
