package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by M on 1/25/2018.
 */

public class GreenAlien extends Alien {
    public GreenAlien(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.WALL_TEXTURE), 1, 1);
    }
}
