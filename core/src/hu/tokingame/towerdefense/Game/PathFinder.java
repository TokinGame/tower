package hu.tokingame.towerdefense.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

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

    ArrayList<Globals.Step> steps = new ArrayList<Globals.Step>();

    public void cloneMap(){
        m = new BuildingBlock[Globals.MAP_SIZE][Globals.MAP_SIZE];
        for(int i = 0; i < gameStage.map.length; i++){
            for(int j = 0; j < gameStage.map[i].length; j++){
                m[i][j] = gameStage.map[i][j];
            }
        }
    }

    public PathFinder(GameStage g) {
        gameStage = g;
        //m = gameStage.map.clone();
        resetPath();
    }

    @Override
    public void run() {}

    public boolean canPlace(int x, int y){
        //m = gameStage.map.clone();
        cloneMap();
        resetPath();
        steps.removeAll(steps);
        if(m[x][y] == null){
            Wall k = new Wall(-1, -1);
            m[x][y] = k;
            System.out.println("trying "+x+" : "+ y);

            //Collections.reverse(steps);




            return pathExists();


        }
        return false;
    }

    public boolean pathExists(){
        if(hasExit()) {
            for (int i = 0; i < Globals.MAP_SIZE; i++) {
                System.out.println(i + " - " + 0 + " - " + entrance(i));
                if (entrance(i)) {
                    if (move(i, 0)) {

                        Collections.reverse(steps);
                        Globals.currentSteps = (ArrayList)steps.clone();
                        System.out.println(Globals.currentSteps);
                        Globals.currentSteps.add(0, Globals.Step.RIGHT);

                        for(int j = 0; j < i; j++){
                            Globals.currentSteps.add(0, Globals.Step.DOWN);
                        }
                        Globals.currentSteps.add(0, Globals.Step.RIGHT);
                        Globals.currentSteps.add(0, Globals.Step.RIGHT);
                        Globals.currentSteps.add(Globals.Step.RIGHT);
                        Globals.currentSteps.add(Globals.Step.RIGHT);
                        Globals.currentSteps.add(Globals.Step.RIGHT);
                        for(int j = i; j <Globals.MAP_SIZE; j++){
                            Globals.currentSteps.add(Globals.Step.DOWN);
                        }
                        Globals.EntryPoint = i;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean move(int x, int y){
        //System.out.println("x: " + x + " y: " + y);
        if(x < 0 || x > Globals.MAP_SIZE -1 || y < 0 || y > Globals.MAP_SIZE -1) return false;
        if(m[x][y] != null) return false;
        if(Path[x][y]) return false;
        if(y == Globals.MAP_SIZE -1) return true;


        Path[x][y] = true;

        if(move(x, y+1)){
            steps.add(Globals.Step.RIGHT);
            return true;
        }
        if(move(x+1, y)){
            steps.add(Globals.Step.DOWN);
            return true;
        }
        if(move(x-1, y)){
            steps.add(Globals.Step.UP);
            return true;
        }
        if(move(x, y-1)){
            steps.add(Globals.Step.LEFT);
            return true;
        }



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

    boolean hasExit(){
        for(int i=0; i<Globals.MAP_SIZE; i++){
            if(m[i][Globals.MAP_SIZE-1] == null && m[i][Globals.MAP_SIZE-2] == null) return true;
        }
        return false;
    }



}
