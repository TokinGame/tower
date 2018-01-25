package hu.tokingame.towerdefense.Credits;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Game.GameScreen;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/25/2018.
 */

public class CreditsStage extends MyStage {

    MyGdxGame game;

    public CreditsStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;



        addActor(new MyTextButton("Kilépés",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
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
