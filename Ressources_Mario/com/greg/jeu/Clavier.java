package com.greg.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.greg.audio.Audio;


public class Clavier implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		if(Main.scene.mario.isVivant() == true && Main.scene.finDePartie() == false){
			// mario va vers la droite	
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				// Annule le d�calage de 1 cr�� par deplacementFond (PanJeu)
	        	if(Main.scene.getxPos() == -1){ 
	        		Main.scene.setxPos(0);
	        		Main.scene.setxFond1(-50);
	        		Main.scene.setxFond2(750);
	        	}
	        	Main.scene.mario.setVersDroite(true);       	
	        	Main.scene.mario.setMarche(true);
				Main.scene.setDx(1);
			// mario va vers la gauche	
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){	
				// Annule le d�calage de 1 cr�� par deplacementFond (PanJeu)
	        	if(Main.scene.getxPos() == 4431){ 
	        		Main.scene.setxPos(4430);
	        		Main.scene.setxFond1(-50);
	        		Main.scene.setxFond2(750);
	        	}
				Main.scene.mario.setVersDroite(false);       	
	        	Main.scene.mario.setMarche(true);
				Main.scene.setDx(-1);}			
			// mario saute
	        if(e.getKeyCode() == KeyEvent.VK_SPACE){ 
	        	Main.scene.mario.setSaut(true);  
	        	Audio.playSound("/audio/saut.wav");
	        }
		}		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
			Main.scene.mario.setMarche(false);
			Main.scene.setDx(0);
		}				
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
}
