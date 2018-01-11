package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Game.UI.BlockSelector;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by davim on 2018. 01. 11..
 */

public class ControlStage extends MyStage {
    GameStage gameStage;
    public ControlStage(Viewport viewport, Batch batch, MyGdxGame game, GameStage gameStage) {
        super(viewport, batch, game);
        this.gameStage = gameStage;
    }

    @Override
    public void init() {

        addActor(new BlockSelector());


        initGrid();

    }


    void initGrid(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                final int finalI = i;
                final int finalJ = j;
                addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GRID_SQUARE)){
                    @Override
                    public void init() {
                        super.init();
                        setSize(90, 90);
                        setX(280+ finalJ *90);
                        setY((7- finalI)*90);
                        addListener(new ClickListener(){
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                super.clicked(event, x, y);
                                System.out.println("clicked "+finalI+" : "+finalJ);
                                gameStage.placeElement(finalI, finalJ);
                            }
                        });
                    }
                });
            }
        }
    }
}
