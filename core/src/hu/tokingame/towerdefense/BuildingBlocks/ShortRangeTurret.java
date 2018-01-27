package hu.tokingame.towerdefense.BuildingBlocks;

import hu.tokingame.towerdefense.Game.GameStage;

/**
 * Created by davimatyi on 2018. 01. 27..
 */

public class ShortRangeTurret extends Turret {

    private int range = 1, damage = 3;

    public ShortRangeTurret(float x, float y, GameStage gameStage) {
        super(x, y, gameStage);
        System.out.println("range "+range+" damage " +damage);
    }


    @Override
    public void upgrade() {
        //super.upgrade();
        damage++;
        if(damage%5==0) range++;
        System.out.println("range "+range+" damage " +damage);
    }
}
