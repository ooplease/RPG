package rpg.game.MainGame.States;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import rpg.util.Sprite;

public class SpriteTest extends BasicGameState {
	
	int stateID = -1;
	int rotation = 1;
	Sprite pc = null;
	Animation north = null;
	Animation south = null;
	Animation east = null;
	Animation west =null;
	boolean moving;
	Image wn = null;
	Image we = null;
	Image ws = null;
	Image ww = null;
	float pcposx = 916;
	float pcposy = 476;
	float posInc = .25f;
	
	public SpriteTest(int sID){
		stateID=sID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		north = Sprite.walkNorth(Sprite.HERO);
		south = Sprite.walkSouth(Sprite.HERO);
		west = Sprite.walkWest(Sprite.HERO);
		east = Sprite.walkEast(Sprite.HERO);
		wn = Sprite.get("sprites",Sprite.HERO, Sprite.NORTH);
		we = Sprite.get("sprites",Sprite.HERO, Sprite.EAST);
		ws = Sprite.get("sprites",Sprite.HERO, Sprite.SOUTH);
		ww = Sprite.get("sprites",Sprite.HERO, Sprite.WEST);

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		if(moving){
			switch(rotation){
			case 1:{north.draw(pcposx,pcposy);north.start();} break;
			case 2:{east.draw(pcposx,pcposy);east.start();} break;
			case 3:{south.draw(pcposx,pcposy);south.start();} break;
			case 4:{west.draw(pcposx,pcposy);west.start();} break;
			}
		}
		else{
			switch(rotation){
			case 1:{wn.draw(pcposx,pcposy);} break;
			case 2:{we.draw(pcposx,pcposy);} break;
			case 3:{ws.draw(pcposx,pcposy);} break;
			case 4:{ww.draw(pcposx,pcposy);} break;
			}

		}
		g.setColor(Color.white);
		g.drawString("Moving:"+moving, 900, 400);
		g.setColor(Color.black);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		Input in = gc.getInput();
		if(!(in.isKeyDown(Input.KEY_W)||in.isKeyDown(Input.KEY_A)||in.isKeyDown(Input.KEY_S)||in.isKeyDown(Input.KEY_D)))
			moving = false;
		else
			moving = true;
		if((pcposx <= 0&&in.isKeyDown(Input.KEY_A))||( pcposx >= (1920-64)&&in.isKeyDown(Input.KEY_D)) ||( pcposy <= 0&&in.isKeyDown(Input.KEY_W)) ||( pcposy >= (1080-64)&&in.isKeyDown(Input.KEY_S)))
			posInc = 0;
		else
			posInc = .25f;
		
		if((in.isKeyDown(Input.KEY_W)&&in.isKeyDown(Input.KEY_S))||(in.isKeyDown(Input.KEY_D)&&in.isKeyDown(Input.KEY_A))||(in.isKeyDown(Input.KEY_W)&&in.isKeyDown(Input.KEY_D))||(in.isKeyDown(Input.KEY_W)&&in.isKeyDown(Input.KEY_A))||(in.isKeyDown(Input.KEY_S)&&in.isKeyDown(Input.KEY_D))||(in.isKeyDown(Input.KEY_S)&&in.isKeyDown(Input.KEY_A)))
				moving = false;
		
		
		if(in.isKeyDown(Input.KEY_W)&&moving){
			rotation = 1;
			pcposy -= posInc * delta;
		}
		if(in.isKeyDown(Input.KEY_D)&&moving){
			rotation = 2;
			pcposx += posInc * delta;
		}
		if(in.isKeyDown(Input.KEY_S)&&moving){
			rotation = 3;
			pcposy += posInc * delta;
		}
		if(in.isKeyDown(Input.KEY_A)&&moving){
			rotation = 4;
			pcposx -= posInc * delta;
		}
		
			
		
		if(in.isKeyDown(Input.KEY_ESCAPE))
			gc.exit();
		

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
