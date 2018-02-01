package hu.tokingame.towerdefense.Globals;

/**
 * Created by M on 1/5/2018.
 */



import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;


public class Assets {

    public static AssetManager manager;
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter.fontFileName = "calibril.ttf";////
        fontParameter.fontParameters.size = 50;
        fontParameter.fontParameters.characters = CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }
    public static final AssetDescriptor<BitmapFont> CALIBRI_FONT = new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


    public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);

    public static final AssetDescriptor<Texture> CIRCLE_TEXTURE = new AssetDescriptor<Texture>("OtherTextures/circle.png", Texture.class);
    public static final AssetDescriptor<Texture> WALL_TEXTURE = new AssetDescriptor<Texture>("Buildings/wall.jpg", Texture.class);
    public static final AssetDescriptor<Texture> TURRET_TEXTURE = new AssetDescriptor<Texture>("Buildings/agyuegybe.jpg", Texture.class);
    public static final AssetDescriptor<Texture> GREEN_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_zold.png", Texture.class);
    public static final AssetDescriptor<Texture> BLUE_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_kek.png", Texture.class);
    public static final AssetDescriptor<Texture> YELLOW_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_sarga.png", Texture.class);
    public static final AssetDescriptor<Texture> BOMBU_ALIEN = new AssetDescriptor<Texture>("Creatures/bombu.png", Texture.class);
    public static final AssetDescriptor<Texture> GREEN_BOSS = new AssetDescriptor<Texture>("Creatures/boss_zold.png", Texture.class);
    public static final AssetDescriptor<Texture> YELLOW_BOSS = new AssetDescriptor<Texture>("Creatures/boss_sarga.png", Texture.class);
    public static final AssetDescriptor<Texture> BLUE_BOSS = new AssetDescriptor<Texture>("Creatures/boss_kek.png", Texture.class);
    public static final AssetDescriptor<Texture> RED_BOSS = new AssetDescriptor<Texture>("Creatures/boss_piros.png", Texture.class);
    public static final AssetDescriptor<Texture> RED_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_piros.png", Texture.class);
    public static final AssetDescriptor<Texture> GRID_SQUARE = new AssetDescriptor<Texture>("UI/grid_square.png", Texture.class);
    public static final AssetDescriptor<Texture> BACKGROUND = new AssetDescriptor<Texture>("UI/hatter.png", Texture.class);
    public static final AssetDescriptor<Texture> EMPTY = new AssetDescriptor<Texture>("OtherTextures/zolipls.png", Texture.class);
    public static final AssetDescriptor<Texture> MENHAJ = new AssetDescriptor<Texture>("UI/urhajomagaba2.png", Texture.class);
    public static final AssetDescriptor<Texture> BACKGROUND_NOCON = new AssetDescriptor<Texture>("UI/hatter_sima.png", Texture.class);
    public static final AssetDescriptor<Texture> BACKGROUND_GAME = new AssetDescriptor<Texture>("szakkor/jatekhatter.png", Texture.class);
    public static final AssetDescriptor<Texture> ROBBANT_PARLAMENT = new AssetDescriptor<Texture>("UI/parlament_robbant.png", Texture.class);
    public static final AssetDescriptor<Texture> PARLAMENT = new AssetDescriptor<Texture>("UI/parlament.png", Texture.class);
    public static final AssetDescriptor<Texture> STEEL = new AssetDescriptor<Texture>("UI/steel_texture.png", Texture.class);
    public static final AssetDescriptor<Texture> SZIV = new AssetDescriptor<Texture>("UI/sziv.png", Texture.class);
    public static final AssetDescriptor<Texture> LABEL_BG = new AssetDescriptor<Texture>("UI/labelbg.png", Texture.class);
    public static final AssetDescriptor<Music> MAIN_MUSIC = new AssetDescriptor<Music>("music/menuzene.wav", Music.class);
    public static final AssetDescriptor<Texture>[] ROCKET_LAUNCH = new AssetDescriptor[]{
            new AssetDescriptor<Texture>("rocketlaunch/1.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/2.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/3.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/4.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/5.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/6.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/7.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/8.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/9.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/10.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/11.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/12.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/13.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/14.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/15.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/16.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/17.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/18.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/19.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/20.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/21.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/22.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/23.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/24.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/25.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/26.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/27.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/28.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/29.png", Texture.class),
            new AssetDescriptor<Texture>("rocketlaunch/30.png", Texture.class)};





    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load() {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));
        manager.load(BACKGROUND);
        manager.load(MENHAJ);
        manager.load(EMPTY);
        manager.load(BADLOGIC_TEXTURE);
        manager.load(CALIBRI_FONT);
        manager.load(BACKGROUND_GAME);

        manager.load(WALL_TEXTURE);
        manager.load(GRID_SQUARE);

        manager.load(TURRET_TEXTURE);
        manager.load(GREEN_ALIEN);
        manager.load(BLUE_ALIEN);
        manager.load(YELLOW_ALIEN);
        manager.load(RED_ALIEN);

        manager.load(CIRCLE_TEXTURE);

        manager.load(BACKGROUND_NOCON);
        manager.load(ROBBANT_PARLAMENT);
        manager.load(PARLAMENT);
        manager.load(STEEL);
        manager.load(SZIV);

        manager.load(LABEL_BG);
        manager.load(MAIN_MUSIC);

        manager.load(BOMBU_ALIEN);
        manager.load(GREEN_BOSS);
        manager.load(BLUE_BOSS);
        manager.load(YELLOW_BOSS);
        manager.load(RED_BOSS);

        for (AssetDescriptor<Texture> frame: ROCKET_LAUNCH) {
            manager.load(frame);
        }
    }

    public static void afterLoaded() {
        // TODO: 1/5/2018 zene
        manager.get(MAIN_MUSIC).setLooping(true);
        if (Globals.music) manager.get(MAIN_MUSIC).play();
    }

    public static void unload() {
        manager.dispose();
    }
}

