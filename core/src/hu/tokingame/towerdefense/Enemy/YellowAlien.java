package hu.tokingame.towerdefense.Enemy;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by M on 1/25/2018.
 */

public class YellowAlien extends Alien {
    public YellowAlien(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.WALL_TEXTURE), 3, 1);
    }
}
