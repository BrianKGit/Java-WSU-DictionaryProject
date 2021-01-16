import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;


public class UserInterface {
	public static void main(String[] args) {
		//Load in textfile
		BSTDictionary bstDic = new BSTDictionary();
		DictionaryHashMap hashDic = new DictionaryHashMap();
		ArrayListDictionary arrayDic = new ArrayListDictionary();
		BufferedReader reader;
		try {
			
			// Change this depending on file
			
			reader = new BufferedReader(new FileReader(
					"/Users/zt9916nr/Desktop/chatdictionary.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				bstDic.addItem(line);
				hashDic.addItem(line);
				arrayDic.addItem(line);
				
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//arrayDic.addItem("LOL Laugh out loud");
		//arrayDic.addItem("LMAO Laughing my Ass off");
		
		/*
		 * Start GUI
		 */
		
		JFrame mainFrame = new JFrame();
		
		//Search Interface
		JPanel searchWindow = new JPanel();
		JPanel searchInputPanel = new JPanel();
		JPanel searchOutputPanel = new JPanel();
		
		searchInputPanel.setLayout(new GridLayout(0, 2));
				
		JTextArea searchOutputArea = new JTextArea();
		searchOutputArea.setPreferredSize(new Dimension(330,350));
		searchOutputArea.setEditable(false);
		searchOutputArea.setEnabled(true);
		searchOutputPanel.add(BorderLayout.CENTER, searchOutputArea);
		
		JTextField searchInputField = new JTextField();
		searchInputField.setColumns(15);
		JButton searchInputButton = new JButton("Search");
		searchInputButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String search = searchInputField.getText();
				
				/*
				 * Place Dictionary calls here
				 */
				//Hash Map
				if(hashDic.lookup(search) != null) {
					searchOutputArea.setText("Hash Map:\n" + hashDic.lookup(searchInputField.getText()));
				} else {
					searchOutputArea.setText("Hash Map:\nEntry '" + search + "' was not found.");
				}/**/
				
				//Binary Search Tree
				if(bstDic.lookup(search) != null) {
					searchOutputArea.append("\n\nBinary Search Tree:\n" + bstDic.lookup(searchInputField.getText()));
				} else {
					searchOutputArea.append("\n\nBinary Search Tree:\nEntry '" + search + "' was not found.");
				}/**/
				
				//ArrayList
				if(arrayDic.lookup(search) != null) {
					searchOutputArea.append("\n\nArray List:\n" + arrayDic.lookup(searchInputField.getText()));
				} else {
					searchOutputArea.append("\n\nArray List:\nEntry '" + search + "' was not found.");
				}/**/
				
				
				
			}
		});
		
		searchInputPanel.add(BorderLayout.WEST, searchInputField);
		searchInputPanel.add(BorderLayout.EAST, searchInputButton);
		
		searchWindow.add(BorderLayout.NORTH, searchOutputPanel);
		searchWindow.add(BorderLayout.SOUTH, searchInputPanel);
		
		
		//Add Entry Interface
		JPanel addEntryWindow = new JPanel();
		
		JPanel addEntryInputPanel = new JPanel();
		JTextField addEntryInputField = new JTextField();
		addEntryInputField.setColumns(15);
		JTextField addDefinitionInputField = new JTextField();
		addDefinitionInputField.setColumns(15);
		
		JPanel addEntryOutputPanel = new JPanel();
		JTextArea addEntryOutputArea = new JTextArea();
		addEntryOutputArea.setPreferredSize(new Dimension(330,350));
		addEntryOutputArea.setEditable(false);
		addEntryOutputPanel.add(BorderLayout.CENTER, addEntryOutputArea);
		
		JButton addEntryButton = new JButton("Add Entry");
		addEntryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String line = "";
				line += addEntryInputField.getText() + " " + addDefinitionInputField.getText();
				
				/*
				 * Place Dictionary calls here
				 */
				
				bstDic.addItem(line);
				hashDic.addItem(line);
				arrayDic.addItem(line);
				
				addEntryOutputArea.setText("Hash Map\nEntry added:\n" + addEntryInputField.getText() + "\n" + addDefinitionInputField.getText());
				addEntryOutputArea.append("\n\nBinary Search Tree\nEntry added:\n" + addEntryInputField.getText() + "\n" + addDefinitionInputField.getText());
				addEntryOutputArea.append("\n\nArray List\nEntry added:\n" + addEntryInputField.getText() + "\n" + addDefinitionInputField.getText());
				addEntryInputField.setText("");
				addDefinitionInputField.setText("");
			}
			
		});
		
		JPanel addEntryTextFieldPanel = new JPanel();
		addEntryTextFieldPanel.setLayout(new GridLayout(2,0));
		addEntryTextFieldPanel.add(addEntryInputField);
		addEntryTextFieldPanel.add(addDefinitionInputField);
		
		addEntryInputPanel.add(BorderLayout.CENTER, addEntryTextFieldPanel);
		addEntryInputPanel.add(BorderLayout.EAST, addEntryButton);
		
		addEntryWindow.add(BorderLayout.CENTER, addEntryOutputPanel);
		addEntryWindow.add(BorderLayout.SOUTH, addEntryInputPanel);
		
		//Remove Menu
		
		JPanel removeEntryWindow = new JPanel();
		JPanel removeEntryOutputPanel = new JPanel();
		JPanel removeEntryInputPanel = new JPanel();
		
		JTextArea removeEntryOutputArea = new JTextArea();
		removeEntryOutputArea.setPreferredSize(new Dimension(330,350));
		removeEntryOutputArea.setEditable(false);
		
		JTextField removeEntryInputField = new JTextField();
		removeEntryInputField.setColumns(15);
		JButton removeEntryButton = new JButton("Remove");
		removeEntryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Place Dictionary calls here
				 */
				
				//Hash Map
				
				String removeEntryHash = hashDic.lookup(removeEntryInputField.getText());
				removeEntryOutputArea.setText("Hash Map:\n");
				if(removeEntryHash != null) {
					hashDic.removeItem(removeEntryInputField.getText());
					removeEntryOutputArea.append("The entry '" + removeEntryInputField.getText() + "' was removed.");
				} else {
					removeEntryOutputArea.append("The entry '" + removeEntryInputField.getText() + "' was not found.");
				}/**/
				
				//Binary Search Tree
								
				String removeEntry = bstDic.lookup(removeEntryInputField.getText());
				removeEntryOutputArea.append("\n\nBinary Search Tree:\n");
				if(removeEntry != null) {
					bstDic.removeItem(removeEntryInputField.getText());
					removeEntryOutputArea.append("The entry '" + removeEntryInputField.getText() + "' was removed.");
				} else {
					removeEntryOutputArea.append("The entry '" + removeEntryInputField.getText() + "' was not found.");
				}/**/
				
				//Array List
				
				String removeEntryArray = arrayDic.lookup(removeEntryInputField.getText());
				removeEntryOutputArea.append("\n\nArray List:\n");
				if(removeEntryArray != null) {
					arrayDic.removeItem(removeEntryInputField.getText());
					removeEntryOutputArea.append("The entry '" + removeEntryInputField.getText() + "' was removed.");
					removeEntryInputField.setText("");	
				} else {
					removeEntryOutputArea.append("The entry '" + removeEntryInputField.getText() + "' was not found.");
					removeEntryInputField.setText("");
				}/**/
				
			}
		});
		
		removeEntryInputPanel.add(BorderLayout.CENTER, removeEntryInputField);
		removeEntryInputPanel.add(BorderLayout.EAST, removeEntryButton);
		removeEntryOutputPanel.add(BorderLayout.CENTER, removeEntryOutputArea);
		
		removeEntryWindow.add(BorderLayout.CENTER, removeEntryOutputPanel);
		removeEntryWindow.add(BorderLayout.SOUTH, removeEntryInputPanel);
		
		//Main Menu
		JPanel mainPanel = new JPanel();
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(4,0));
		
		JButton menuSearchButton = new JButton("Search");
		menuSearchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.remove(mainPanel);
				mainFrame.remove(addEntryWindow);
				mainFrame.remove(removeEntryWindow);
				mainFrame.add(searchWindow);
				mainFrame.revalidate();
				mainFrame.repaint();
			}
		});
		
		JButton menuAddEntryButton = new JButton("Add Entry");
		menuAddEntryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.remove(mainPanel);
				mainFrame.remove(searchWindow);
				mainFrame.remove(removeEntryWindow);
				mainFrame.add(addEntryWindow);
				mainFrame.revalidate();
				mainFrame.repaint();
			}
			
		});
		
		JButton menuRemoveEntryButton = new JButton("Remove Entry");
		menuRemoveEntryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.remove(mainPanel);
				mainFrame.remove(searchWindow);
				mainFrame.remove(addEntryWindow);
				mainFrame.add(removeEntryWindow);
				mainFrame.revalidate();
				mainFrame.repaint();
			}
			
		});
		
		JButton menuSaveAll = new JButton("Save Changes");
		menuSaveAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Place Dictionary calls here
				 */
				try {
					bstDic.saveAll();
					hashDic.saveAll();
					arrayDic.saveAll();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		sidePanel.add(menuSearchButton);
		sidePanel.add(menuAddEntryButton);
		sidePanel.add(menuRemoveEntryButton);
		sidePanel.add(menuSaveAll);
		
		mainFrame.add(BorderLayout.CENTER, mainPanel);
		mainFrame.add(BorderLayout.WEST, sidePanel);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setVisible(true);
		
	}
}
