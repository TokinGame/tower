package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;
import hu.tokingame.towerdefense.BuildingBlocks.Turret;
import hu.tokingame.towerdefense.BuildingBlocks.Wall;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Enemy.Alien;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.Globals.Globals.Selectable;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;
import hu.tokingame.towerdefense.MyGdxGame;
import jdk.nashorn.internal.objects.Global;

/**
 * Created by M on 1/11/2018.
 */

public class GameStage extends MyStage {

    private ControlStage controlStage;
    public BuildingBlock[][] map;
    PathFinder pathFinder;
    Thread t;



    public Globals.Selectable selectedBlock = Selectable.WALL;

    private int healthLeft = Globals.STARTINGHEALTH;

    Alien alien;


    OneSpriteStaticActor defendedbase;

    MyLabel healthLabel;

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
            t = new Thread(pathFinder);
            t.start();
        }catch(Exception e){
            e.printStackTrace();
        }



        addActor(defendedbase = new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){  // bázis, vonja az életet ha belemegy a cucc
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(Globals.WORLD_WIDTH-getWidth(), 0);
            }
        });

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

        addActor(healthLabel = new MyLabel("10", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(1140, 300);
            }
        });
    }


    @Override
    public void init() {
        //addActor(new Wall(0,0));
    }

    @Override
    public void dispose() {
        super.dispose();
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
        if(defendedbase.overlaps(alien)){
            decreaseHealth();
            System.out.println("Hinnye támad");
            alien.remove();
        }
    }


    void placeElement(int x, int y){
        if(pathFinder.canPlace(x, y)){
            BuildingBlock k = null;
            switch(selectedBlock){
                case WALL: k = new Wall(x, y); break;
                case TURRET: k = new Turret(x, y, this); break;
                case OTHERTURRET: k = new Turret(x, y, this); break;
            }

            map[x][y] = k;
            addActor(k);
            System.out.println("placed "+x+" : "+ y);
        }else
            System.out.println("cannot place");
    }

    public void decreaseHealth() {
        if (healthLeft > 1) healthLeft--;
        else game.setScreenBackByStackPop();     //TODO meghaltál képernyő
        healthLabel.setText(healthLeft+"");
    }
    public PathFinder getPathFinder() {
        return pathFinder;
    }

    public OneSpriteStaticActor getDefendedbase() {
        return defendedbase;
    }
}
