package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by davim on 2018. 01. 25.
 */

public class WaveLoader implements Runnable {


    int rd(int a , int b){return (int)(Math.random()*(b-a+1)+a);}

    ArrayList<int[]> upcoming = new ArrayList<int[]>();

    GameStage gameStage;
    public WaveLoader(GameStage g) {
        gameStage = g;
    }

    @Override
    public void run() {

    }

    public void load(int l){
        /*try {
            InputStreamReader isr = new InputStreamReader(Gdx.files.internal("Waves/"+l+".txt").read());
            BufferedReader br = new BufferedReader(isr);
            //gameStage.nextMoney(new Integer(br.readLine()));
            String k[] = br.readLine().split(" ");
            gameStage.nextMoney(new Integer(k[0]));
            if(k.length>1) gameStage.addHealthAfterRound = true;
            while(br.ready()){
                String[] t = br.readLine().split(" ");
                int[] kl = {new Integer(t[0]), new Integer(t[1])};
                upcoming.add(kl);
            }
            //gameStage.startWave();
        }catch(FileNotFoundException fileex){
            gameStage.messageRelay(fileex.getLocalizedMessage());
            fileex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/

        gameStage.moneyToBeAdded = 500;

        System.out.println("lellvlelelel" + l);

        if(l % 5 == 0){
            gameStage.addHealthAfterRound = true;


            if(l % 10 == 0){
                gameStage.moneyToBeAdded = 1000;
                for(int i = 0; i < l/10; i++){
                    int kl[] = {7, i*5};
                    System.out.println("klklklk" + kl);
                    upcoming.add(kl);
                }
            }else{
                for(int i = 0; i < l/5; i++){
                    int kl[] = {6, i*5};
                    System.out.println("klklklk" + kl);
                    upcoming.add(kl);
                }
            }
        }else{

            int ll = l % 5;

            System.out.println("lllllllll"+ll);

            int hk = l / 5 + 1;

            System.out.println("hhhhhhhhkkkkk "+hk);



            if(rd(1,10) > 8){
                int kl[] = {5, 3};
                System.out.println("BOMBU");
                upcoming.add(kl);
            }






        }



    }

    public ArrayList<int[]> getUpcoming() {
        return upcoming;
    }
}
