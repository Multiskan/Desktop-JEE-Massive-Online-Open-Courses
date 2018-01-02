package edu.esprit.moocClient.ui.ui;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Addpdf extends JFrame {

	private JPanel contentPane;
	private JTextField pdfname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addpdf frame = new Addpdf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Addpdf() {
		setTitle("add pdf ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 470, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("to add a descriptive pdf for this course follow the instructios bellow :\r\n\r\n");
		lblNewLabel.setBounds(20, 23, 440, 41);
		panel.add(lblNewLabel);
		
		JLabel lblAddAPdf = new JLabel("add a pdf to your course ");
		lblAddAPdf.setBounds(181, 5, 213, 14);
		panel.add(lblAddAPdf);
		
		JLabel lblNewLabel_1 = new JLabel("1- put the targeted pdf in the desktop ");
		lblNewLabel_1.setBounds(20, 75, 270, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblRenameIt = new JLabel("2- rename it \"it must have the same name as your course \"");
		lblRenameIt.setBounds(20, 100, 340, 24);
		panel.add(lblRenameIt);
		
		JLabel lblPressSubmit = new JLabel("3-  enter file name then press submit to save the file ");
		lblPressSubmit.setBounds(20, 124, 310, 24);
		panel.add(lblPressSubmit);
		
		pdfname = new JTextField();
		pdfname.setBounds(148, 162, 142, 20);
		panel.add(pdfname);
		pdfname.setColumns(10);
		
		JButton btnSubmit = new JButton("submit ");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String ACCESS_TOKEN = "2W5YKl8dXOAAAAAAAAAABohEUjmVzUhXUtZf1m4R3cvrgxcvy5VnxkfflKp8M6oV";
				// Create Dropbox client
		        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
		        DbxClientV1 client = new DbxClientV1(config, ACCESS_TOKEN);
		        File inputFile = new File("C:\\Users\\HP\\Desktop\\"+pdfname.getText());
		        FileInputStream inputStream = null;
				try {
					inputStream = new FileInputStream(inputFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
		            DbxEntry.File uploadedFile = client.uploadFile("/"+pdfname.getText(),
		                DbxWriteMode.add(), inputFile.length(), inputStream);
		            System.out.println("Uploaded: " + uploadedFile.toString());
		            JOptionPane.showMessageDialog(null, "pdf successfully added !", "info",
		    				JOptionPane.INFORMATION_MESSAGE);
		        } catch (DbxException e) {
		        	
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
		            try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});
		btnSubmit.setBounds(107, 215, 89, 23);
		panel.add(btnSubmit);
		
		JButton btnCheck = new JButton("check \r\n");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Browser browser = new Browser();
			       BrowserView browserView = new BrowserView(browser);
			 
			       JFrame frame = new JFrame("drop box account ");
			       frame.getContentPane().add(browserView, BorderLayout.CENTER);
			       frame.setSize(700, 500);
			       frame.setVisible(true);
			       
			       browser.loadURL("https://www.dropbox.com/home");
			}
		});
		btnCheck.setBounds(290, 215, 89, 23);
		panel.add(btnCheck);
		
		
	}
}
