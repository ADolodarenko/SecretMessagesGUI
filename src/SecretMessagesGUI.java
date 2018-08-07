import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SecretMessagesGUI extends JFrame
{
	private JTextField txtKey;
	private JTextArea txtIn;
	private JTextArea txtOut;
	private JSlider slider;
	
	public String encode(String message, int keyVal)
	{
		String output = "";
		
		char key = (char)keyVal;

		for (int x = 0; x < message.length(); x++)
		{
			char input = message.charAt(x);

			if (input >= 'A' && input <= 'Z')
			{
				input += key;

				if (input > 'Z')
					input -= 26;
				if (input < 'A')
					input += 26;
			}
			else if (input >= 'a' && input <= 'z')
			{
				input += key;

				if (input > 'z')
					input -= 26;
				if (input < 'a')
					input += 26;
			}
			else if (input >= '0' && input <= '9')
			{
				input += (keyVal % 10);
				if (input > '9')
					input -= 10;
				if (input < '0')
					input += 10;
			}

			output += input;
		}
		
		return output;
	}
	
	public SecretMessagesGUI() {
		getContentPane().setBackground(new Color(176, 196, 222));
		setResizable(false);
		setTitle("Alex's Secret Message App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtIn = new JTextArea();
		txtIn.setWrapStyleWord(true);
		txtIn.setLineWrap(true);
		txtIn.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtIn.setBounds(10, 11, 613, 172);
		getContentPane().add(txtIn);
		
		txtKey = new JTextField();
		txtKey.setText("5");
		txtKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtKey.setBounds(292, 217, 47, 20);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		txtOut = new JTextArea();
		txtOut.setWrapStyleWord(true);
		txtOut.setLineWrap(true);
		txtOut.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtOut.setBounds(10, 270, 613, 172);
		getContentPane().add(txtOut);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(236, 220, 46, 14);
		getContentPane().add(lblKey);
		
		JButton btnEncodedecode = new JButton("Encode/Decode");
		btnEncodedecode.setForeground(new Color(0, 0, 0));
		btnEncodedecode.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String message = txtIn.getText();
					int key = Integer.parseInt(txtKey.getText());

					String output = encode(message, key);
					txtOut.setText(output);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter a whole number value for the encryption key.");
					
					txtKey.requestFocus();
					txtKey.selectAll();
				}
			}
		});
		btnEncodedecode.setBounds(349, 216, 144, 23);
		getContentPane().add(btnEncodedecode);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				txtKey.setText("" + slider.getValue());
				
				String message = txtIn.getText();
				int key = slider.getValue();

				String output = encode(message, key);
				txtOut.setText(output);
			}
		});
		slider.setForeground(new Color(0, 0, 0));
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(13);
		slider.setMinorTickSpacing(1);
		slider.setValue(5);
		slider.setMinimum(-26);
		slider.setMaximum(26);
		slider.setPaintLabels(true);
		slider.setBackground(new Color(176, 196, 222));
		slider.setBounds(42, 205, 200, 44);
		getContentPane().add(slider);
	}
	
	public static void main(String[] args)
	{
		SecretMessagesGUI theApp = new SecretMessagesGUI();
		theApp.setSize(new Dimension(640, 480));
		theApp.setVisible(true);
	}
}
