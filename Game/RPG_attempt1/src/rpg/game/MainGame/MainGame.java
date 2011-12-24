package rpg.game.MainGame;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import rpg.game.MainGame.States.*;

public class MainGame extends StateBasedGame {
	
	public final int MAINMENU = 0;
	public final int OPTIONS = 1;
	public final int LOADMENU = 2;
	public final int INTROMOVIE = 3;
	
	public final int SPRITETEST = 99;
	//TODO add any additional states

	public MainGame() {
		super("RPG");
		
		this.addState(new MainMenu(MAINMENU));
		this.addState(new SpriteTest(SPRITETEST));
		//TODO add all states
		
		this.enterState(MAINMENU);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new MainGame());
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		
		
		app.setDisplayMode((int)dim.getWidth(),(int)dim.getHeight(),true);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MAINMENU).init(gc, this);
//		this.getState(OPTIONS).init(gc, this);
//		this.getState(LOADMENU).init(gc, this);
//		this.getState(INTROMOVIE).init(gc, this);
		this.getState(SPRITETEST).init(gc, this);
		//TODO add any additional states

	}

}
