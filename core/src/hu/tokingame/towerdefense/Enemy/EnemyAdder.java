package hu.tokingame.towerdefense.Enemy;

/**
 * Created by M on 1/25/2018.
 */

public class EnemyAdder{
    private Enemy enemy;
    private float timout;

    public EnemyAdder(Enemy enemy, float timeout){
        this.enemy = enemy;
        this.timout = timeout;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public float getTimout() {
        return timout;
    }
}