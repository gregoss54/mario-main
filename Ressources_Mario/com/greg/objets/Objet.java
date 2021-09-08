package com.greg.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.greg.jeu.Main;


public class Objet {
	//**** VARIABLES ****//
	private int largeur, hauteur; //dimensions de l'objet
	private int x, y; //position de l'objet	
	protected Image imgObjet;
	protected ImageIcon icoObjet;
	
	
	//**** CONSTRUCTEUR ****//	
	public Objet(int x, int y, int largeur, int hauteur){		
	    this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	
    //**** GETTERS ****//	
    public int getX() {return x;}

	public int getY() {return y;}

	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}
	
	public Image getImgObjet() {return imgObjet;}


	//**** SETTERS ****//	
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setLarg(int largeur) {this.largeur = largeur;}

	public void setHaut(int hauteur) {this.hauteur = hauteur;}
	
	
	//**** METHODES ****//
	public void deplacement() {		
		if(Main.scene.getxPos() >= 0 && Main.scene.getxPos() <= 4430){
		  this.setX(this.getX() - Main.scene.getDx());		
	    }
	}		
}