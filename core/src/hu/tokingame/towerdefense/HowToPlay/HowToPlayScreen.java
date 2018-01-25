package hu.tokingame.towerdefense.HowToPlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/25/2018.
 */

public class HowToPlayScreen extends MyScreen {
    private HowToPlayStage howtoplayStage;
    public HowToPlayScreen(MyGdxGame game) {
        super(game);
        howtoplayStage = new HowToPlayStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        howtoplayStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(howtoplayStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        howtoplayStage.act(delta);
        howtoplayStage.draw();
    }
}
