package hu.tokingame.towerdefense.Settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/25/2018.
 */

public class SettingsScreen extends MyScreen {
    private SettingsStage settingsStage;
    public SettingsScreen(MyGdxGame game) {
        super(game);
        settingsStage = new SettingsStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        settingsStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(settingsStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        settingsStage.act(delta);
        settingsStage.draw();
    }
}