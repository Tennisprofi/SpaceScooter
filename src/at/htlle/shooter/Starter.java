package at.htlle.shooter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.htlle.shooter.gameobjects.SpaceShip;
import at.htlle.shooter.gameobjects.Asteroid;
import at.htlle.shooter.gameobjects.Rocket;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Starter extends Application implements EventHandler<KeyEvent>
{

	// Raumschiff erzeugen und hinpinseln
	SpaceShip enterprise = new SpaceShip(100,100);
	List<Asteroid> asteroiden = new ArrayList<>();
	List<Rocket> raketen = new ArrayList<>();
	
	final int WIDTH = 600;
	final int HEIGHT = 400;
	
	public static void main(String[] args)
	{
		Application.launch(Starter.class, args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("SpaceShooter - Hutter");
		
		Group root = new Group();
		
		Canvas canvas = new Canvas(this.WIDTH, this.HEIGHT);
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(this);
		root.getChildren().add(canvas);
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
		// Asteroiden erzeugen
		Random rnd = new Random();
		for(int i = 0; i < 20; i++)
		{
			int x = this.WIDTH + rnd.nextInt(this.WIDTH);
			int y = rnd.nextInt(this.HEIGHT);
			int s = rnd.nextInt(100) + 10;
			Asteroid a = new Asteroid(x,y,s);
			this.asteroiden.add(a);
		}
		
		
		// Raumschiff hinmalen
		enterprise.paint(canvas.getGraphicsContext2D());
		
		// GameLoop
		new AnimationTimer()
		{
			@Override
			public void handle(long currentNanoTime) 
			{
				canvas.getGraphicsContext2D().clearRect(0, 0, WIDTH, HEIGHT);
				enterprise.paint(canvas.getGraphicsContext2D());
				
				List<Asteroid> oldAsteroids = new ArrayList<>();
				
				
				for(Asteroid a : asteroiden)
				{
					a.paint(canvas.getGraphicsContext2D());
					a.move();
					
					if(a.isVisible() == false)
					{
						oldAsteroids.add(a);
					}
				}

				// Vorbeigeflogene Asteroiden löschen
				asteroiden.removeAll(oldAsteroids);

				for(Asteroid a : oldAsteroids)
				{
					System.out.println("Lösche " + a.toString());
					a = null; // Garbage Collector kann ihn wegräumen

					// Dafür basteln wir einen neuen 
					int x = WIDTH + rnd.nextInt(WIDTH);
					int y = rnd.nextInt(HEIGHT);
					int s = rnd.nextInt(100) + 10;
					asteroiden.add(new Asteroid(x,y,s));
				}
				
				List<Rocket> oldRockets = new ArrayList<>();
				for(Rocket r : raketen)
				{
					r.paint(canvas.getGraphicsContext2D());
					r.move();
					
					if(r.isVisible() == false)
					{
						oldRockets.add(r);
					}
				}

				// Vorbeigeflogene Asteroiden löschen
				raketen.removeAll(oldRockets);
				for(Rocket r : oldRockets)
				{
					System.out.println("Lösche " + r.toString());
					r = null; // Garbage Collector kann ihn wegräumen
				}
				
			}
		}.start();
		
	}

	/**
	 * Kümmert sich um die Tastatureingaben
	 */
	@Override
	public void handle(KeyEvent evnt) 
	{
		System.out.println(evnt.getCode().getName());
		
		// Shift - Double Speed !
		int speed = 5;
		if(evnt.isShiftDown())
		{
			speed = 10;
		}
		
		switch(evnt.getCode().getName())
		{
			case "Up": 
				enterprise.moveUp(speed);
				break;
				
			case "Down":
				enterprise.moveDown(speed);
				break;

			case "Left":
				enterprise.moveLeft(speed);
				break;

			case "Right":
				enterprise.moveRight(speed);
				break;

			case "Space":
				Rocket r = enterprise.fireRocket();
				raketen.add(r);
				break;
								
		}
		
	}

}
