package com.bnito.proyectofinal.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bnito.proyectofinal.ProyectoFinal;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ProyectoFinal.ANCHO;
		config.height = ProyectoFinal.ALTO;
		config.title = ProyectoFinal.TITLE;
		new LwjglApplication(new ProyectoFinal(), config);
	}
}
