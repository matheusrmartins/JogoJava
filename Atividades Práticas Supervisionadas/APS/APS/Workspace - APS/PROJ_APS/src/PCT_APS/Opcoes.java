package PCT_APS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;


public class Opcoes extends JFrame {
	
	public static int a;
	
	public int nivel()
	{
		a = cbNivel.getSelectedIndex();
		return a;
	}

	
	private JPanel contentPane;

	final static JComboBox cbNivel = new JComboBox();
	
	public Opcoes() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Opcoes.class.getResource("/PCT_APS/Logos/logo.png")));
		setTitle("Reciclando");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbNivel.setForeground(new Color(255, 255, 255));
		cbNivel.setBackground(new Color(0, 0, 204));
		cbNivel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		

		cbNivel.setModel(new DefaultComboBoxModel(new String[] {"F\u00E1cil", "M\u00E9dio", "D\u00EDficil"}));
		cbNivel.setSelectedIndex(1);
		cbNivel.setBounds(383, 67, 89, 23);
		contentPane.add(cbNivel);
		
		
		JLabel lblSelecioneONivel = new JLabel("Selecione o Nivel: ");
		lblSelecioneONivel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSelecioneONivel.setBounds(245, 69, 114, 14);
		contentPane.add(lblSelecioneONivel);
			
		
		JButton btnJogar = new JButton("Tabela de pontos");
		btnJogar.setForeground(Color.WHITE);
		btnJogar.setBackground(new Color(0, 0, 204));
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pontuacao dialog;
				
				dialog = new Pontuacao();
				dialog.setVisible(true);
			

			}
		});
		btnJogar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnJogar.setBounds(543, 67, 134, 23);
		contentPane.add(btnJogar);
		
		final JButton btnVoltar = new JButton("Voltar");
		AbstractAction nemonicoVoltar = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnVoltar.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla T para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0);  
		String actionName = "TECLA_VOLTAR";  
		InputMap inputMap = btnVoltar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap.put(keyStroke, actionName);  
		ActionMap actionMap = btnVoltar.getActionMap();  
		actionMap.put(actionName, nemonicoVoltar); 
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(0, 0, 204));
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu().setVisible(true);  
				dispose(); 
			}
		});
		btnVoltar.setBounds(425, 458, 89, 23);
		contentPane.add(btnVoltar);
		
		JTextPane txtpnDicasDoJogo = new JTextPane();
		txtpnDicasDoJogo.setForeground(Color.BLACK);
		txtpnDicasDoJogo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtpnDicasDoJogo.setBackground(new Color(204, 255, 255));
		txtpnDicasDoJogo.setEditable(false);
		txtpnDicasDoJogo.setText("Dicas do jogo:\r\n\r\n\u2022 Conforme o objeto aparece na tela, voc\u00EA deve clicar no lixo correspondente. \r\n\r\n\u2022 Enquanto voc\u00EA pensa, uma barra de tempo vai diminuindo. Voc\u00EA n\u00E3o pode deixar que essa barra chegue ao fim!\r\n\r\n\u2022 Conforme voc\u00EA coloca os objetos nos lixos certos, a barra de tempo aumenta e voc\u00EA ganha 5 pontos. Por\u00E9m se voc\u00EA errar o lixo a barra diminui mais ainda e voc\u00EA perde 2 pontos.\r\n\r\n\u2022 O jogo acaba quando voc\u00EA terminar de responder \u00E0 todos os objetos. Para ganhar, voc\u00EA deve somar os pontos necess\u00E1rios conforme a dificuldade escolhida, e tamb\u00E9m n\u00E3o pode deixar a barra de tempo chegar ao fim.\r\n\r\n\u2022 Quanto maior a dificuldade escolhida, mais pontos voc\u00EA deve fazer para vencer e mais variedades de lixos e objetos aparecer\u00E3o.\r\n\r\n\u2022 Para descobrir quantos pontos voc\u00EA precisa fazer para vencer o jogo, clique na tabela de pontos\r\n\r\n\u2022 Agora \u00E9 s\u00F3 clicar em come\u00E7ar! ");
		txtpnDicasDoJogo.setBounds(41, 67, 777, 342);
		contentPane.add(txtpnDicasDoJogo);
		
		final JButton button = new JButton("Come\u00E7ar");
		AbstractAction nemonicoComecar = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        button.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla ENTER para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);  
		String actionName1 = "TECLA_ENTER";  
		InputMap inputMap1 = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap1.put(keyStroke1, actionName1);  
		ActionMap actionMap1 = button.getActionMap();  
		actionMap1.put(actionName1, nemonicoComecar); 
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nivel();
				
				try {
					new Jogo().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				dispose();
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.BOLD, 12));
		button.setBackground(new Color(0, 0, 204));
		button.setBounds(300, 457, 89, 23);
		contentPane.add(button);
		
	}
}

