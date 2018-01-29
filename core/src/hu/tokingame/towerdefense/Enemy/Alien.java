package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyRectangle;

/**
 * Created by M on 1/17/2018.
 */

public class Alien extends Enemy {

    public Alien(GameStage gameStage, Texture texture, int hp, float speeds) {
        super(texture, gameStage, hp, speeds);
        this.setSize(Globals.GRID_WIDTH-10,Globals.GRID_HEIGHT-10);
        this.setPosition(15, Globals.WORLD_HEIGHT-getHeight()-5);
        // TODO: 1/29/2018 Szar helyen van
        addCollisionShape(this.toString(),new MyRectangle(getWidth(),getHeight(),0,0,getOriginX(), getOriginY(), getRotation(), 0, true));

    }


    @Override
    public void init() {
        super.init();
    }
}
