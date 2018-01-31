package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.ArrayList;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyRectangle;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.Globals.Globals.Step;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by M on 1/17/2018.
 */

public abstract class Enemy extends OneSpriteStaticActor {

    protected GameStage stage;

    private float MOVE_TIME = 1;

    protected float time = 0;

    protected int steps = 0;

    protected int health = 1;

    protected boolean flaggedForRemoval = false;

    ArrayList<Globals.Step> stepsList;

    public void setStepsList(ArrayList<Step> stepsList) {
        this.stepsList = stepsList;
    }

    public Enemy(Texture texture, GameStage gameStage, int health, float movetime) {
        super(texture);
        this.stage = gameStage;
        this.health = health;
        MOVE_TIME = movetime;
        // TODO: 1/17/2018 kell egy tömb, arraylist, vector vagy valami amiben benne vannak a lépések
        // pl ez:
        stepsList = new ArrayList<Globals.Step>();
        setStepsList(Globals.currentSteps);
        addCollisionShape("Enemy", new MyRectangle(getWidth(),getHeight(),0,0, getOriginX(), getOriginY(), getRotation(),0, getX(), getY(), true));
    }


    public void takeDamage(int hitpoints){
        System.out.println("rip: " + health + "      " + (health - hitpoints));
        health -= hitpoints;
        if(health < 1){
            //clearActions();
            flaggedForRemoval = true;
            System.out.println("meghótam");
        }
    }


    public boolean moveRight(){
        boolean completed = true;
        moveTo(getX() + Globals.GRID_WIDTH, getY());
        return completed;
    }

    public boolean moveLeft(){
        boolean completed = true;
        if(this.getX() - Globals.GRID_WIDTH < 280) return false;
        moveTo(getX() - Globals.GRID_WIDTH,getY());
        return completed;
    }

    public boolean moveUp(){
        boolean completed = true;
        if(this.getY() + this.getHeight()>  (Globals.MAP_SIZE-1) * Globals.GRID_HEIGHT) return false;
        moveTo(getX(),getY() + Globals.GRID_HEIGHT);
        return completed;
    }

    public boolean moveDown(){
        boolean completed = true;
        if(this.getY() - Globals.GRID_WIDTH < 0) return false;
        moveTo(getX(),getY() - Globals.GRID_HEIGHT);
        return completed;
    }


    public void moveTo(float x, float y){
        addAction(sequence(Actions.moveTo(x,y,MOVE_TIME), run(new Runnable() {
            public void run () {
            }
        })));
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        if(stepsList != null){
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
                }else{
                    for (Action action: getActions()) {
                        removeAction(action);
                    }
                }
            }
        }

        if(getX() > Globals.WORLD_WIDTH-240 && getY() < 160){
            stage.decreaseHealth();
            //System.out.println("Bement a köcsög");
            stage.enemiesAlive--;
            remove();
        }

        if(flaggedForRemoval) {
            stage.enemiesAlive--;
            System.out.println("ded");
            remove();

        }
    }
}
