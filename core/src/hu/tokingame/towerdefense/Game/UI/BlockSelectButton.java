package hu.tokingame.towerdefense.Game.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by davimatyi on 2018. 01. 16..
 */

public class BlockSelectButton extends OneSpriteStaticActor {
    BlockSelector blockSelector;
    private final int id;
    public BlockSelectButton(float x, float y, BlockSelector bs, int i) {
        super(Assets.manager.get(Assets.WALL_TEXTURE));
        blockSelector = bs;
        setPosition(x, y);
        setSize(200, 100);
        id = i;
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                blockSelector.selected(id);
            }
        });
    }


}
