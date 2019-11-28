package com.bnito.proyectofinal;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bnito.proyectofinal.states.GameStateManager;
import com.bnito.proyectofinal.states.MenuState;

public class ProyectoFinal extends ApplicationAdapter {

	public static final int ANCHO = 480;
	public static final int ALTO = 720;
	public static final String TITLE = "PROYECTO FINAL DE PROGRAMACION MOVIL";

	private GameStateManager gsm;
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.actualizar(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
