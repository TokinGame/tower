package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;
import hu.tokingame.towerdefense.BuildingBlocks.Wall;
import hu.tokingame.towerdefense.Enemy.Alien;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by M on 1/11/2018.
 */

public class GameStage extends MyStage {

    private ControlStage controlStage;
    public BuildingBlock[][] map;
    PathFinder pathFinder;

    Alien alien;

    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        controlStage = new ControlStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)),new SpriteBatch(), game, this);

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);

        map = new BuildingBlock[8][8];

        pathFinder = new PathFinder(this);
        try{
            Thread t = new Thread(pathFinder);
            t.start();
        }catch(Exception e){
            e.printStackTrace();
        }

        addActor(alien = new Alien(this));

        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                System.out.println("sdafksadkl: " + keycode);
                switch (keycode){
                    case Input.Keys.D: alien.moveRight(); break;
                    case Input.Keys.W: alien.moveUp(); break;
                    case Input.Keys.S: alien.moveDown(); break;
                    case Input.Keys.A: alien.moveLeft(); break;
                }
                return true;
            }
        });
    }


    @Override
    public void init() {
        //addActor(new Wall(0,0));
    }


    @Override
    public void draw() {
        super.draw();
        controlStage.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        controlStage.act(delta);
    }


    void placeElement(int x, int y){
        if(pathFinder.canPlace(x, y)){
            Wall k = new Wall(x, y);
            map[x][y] = k;
            addActor(k);
            System.out.println("placed "+x+" : "+ y);
        }else
            System.out.println("cannot place");
    }

    public PathFinder getPathFinder() {
        return pathFinder;
    }

}
