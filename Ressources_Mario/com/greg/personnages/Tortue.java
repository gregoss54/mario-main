package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.objets.Objet;

public class Tortue extends Personnage implements Runnable{
	//**** VARIABLES ****//
	private final int PAUSE = 30; // temps d'attente en ms entre 2 tours de boucle
	private int dxTortue;	
	private Image imgTortue;
	private ImageIcon icoTortue;
	
	
	//**** CONSTRUCTEUR	****//
	public Tortue(int x, int y) {			
		super(x, y, 27, 30);
		super.setVersDroite(false);
		super.setMarche(true);
		this.dxTortue = -1;			
		icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
        imgTortue = icoTortue.getImage();					
		Thread chronoTortue = new Thread(this);
		chronoTortue.start();
	}

		
	//**** GETTERS ****//		
	public Image getImgTortue() {return imgTortue;}

			
	//**** SETTERS ****//
			
			
	//**** METHODES ****//
	public void bouge(){ // Déplacement de la tortue
		if(this.vivant == true){
			if(super.isVersDroite() == true){this.dxTortue = 1;}
			else{this.dxTortue = -1;}
		    super.setX(super.getX() + this.dxTortue);
		}	    
	}
			
    public Image meurt(){		
    	String str;	
		ImageIcon ico;
		Image img;
		
		this.dxTortue = 0;
        str = "/images/tortueFermee.png";	
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}
	
	public void contact(Objet objet) {
				
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
	        super.setVersDroite(false);
		    this.dxTortue = -1; 
		}else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
		    super.setVersDroite(true);
		    this.dxTortue = 1;     
		}	
	}
		
	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
	        super.setVersDroite(false);
	    	this.dxTortue = -1; 
	    }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxTortue = 1;     
	    }	
	}
	    
	@Override
	public void run() {		
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient complètement créés
		catch (InterruptedException e){}					
		while(true){ // boucle infinie											
			this.bouge();
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}		
	}
}