import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LevelSelectionMenu extends JPanel implements FillTheCircleView {

	/**
	 * Create the panel.
	 */
	private JButton buttonReturnBack;
	private JButton button1, button2, button3, button4;
	JLabel lblLevelSelectionMenu;
	
	public LevelSelectionMenu() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 600));
		
		button1 = new JButton("1");
		button1.setBackground(Color.CYAN);
		button1.setFont(new Font("Impact", Font.BOLD, 16));
		button1.setBounds(40, 178, 71, 40);
		add(button1);

		lblLevelSelectionMenu = new JLabel("Level Select");
		lblLevelSelectionMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelectionMenu.setForeground(Color.GREEN);
		lblLevelSelectionMenu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLevelSelectionMenu.setBounds(64, 34, 284, 70);
		add(lblLevelSelectionMenu);

		button2 = new JButton("2");
		button2.setBackground(Color.CYAN);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button2.setFont(new Font("Impact", Font.BOLD, 16));
		button2.setBounds(202, 178, 71, 40);
		add(button2);

		button3 = new JButton("3");
		button3.setBackground(Color.CYAN);
		button3.setFont(new Font("Impact", Font.BOLD, 16));
		button3.setBounds(125, 277, 71, 40);
		add(button3);

		button4 = new JButton("4");
		button4.setBackground(Color.CYAN);
		button4.setFont(new Font("Impact", Font.BOLD, 16));
		button4.setBounds(277, 277, 71, 40);
		add(button4);

		buttonReturnBack = new JButton("");
		buttonReturnBack.setIcon(new ImageIcon("images\\rsz_go-back-icon-md.png"));
		buttonReturnBack.setBorder( new LineBorder(Color.WHITE, 0));
		buttonReturnBack.setContentAreaFilled(false);
		buttonReturnBack.setBounds(10, 549, 45, 40);
		add(buttonReturnBack);

		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon("images\\background_LevelSelection.jpg"));
		lblNewLabel.setBounds(0, 0, 400, 600);
		add(lblNewLabel);

	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			lblLevelSelectionMenu.setText("Mərhələ Seçimi");
		}
		if(lang.equals("Eng"))
		{
			lblLevelSelectionMenu.setText("Level Select");
		}
		if(lang.equals("Rus"))
		{
			lblLevelSelectionMenu.setText("Выбрать уровень");
		}
		if(lang.equals("Trk"))
		{
			lblLevelSelectionMenu.setText("Level seçimi");
		}
	}
	public JButton getButtonReturnBack()
	{
		return buttonReturnBack;
	}
	public JButton getButton1()
	{
		return button1;
	}
	public JButton getButton2()
	{
		return button2;
	}
	public JButton getButton3()
	{
		return button3;
	}
	public JButton getButton4()
	{
		return button4;
	}
}
