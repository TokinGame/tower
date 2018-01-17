package hu.tokingame.towerdefense.Game;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;
import hu.tokingame.towerdefense.BuildingBlocks.Wall;
import hu.tokingame.towerdefense.Globals.Globals;


/**
 * Created by davim on 2018. 01. 11..
 */

public class PathFinder implements Runnable {
    GameStage gameStage;
    BuildingBlock[][] m;
    boolean[][] Path = new boolean[Globals.MAP_SIZE][Globals.MAP_SIZE];
    public PathFinder(GameStage g) {
        gameStage = g;
        m = gameStage.map.clone();

        resetPath();
    }

    @Override
    public void run() {}

    public boolean canPlace(int x, int y){
        m = gameStage.map.clone();
        resetPath();
        if(m[x][y] == null){
            Wall k = new Wall(-1, -1);
            m[x][y] = k;
            System.out.println("trying "+x+" : "+ y);
            return pathExists();


        }
        return false;
    }

    public boolean pathExists(){
        for(int i = 0; i < Globals.MAP_SIZE; i++){
            if(entrance(i)){
                if(move(i, 0)) return true;
            }
        }

        return false;
    }

    boolean move(int x, int y){
        //System.out.println("x: " + x + " y: " + y);
        if(x < 0 || x > Globals.MAP_SIZE -1 || y < 0 || y > Globals.MAP_SIZE -1) return false;
        if(y == Globals.MAP_SIZE -1) return true;
        if(m[x][y] != null) return false;
        if(Path[x][y]) return false;

        Path[x][y] = true;

        if(move(x-1, y)) return true;
        if(move(x, y-1)) return true;
        if(move(x+1, y)) return true;
        if(move(x, y+1)) return true;

        Path[x][y] = false;


        return false;

    }

    boolean entrance(int x){
        return m[x][0] == null;
    }

    void resetPath(){
        for(int i = 0; i < Path.length; i++){
            for(int j = 0; j < Path[i].length; j++){
                Path[i][j] = false;
            }
        }
    }



}