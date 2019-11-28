package com.bnito.proyectofinal.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Play {

    private Animacion playAnimacion;
    private Texture texture;
    private Vector3 posicion;
    private Rectangle contorno;

    public Play(int x, int y){

        posicion = new Vector3(x, y, 0);
        texture = new Texture("playbtn.png");
        playAnimacion = new Animacion(new TextureRegion(texture), 3, 0.5f);
        contorno = new Rectangle(x, y, texture.getWidth()/3, texture.getHeight());
    }

    public void actualizar (float dt){
        playAnimacion.actualizar(dt);
    }

    public Vector3 getPosicion() {
        return posicion;
    }

    public TextureRegion getTexture() {
        return playAnimacion.getFrame();
    }

    public void dispose(){
        texture.dispose();
    }

}
