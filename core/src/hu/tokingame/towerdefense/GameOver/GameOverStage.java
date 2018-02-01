package hu.tokingame.towerdefense.GameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.Menu.MenuScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;

import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by zoltan on 2018.01.31..
 */

public class GameOverStage extends MyStage {

    MyGdxGame game;


    public GameOverStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;
        Gdx.input.setCatchBackKey(true);


        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });


        addActor(new MyTextButton("Nem",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10,10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });




    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}
