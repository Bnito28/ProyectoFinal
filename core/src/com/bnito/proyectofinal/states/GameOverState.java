package com.bnito.proyectofinal.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bnito.proyectofinal.ProyectoFinal;

public class GameOverState extends State {

    private Texture background;
    private Texture over;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        camara.setToOrtho(false, ProyectoFinal.ANCHO/2, ProyectoFinal.ALTO/2);
        background = new Texture("fondo.png");
        over = new Texture("gameover.png");
    }

    @Override
    protected void manejarEntrada() {
        if (Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void actualizar(float dt) {
        manejarEntrada();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camara.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0,0);
        spriteBatch.draw(over, camara.position.x - over.getWidth()/2, camara.position.y);
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        over.dispose();
    }
}
