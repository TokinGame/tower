package hu.tokingame.towerdefense.Exit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by zoltan on 2018.01.31..
 */

public class ExitScreen extends MyScreen {
    private ExitStage exitStage;
    public ExitScreen(MyGdxGame game) {
        super(game);
        exitStage = new ExitStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        exitStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(exitStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        exitStage.act(delta);
        exitStage.draw();
    }
}
