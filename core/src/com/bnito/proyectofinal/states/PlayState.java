package com.bnito.proyectofinal.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.bnito.proyectofinal.ProyectoFinal;
import com.bnito.proyectofinal.sprites.Personaje;
import com.bnito.proyectofinal.sprites.Puas;


public class PlayState extends State{

    private static final int OBS_SPACING = 125;
    private static final int OBS_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -30;

    private Personaje personaje;
    private Texture bg;

    private Texture lava;
    private Vector2 lava1;
    private Vector2 lava2;

    private Array<Puas> puas;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        personaje = new Personaje(50, 150);
        camara.setToOrtho(false, ProyectoFinal.ANCHO / 2, ProyectoFinal.ALTO / 2);
        bg = new Texture("fondo.png");

        lava = new Texture("lava.png");
        lava1 = new Vector2(camara.position.x - camara.viewportWidth / 2, GROUND_Y_OFFSET);
        lava2 = new Vector2((camara.position.x - camara.viewportWidth / 2) + lava.getWidth(), GROUND_Y_OFFSET);

        puas = new Array<Puas>();

        for (int i = 1; i <= OBS_COUNT; i++){
            puas.add(new Puas(i * (OBS_SPACING + Puas.OBS_WIDTH)));
        }
    }

    @Override
    protected void manejarEntrada() {
        if (Gdx.input.justTouched()){
            personaje.bajar();
        }
    }

    @Override
    public void actualizar(float dt) {
        manejarEntrada();
        actualizarLava();
        personaje.actualizar(dt);

        camara.position.x = personaje.getPosicion().x + 80;

        for (int i = 0; i <puas.size; i++) {
            Puas pu = puas.get(i);
            if (camara.position.x - (camara.viewportWidth / 2) > pu.getPosAbajoPua().x + pu.getArribaObstaculo().getWidth()) {
                pu.reposicionar(pu.getPosArribaPua().x + ((Puas.OBS_WIDTH + OBS_SPACING) * OBS_COUNT));
            }
            if (pu.colision(personaje.getContorno())){
                gsm.set(new GameOverState(gsm));
            }
        }

        if (personaje.getPosicion().y <= lava.getHeight() + GROUND_Y_OFFSET){
            gsm.set(new GameOverState(gsm));
        }

        camara.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.setProjectionMatrix(camara.combined);

        spriteBatch.begin();
        spriteBatch.draw(bg, camara.position.x - (camara.viewportWidth/2),camara.position.y - (camara.viewportHeight/2));
        spriteBatch.draw(personaje.getTexture(), personaje.getPosicion().x, personaje.getPosicion().y);
        for ( Puas pu: puas) {
            spriteBatch.draw(pu.getArribaObstaculo(), pu.getPosArribaPua().x, pu.getPosArribaPua().y);
            spriteBatch.draw(pu.getAbajoObstaculo(), pu.getPosAbajoPua().x, pu.getPosAbajoPua().y);
        }
        spriteBatch.draw(lava, lava1.x, lava1.y);
        spriteBatch.draw(lava, lava2.x, lava2.y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        lava.dispose();
        personaje.dispose();
        for (Puas pu: puas){
            pu.dispose();
        }
    }
    private void actualizarLava() {
        if (camara.position.x - (camara.viewportWidth / 2) > lava1.x + lava.getWidth())
            lava1.add(lava.getWidth() * 2, 0);
        if (camara.position.x - (camara.viewportWidth / 2) > lava2.x + lava.getWidth())
            lava2.add(lava.getWidth() * 2, 0);
    }
}

