package hu.tokingame.towerdefense.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.xml.bind.annotation.XmlElementDecl;

import hu.tokingame.towerdefense.Credits.CreditsScreen;
import hu.tokingame.towerdefense.Exit.ExitScreen;
import hu.tokingame.towerdefense.Game.GameScreen;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.High.HighScreen;
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
    int selected=1;


    public MenuStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);
        selected=1;
        System.out.println("asdf");
        game = gam;
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
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

        addActor(new MyTextButton("High Scores",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, (Globals.WORLD_HEIGHT/5-this.getHeight()/5)*4);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HighScreen(game));
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
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });


        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2), (Globals.WORLD_HEIGHT/2-getHeight()/2)+50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected--;
                        if (selected==0){
                            selected=6;
                        }
                        if (selected==7){
                            selected=1;
                        }
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2), (Globals.WORLD_HEIGHT/2-getHeight()/2)-50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected++;
                        if (selected==0){
                            selected=6;
                        }
                        if (selected==7){
                            selected=1;
                        }
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+50, (Globals.WORLD_HEIGHT/2-getHeight()/2));
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected--;
                        if (selected==0){
                            selected=6;
                        }
                        if (selected==7){
                            selected=1;
                        }
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)-50, (Globals.WORLD_HEIGHT/2-getHeight()/2));
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected++;
                        if (selected==0){
                            selected=6;
                        }
                        if (selected==7){
                            selected=1;
                        }
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+150, (Globals.WORLD_HEIGHT/2-getHeight()/2));
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        /*switch (selected){
                            case 1: game.setScreen(new GameScreen(game));
                            case 2: game.setScreen(new HighScreen(game));
                            case 3: game.setScreen(new HowToPlayScreen(game));
                            case 4: game.setScreen(new CreditsScreen(game));
                            case 5: game.setScreen(new SettingsScreen(game));
                            case 6: game.setScreen(new ExitScreen(game));//TODO exit screen
                        }*/
                        if (selected==1){
                            game.setScreen(new GameScreen(game));
                        }
                        else if (selected==2){
                            game.setScreen(new HighScreen(game));
                        }
                        else if (selected==3){
                            game.setScreen(new HowToPlayScreen(game));
                        }
                        else if (selected==4){
                            game.setScreen(new CreditsScreen(game));
                        }
                        else if (selected==5){
                            game.setScreen(new SettingsScreen(game));
                        }
                        else if (selected==6){
                            game.setScreen(new ExitScreen(game));
                        }
                    }
                });
            }
        });




    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new ExitScreen(game));
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
