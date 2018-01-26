package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;

/**
 * Created by M on 1/17/2018.
 */

public class Alien extends Enemy {

    public Alien(GameStage gameStage, Texture texture, int hp, float speeds) {
        super(texture, gameStage, hp, speeds);
        this.setSize(80,80);
        this.setPosition(15, Globals.WORLD_HEIGHT-getHeight()-5);


    }


    @Override
    public void init() {
        super.init();
    }
}
