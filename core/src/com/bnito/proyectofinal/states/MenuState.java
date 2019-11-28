package com.bnito.proyectofinal.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bnito.proyectofinal.ProyectoFinal;
import com.bnito.proyectofinal.sprites.Play;

public class MenuState extends State{

    private Texture background;
    private Play playbtn;

    public MenuState(GameStateManager gsm){
        super(gsm);
        camara.setToOrtho(false, ProyectoFinal.ANCHO/2, ProyectoFinal.ALTO/2);
        background = new Texture("fondo.png");
        playbtn = new Play(65, 155);

    }
    @Override
    public void manejarEntrada() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void actualizar(float dt) {
        manejarEntrada();
        playbtn.actualizar(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camara.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0,0);
        spriteBatch.draw(playbtn.getTexture(),playbtn.getPosicion().x, playbtn.getPosicion().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}

