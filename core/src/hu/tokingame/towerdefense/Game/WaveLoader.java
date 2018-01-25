package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.Game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by davim on 2018. 01. 25..
 */

public class WaveLoader implements Runnable {
    GameStage gameStage;
    public WaveLoader(GameStage g) {
        gameStage = g;
    }

    @Override
    public void run() {

    }

    public void load(int l){
        try {
            FileInputStream fis = new FileInputStream("Waves/"+l+".txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            gameStage.nextMoney(new Integer(br.readLine()));
            while(br.ready()){
                String[] t = br.readLine().split(" ");
                gameStage.spawnEnemy(new Integer(t[0]), new Integer(t[1]));
            }
            gameStage.startWave();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
