package hu.tokingame.towerdefense.Enemy;

/**
 * Created by M on 1/25/2018.
 */

public class EnemyAdder{
    private Enemy enemy;
    private float timeOut;

    public EnemyAdder(Enemy enemy, float timeout){
        this.enemy = enemy;
        this.timeOut = timeout;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public float getTimeOut() {
        return timeOut;
    }
}