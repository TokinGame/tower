package hu.tokingame.towerdefense.BuildingBlocks;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyActor;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyCircle;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by davimatyi on 2018. 01. 17..
 */

public class Turret extends BuildingBlock {

    private int range = 3, damage = 1;
    float timing = 1;

    public Turret(float x, float y, GameStage gameStage) {
        super(Assets.manager.get(Assets.TURRET_TEXTURE), x, y);
        setOrigintoCenter();
        addCollisionShape("Range",new MyCircle((float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2), 0, 0, getOriginX(), getOriginY(), getX()+getWidth()/2, getY()+getHeight()/2, false));
        System.out.println("range "+range+" damage " +damage);
    }


    @Override
    public void upgrade() {
        super.upgrade();
        damage++;
        if(damage%5 == 0) {
            range++;
            removeCollisionShape("Range");
            addCollisionShape("Range",new MyCircle((float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2), 0, 0, getOriginX(), getOriginY(), getX()+getWidth()/2, getY()+getHeight()/2, false));
        }
        System.out.println("UPGRADED");
        System.out.println("range "+range+" damage " +damage);
    }


    public int getDamage() {
        return damage;
    }
}
