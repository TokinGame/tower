package hu.tokingame.towerdefense.Globals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.ArrayList;
import java.util.Collections;

import hu.tokingame.towerdefense.BuildingBlocks.BuildingBlock;

/**
 * Created by M on 1/11/2018.
 */

public class Globals {

    public static final boolean DEBUG = false;

    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public static float pintsz = 0;//score

    public enum Step{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public enum Selectable{
        WALL, TURRET, OTHERTURRET
    }
    public static ArrayList<Float> scores = new ArrayList<Float>();

    public static void addScore(float pintsz){
        scores.add(pintsz);
        Collections.sort(scores);
        Collections.reverse(scores);

        if(scores.size() > 5){
            scores = (ArrayList<Float>)scores.subList(0, 5);
        }

        for(int i = 0; i < scores.size(); i++){
            prefs.putFloat("s"+i, scores.get(i));
        }

        prefs.flush();
    }



    public static final int[] costs = {100, 250, 250};

    public static Selectable selectedBlock = Selectable.WALL;


    public static final int MAP_SIZE = 8;

    public static final float GRID_WIDTH = WORLD_HEIGHT/MAP_SIZE;
    public static final float GRID_HEIGHT  = WORLD_HEIGHT/MAP_SIZE;

    public static int STARTINGHEALTH = 10;


    public static int EntryPoint = -1;

    public static final Preferences prefs = Gdx.app.getPreferences("main");

    public static ArrayList<Step> currentSteps;

    public static boolean soundFX = true, music = prefs.getBoolean("music",true);

    public static Preferences getPrefs(){
        return prefs;
    }





}
