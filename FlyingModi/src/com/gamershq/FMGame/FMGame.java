package com.gamershq.FMGame;

import com.badlogic.gdx.Game;
import com.gamershq.FMHelpers.AssetLoader;
import com.gamershq.Screens.SplashScreen;

public class FMGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}