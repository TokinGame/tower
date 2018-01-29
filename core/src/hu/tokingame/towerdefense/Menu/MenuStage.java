package hu.tokingame.towerdefense.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.xml.bind.annotation.XmlElementDecl;

import hu.tokingame.towerdefense.Credits.CreditsScreen;
import hu.tokingame.towerdefense.Game.GameScreen;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.HowToPlay.HowToPlayScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;
import hu.tokingame.towerdefense.Settings.SettingsScreen;


/**
 * Created by M on 11/9/2017.
 */

public class MenuStage extends MyStage {

    MyGdxGame game;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);
        System.out.println("asdf");
        game = gam;
        Gdx.input.setInputProcessor(this);

        for(StackTraceElement s: Thread.currentThread().getStackTrace()){
            System.out.println(s);
        }


        addActor(new MyTextButton("Játék",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, Globals.WORLD_HEIGHT-this.getHeight()-10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Hogyan Játssz",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, (Globals.WORLD_HEIGHT/5-this.getHeight()/5)*3);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HowToPlayScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Készítők",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, (Globals.WORLD_HEIGHT/5-this.getHeight()/5)*2);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new CreditsScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Beállítások",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, Globals.WORLD_HEIGHT/5-this.getHeight()/5);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new SettingsScreen(game));
                    }
                });
            }
        });

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
