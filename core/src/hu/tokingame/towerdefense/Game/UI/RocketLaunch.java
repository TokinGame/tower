package hu.tokingame.towerdefense.Game.UI;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 2/1/2018.
 */

public class RocketLaunch extends OneSpriteStaticActor {
    private int actNum = 0;
    private int currentImg = 0;

    public RocketLaunch() {
        super(Assets.manager.get(Assets.ROCKET_LAUNCH[0]));
        this.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
        this.setPosition(0, 0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        actNum++;
        if(actNum == 5){
            currentImg++;
            actNum = 0;
            if(currentImg > 29){
                finished();
                return;
            }
            this.setTexture(Assets.manager.get(Assets.ROCKET_LAUNCH[currentImg]));
        }
    }

    public void finished(){
        remove();
    }
}
