package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 1/17/2018.
 */

public abstract class Enemy extends OneSpriteStaticActor {

    protected GameStage stage;

    public static final float MOVE_TIME = 0.5f;

    protected float time = 0;

    protected int steps = 0;

    ArrayList<Step> stepsList;

    public Enemy(Texture texture, GameStage gameStage) {
        super(texture);
        this.stage = gameStage;
        // TODO: 1/17/2018 kell egy tömb, arraylist, vector vagy valami amiben benne vannak a lépések
        // pl ez:
        stepsList = new ArrayList<Step>();
        stepsList.add(Step.RIGHT);
        stepsList.add(Step.RIGHT);
        stepsList.add(Step.DOWN);
        stepsList.add(Step.DOWN);
        stepsList.add(Step.RIGHT);
        stepsList.add(Step.RIGHT);
        stepsList.add(Step.UP);
        stepsList.add(Step.LEFT);
    }


    public boolean moveRight(){
        boolean completed = true;
        this.setX(getX() + Globals.GRID_WIDTH);
        return completed;
    }

    public boolean moveLeft(){
        boolean completed = true;
        if(this.getX() - Globals.GRID_WIDTH < 280) return false;
        this.setX(getX() - Globals.GRID_WIDTH);
        return completed;
    }

    public boolean moveUp(){
        boolean completed = true;
        if(this.getY() + Globals.GRID_WIDTH >  (Globals.MAP_SIZE-1) * Globals.GRID_HEIGHT) return false;
        this.setY(getY() + Globals.GRID_HEIGHT);
        return completed;
    }

    public boolean moveDown(){
        boolean completed = true;
        if(this.getY() - Globals.GRID_WIDTH < 0) return false;
        this.setY(getY() - Globals.GRID_HEIGHT);
        return completed;
    }

    public enum Step{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(stepsList.size() >= 1){
            if(time < MOVE_TIME) time += delta;
            else if(stepsList.size() > steps){
                time = 0;
                switch (stepsList.get(steps)){
                    case UP: moveUp(); break;
                    case DOWN: moveDown(); break;
                    case LEFT: moveLeft(); break;
                    case RIGHT: moveRight(); break;
                }
                steps++;
            }
        }
    }
}
