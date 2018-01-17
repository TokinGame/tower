package hu.tokingame.towerdefense.Globals;

import java.util.ArrayList;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;

/**
 * Created by M on 1/11/2018.
 */

public class Globals {
    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public enum Step{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public enum Selectable{
        WALL, TURRET, OTHERTURRET
    }


    public static final int MAP_SIZE = 8;

    public static final float GRID_WIDTH = WORLD_HEIGHT/MAP_SIZE;
    public static final float GRID_HEIGHT  = WORLD_HEIGHT/MAP_SIZE;

    public static int STARTINGHEALTH = 10;


    public static ArrayList<Step> currentSteps;


}
