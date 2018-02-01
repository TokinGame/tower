package hu.tokingame.towerdefense.GameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by zoltan on 2018.02.01..
 */

public class GameOverScreen extends MyScreen {
    private GameOverStage gameStage;
    public GameOverScreen(MyGdxGame game) {
        super(game);
        gameStage = new GameOverStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        gameStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(gameStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        gameStage.draw();
    }
}
