package PCT_APS;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class Jogo extends JFrame {
	
	int npalavras = 0;

	double i;//criando e iniciando as vari�veis globais
	
	int contPalavras;
	
	int pontMinima = 0;
	
	int pbVelocidade;
	
	private JPanel contentPane;
	
	Opcoes p = new Opcoes();
	
	public  int c;
	
	int pontuacao;
	
	JLabel lblPontuacao = new JLabel("");
	
    ArrayList<Integer> lista = new ArrayList<Integer>();  

	String titulo;

	JLabel lblPalavra = new JLabel(" ");// criando a label, que receber� valores do vetor
	
	int nivel = p.a;
	
	JLabel lblPontos = new JLabel("Pontos: ");	

	int cont = -1;
	
	

	public void sorteio(){
		
		
		cont += 1;
		String palavras [] = {"Caixa de pizza", "Garrafa pet", "Frasco de rem�dio", "Lata de refrigerante", "C�co vazio", "Monitor LED"};// O vetor que recebe as palavras mostradas para o usu�rio.
		
		contPalavras =(int) (0 + Math.random() * npalavras);//Sorteia um n�mero inteiro, este n�mero ser� usado como �ndice do vetor palavras[]
	
		 if (cont == npalavras)
			{
				i = 0;
			}

				if(!lista.contains(contPalavras))
				{  
					lista.add(contPalavras);	
				}
				else if (lista.contains(contPalavras))
				{
					while(lista.contains(contPalavras))
					{
						if(cont < npalavras)
							contPalavras =(int) (0 + Math.random() * npalavras);
						else
							break;
					}
					lista.add(contPalavras);	
				}
				if(cont < npalavras)
				{
					lblPalavra.setText(palavras[contPalavras]);  // A label lblPalavra recebe o valor do vetor de �ndice randomico.
					lblPalavra.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Imagens/" + contPalavras + ".png")));
				}


	
	}

	public Jogo() throws IOException {
		
		
		
		if (nivel == 0)
		{
			npalavras = 4;
			titulo = "F�cil";
			pontMinima = 13;
		}
		else if (nivel == 1)
		{
			npalavras = 5;
			titulo = "M�dio";
			pontMinima = 18;
		}
		else if (nivel == 2)
		{
			npalavras = 6;
			titulo = "Dif�cil";
			pontMinima = 23;
		}
		lblPontos.setVisible(false);
		lblPontuacao.setVisible(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jogo.class.getResource("/PCT_APS/Logos/logo.png")));
		setTitle("Reciclando - N�vel " + titulo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 554);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 255, 255));
		progressBar.setBackground(new Color(0, 100, 0));
		progressBar.setValue(100);
		
		JLabel lblW = new JLabel("W");
		lblW.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblR = new JLabel("R");
		lblR.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblY = new JLabel("Y");
		lblY.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblQ = new JLabel("Q");
		lblQ.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblT = new JLabel("T");
		lblT.setFont(new Font("Segoe UI", Font.BOLD, 14));

		final JButton btnPapel = new JButton("");
		AbstractAction nemonicoPapel = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnPapel.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla Q para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0);  
		String actionName = "TECLA_Q";  
		InputMap inputMap = btnPapel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap.put(keyStroke, actionName);  
		ActionMap actionMap = btnPapel.getActionMap();  
		actionMap.put(actionName, nemonicoPapel);  
		btnPapel.setBackground(Color.BLUE);
		btnPapel.setEnabled(false);
		btnPapel.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Lixos/papel.png")));//escolhe o �cone do bot�o
		btnPapel.addActionListener(new ActionListener() {//Bot�o papel
			public void actionPerformed(ActionEvent arg0) {
				
				if(contPalavras == 0)//Se o vetor estiver entre as posi��es informadas, executa o c�digo abaixo entre as chaves:
				{
					
					i += 10; //adiciona 10 � variavel i, ou seja, o usu�rio ganha mais tempo
					sorteio();//chama o m�todo sorteio para chamar outro �ndice do vetor
					pbVelocidade -= 1;//aumenta a velocidade da barra de progresso 
					pontuacao += 5;//acrescenta 5 pontos para a pontua��o do usu�rio
				}
				
				else//caso o �ndice do vetor n�o esteja entre as posi��es informadas acima, executa o c�digo abaixo entre as chaves:
				{
					i -= 10;//decrementa 10 a� variavel i, ou seja, o usu�rio perde tempo
					sorteio();//chama o m�todo sorteio para chamar outro �ndice do vetor
					pontuacao -= 2;//decrementa 2 pontos para a pontua��o do usu�rio
				}
			}
		});
		
		/*
		 * O procedimento mostrado no bot�o acima, � o mesmo usado nos bot�es seguintes.
		 */
		final JButton btnPlastico;
		btnPlastico = new JButton("");
		AbstractAction nemonicoPlastico = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnPlastico.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla W para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0);  
		String actionName1 = "TECLA_W";  
		InputMap inputMap1 = btnPlastico.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap1.put(keyStroke1, actionName1);  
		ActionMap actionMap1 = btnPlastico.getActionMap();  
		actionMap1.put(actionName1, nemonicoPlastico);  
		btnPlastico.setBackground(Color.RED);
		btnPlastico.setEnabled(false);
		btnPlastico.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Lixos/plastico.png")));//Escolhe o �cone do bot�o
		btnPlastico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(contPalavras == 1)
				{
					i += 10;
					sorteio();
					pbVelocidade -= 1;
					pontuacao += 5;
				}
				
				else
				{
					i -= 10;
					sorteio();
					pontuacao -= 2;
				}
			}
		});
		
		final JButton btnVidro = new JButton("");
		AbstractAction nemonicoVidro = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnVidro.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla E para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_E, 0);  
		String actionName2 = "TECLA_E";  
		InputMap inputMap2 = btnVidro.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap2.put(keyStroke2, actionName2);  
		ActionMap actionMap2 = btnVidro.getActionMap();  
		actionMap2.put(actionName2, nemonicoVidro);  
		btnVidro.setBackground(Color.GREEN);
		btnVidro.setEnabled(false);	
		btnVidro.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Lixos/vidro.png")));//Escolhe o �cone do bot�o
		btnVidro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(contPalavras == 2)
				{
					i += 10;
					sorteio();
					pbVelocidade -= 1;
					pontuacao += 5;
				}
				
				else
				{
					i -= 10;
					sorteio();
					pontuacao -= 2;
				}
			}
		});
		
		
		final JButton btnMetal = new JButton("");
		AbstractAction nemonicoMetal = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnMetal.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla R para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_R, 0);  
		String actionName3 = "TECLA_R";  
		InputMap inputMap3 = btnMetal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap3.put(keyStroke3, actionName3);  
		ActionMap actionMap3 = btnMetal.getActionMap();  
		actionMap3.put(actionName3, nemonicoMetal);  
		btnMetal.setBackground(Color.YELLOW);
		btnMetal.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Lixos/metal.png")));
		btnMetal.setEnabled(false);
		btnMetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(contPalavras == 3)
				{
					i += 10;
					sorteio();
					pbVelocidade -= 1;
					pontuacao += 5;
				}
				
				else
				{
					i -= 10;
					sorteio();
					pontuacao -= 2;
				}
			}
		});
		
		
		final JButton btnOrganico = new JButton("");
		if(nivel < 1)
		{
			btnOrganico.setVisible(false);
			lblT.setVisible(false);
		}
		AbstractAction nemonicoOrganico = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnOrganico.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla T para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_T, 0);  
		String actionName4 = "TECLA_T";  
		InputMap inputMap4 = btnOrganico.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap4.put(keyStroke4, actionName4);  
		ActionMap actionMap4 = btnOrganico.getActionMap();  
		actionMap4.put(actionName4, nemonicoOrganico);  
		btnOrganico.setBackground(new Color(102, 51, 0));
		btnOrganico.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Lixos/organico.png")));
		btnOrganico.setEnabled(false);
		btnOrganico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(contPalavras == 4)
				{
					i += 10;
					sorteio();
					pbVelocidade -= 1;
					pontuacao += 5;
				}
				
				else
				{
					i -= 10;
					sorteio();
					pontuacao -= 2;
				}
			}
		});
		
		final JButton btnNaoReciclavel = new JButton("");
		if(nivel < 2)
		{
			btnNaoReciclavel.setVisible(false);
			lblY.setVisible(false);
		}
		AbstractAction nemonicoNreciclavel = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		    	btnNaoReciclavel.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla Y para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke5 = KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0);  
		String actionName5 = "TECLA_Y";  
		InputMap inputMap5 = btnNaoReciclavel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap5.put(keyStroke5, actionName5);  
		ActionMap actionMap5 = btnNaoReciclavel.getActionMap();  
		actionMap5.put(actionName5, nemonicoNreciclavel);  
		btnNaoReciclavel.setBackground(Color.GRAY);
		btnNaoReciclavel.setIcon(new ImageIcon(Jogo.class.getResource("/PCT_APS/Lixos/n\u00E3o reciclavel.png")));
		btnNaoReciclavel.setEnabled(false);
		btnNaoReciclavel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(contPalavras == 5)
				{
					i += 10;
					sorteio();
					pbVelocidade -= 1;
					pontuacao += 5;
				}
				
				else
				{
					i -= 10;
					sorteio();
					pontuacao -= 2;
				}
			}
		});
		
		final JButton btnVoltar = new JButton("Voltar");
		AbstractAction nemonicoVoltar = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnVoltar.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla T para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke7 = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0);  
		String actionName7 = "TECLA_VOLTAR";  
		InputMap inputMap7 = btnVoltar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap7.put(keyStroke7, actionName7);  
		ActionMap actionMap7 = btnVoltar.getActionMap();  
		actionMap7.put(actionName7, nemonicoVoltar); 
		btnVoltar.setBackground(new Color(0, 100, 0));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Opcoes().setVisible(true);  
				dispose(); 
			}
		});
	 
		final JButton btnIniciar = new JButton("Iniciar");
		AbstractAction nemonicoIniciar = new AbstractAction() {  
		    public void actionPerformed(ActionEvent arg0) {  
		                              //simula o click no bot�o  
		        btnIniciar.doClick();  
		          
		    }  
		};   
		              //Associa o listener com a tecla T para que seja disparado toda vez, mesmo quando o foco n�o est� no bot�o  
		KeyStroke keyStroke6 = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);  
		String actionName6 = "TECLA_ENTER";  
		InputMap inputMap6 = btnIniciar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  
		inputMap6.put(keyStroke6, actionName6);  
		ActionMap actionMap6 = btnIniciar.getActionMap();  
		actionMap6.put(actionName6, nemonicoIniciar);   
		btnIniciar.setBackground(new Color(0, 100, 0));
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblPontos.setVisible(true);
				lblPontuacao.setVisible(true);
				sorteio();
				btnIniciar.setVisible(false);
				btnVoltar.setVisible(false);
				btnPapel.setEnabled(true);
				btnPlastico.setEnabled(true);
				btnVidro.setEnabled(true);
				btnMetal.setEnabled(true);
				btnOrganico.setEnabled(true);
				btnNaoReciclavel.setEnabled(true);
				pontuacao = 0;//inicializa a vari�vel pontuacao como 0
				pbVelocidade = 110;//inicializa a vari�vel pbVelocidade como 110, velocidade inicial da progress bar

				
				new Thread(){//Thread � um m�todo que permite que o jogo seja executado enquanto a barra de progresso se movimenta
				public void run(){
					for (i = 100; i >= 0; i--)//controla a barra de progresso atrav�s da estrutura for
					{
						try{
							sleep(pbVelocidade);//sleep � o comando que causa um delay na progressbar, quanto maior o n�mero informado na assinatura, mais lentamente a progressbar desce
							progressBar.setValue( (int) i);//Determina o valor i para a progress bar. Esse valor � alterado constantemente nessa estrutura for e nos bot�es 
							
							lblPontuacao.setText(String.valueOf(pontuacao));
							
							if (i > 100)//Essa estrutura if impede com que a barra de progresso fique com um valor acima de 100, que � o valor m�ximo dela.
							{
								i = 100;
							}

					
						}
						catch(InterruptedException erro){
							
							JOptionPane.showMessageDialog(null, "Erro!");
							
						}
						
						
						if (progressBar.getValue() <= 0)//caso a progress bar seja igual ou menor que 0, ou seja, o jogo chegou ao fim
						{
							lblPalavra.setIcon(null);
							lblPalavra.setText("");
							lista.clear();
							lblPontos.setVisible(false);
							lblPontuacao.setVisible(false);
							String fim;
							 if ((cont == npalavras)&&(pontuacao >= pontMinima))
								{
									fim = "Voc� ganhou!";
								}
							 else
							 	{
									fim = "Voc� perdeu!";
								}	
							
							int resposta = JOptionPane.showConfirmDialog(null, fim + "\nVoc� fez " + pontuacao + " pontos\nDeseja jogar novamente?", "Fim de jogo!", JOptionPane.YES_NO_OPTION);//mostra uma caixa de mensagem no final, mostrando a pontua��o final
							if(resposta == JOptionPane.YES_OPTION)
							{
								try {
									Jogo frame = new Jogo();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
								dispose();
								
							}
							
							else
							{
								
								try {
									Menu frame = new Menu();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								dispose();
								
								
							}
						}
					}
				}
				
			}.start();
			}});
		lblPalavra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalavra.setFont(new Font("Segoe UI", Font.BOLD, 20));
		

		

		lblPontuacao.setHorizontalAlignment(SwingConstants.TRAILING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnIniciar)
							.addGap(96)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblPontos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPontuacao))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnVoltar)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(37))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(56)
									.addComponent(lblPalavra, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnPapel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(btnPlastico, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(btnVidro, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnMetal, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(23)
									.addComponent(btnOrganico, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNaoReciclavel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(45)
									.addComponent(lblQ)
									.addGap(134)
									.addComponent(lblW, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addGap(128)
									.addComponent(lblE, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(118)
									.addComponent(lblR)
									.addGap(119)
									.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addGap(113)
									.addComponent(lblY)))))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnIniciar)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPontos)
								.addComponent(lblPontuacao))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar)
						.addComponent(lblPalavra, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPapel)
						.addComponent(btnPlastico, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVidro, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMetal, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOrganico)
						.addComponent(btnNaoReciclavel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblQ)
							.addComponent(lblW)
							.addComponent(lblE)
							.addComponent(lblR)
							.addComponent(lblT))
						.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
