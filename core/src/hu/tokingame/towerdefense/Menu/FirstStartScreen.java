package hu.tokingame.towerdefense.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by M on 11/9/2017.
 */

public class FirstStartScreen extends MyScreen {
    private FirstStartStage firstStartStage;

    public FirstStartScreen(MyGdxGame game) {
        super(game);
        firstStartStage = new FirstStartStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        firstStartStage.addBackEventStackListener();

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        firstStartStage.act(delta);
        firstStartStage.draw();
    }
}