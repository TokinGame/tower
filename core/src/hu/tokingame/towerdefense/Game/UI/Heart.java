package hu.tokingame.towerdefense.Game.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by M on 2/1/2018.
 */

public class Heart extends OneSpriteStaticActor {

    private boolean removeEffect = false;
    private float removeTime = 0;

    private boolean fadeInEffect = false;
    private float fadeInTime = 0;

    private static final float FADE_TIME = 1f;

    private GameStage gameStage;

    public Heart(float x, float y, final GameStage gameStage) {
        super(Assets.manager.get(Assets.SZIV));
        this.gameStage = gameStage;
        setSize(50, 50);
        this.setPosition(x, y);


        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!removeEffect){
                    Heart.this.gameStage.addHP();
                    remove();
                }
            }
        });
        Color c = this.getColor();
        c.a = 0f;
        this.setColor(c);
        fadeInEffect = true;
    }


    public void enableRemoveEffect(){
        removeEffect = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (removeEffect){
            removeTime += delta;
            Color c = this.getColor();
            c.a = 1f - removeTime;
            this.setColor(c);
            if (removeTime > FADE_TIME){
                remove();
            }
        }

        if (fadeInEffect){
            fadeInTime += delta;
            Color c = this.getColor();
            c.a = 0f + fadeInTime;
            this.setColor(c);
            if (fadeInTime > FADE_TIME){
                fadeInEffect = false;
            }
        }
    }

    @Override
    public boolean remove() {
        return super.remove();
    }
}
