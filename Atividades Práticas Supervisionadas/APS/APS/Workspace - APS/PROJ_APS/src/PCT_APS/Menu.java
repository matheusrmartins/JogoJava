package PCT_APS;

import java.awt.BorderLayout;
import java.io.IOException;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Menu extends JFrame {

	private JPanel contentPane;

	
public static void main(String[] args) throws IOException {
		 

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Menu frame = new Menu();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	
	public Menu() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/PCT_APS/Logos/logo.png")));
		setTitle("Reciclando");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 426);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setDisplayedMnemonic('p');
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/PCT_APS/Logos/pendoleo.png")));
		lblNewLabel.setBounds(10, -19, 159, 110);
		contentPane.add(lblNewLabel);
		
		JLabel lblPendoleo = new JLabel("Pendoleo");
		lblPendoleo.setForeground(Color.RED);
		lblPendoleo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPendoleo.setBounds(10, 46, 62, 20);
		contentPane.add(lblPendoleo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/PCT_APS/Logos/nomejogo.png")));
		lblNewLabel_1.setBounds(324, 52, 208, 157);
		lblNewLabel_1.setVisible(true);
		contentPane.add(lblNewLabel_1);
		
		final JButton btnIniciar = new JButton("Iniciar");
		AbstractAction nemonicoIniciar = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnIniciar.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla T para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);  
		String actionName = "TECLA_ENTER";  
		InputMap inputMap = btnIniciar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap.put(keyStroke, actionName);  
		ActionMap actionMap = btnIniciar.getActionMap();  
		actionMap.put(actionName, nemonicoIniciar); 
		btnIniciar.setBackground(new Color(0, 0, 204));
		btnIniciar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Opcoes().setVisible(true);  
				dispose(); 
				
			}
		});
		btnIniciar.setForeground(new Color(255, 255, 255));
		btnIniciar.setBounds(712, 96, 106, 35);
		contentPane.add(btnIniciar);
		
		final JButton btnSair = new JButton("Sair");
		AbstractAction nemonicoSair = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnSair.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla T para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);  
		String actionName1 = "TECLA_ESC";  
		InputMap inputMap1 = btnSair.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap1.put(keyStroke1, actionName1);  
		ActionMap actionMap1 = btnSair.getActionMap();  
		actionMap1.put(actionName1, nemonicoSair); 
		btnSair.setBackground(new Color(0, 0, 204));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(712, 172, 106, 35);
		contentPane.add(btnSair);
		
		JLabel lblReciclarMenu = new JLabel("");
		lblReciclarMenu.setIcon(new ImageIcon(Menu.class.getResource("/PCT_APS/Logos/reciclagem.png")));
		lblReciclarMenu.setBounds(249, -34, 510, 461);
		contentPane.add(lblReciclarMenu);
	}
}
