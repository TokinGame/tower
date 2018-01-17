package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 1/17/2018.
 */

public abstract class Enemy extends OneSpriteStaticActor {

    protected GameStage stage;

    public Enemy(Texture texture, GameStage gameStage) {
        super(texture);
        this.stage = gameStage;
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

}
