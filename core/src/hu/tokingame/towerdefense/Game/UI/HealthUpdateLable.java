package hu.tokingame.towerdefense.Game.UI;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;

/**
 * Created by M on 2/1/2018.
 */

public class HealthUpdateLable extends MyLabel {

    public HealthUpdateLable(String text, LabelStyle labelStyle) {
        super(text, labelStyle);
        setSize(80, 40);
        setPosition(Globals.WORLD_WIDTH - 200 + 40,410);
        addAction(Actions.sequence(Actions.moveTo(getX(), getY()+40, 0.4f), Actions.removeActor()));
    }
}