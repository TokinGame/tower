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

import java.util.ArrayList;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;
import hu.tokingame.towerdefense.BuildingBlocks.Turret;
import hu.tokingame.towerdefense.BuildingBlocks.Wall;
import hu.tokingame.towerdefense.Enemy.BlueAlien;
import hu.tokingame.towerdefense.Enemy.Enemy;
import hu.tokingame.towerdefense.Enemy.EnemyAdder;
import hu.tokingame.towerdefense.Enemy.GreenAlien;
import hu.tokingame.towerdefense.Enemy.RedAlien;
import hu.tokingame.towerdefense.Enemy.YellowAlien;
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


    public boolean duringWave = false;

    public float waveTimer = 0;

    public int roundsCount = 0;

    private int healthLeft = Globals.STARTINGHEALTH;

    public int Moneys = 500;

    int moneyToBeAdded = 0;

    Alien alien;
    private ArrayList<Enemy> enemies;
    private ArrayList<EnemyAdder> enemiesQueue;
    private ArrayList<EnemyAdder> rem;

    OneSpriteStaticActor defendedbase;

    MyLabel healthLabel;

    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        controlStage = new ControlStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)),new SpriteBatch(), game, this);

        enemies = new ArrayList<Enemy>();
        enemiesQueue = new ArrayList<EnemyAdder>();
        rem = new ArrayList<EnemyAdder>();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);

        map = new BuildingBlock[Globals.MAP_SIZE][Globals.MAP_SIZE];

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

        //addActor(alien = new Alien(this));

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
        if(duringWave) waveTimer += delta;
        /*if(defendedbase.overlaps(alien)){                             //TODO normálisan megoldani az életlevonást
            decreaseHealth();
            System.out.println("Hinnye támad");
            alien.remove();
        }*/


        //System.out.println("wave: " + waveTimer);
        //System.out.println(enemiesQueue);
        for (EnemyAdder adder: enemiesQueue) {
            System.out.println(adder.getTimeOut());
            if(adder.getTimeOut() <= waveTimer){
                Enemy enemy = adder.getEnemy();
                rem.add(adder);
                enemies.add(enemy);
                addActor(enemy);
            }
        }
        //System.out.println(enemiesQueue);
        enemiesQueue.removeAll(rem);
        rem.clear();
        //System.out.println(enemiesQueue);
    }


    void placeElement(int x, int y){
        if(!duringWave) {
            if(hasEnoughMoney()){
                if (pathFinder.canPlace(x, y)) {
                    BuildingBlock k = null;
                    switch (Globals.selectedBlock) {
                        case WALL:
                            k = new Wall(x, y);
                            Moneys -= Globals.costs[0];
                            break;
                        case TURRET:
                            k = new Turret(x, y, this);
                            Moneys -= Globals.costs[1];
                            break;
                        case OTHERTURRET:
                            k = new Turret(x, y, this);
                            Moneys -= Globals.costs[2];
                            break;
                    }
                    map[x][y] = k;
                    addActor(k);
                    System.out.println("placed " + x + " : " + y);
                } else
                    controlStage.showMessage("Nem zárhatod el az egyetlen utat");
            } else controlStage.showMessage("Nincs elég pénzed");
        } else controlStage.showMessage("Kör közben nem építhetsz");
        controlStage.updateMoneys();
    }

    public void spawnEnemy(int identifier, float timing){
            switch (identifier) {
                case 1:
                    enemiesQueue.add(new EnemyAdder(new GreenAlien(this), timing));
                    break;
                case 2:
                    enemiesQueue.add(new EnemyAdder(new BlueAlien(this), timing));
                    break;
                case 3:
                    enemiesQueue.add(new EnemyAdder(new YellowAlien(this), timing));
                    break;
                case 4:
                    enemiesQueue.add(new EnemyAdder(new RedAlien(this), timing));
                    break;
                default:
                    enemiesQueue.add(new EnemyAdder(new GreenAlien(this), timing));
                    break;
            }
    }

    public void decreaseHealth() {
        if (healthLeft > 1) healthLeft--;
        else game.setScreenBackByStackPop();     //TODO meghaltál képernyő
        healthLabel.setText(healthLeft+"");
    }

    public void startWave(){
        duringWave = true;
        roundsCount++;
        controlStage.showMessage("A "+roundsCount+" kör elkezdődött");
        System.out.println("wave started");
        spawnEnemy(0, 1);
        spawnEnemy(0, 2);
        spawnEnemy(0, 3);
    }

    public void endWave(){
        duringWave = false;
        waveTimer = 0;
        Moneys += moneyToBeAdded;
        moneyToBeAdded = 0;
        controlStage.updateMoneys();
        controlStage.showMessage("A kör véget ért");
        System.out.println("wave ended");
    }

    boolean hasEnoughMoney(){
        switch(Globals.selectedBlock){
            case WALL:
                if (Moneys - Globals.costs[0] < 1) return false;
            case TURRET:
                if (Moneys - Globals.costs[1] < 1) return false;
            case OTHERTURRET:
                if (Moneys - Globals.costs[2] < 1) return false;
        }
        return true;
    }

    public void nextMoney(int amount){
        moneyToBeAdded = amount;
    }




    public PathFinder getPathFinder() {
        return pathFinder;
    }

    public OneSpriteStaticActor getDefendedbase() {
        return defendedbase;
    }
}
