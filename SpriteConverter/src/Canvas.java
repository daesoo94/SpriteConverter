import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Canvas {
	private JFrame mainFrame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JButton spritePathButton = new JButton();
	private JButton jsonPathButton = new JButton();
	private JButton convertSpriteButton = new JButton("convert all of sprites");
	public JTextField spritePathLabel = new JTextField("path : ");
	public JTextField jsonPathLabel = new JTextField("path : ");
	public JComboBox<String> spriteComboBox = new JComboBox<String>();
	public JComboBox<String> jsonComboBox = new JComboBox<String>();

	Canvas() {
		this.init();
	}

	public void addSpriteEvent(ActionListener listener) {
		this.spritePathButton.addActionListener(listener);
	}

	public void addJsonEvent(ActionListener listener) {
		this.jsonPathButton.addActionListener(listener);
	}

	public void addConvertButtonEvent(ActionListener listener) {
		this.convertSpriteButton.addActionListener(listener);
	}

	public void setSpriteComboList(List<String> comboList) {
		System.out.print(comboList);
		this.spriteComboBox.removeAllItems();
		for (String sprite : comboList) {
			this.spriteComboBox.addItem(sprite);
		}
	}

	public void setJsonComboList(List<String> comboList) {
		System.out.print(comboList);
		this.jsonComboBox.removeAllItems();
		for (String json : comboList) {
			this.jsonComboBox.addItem(json);
		}
	}

	private void init() {
		// init main frame
		this.mainFrame.setSize(600, 160);
		this.mainFrame.setTitle("Sprite Converter");
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// set style
		this.mainPanel.setLayout(null);
		this.spritePathButton.setText("set sprites path");
		this.jsonPathButton.setText("set jsons path");

		this.spritePathButton.setBounds(5, 5, 150, 30);
		this.jsonPathButton.setBounds(5, 35, 150, 30);
		this.spritePathLabel.setEnabled(false);
		this.jsonPathLabel.setEnabled(false);
		this.spritePathLabel.setBounds(155, 5, 440, 30);
		this.jsonPathLabel.setBounds(155, 35, 440, 30);
		this.spriteComboBox.setBounds(80, 65, 220, 30);
		this.jsonComboBox.setBounds(380, 65, 220, 30);
		this.convertSpriteButton.setBounds(155, 100, 300, 30);

		JButton spriteLabel = new JButton("sprite : ");
		spriteLabel.setBounds(5, 65, 80, 30);
		spriteLabel.setEnabled(false);
		JButton jsonLabel = new JButton("json : ");
		jsonLabel.setBounds(300, 65, 80, 30);
		jsonLabel.setEnabled(false);

		// add items
		this.mainPanel.add(this.spritePathButton);
		this.mainPanel.add(this.spritePathLabel);
		this.mainPanel.add(this.jsonPathButton);
		this.mainPanel.add(this.jsonPathLabel);
		this.mainPanel.add(this.spriteComboBox);
		this.mainPanel.add(spriteLabel);
		this.mainPanel.add(this.spriteComboBox);
		this.mainPanel.add(jsonLabel);
		this.mainPanel.add(this.jsonComboBox);
		this.mainPanel.add(this.convertSpriteButton);

		this.mainFrame.add(this.mainPanel);

		// show window
		this.mainFrame.setVisible(true);
	}
}
