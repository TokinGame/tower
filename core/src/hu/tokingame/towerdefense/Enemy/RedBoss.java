package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by davim on 2018. 02. 01..
 */

public class RedBoss extends Alien {
    public RedBoss(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.RED_BOSS), 30, 2.5f);
    }
}
