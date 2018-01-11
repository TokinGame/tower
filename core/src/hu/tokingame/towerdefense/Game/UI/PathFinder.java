package hu.tokingame.towerdefense.Game.UI;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;
import hu.tokingame.towerdefense.BuildingBlocks.Wall;
import hu.tokingame.towerdefense.Game.GameStage;

/**
 * Created by davim on 2018. 01. 11..
 */

public class PathFinder implements Runnable {
    GameStage gameStage;
    public PathFinder(GameStage g) {
        gameStage = g;
    }

    @Override
    public void run() {

    }

    public boolean findPath(int x, int y){
        BuildingBlock[][] tempmap = gameStage.map.clone();
        tempmap[x][y] = new Wall(0,0);
        if(hasEntrance() && hasExit()){
            return true;                            //TODO 2018.01.11 befejezni
        }else return false;
    }

    boolean hasEntrance(){
        return true;
    }
    boolean hasExit(){
        return true;
    }
}
