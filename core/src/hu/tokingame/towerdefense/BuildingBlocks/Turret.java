package hu.tokingame.towerdefense.BuildingBlocks;

import com.badlogic.gdx.graphics.Texture;

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

    private int range = 3, damage = 1;
    float timing = 1;

    public Turret(float x, float y, GameStage gameStage) {
        super(Assets.manager.get(Assets.TURRET_TEXTURE), x, y);
        setOrigintoCenter();
        addCollisionShape("Range",new MyCircle((float) (Math.sqrt(getWidth()* range * getHeight()* range) / 2), 0, 0, getOriginX(), getOriginY(), getX()+getWidth()/2, getY()+getHeight()/2, false));
        System.out.println("range "+range+" damage " +damage);
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
    }

    public void shoot(Enemy enemy){
        if(getStage() != null){
            getStage().addActor(new TurretProjectile(enemy, this, getDamage()));
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
            System.out.println(this.getOtherOverlappedShapeKeys(toFollow));
            if(this.getOtherOverlappedShapeKeys(toFollow).contains("ProjRect")){
                toFollow.takeDamage(damage);
                this.remove();
            }

            if(!(toFollow.getX() + 3 < getX())){
                this.setX(this.getX() + 10);
            }else if(!(toFollow.getX() - 3 > getX())){
                this.setX(this.getX() - 10);
            }

            if(!(toFollow.getY() + 3 < getY())){
                this.setY(this.getY() + 10);
            }else if(!(toFollow.getY() - 3 > getY())){
                this.setY(this.getY() - 10);
            }


        }

        @Override
        public void init() {
            super.init();
        }
    }
}
