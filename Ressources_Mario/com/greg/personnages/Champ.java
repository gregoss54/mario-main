package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.objets.Objet;

public class Champ extends Personnage implements Runnable{
	//**** VARIABLES ****//
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxChamp;	
	private Image imgChamp;
	private ImageIcon icoChamp;
	
	
	//**** CONSTRUCTEUR	****//
	public Champ(int x, int y) {		
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxChamp = 1;		
		icoChamp = new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
        imgChamp = icoChamp.getImage();				
		Thread chronoChamp = new Thread(this);
		chronoChamp.start();
	}

	
	//**** GETTERS ****//		
	public Image getImgChamp() {return imgChamp;}

		
	//**** SETTERS ****//
		
		
	//**** METHODES ****//		
    public void bouge(){ // Déplacement du champignon
    	if(this.vivant == true){
    		if(super.isVersDroite() == true){this.dxChamp = 1;}
    		else{this.dxChamp = -1;}
        	super.setX(super.getX() + this.dxChamp);
    	}  	
    }
	
    public Image meurt(){		
		String str;	
		ImageIcon ico;
		Image img;
		
		this.dxChamp = 0;
        if(this.isVersDroite() == true){str = "/images/champEcraseDroite.png";}
        else{str = "/images/champEcraseGauche.png";}		
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}
    
	public void contact(Objet objet) {			
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
	    	this.dxChamp = -1; 
	    }else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxChamp = 1;     
	    }	
	}
	
    public void contact(Personnage personnage) {		
	    if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
    	    this.dxChamp = -1; 
        }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
    	    super.setVersDroite(true);
    	    this.dxChamp = 1;     
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