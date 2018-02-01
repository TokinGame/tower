package hu.tokingame.towerdefense.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.towerdefense.Game.GameScreen;
import hu.tokingame.towerdefense.Game.UI.RocketLaunch;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.UI.MyLabel;
import hu.tokingame.towerdefense.MyGdxGame;

/**
 * Created by zoltan on 2018.02.01..
 */

public class FirstStartStage extends MyStage {

    private MyLabel label;

    public FirstStartStage(Viewport viewport, Batch batch, final MyGdxGame game) {
        super(viewport, batch, game);
        addActor(new RocketLaunch(){
            @Override
            public void finished() {
                super.finished();
                game.setScreen(new MenuScreen(game),false);
            }
        });

        addActor(label = new MyLabel("2030-at írunk. Magyarország átvette a vezetést az űkutatásban, és a cél már nem a mars, hanem a plutó nevű törpe bolygó.\n" +
                "A Betyár-2 rakétát 2029 augusztus 20-án lőtték és a különleges Erős Pista hajtóanyag miatt el is érte célját Február 2-ra.\n" +
                "Viszont bátor űrhajósaink a leszállás után nehézségekbe ütköztek, ugyanis a bolygók nem ők az első értelmes lények.", game.getLabelStyle_White()){
            @Override
            public void init() {
                super.init();
                this.setPosition(-this.getHeight(), Globals.WORLD_HEIGHT/2f - this.getHeight() / 2f);
            }
        });

        label.addAction(Actions.sequence(Actions.moveTo(label.getX(), 50, 1f), Actions.removeActor()));
    }

    @Override
    public void init() {

    }
}
