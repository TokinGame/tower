package hu.tokingame.towerdefense.Exit;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.Menu.MenuScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;

import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by zoltan on 2018.01.31..
 */

public class ExitStage extends MyStage {

    MyGdxGame game;


    public ExitStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;





        addActor(new MyTextButton("Biztosan ki akarsz lépni?",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, Globals.WORLD_HEIGHT/2-this.getHeight()/2);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });
        addActor(new MyTextButton("Igen",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10,10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        //TODO kilépés
                    }
                });
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
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}
