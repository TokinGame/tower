package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.RegionInfluencer;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by davim on 2018. 02. 01..
 */

public class YellowBoss extends Alien {
    public YellowBoss(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.YELLOW_BOSS), 20, 2f);
    }
}
