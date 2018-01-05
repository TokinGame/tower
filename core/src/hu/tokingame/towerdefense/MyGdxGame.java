package hu.tokingame.towerdefense;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {
	SpriteBatch batch;
	Texture img;

	public Label.LabelStyle getLabelStyle() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		style.fontColor = Color.YELLOW;
		return style;
	}

	public TextField.TextFieldStyle getTextFieldStyle() {
		// TODO: 1/5/2018 textfield texture 
		TextField.TextFieldStyle style = new TextField.TextFieldStyle();
		// style.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.TEXTBOX_TEXTURE)));
		style.background.setLeftWidth(style.background.getLeftWidth()+20);
		style.background.setRightWidth(style.background.getRightWidth()+20);
		style.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		// style.cursor = new TextureRegionDrawable(new TextureRegion(new TextureRegion(Assets.manager.get(Assets.CURSOR_TEXTURE))));
		// style.cursor.setMinWidth(50);
		style.fontColor = Color.BLACK;
		// style.selection = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BLUE_TEXTURE)));
		return style;
	}


	public TextButton.TextButtonStyle getTextButtonStyle() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		// TODO: 1/5/2018 Button texture 
		/*
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BLUE_TEXTURE)));
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.GREEN_TEXTURE)));
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.YELLOW_TEXTURE)));
		*/
		return textButtonStyle;
	}


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
