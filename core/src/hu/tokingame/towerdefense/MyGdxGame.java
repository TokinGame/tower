package hu.tokingame.towerdefense;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import hu.tokingame.towerdefense.Globals.Assets;
import hu.tokingame.towerdefense.Menu.MenuScreen;
import hu.tokingame.towerdefense.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {
	SpriteBatch batch;
	Texture img;

	public Label.LabelStyle getLabelStyle() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		style.fontColor = Color.YELLOW;
		return style;
	}

	public TextField.TextFieldStyle getTextFieldStyle() {
		// TODO: 1/5/2018 textfield texture 
		TextField.TextFieldStyle style = new TextField.TextFieldStyle();
		// style.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.TEXTBOX_TEXTURE)));
		style.background.setLeftWidth(style.background.getLeftWidth()+20);
		style.background.setRightWidth(style.background.getRightWidth()+20);
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		// style.cursor = new TextureRegionDrawable(new TextureRegion(new TextureRegion(Assets.manager.get(Assets.CURSOR_TEXTURE))));
		// style.cursor.setMinWidth(50);
		style.fontColor = Color.BLACK;
		// style.selection = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BLUE_TEXTURE)));
		return style;
	}


	public TextButton.TextButtonStyle getTextButtonStyle() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.CALIBRI_FONT);
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
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
	}
}
