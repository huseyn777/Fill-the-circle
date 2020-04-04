import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class HowToPlay extends JPanel implements FillTheCircleView{

	
	JButton soundButton;
	JButton backButton;
	JLabel nameLabel;
	JTextArea infoArea;
	JLabel backgroundLabel;
	/**
	 * Create the panel.
	 */
	public HowToPlay() {
		
		
		setPreferredSize(new Dimension(400, 600));
		setLayout(null);
		
		ImageIcon soundIcon = new ImageIcon("images\\muteIcon.png");     // adding High Score button
		soundButton = new JButton(new ImageIcon("C:\\Users\\user\\Desktop\\FillTheCircle_GUI\\GUI\\images\\rsz_soundicon41.png"));
		soundButton.setBorder(new LineBorder(Color.white, 0));
		soundButton.setContentAreaFilled(false);
		soundButton.setBounds(359, 0, 41, 41);
		add(soundButton);
		
		nameLabel = new JLabel("How To Play");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 49));
		nameLabel.setBounds(43, 27, 357, 81);
		add(nameLabel);
		
		infoArea = new JTextArea();
		infoArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		infoArea.setForeground(Color.WHITE);
		infoArea.append("On the screen there will be an empty circle \n");
		infoArea.append("and a ball. In order to win game you have \n");
		infoArea.append("to fill the empty circle by keeping the ball \n");
		infoArea.append("inside the circle by using arrow keys. But \n");
		infoArea.append("you will have a limited time. Time starts \n");
		infoArea.append("when ball enters to the circle. At the same \n");
		infoArea.append("time you should be careful about not letting \n");
		infoArea.append("the ball to go out of the circle. Moreover, \n");
		infoArea.append("you will have 5 chances when the game starts \n");
		infoArea.append("Each time ball leaves the circle you loose 1 \n");
		infoArea.append("of your chances. Good Luck! \n");
		infoArea.setRows(10);
		infoArea.setColumns(10);
		infoArea.setBounds(10, 161, 380, 291);
		infoArea.setOpaque(false);
		add(infoArea);
		
		ImageIcon backIcon = new ImageIcon("images\\backIcon.png");
		backButton = new JButton(backIcon);
		backButton.setBounds(10, 549, 45, 40);
		backButton.setBorder( new LineBorder(Color.WHITE, 0));
		backButton.setContentAreaFilled(false);
		add(backButton);
		
		ImageIcon backgroundIcon = new ImageIcon("images\\howToPlayBackground.jpg");
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(backgroundIcon);
		backgroundLabel.setBounds(0, 0, 400, 600);
		add(backgroundLabel);
		
	}
	public void updateLanguage(String lang)
	{
		if(lang.equals("Aze"))
		{
			nameLabel.setText("Necə oynamalı ?");
			infoArea.setText("");
			infoArea.append("Oyun boş bir dairə və top ilə başlayır. \n");
			infoArea.append("Mərhələni keçmək üçün istiqamət (←↑↓→) \n");
			infoArea.append("və WASD düymələri ilə topu dairə dolana  \n");
			infoArea.append("qədər dairənin içində tutmaq lazımdır. \n");
			infoArea.append("Amma bunun üçün vaxtınız məhdud olacaq. \n");
			infoArea.append("Eyni zamanda topun dairənin içindən \n");
			infoArea.append("çıxmamasına da diqqət etmək lazımdır. Çünki,  \n");
			infoArea.append("top hər dəfə dairəni tərk etdikdə oyun  \n");
			infoArea.append("başladığı zaman sizə verilmiş 5 şansdan  \n");
			infoArea.append("birini itirirsiniz. Uğurlar !");
			infoArea.setRows(10);
			infoArea.setColumns(10);
		}
		if(lang.equals("Eng"))
		{
			nameLabel.setText("How To Play");
			infoArea.setText("");
			infoArea.append("On the screen there will be an empty circle \n");
			infoArea.append("and a ball. In order to win game you have \n");
			infoArea.append("to fill the empty circle by keeping the ball \n");
			infoArea.append("inside the circle by using arrow keys. But \n");
			infoArea.append("you will have a limited time. Time starts \n");
			infoArea.append("when ball enters to the circle. At the same \n");
			infoArea.append("time you should be careful about not letting \n");
			infoArea.append("the ball to go out of the circle. Moreover, \n");
			infoArea.append("you will have 5 chances when the game starts \n");
			infoArea.append("Each time ball leaves the circle you loose 1 \n");
			infoArea.append("of your chances. Good Luck! \n");
			infoArea.setRows(10);
			infoArea.setColumns(10);
		}
		if(lang.equals("Rus"))
		{
			nameLabel.setText("Инструкция");
			infoArea.setText("");
			infoArea.append("На экране вы можете наблюдать мяч и \n");
			infoArea.append("шар. Для победы вам нужно продержать  \n");
			infoArea.append("мяч внутри шара пока тот заполняется \n");
			infoArea.append("цветом используя стрелки направление   \n");
			infoArea.append("на клавиатуре. Но у вас будет  \n");
			infoArea.append("ограниченое время.В то же время вам  \n");
			infoArea.append("нужно следить за тем чтобы мяч не \n");
			infoArea.append("покинул шар после того  как он зайдет \n");
			infoArea.append(" внутрь.У вас будет 5 шансво и  \n");
			infoArea.append("с каждым выходом из шара вы будете \n");
			infoArea.append("терять по одному шансу. Удачи!");
			infoArea.setRows(12);
			infoArea.setColumns(12);
		}
		if(lang.equals("Trk"))
		{
			nameLabel.setText("Nasıl oynanır ?");
			infoArea.setText("");
			infoArea.append("Oyun boş bir daire ve bir top ile başlıyor. \n");
			infoArea.append("Oyunu kazanmak için, yön tuşlarıyla topu \n");
			infoArea.append("dairenin içinde daire tamamen dolana kadar \n");
			infoArea.append("tutmanız gerekir.Sınırlı olan süreniz top dairenin \n");
			infoArea.append("içine girdiğinde başlar. \n");
			infoArea.append("Topun daire dışına çıkmamasına da dikkat \n");
			infoArea.append(" etmek gerekiyor. Çünkü top her defasında  \n");
			infoArea.append("dairenin dışına çıktığında, oyun başladığı  \n");
			infoArea.append("zaman sahip olduğunuz 5 şansdan birini \n");
			infoArea.append("kaybedersiniz. İyi oyunlar!");
			infoArea.setRows(10);
			infoArea.setColumns(10);
		}
	}
	public JButton getSoundButton()
	{
		return soundButton;
	}
	
	public JButton getBackButton()
	{
		return backButton;
	}
}
