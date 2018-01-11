package hu.tokingame.towerdefense.Game.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by M on 1/11/2018.
 */

public class BlockSelector extends OneSpriteStaticActor {

    private boolean moving = false;
    private State state;
    public BlockSelector() {
        super(Assets.manager.get(Assets.BADLOGIC_TEXTURE)); // TODO: 1/11/2018 Change BG
        this.setSize(250,100);
        this.setPosition(-200, Globals.WORLD_HEIGHT/2f - this.getHeight()/2f);
        state = State.OUT;
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!moving){
                    switch (state){
                        case IN:
                            slideOut();
                            break;
                        case OUT:
                            slideIn();
                            break;
                    }
                }
            }
        });

    }

    public void slideOut(){
        moving = true;
        state = State.OUT;
        this.addAction(sequence(moveTo(0, getY(), 0.5f), run(new Runnable() {
            public void run () {
                moving = false;
                BlockSelector.this.removeAction(BlockSelector.this.getActions().first());
            }
        })));
    }

    public void slideIn(){
        moving = true;
        state = State.IN;
        this.addAction(sequence(moveTo(-200, getY(), 0.5f), run(new Runnable() {
            public void run () {
                moving = false;
                BlockSelector.this.removeAction(BlockSelector.this.getActions().first());
            }
        })));
    }

    @Override
    public void init() {
        super.init();
    }


    private enum State{
        IN,OUT
    }

}

