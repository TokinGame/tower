package hu.tokingame.towerdefense.Settings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Game.GameScreen;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/25/2018.
 */

public class SettingsStage extends MyStage {

    MyGdxGame game;
    private static final String SOUDNFX_LABEL = "Hangeffektek: ", MUSIC_LABEL = "Zene: ";

    public SettingsStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });

        /*addActor(new MyTextButton(MUSIC_LABEL){
            @Override
            protected void init() {
                super.init();
                this.setText(MUSIC_LABEL + (Globals.music ? "Be" : "Ki"));
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.music = !Globals.music;
                        if(Globals.music)Assets.manager.get(Assets.MAIN_MUSIC).play();
                        else Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        Globals.getPrefs().putBoolean("music", Globals.music);
                        Globals.getPrefs().flush();
                        setText(MUSIC_LABEL + (Globals.music ? "Be" : "Ki"));
                    }
                });
            }
        });


        addActor(new MyTextButton(SOUDNFX_LABEL){
            @Override
            protected void init() {
                super.init();
                this.setText(SOUDNFX_LABEL + (Globals.soundFX ? "Be" : "Ki"));
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 500);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.soundFX = !Globals.soundFX;
                        Globals.getPrefs().putBoolean("soundFX", Globals.soundFX);
                        Globals.getPrefs().flush();
                        setText(SOUDNFX_LABEL + (Globals.soundFX ? "Be" : "Ki"));
                    }
                });
            }
        });*/


        addActor(new MyTextButton("Vissza",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });




    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}
