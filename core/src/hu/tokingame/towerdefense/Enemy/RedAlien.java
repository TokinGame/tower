package hu.tokingame.towerdefense.Enemy;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by M on 1/25/2018.
 */

public class RedAlien extends Alien {
    public RedAlien(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.RED_ALIEN), 4, 1);
    }
}
