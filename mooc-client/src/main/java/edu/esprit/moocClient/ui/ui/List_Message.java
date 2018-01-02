package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import edu.esprit.mooc.client.BuisnessDeligator.GestMessageBD;
import edu.esprit.mooc.domain.Entity.Message;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class List_Message extends JFrame {

	private JPanel contentPane;

	private JTextField textField;
	private JTable table;
	private DefaultTableModel	model;
	private JComboBox filterList;
	TableRowSorter<TableModel> sorter ;
     String  comite ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_Message frame = new List_Message();
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
	
	
	public  List_Message(String comite){
		this.comite=comite ;
	setTitle("Liste_Apprenants");
		
		//setBounds(100, 100, 520, 377);
		JPanel panel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(UIManager.getColor("Button.shadow"));
	//	panel.setBounds(0, 0, 494, 33);
		
		
		JTextPane txtpnRechercher = new JTextPane();
		txtpnRechercher.setBackground(UIManager.getColor("Button.background"));
		txtpnRechercher.setText("Rechercher");
		panel.add(txtpnRechercher);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("OK",new ImageIcon("images/Zoom.gif"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     System.out.println("Start Filter");
			     String text = textField.getText();
			     int type = filterList.getSelectedIndex();
			     RowFilter<TableModel, Object> rf = null;
			     //If current expression doesn't parse, don't update.
			     try {
			         rf = RowFilter.regexFilter(text, type);
			     } catch (java.util.regex.PatternSyntaxException e1) {
			         return;
			     }
			     sorter.setRowFilter(rf);
			  }
			
		});

		
		String[] filterTypeStrings = { "    From    ", "    Subject    ", "    body    ", "    date    " };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		filterList = new JComboBox(filterTypeStrings);
		filterList.setSelectedIndex(1);
		panel.add(filterList);
		
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Créer", new ImageIcon("images/Add.gif"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			/*	Ajout_Developper apprenant=new Ajout_Developper();
				apprenant.setVisible(true);
				apprenant.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						loadTableData();
						}
						});
				*/
				
			}
		});
		btnNewButton_2.setToolTipText("Créer");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Supprimer",new ImageIcon("images/delete.gif"));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
				}
		});
		
		btnNewButton.setToolTipText("Supprimer");
		panel.add(btnNewButton);
		
		JTextArea txtrKlbhkgb = new JTextArea();
		txtrKlbhkgb.setLineWrap(true);
		txtrKlbhkgb.setWrapStyleWord(true);
		txtrKlbhkgb.setBackground(UIManager.getColor("Button.light"));
		txtrKlbhkgb.setText("les formateures");
		txtrKlbhkgb.setBounds(37, 42, 148, 22);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 64, 484, 254);
		
		table = new JTable();
table.setAutoCreateRowSorter(true);
		
		
//		table.setPreferredScrollableViewportSize(new Dimension(400, 70));
        table.setFillsViewportHeight(true);
 
		//table.setForeground(UIManager.getColor("CheckBox.background"));
		//table.setSurrendersFocusOnKeystroke(true);
		//table.setFillsViewportHeight(true);
		//table.setColumnSelectionAllowed(true);
		//table.setCellSelectionEnabled(true);
		//table.setBackground(UIManager.getColor("Button.disabledShadow"));

					
		
		loadTableData();
		
		
		
			    
        
//    	    RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
//			      public boolean include(Entry entry) {
//			        Integer population = (Integer) entry.getValue(1);
//			        return population.intValue() > 3;
//			      }
//			    };

			 //   TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
			  //  sorter.setRowFilter(filter);
			   // table.setRowSorter(sorter);
			    
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        scrollPane_1.setViewportView(scrollPane);		
		
		getContentPane( ).add(panel, BorderLayout.NORTH);
		getContentPane( ).add(scrollPane_1, BorderLayout.CENTER);
		
		
		
	}
	public List_Message() {
		setTitle("Liste_Apprenants");
		
		setBounds(100, 100, 818, 388);
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	//	panel.setBounds(0, 0, 494, 33);
		
		
		JTextPane txtpnRechercher = new JTextPane();
		txtpnRechercher.setBackground(UIManager.getColor("Button.background"));
		txtpnRechercher.setText("Rechercher");
		panel.add(txtpnRechercher);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Send",new ImageIcon("images/Zoom.gif"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     
				new List_send_Message().setVisible(true);
				
			  }
			
		});

		
		String[] filterTypeStrings = { "    From    ", "    Subject    ", "    body    ", "    date    " };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		filterList = new JComboBox(filterTypeStrings);
		filterList.setSelectedIndex(1);
		panel.add(filterList);
		
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Créer", new ImageIcon("images/Add.gif"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new home_message().setVisible(true);
			/*	Ajout_Developper apprenant=new Ajout_Developper();
				apprenant.setVisible(true);
				apprenant.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						loadTableData();
						}
						});
				*/
				
			}
		});
		btnNewButton_2.setToolTipText("Créer");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Supprimer",new ImageIcon("images/delete.gif"));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
				}
		});
		
		btnNewButton.setToolTipText("Supprimer");
		panel.add(btnNewButton);
		
		JTextArea txtrKlbhkgb = new JTextArea();
		txtrKlbhkgb.setLineWrap(true);
		txtrKlbhkgb.setWrapStyleWord(true);
		txtrKlbhkgb.setBackground(UIManager.getColor("Button.light"));
		txtrKlbhkgb.setText("les formateures");
		txtrKlbhkgb.setBounds(37, 42, 148, 22);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 64, 484, 254);
		
		table = new JTable();
table.setAutoCreateRowSorter(true);
		
		
//		table.setPreferredScrollableViewportSize(new Dimension(400, 70));
        table.setFillsViewportHeight(true);
 
		//table.setForeground(UIManager.getColor("CheckBox.background"));
		//table.setSurrendersFocusOnKeystroke(true);
		//table.setFillsViewportHeight(true);
		//table.setColumnSelectionAllowed(true);
		//table.setCellSelectionEnabled(true);
		//table.setBackground(UIManager.getColor("Button.disabledShadow"));

					
		
		loadTableData();
		
		
		
			    
        
//    	    RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
//			      public boolean include(Entry entry) {
//			        Integer population = (Integer) entry.getValue(1);
//			        return population.intValue() > 3;
//			      }
//			    };

			 //   TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
			  //  sorter.setRowFilter(filter);
			   // table.setRowSorter(sorter);
			    
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        scrollPane_1.setViewportView(scrollPane);		
		
		getContentPane( ).add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton_3 = new JButton("back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Comitemenu().setVisible(true);
				List_Message.this.dispose();
			}
		});
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		
		int a = GestMessageBD.getAllnumberMessage(1);
		String mi=Integer.toString(a);
		lblNewLabel.setText(mi);
		panel.add(lblNewLabel);
		
		JLabel lblNewMessage = new JLabel("New Message");
		lblNewMessage.setForeground(Color.RED);
		panel.add(lblNewMessage);
		getContentPane( ).add(scrollPane_1, BorderLayout.CENTER);
	}
	public void loadTableData(){
		model = new DefaultTableModel(
				new Object[][] {
						
				},
				new String[] {
				"From", "Subject", "body","date"
			}
		);

			//supposant que id user est 3
			List<Message>messages=GestMessageBD.getAllMessage(3);
			
		
			for(Object app:messages){
				Message appr=(Message)app;
				System.out.println(appr.getSubject());
			
				model.addRow(new Object[]{appr.getSender().getNom_user(),appr.getSubject(),appr.getBody(),appr.getDate_Message()});
			
			}
			table.setModel(model);
			sorter = new TableRowSorter<TableModel>(model);
			  //  sorter.setRowFilter(filter);
			    table.setRowSorter(sorter);
		
		
		
			
			
	}
			
			
		
			
		

		
	
	
	
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
        
        
        
    }
	
	public void deleteUser(){
		Integer i=table.getSelectedRow();
		javax.swing.table.TableModel model = table.getModel();
	int a=(Integer)model.getValueAt(i, 0);
		System.out.println(a);
    	GestMessageBD.removeMessage(a);
	    loadTableData();
	}

}
