package hu.tokingame.towerdefense.Credits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/25/2018.
 */

public class CreditsScreen extends MyScreen {
    private CreditsStage creditsStage;
    public CreditsScreen(MyGdxGame game) {
        super(game);
        creditsStage = new CreditsStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        creditsStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(creditsStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        creditsStage.act(delta);
        creditsStage.draw();
    }
}
