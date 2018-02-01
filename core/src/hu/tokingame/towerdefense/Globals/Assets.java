package hu.tokingame.towerdefense.Globals;

/**
 * Created by M on 1/5/2018.
 */



import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
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

    public static final AssetDescriptor<Texture> WALL_TEXTURE = new AssetDescriptor<Texture>("Buildings/wall.jpg", Texture.class);
    public static final AssetDescriptor<Texture> TURRET_TEXTURE = new AssetDescriptor<Texture>("Buildings/agyuegybe.jpg", Texture.class);
    public static final AssetDescriptor<Texture> GREEN_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_zold.png", Texture.class);
    public static final AssetDescriptor<Texture> BLUE_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_kek.png", Texture.class);
    public static final AssetDescriptor<Texture> YELLOW_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_sarga.png", Texture.class);
    public static final AssetDescriptor<Texture> RED_ALIEN = new AssetDescriptor<Texture>("Creatures/leny_piros.png", Texture.class);
    public static final AssetDescriptor<Texture> GRID_SQUARE = new AssetDescriptor<Texture>("UI/grid_square.png", Texture.class);
    public static final AssetDescriptor<Texture> BACKGROUND = new AssetDescriptor<Texture>("szakkor/hatter.png", Texture.class);
    public static final AssetDescriptor<Texture> EMPTY = new AssetDescriptor<Texture>("OtherTextures/zolipls.png", Texture.class);
    public static final AssetDescriptor<Texture> MENHAJ = new AssetDescriptor<Texture>("szakkor/urhajomagaba2.png", Texture.class);



   


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

        manager.load(WALL_TEXTURE);
        manager.load(GRID_SQUARE);

        manager.load(TURRET_TEXTURE);
        manager.load(GREEN_ALIEN);
        manager.load(BLUE_ALIEN);
        manager.load(YELLOW_ALIEN);
        manager.load(RED_ALIEN);
    }

    public static void afterLoaded() {
        // TODO: 1/5/2018 zene 
    }

    public static void unload() {
        manager.dispose();
    }

}

