import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class DeleLine extends JFrame {

	private JPanel contentPane;
	JTextArea input, output;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleLine frame = new DeleLine();
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
	public DeleLine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		input = new JTextArea();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						dele();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
			}
		});
		panel.add(input);
		
		JLabel lblNewLabel = new JLabel("input");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		output = new JTextArea();
		output.setLineWrap(true);
		panel_1.add(output);
		
		JLabel lblOutput = new JLabel("output");
		panel_1.add(lblOutput, BorderLayout.NORTH);
		
		JButton button = new JButton("\u53D8\u53D8\u53D8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dele();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		contentPane.add(button, BorderLayout.SOUTH);
	}
	
	
	private void dele() throws IOException {
		// TODO Auto-generated method stub
		output.setText("");
		String str;
		BufferedReader br = new BufferedReader(new StringReader(input
				.getText()));
		while ((str = br.readLine()) != null) {
			String s = str;
			// s.replace("\r", "a");
			// s.replace("\t"," ");
			output.append(s);
			output.append(" ");

		}
		input.setText("");
		StringSelection stsel = new StringSelection(output.getText());
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stsel, stsel);
	}


}
