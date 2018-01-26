package hu.tokingame.towerdefense.BuildingBlocks;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 1/11/2018.
 */

public class BuildingBlock extends OneSpriteStaticActor {
    public BuildingBlock(Texture texture, float x, float y) {
        super(texture);
        place(x, y);
        setSize(90,90);
    }

    @Override
    public void init() {
        super.init();
    }


    void place(float e, float m){
        setX(280+ m *Globals.GRID_WIDTH);
        setY(((Globals.MAP_SIZE-1) - e)*Globals.GRID_HEIGHT);
    }


    public void upgrade(){

    }
}
