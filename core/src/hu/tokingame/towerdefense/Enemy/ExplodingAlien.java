package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by davimatyi on 2018. 01. 29..
 */

public class ExplodingAlien extends Alien {
    public ExplodingAlien(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.BADLOGIC_TEXTURE), 5, 0.7f);
    }
}
