package rpg.util;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Sprite {
	//Convert characters to y position
	public static final int HERO = 0;
	//TODO add additional character and name hero
	
	//Convert positions to x position
	public static final int NORTH = 0;
	public static final int NORTHWALK = 1;
	public static final int EAST = 2;
	public static final int EASTWALK = 3;
	public static final int SOUTH = 4;
	public static final int SOUTHWALK = 5;
	public static final int WEST = 6;
	public static final int WESTWALK = 7;
	public static final int BATTLESTANCE = 8;
	public static final int ATTACK1 = 9;
	public static final int ATTACK2 = 10;
	public static final int ATTACK3 = 11;
	//TODO add additional positions as they come up
	
	//define animations
	public static Animation heroAttack(int character) throws SlickException{
		return new Animation(ss("sprites"),BATTLESTANCE,character,ATTACK3,HERO,true,100,true);
		}
	public static Animation walkNorth(int character) throws SlickException{
		return new Animation(ss("sprites"),NORTH,character,NORTHWALK,HERO,true,100,true);
		}
	public static Animation walkEast(int character) throws SlickException{
		return new Animation(ss("sprites"),EAST,character,EASTWALK,HERO,true,100,true);
		}
	public static Animation walkSouth(int character) throws SlickException{
		return new Animation(ss("sprites"),SOUTH,character,SOUTHWALK,HERO,true,100,true);
		}
	public static Animation walkWest(int character) throws SlickException{
		return new Animation(ss("sprites"),WEST,character,WESTWALK,HERO,true,100,true);
		}
	//TODO add all animations
	
	//prepare sprite sheet var
	public static SpriteSheet ss(String file)throws SlickException {
		return new SpriteSheet("res/"+file+".png",64,64);
	}
	
	
//	public Sprite(String file) throws SlickException{
//		ss = new SpriteSheet("res/"+file+".png",64,64);
//		animate();
//	}
	
	public static Image get(String sheet, int character, int position) throws SlickException{
		return ss(sheet).getSprite(position,character);
	}
	
//	private void animate() throws SlickException{
//		heroAttack = new Animation(ss, BATTLESTANCE, HERO,ATTACK3,HERO,true,17,true);
		
//		heroWalkNorth = new Animation(ss,NORTH,HERO,NORTHWALK,HERO,true,100,true);
//		heroWalkNorth.setLooping(true);
//		
//		heroWalkEast = new Animation(ss,EAST,HERO,EASTWALK,HERO,true,100,true);
//		heroWalkEast.setLooping(true);
//		
//		heroWalkSouth = new Animation(ss,SOUTH,HERO,SOUTHWALK,HERO,true,100,true);
//		heroWalkSouth.setLooping(true);
//		
//		heroWalkWest = new Animation(ss,WEST,HERO,WESTWALK,HERO,true,100,true);
//		heroWalkWest.setLooping(true);
//	}

}
