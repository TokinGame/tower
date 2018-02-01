package hu.tokingame.towerdefense.High;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.Menu.MenuScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;




/**
 * Created by zoltan on 01/31/2018.
 */

public class HighStage extends MyStage {

    MyGdxGame game;

    ArrayList<MyLabel> hsV;


    public HighStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;
        Gdx.input.setCatchBackKey(true);



        if (Globals.scores.size() > 0) {
            hsV = new ArrayList();

            for (int i = 0; i < Globals.scores.size(); i++) {
                float k = Globals.scores.get(i);
                int b = Math.round(k * 100) / 100;
                final int finalI = i;
                hsV.add(new MyLabel(i + 1 + ". " + b + " pont", game.getLabelStyle_White()) {
                    @Override
                    public void init() {
                        super.init();
                        setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, finalI > 0 ? hsV.get(finalI - 1).getY() - 75 : 500);
                    }
                });
                addActor(hsV.get(i));
            }
            hsV.clear();
        } else {
            addActor(new MyLabel("Még nincs elért eredmény", game.getLabelStyle_White()) {
                @Override
                public void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 500);
                }
            });
        }

        addActor(new MyTextButton("Vissza",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
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
            game.setScreenBackByStackPop();
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
