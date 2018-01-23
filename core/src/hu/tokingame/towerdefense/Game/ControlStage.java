package hu.tokingame.towerdefense.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Game.UI.BlockSelector;
import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.towerdefense.MyGdxGame;

import static hu.tokingame.towerdefense.Globals.Globals.GRID_HEIGHT;
import static hu.tokingame.towerdefense.Globals.Globals.GRID_WIDTH;
import static hu.tokingame.towerdefense.Globals.Globals.MAP_SIZE;

/**
 * Created by davim on 2018. 01. 11..
 */

public class ControlStage extends MyStage {
    private GameStage gameStage;
    MyLabel message;

    public ControlStage(Viewport viewport, Batch batch, MyGdxGame game, GameStage gameStage) {
        super(viewport, batch, game);
        this.gameStage = gameStage;
    }

    @Override
    public void init() {

        addActor(new BlockSelector(gameStage));


        initGrid();

        addActor(message = new MyLabel("", game.getLabelStyle()));
        message.setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 600);
        message.setAlignment(1);
        //message.setVisible(false);

        addActor(new MyTextButton("Kör teszt", game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-getWidth(), Globals.WORLD_HEIGHT-getHeight());
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        if(!gameStage.duringWave)gameStage.startWave();
                        else gameStage.endWave();
                    }
                });
            }
        });
    }


    void initGrid(){
        for (int i = 0; i < MAP_SIZE; i++){
            for (int j = 0; j < MAP_SIZE; j++){
                final int finalI = i;
                final int finalJ = j;
                addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GRID_SQUARE)){
                    @Override
                    public void init() {
                        super.init();
                        setSize(GRID_WIDTH, GRID_HEIGHT);
                        setX(280 + finalJ * GRID_WIDTH);
                        setY((MAP_SIZE - 1 - finalI) * GRID_HEIGHT);
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
    void showMessage(String text){
        message.setText(text);
        message.setPosition(Globals.WORLD_WIDTH/2-message.getWidth()/2, 600);
        message.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(0.5f), Actions.delay(2), Actions.fadeOut(0.5f), Actions.alpha(0)));
    }
}
