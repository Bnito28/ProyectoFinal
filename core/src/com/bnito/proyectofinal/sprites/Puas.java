package com.bnito.proyectofinal.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;


public class Puas {

    public static final int OBS_WIDTH = 52;
    private static final int FLUCTUACION = 130;
    private static final int OBS_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture puaTop;
    private Texture puaBot;

    private Vector2 posPuaTop;
    private Vector2 posPuaBot;

    private Random rand;

    private Rectangle contornoArriba;
    private Rectangle contornoAbajo;


    public Puas(float x){

        puaTop = new Texture("puatop.png");
        puaBot = new Texture("puabot.png");

        rand = new Random();


        posPuaTop = new Vector2(x,rand.nextInt(FLUCTUACION) + OBS_GAP + LOWEST_OPENING);
        posPuaBot = new Vector2(x, posPuaTop.y - OBS_GAP - puaBot.getHeight());

        contornoArriba = new Rectangle(posPuaTop.x, posPuaTop.y,puaTop.getWidth(), puaTop.getHeight());
        contornoAbajo = new Rectangle(posPuaBot.x, posPuaBot.y, puaBot.getWidth(), puaBot.getHeight());
    }

    public void reposicionar(float x){

        posPuaTop.set(x,rand.nextInt(FLUCTUACION) + OBS_GAP + LOWEST_OPENING);
        posPuaBot.set(x, posPuaTop.y - OBS_GAP - puaBot.getHeight());

        contornoArriba.setPosition(posPuaTop.x, posPuaBot.y);
        contornoAbajo.setPosition(posPuaBot.x, posPuaBot.y);
    }

    public boolean colision(Rectangle jugador){
        return jugador.overlaps(contornoArriba)|| jugador.overlaps(contornoAbajo);
    }

    public Texture getArribaObstaculo() {
        return puaTop;
    }

    public Texture getAbajoObstaculo(){
        return puaBot;
    }

    public Vector2 getPosArribaPua() {
        return posPuaTop;
    }

    public  Vector2 getPosAbajoPua(){
        return  posPuaBot;
    }

    public void dispose(){
        puaTop.dispose();
        puaBot.dispose();
    }
}
