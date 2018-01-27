package hu.tokingame.towerdefense.Game.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;

/**
 * Created by davimatyi on 2018. 01. 26..
 */

public class MoneySpentText extends MyLabel {
    public MoneySpentText(String text, LabelStyle labelStyle, float x, float y) {
        super(text, labelStyle);
        setSize(80, 40);
        setX(280+ y * Globals.GRID_WIDTH);
        setY(((Globals.MAP_SIZE-1) - x)*Globals.GRID_HEIGHT+ Globals.GRID_HEIGHT);
        addAction(Actions.sequence(Actions.moveTo(getX(), getY()+40, 0.4f), Actions.removeActor()));
    }
}
