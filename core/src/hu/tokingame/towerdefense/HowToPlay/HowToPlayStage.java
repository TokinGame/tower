package hu.tokingame.towerdefense.HowToPlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Game.GameScreen;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.Menu.FirstStartScreen;
import hu.tokingame.towerdefense.Menu.MenuScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by zoltan on 01/25/2018.
 */

public class HowToPlayStage extends MyStage {

    MyGdxGame game;

    public HowToPlayStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;
        Gdx.input.setCatchBackKey(true);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_NOCON)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });

        addActor(new MyLabel("Játék menete:\nA játék során az ellenség hullámokban fog érkezni,\nhogy elpusztítsák a bázist.\nA feledat ezt megakadályozni falak és ágyúk segítségével\n Az eszköztárban lehet választani, fal és ágyú között,\nmelyeket Űrforintért lehet vásárolni, és lehelyezni a pályára\n Sok Sikert!", game.getLabelStyle_White_DarkBG()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 200);
                setAlignment(2);

            }
        });

        addActor(new MyTextButton("Intro",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition((Globals.WORLD_WIDTH-getWidth())-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new FirstStartScreen(game));
                    }
                });
            }
        });

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
