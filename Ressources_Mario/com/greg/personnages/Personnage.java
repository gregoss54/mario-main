package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.jeu.Main;
import com.mathmaurer.objets.Objet;

public class Personnage {
	//**** VARIABLES ****//
	private int largeur, hauteur; //dimensions du personnage
	private int x, y; //position du personnage	
	protected boolean marche; // vrai quand le personnage marche
	protected boolean versDroite; // vrai quand le personnage est tourné vers la droite
	public int compteur; // compteur des pas du personnage
	protected boolean vivant; //vrai quand le personnage est vivant
	public int compteurMort; //utilisé lorsque le personnage meurt
	
	
	//**** CONSTRUCTEUR ****//
	public Personnage(int x, int y, int largeur, int hauteur){				
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;		
		this.compteur = 0;
		this.vivant = true;
		this.compteurMort = 0;
	}


	//**** GETTERS ****//	
	public int getX() {return x;}

	public int getY() {return y;}

    public int getLargeur() {return largeur;}
	
	public int getHauteur() {return hauteur;}

	public boolean isMarche() {return marche;}

	public boolean isVersDroite() {return versDroite;}

	public int getCompteur() {return compteur;}
		
	public boolean isVivant() {return vivant;}

	public int getCompteurMort() {return compteurMort;}
	
	
	//**** SETTERS ****//	
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	public void setLargeur(int largeur) {this.largeur = largeur;}

	public void setHauteur(int hauteur) {this.hauteur = hauteur;}
	
	public void setMarche(boolean marche) {this.marche = marche;}
	
	public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

	public void setCompteur(int compteur) {this.compteur = compteur;}
	
	public void setVivant(boolean vivant) {this.vivant = vivant;}
	
	public void setCompteurMort(int compteurMort) {this.compteurMort = compteurMort;}
	
	
    //**** METHODES ****//	
    public void deplacement() {		
		if(Main.scene.getxPos() >= 0){this.setX(this.getX() - Main.scene.getDx());}
	}
    
    public Image marche(String nom, int frequence){ //nom du personnage et fréquence des pas		
    	String str;	
		ImageIcon ico;
		Image img;
			
		if (this.marche == false) {
			if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
			else{str = "/images/" + nom + "ArretGauche.png";}				
		}else{
		    this.compteur++;
		    if (this.compteur / frequence == 0) { // quotient de la division euclidienne de compteur par frequence
		    	if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
		    	else{str = "/images/" + nom + "ArretGauche.png";}					
		    }else{
		    	if(this.versDroite == true){str = "/images/" + nom + "MarcheDroite.png";}
		    	else{str = "/images/" + nom + "MarcheGauche.png";}	
		    }		    
		    if (this.compteur == 2 * frequence) {this.compteur = 0;}
		}
		// Affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}
    
    protected boolean contactAvant(Objet objet){
		if(this.isVersDroite() == true){
			if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
			else{return true;}
		}else{return false;}
	} 
    
    protected boolean contactArriere(Objet objet){		
		if(this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
		else{return true;}
	}

    protected boolean contactDessous(Objet objet){	
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5){return false;}
		else{return true;}		
	}

    protected boolean contactDessus(Objet objet){
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5){return false;}
		else{return true;}
	}
	
    public boolean proche(Objet objet){   	
    	if((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10) 
    	|| (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)){return true;}
    	else{return false;}
    }
    
    protected boolean contactAvant(Personnage personnage){
		if(this.isVersDroite() == true){
			if(this.x + this.largeur < personnage.getX() || this.x + this.largeur > personnage.getX() + 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()){return false;}
			else{return true;}
		}else{return false;}
	} 
    
    protected boolean contactArriere(Personnage personnage){		
		if(this.x > personnage.getX() + personnage.getLargeur() || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()){return false;}
		else{return true;}
	}

    protected boolean contactDessous(Personnage personnage){
    	if(this.x + this.largeur < personnage.getX() || this.x > personnage.getX() + personnage.getLargeur() || this.y + this.hauteur < personnage.getY() || this.y + this.hauteur > personnage.getY()){return false;}
		else{return true;}
	}
    
    public boolean proche(Personnage personnage){  	
    	if((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getLargeur() + 10) 
    	|| (this.x + this.largeur > personnage.getX() - 10 && this.x + this.largeur < personnage.getX() + personnage.getLargeur() + 10)){return true;}
    	else{return false;}
    }
}