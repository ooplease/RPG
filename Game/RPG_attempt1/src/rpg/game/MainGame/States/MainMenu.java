package rpg.game.MainGame.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import rpg.game.MainGame.MainGame;

public class MainMenu extends BasicGameState {
	
	int stateID = -1;
	Image background = null;
	Image options = null;
	Image newgame = null;
	Image loadgame = null;
	
	boolean overNewGame;
	boolean overLoadGame;
	boolean overOptions;
	boolean overExit;

	public MainMenu(int sID) {
		stateID = sID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("res/MenuBKG.jpg");
		Image menuOptions = new Image("res/MenuButtons.png");
		// new game is 0,0,295,62
		// load game is 0,67,302,130-67
		// options 0,131,211,192-131
		newgame = menuOptions.getSubImage(0, 0, 295, 62);
		loadgame = menuOptions.getSubImage(0, 67, 302, 130-67);
		options = menuOptions.getSubImage(0, 131, 211, 192-131);
		

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		background.draw(0,0);
		if(overNewGame){
			g.setColor(Color.white);
			g.fillRect(200,600,newgame.getWidth(),newgame.getHeight());
			g.setColor(Color.black);
		}
		newgame.draw(200,600);
		if(overLoadGame){
			g.setColor(Color.white);
			g.fillRect(200,700,loadgame.getWidth(),loadgame.getHeight());
			g.setColor(Color.black);
		}
		loadgame.draw(200,700);
		if(overOptions){
			g.setColor(Color.white);
			g.fillRect(200,800,options.getWidth(),options.getHeight());
			g.setColor(Color.black);
		}
		options.draw(200,800);
		if(overExit)
			g.setColor(Color.white);
		else
			g.setColor(Color.black);
		g.fillRect(200,900,200,100);
		g.drawString("EXIT", 250, 925);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input in = gc.getInput();
		
		int mX = in.getMouseX();
		int mY = in.getMouseY();
		
		overNewGame = false;
		overLoadGame = false;
		overOptions = false;
		overExit = false;
		
		if((mX >= 200 && mX <= 495)&&(mY >= 600 && mY <= 662))
			overNewGame = true;
		if((mX >= 200 && mX <= 502)&&(mY >= 700 && mY <= 700+(130-67)))
			overLoadGame = true;
		if((mX >= 200 && mX <= 411)&&(mY >= 800 && mY <= 800+(192-131)))
			overOptions = true;
		if((mX >= 200 && mX <= 400)&&(mY >= 900 && mY <= 1000))
			overExit = true;
		
		
//		if(overNewGame && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
//			sbg.enterState(3);
		if(overLoadGame && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
			sbg.enterState(99);
//		if(overOptions && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
//			sbg.enterState(1);
		if(overExit && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
			gc.exit();

	}

	@Override
	public int getID() {
		
		return stateID;
	}

}
