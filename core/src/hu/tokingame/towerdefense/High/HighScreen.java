package hu.tokingame.towerdefense.High;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;

import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/31/2018.
 */

public class HighScreen extends MyScreen {
    private HighStage highStage;
    public HighScreen(MyGdxGame game) {
        super(game);
        highStage = new HighStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        highStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(highStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        highStage.act(delta);
        highStage.draw();
    }
}
