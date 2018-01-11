package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.BuildingBlocks.Wall;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by M on 1/11/2018.
 */

public class GameStage extends MyStage {
    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        fillMapWithTrue();
        addActor(new Wall(280, 0));
    }

    void fillMapWithTrue(){
        for (boolean[] b: Globals.map) {
            for (boolean k :b){
                k = true;
            }
        }
    }

    boolean canPlace(int x, int y){
        for(int i = 0; i < 8; i++){
            if(Globals.map[i][0]) return true;
            if(Globals.map[i][7]) return true;
        }
        return false;
    }
}
