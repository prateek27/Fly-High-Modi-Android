package com.gamershq.FMHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture, logoTexture,tempTexture;
	public static TextureRegion logo, zbLogo, bg, grass, bird, birdDown,
			birdUp, skullUp, skullDown, bar, playButtonUp, playButtonDown,
			ready, gameOver, highScore, scoreboard, star, noStar, retry,
			fire1,fire2,fire3,fire4,fire1down,fire2down,fire3down,fire4down;
	public static Animation birdAnimation,fireAnimation,fireDownAnimation;
	public static Sound dead, flap, coin, fall;
	public static BitmapFont font, shadow, whiteFont;
	private static Preferences prefs;

	public static void load() {

		logoTexture = new Texture(Gdx.files.internal("data/logo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 114);

		texture = new Texture(Gdx.files.internal("data/modi-sprite-complete.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Linear);

		
		
		playButtonUp = new TextureRegion(texture, 631, 378, 125, 71);
		playButtonDown = new TextureRegion(texture,769, 378, 125, 71);
		playButtonUp.flip(false, true);
		playButtonDown.flip(false, true);

		ready = new TextureRegion(texture, 808, 220, 206, 53);
		ready.flip(false, true);

		retry = new TextureRegion(texture, 808, 157, 206, 53);
		retry.flip(false, true);
		
		gameOver = new TextureRegion(texture, 805, 91, 206, 54);
		gameOver.flip(false, true);

		scoreboard = new TextureRegion(texture, 658, 487, 350, 120);
		scoreboard.flip(false, true);

		star = new TextureRegion(texture, 707, 626, 34, 34);
		noStar = new TextureRegion(texture, 661, 621, 34, 34);

		star.flip(false, true);
		noStar.flip(false, true);

		highScore = new TextureRegion(texture, 805, 27, 206, 53);
		highScore.flip(false, true);

		zbLogo = new TextureRegion(texture, 630, 348, 130, 21);
		zbLogo.flip(false, true);

		bg = new TextureRegion	(texture, 0, 0,614, 621);
		bg.flip(false, true);

		grass = new TextureRegion(texture, 0,643,614,230);
		grass.flip(false, true);

		birdDown = new TextureRegion(texture, 718, 80, 71, 46);
		birdDown.flip(false, true);

		bird = new TextureRegion(texture, 718, 27, 71, 47);
		bird.flip(false, true);

		birdUp = new TextureRegion(texture, 718, 136, 71, 47);
		birdUp.flip(false, true);
		
		fire1 = new TextureRegion(texture, 492, 892, 72, 131);
		fire1.flip(false,true);
		
		fire2 = new TextureRegion(texture, 792, 884, 72, 139);
		fire2.flip(false,true);
		
		fire3 = new TextureRegion(texture, 792, 869, 72, 154);
		fire3.flip(false,true);
		
		fire4 = new TextureRegion(texture, 945, 882, 72, 141);
		fire4.flip(false,true);
		
		fire1down=new TextureRegion(fire4);
		fire1down.flip(false, true);
		
		fire2down=new TextureRegion(fire3);
		fire2down.flip(false, true);
		
		fire3down=new TextureRegion(fire2);
		fire3down.flip(false, true);
		
		fire4down=new TextureRegion(fire1);
		fire4down.flip(false, true);
		

		TextureRegion[] birds = { birdDown, bird, birdUp };
		TextureRegion[] fires = {fire1,fire2,fire3,fire4};
		TextureRegion[] firesDown = {fire1down,fire2down,fire3down,fire4down};
		birdAnimation = new Animation(0.06f, birds);
		birdAnimation.setPlayMode(Animation.LOOP_PINGPONG);

		fireAnimation = new Animation(0.12f,fires);
		fireAnimation.setPlayMode(Animation.LOOP_PINGPONG);
		
		fireDownAnimation = new Animation(0.12f,firesDown);
		fireDownAnimation.setPlayMode(Animation.LOOP_PINGPONG);
		
		skullUp = new TextureRegion(texture, 492, 909, 72, 114);
		// Create by flipping existing skullUp
		skullDown = new TextureRegion(skullUp);
		skullDown.flip(false, true);

		bar = new TextureRegion(texture, 737, 210, 22, 37);
		bar.flip(false, true);

		dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
		flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
		coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
		fall = Gdx.audio.newSound(Gdx.files.internal("data/fall.wav"));

		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(.25f, -.25f);

		whiteFont = new BitmapFont(Gdx.files.internal("data/whitetext.fnt"));
		whiteFont.setScale(.1f, -.1f);

		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.setScale(.25f, -.25f);

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("ZombieBird");

		if (!prefs.contains("highScore")) {
			prefs.putInteger("highScore", 0);
		}
	}

	public static void setHighScore(int val) {
		prefs.putInteger("highScore", val);
		prefs.flush();
	}

	public static int getHighScore() {
		return prefs.getInteger("highScore");
	}

	public static void dispose() {
		// We must dispose of the texture when we are finished.
		texture.dispose();

		// Dispose sounds
		dead.dispose();
		flap.dispose();
		coin.dispose();

		font.dispose();
		shadow.dispose();
	}

}