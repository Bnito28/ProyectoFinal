package com.bnito.proyectofinal.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void actualizar(float dt){
        states.peek().actualizar(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
