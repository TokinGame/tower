package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by M on 1/11/2018.
 */

public class GameScreen extends MyScreen {

    private GameStage gameStage;

    public GameScreen(MyGdxGame game) {
        super(game);
        gameStage = new GameStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)),spriteBatch, game);
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
    }

    @Override
    public void init() {

    }
}
