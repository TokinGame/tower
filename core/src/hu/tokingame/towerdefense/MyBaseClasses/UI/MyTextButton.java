package hu.tokingame.towerdefense.MyBaseClasses.UI;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import hu.tokingame.towerdefense.MyBaseClasses.Game.InitableInterface;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MyTextButton extends MyButton{

    public MyTextButton(String text, TextButtonStyle style) {
        super(text, style);
        init();
    }

    public void init() {
    }
}
