package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.adobe.acrobat.Viewer;

public class LecteurPdf extends JPanel {

	
	private Viewer viewer;
	/**
	 * Create the panel.
	 */
	

	 
	 
	    public LecteurPdf(String url) throws Exception{
	        this.setLayout(new BorderLayout());
	 
	        //créer le viewer qui va servir à afficher le contenu du pdf
	        viewer = new Viewer();
	        this.add(viewer, BorderLayout.CENTER);
	       
	        viewer.setDocumentURL(url);
	        viewer.activate();
}}
