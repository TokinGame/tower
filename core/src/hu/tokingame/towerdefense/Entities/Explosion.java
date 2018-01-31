package hu.tokingame.towerdefense.Entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyCircle;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by davimatyi on 2018. 01. 30..
 */

public class Explosion extends OneSpriteAnimatedActor {
    public Explosion(float x, float y, float size) {
        super("OtherTextures/explosion.txt");
        setSize(size, size);
        setPosition(x, y);
        setFps(10);
        setLooping(false);
        addCollisionShape("Explosion", new MyCircle((float) Math.sqrt(getWidth() * getHeight()) / 2, 0, 0, getOriginX(), getOriginY(), getX(), getY(), true));
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
