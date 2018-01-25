package hu.tokingame.towerdefense.Enemy;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by M on 1/25/2018.
 */

public class BlueAlien extends Alien {
    public BlueAlien(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.BLUE_ALIEN), 2, 1);
    }
}
