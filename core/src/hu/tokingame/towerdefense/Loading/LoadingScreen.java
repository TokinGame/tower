package hu.tokingame.towerdefense.Loading;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Globals.Globals;
import hu.tokingame.towerdefense.Menu.MenuScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.tokingame.towerdefense.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.towerdefense.MyGdxGame;


/**
 * Created by M on 11/9/2017.
 */

public class LoadingScreen extends MyScreen {

    MyStage stage;

    private float elapsedTime = 0;
    private OneSpriteStaticActor backGround;


    public LoadingScreen(MyGdxGame game) {
        super(game);
        setBackGroundColor(0f, 0f, 0f);
        stage = new MyStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game){
            @Override
            public void init() {

            }
        };
        //stage.addActor(backGround= new OneSpriteStaticActor("loadingbg.png"));
//        backGround.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
  //      backGround.setPosition(0,0);
        stage.addActor(new OneSpriteAnimatedActor("loading/loading.txt")
        {
            @Override
            public void init() {
                super.init();
                setFps(30);
                setSize(400, 400);
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, Globals.WORLD_HEIGHT/2-this.getHeight()/2);
            }
        });
    }


    @Override
    public void show() {
        Assets.manager.finishLoading();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (elapsedTime > 2.0 && Assets.manager.update()) {
            if (Assets.manager.update()) {
                Assets.afterLoaded();
                game.setScreen(new MenuScreen(game));
            }
        }
        elapsedTime += delta;
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {

    }

    @Override
    public void init() {
        setBackGroundColor(0f, 0f, 0f);
    }

}
