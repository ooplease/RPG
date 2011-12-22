package rpg.game.MainGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends StateBasedGame {
	
	public final int MAINMENU = 0;
	public final int OPTIONS = 1;
	public final int LOADMENU = 2;
	public final int INTROMOVIE = 3;

	public MainGame(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub

	}

}
