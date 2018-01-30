package hu.tokingame.towerdefense.BuildingBlocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import hu.tokingame.towerdefense.Enemy.Enemy;
import hu.tokingame.towerdefense.Game.GameStage;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyActor;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyCircle;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyRectangle;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by davimatyi on 2018. 01. 17..
 */

public class Turret extends BuildingBlock {

    private int range = 4, damage = 1;
    float timing = 1;

    private float moveAmount = 5;

    private float debugtimer = 2;

    ShapeRenderer shapeRenderer;

    public Turret(float x, float y, GameStage gameStage, int r, int d) {
        super(Assets.manager.get(Assets.TURRET_TEXTURE), x, y);
        setOrigintoCenter();
        range = r;
        damage = d;
        addCollisionShape("Range",new MyCircle((float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2), 0, 0, getOriginX(), getOriginY(), getX()+getWidth()/2, getY()+getHeight()/2, false));
        System.out.println("range "+range+" damage " + damage);


    }

    public Turret(float x, float y, GameStage gameStage) {
        super(Assets.manager.get(Assets.TURRET_TEXTURE), x, y);
        setOrigintoCenter();
        addCollisionShape("Range",new MyCircle((float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2), 0, 0, getOriginX(), getOriginY(), getX()+getWidth()/2, getY()+getHeight()/2, false));
        System.out.println("range "+range+" damage " + damage);

    }


    @Override
    public void upgrade() {
        super.upgrade();
        damage++;
        if(damage%5 == 0) {
            range++;
            removeCollisionShape("Range");
            addCollisionShape("Range",new MyCircle((float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2), 0, 0, getOriginX(), getOriginY(), getX()+getWidth()/2, getY()+getHeight()/2, false));
        }
        System.out.println("UPGRADED");
        System.out.println("range "+range+" damage " +damage);
        debugtimer = 2;
    }

    public void shoot(Enemy enemy){
        if(getStage() != null){
            getStage().addActor(new TurretProjectile(enemy, this, damage));
        }
    }


    public int getDamage() {
        return damage;
    }

    public class TurretProjectile extends OneSpriteStaticActor{
        private Enemy toFollow;
        private int damage;

        public TurretProjectile(Enemy toFollow, Turret turret, int damage) {
            super(Assets.manager.get(Assets.BADLOGIC_TEXTURE));
            this.toFollow = toFollow;
            this.damage = damage;
            this.setSize(20,20);
            this.setPosition(turret.getX(), turret.getY());
            addCollisionShape("ProjRect", new MyRectangle(getWidth(),getHeight(),0,0,getOriginX(), getOriginY(), getRotation(), 0, true));
        }

        @Override
        public void act(float delta) {
            super.act(delta);
            //System.out.println(this.getMyOverlappedShapeEntries(toFollow));
            if(this.getMyOverlappedShapeKeys(toFollow).contains("ProjRect")){
                System.out.println("damage: " + damage);
                this.remove();
                toFollow.takeDamage(damage);
            }

            if(!(toFollow.getX() + 3 < getX())){
                this.setX(this.getX() + moveAmount);
            }else if(!(toFollow.getX() - 3 > getX())){
                this.setX(this.getX() - moveAmount);
            }

            if(!(toFollow.getY() + 3 < getY())){
                this.setY(this.getY() + 10);
            }else if(!(toFollow.getY() - 3 > getY())){
                this.setY(this.getY() - moveAmount);
            }

            if(debugtimer > 0) {
                debugtimer -= delta;
                System.out.println("debug drawn for range");
                //drawDebugLines(new Vector2[0], shapeRenderer);

            }

            //drawDebugBounds(shapeRenderer);



        }

        @Override
        public void init() {
            super.init();
            /*shapeRenderer = new ShapeRenderer(200);
            shapeRenderer.setProjectionMatrix();
            shapeRenderer.begin();
            shapeRenderer.setColor(1, 1, 0, 1);
            shapeRenderer.circle(getX(), getY(), (float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2));*/
            //shapeRenderer.end();
        }
    }
}
