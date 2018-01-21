package hu.tokingame.towerdefense.Enemy;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;

/**
 * Created by M on 1/17/2018.
 */

public class Alien extends Enemy {

    public Alien(GameStage gameStage) {
        super(Assets.manager.get(Assets.WALL_TEXTURE), gameStage);
        this.setSize(80,80);
        this.setPosition(15, Globals.WORLD_HEIGHT-getHeight()-5);
    }


    @Override
    public void init() {
        super.init();
    }
}
