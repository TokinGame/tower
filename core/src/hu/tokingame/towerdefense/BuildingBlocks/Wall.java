package hu.tokingame.towerdefense.BuildingBlocks;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by davim on 2018. 01. 11..
 */

public class Wall extends BuildingBlock {
    public Wall(float x, float y) {
        super(Assets.manager.get(Assets.WALL_TEXTURE), x, y);

    }
}
