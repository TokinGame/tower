package hu.tokingame.towerdefense.Enemy;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Entities.Explosion;
import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;

/**
 * Created by davimatyi on 2018. 01. 29..
 */

public class ExplodingAlien extends Alien {

    int explodePoint;

    public ExplodingAlien(GameStage gameStage) {
        super(gameStage, Assets.manager.get(Assets.BOMBU_ALIEN), 5, 1.5f);
        explodePoint = (int)(Math.random()*(1000 - 280 + 1) +280);
        System.out.println("explode at "+explodePoint);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getX() > explodePoint){
            System.out.println("Allahu akbar");
            stage.addActor(new Explosion(getX()-getWidth(), getY()-getHeight(), getWidth()*3));
            stage.enemiesAlive--;
            remove();
        }
    }
}
