package com.bnito.proyectofinal.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected OrthographicCamera camara;
    protected Vector3 raton;
    protected GameStateManager gsm;

    protected  State(GameStateManager gameStateManager){
        this.gsm = gameStateManager;
        camara = new OrthographicCamera();
        raton = new Vector3();
    }

    protected abstract void manejarEntrada();
    public abstract void actualizar(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public  abstract void dispose();
}
