package com.bnito.proyectofinal.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Personaje {

    private static final int MOVIMIENTO = 85;
    private static final int GRAVEDAD = 5;

    private Vector3 posicion;
    private Vector3 velocidad;

    private Animacion personajeAnimacion;
    private Texture texture;

    private Rectangle contorno;
    private Sound flap;

    public Personaje(int x, int y){
        posicion = new Vector3(x, y, 0);
        velocidad = new Vector3(0,0,0);
        texture = new Texture("personajeAnimacion.png");
        personajeAnimacion = new Animacion(new TextureRegion(texture), 5, 0.5f);
        /*flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));*/
        contorno = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
    }
    public void actualizar(float dt){
        personajeAnimacion.actualizar(dt);
        if (posicion.y > 0){
            velocidad.add(0,GRAVEDAD,0);
        }
        velocidad.scl(dt);
        posicion.add(MOVIMIENTO * dt,velocidad.y,0);

        if (posicion.y < 0){
            posicion.y = 0;
        }
        velocidad.scl(1/dt);
        contorno.setPosition(posicion.x, posicion.y);
    }

    public Rectangle getContorno(){
        return contorno;
    }

    public Vector3 getPosicion() {
        return posicion;
    }

    public TextureRegion getTexture() {
        return personajeAnimacion.getFrame();
    }

    public void bajar(){
        velocidad.y = -125;
 /*       flap.play(0.03f);*/
    }

    public void dispose(){
        texture.dispose();
 /*       flap.dispose();*/
    }
}
