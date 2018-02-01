package hu.tokingame.towerdefense.BuildingBlocks;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyActor;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 02. 01..
 */

public class CircleActor extends OneSpriteStaticActor {
    private float speed;
    private float radius;
    private Vector2 center;
    private float alpha = 0;
    private static float PI = (float)Math.PI;

    public CircleActor(float x, float y, float speed, float radius) {
        super(Assets.manager.get(Assets.CIRCLE_TEXTURE));
        this.speed = speed;
        this.radius = radius;
        center = new Vector2(x,y);
        setTouchable(Touchable.disabled);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        if (alpha<1 && elapsedTime<0.5f){
            alpha+=delta*2;
        }
        if (elapsedTime * speed > 360f) {
            if (alpha>0) {
                alpha-=delta*2;
                System.out.println(alpha);
            }else{
                getStage().getActors().removeValue(this, true);
            }
        }
        if (alpha<0){
            alpha = 0;
        }
        sprite.setAlpha(alpha);
        Vector2 pos = center.cpy().add((new Vector2(0, radius)).rotate(-elapsedTime * speed));

        setPosition(pos.x-sprite.getWidth()/2, pos.y-sprite.getHeight()/2);
    }
}
