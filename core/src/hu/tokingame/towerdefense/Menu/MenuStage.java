package hu.tokingame.towerdefense.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

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
    ArrayList<float[]> pos=new ArrayList();
    MyGdxGame game;
    int selected=0;
    OneSpriteStaticActor Hajo;


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

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });
        addActor(new MyTextButton("Játék",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, Globals.WORLD_HEIGHT-this.getHeight()-10);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
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
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
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
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
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
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
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
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
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
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });


        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EMPTY)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+243, (Globals.WORLD_HEIGHT/2-getHeight()/2)-205);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected--;
                        if (selected==-1){
                            selected=5;
                        }
                        if (selected==6){
                            selected=0;
                        }
                        mozgas();
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EMPTY)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+243, (Globals.WORLD_HEIGHT/2-getHeight()/2)-305);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected++;
                        if (selected==-1){
                            selected=5;
                        }
                        if (selected==6){
                            selected=0;
                        }
                        mozgas();
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EMPTY)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+193, (Globals.WORLD_HEIGHT/2-getHeight()/2)-255);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected--;
                        if (selected==-1){
                            selected=5;
                        }
                        if (selected==6){
                            selected=0;
                        }
                        mozgas();
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EMPTY)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+293, (Globals.WORLD_HEIGHT/2-getHeight()/2)-255);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        selected++;
                        if (selected==-1){
                            selected=5;
                        }
                        if (selected==6){
                            selected=0;
                        }
                        mozgas();
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EMPTY)){
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition((Globals.WORLD_WIDTH/2-getWidth()/2)+525, (Globals.WORLD_HEIGHT/2-getHeight()/2)-255);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        switch (selected){
                            case 0: game.setScreen(new GameScreen(game)); break;
                            case 1: game.setScreen(new HighScreen(game)); break;
                            case 2: game.setScreen(new HowToPlayScreen(game)); break;
                            case 3: game.setScreen(new CreditsScreen(game)); break;
                            case 4: game.setScreen(new SettingsScreen(game)); break;
                            case 5: game.setScreen(new ExitScreen(game)); break;
                        }
                        /*if (selected==0){
                            game.setScreen(new GameScreen(game));
                        }
                        else if (selected==1){
                            game.setScreen(new HighScreen(game));
                        }
                        else if (selected==2){
                            game.setScreen(new HowToPlayScreen(game));
                        }
                        else if (selected==3){
                            game.setScreen(new CreditsScreen(game));
                        }
                        else if (selected==4){
                            game.setScreen(new SettingsScreen(game));
                        }
                        else if (selected==5){
                            game.setScreen(new ExitScreen(game));
                        }*/
                    }
                });
            }
        });

        addActor(Hajo=new OneSpriteStaticActor(Assets.manager.get(Assets.MENHAJ)){
            @Override
            public void init() {
                super.init();
                setSize(100, 50);
                setPosition(200, Globals.WORLD_HEIGHT-this.getHeight()-10);

            }
        });


    }

    void mozgas(){
        Hajo.addAction(Actions.moveTo(pos.get(selected)[0],pos.get(selected)[1],0.5f));
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
