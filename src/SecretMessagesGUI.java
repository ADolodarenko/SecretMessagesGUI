import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SecretMessagesGUI extends JFrame {
	private JTextField txtKey;
	private JTextArea txtIn;
	private JTextArea txtOut;
	
	public String encode(String message, int keyVal)
	{
		String output = "";
		
		return output;
	}
	
	public SecretMessagesGUI() {
		setResizable(false);
		setTitle("Alex's Secret Message App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtIn = new JTextArea();
		txtIn.setBounds(10, 11, 613, 172);
		getContentPane().add(txtIn);
		
		txtKey = new JTextField();
		txtKey.setBounds(292, 217, 47, 20);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		txtOut = new JTextArea();
		txtOut.setBounds(10, 270, 613, 172);
		getContentPane().add(txtOut);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(236, 220, 46, 14);
		getContentPane().add(lblKey);
		
		JButton btnEncodedecode = new JButton("Encode/Decode");
		btnEncodedecode.setBounds(349, 216, 121, 23);
		getContentPane().add(btnEncodedecode);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
