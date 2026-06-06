package API;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;

import com.google.gson.Gson;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaCep {

	private JFrame telaCep;
	private JTextField txtcep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCep window = new TelaCep();
					window.telaCep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public TelaCep() throws IOException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	private void initialize() throws IOException, InterruptedException {
		List<dadosCEP> CEPs = new LinkedList<dadosCEP>();
		
		telaCep = new JFrame();
		telaCep.setBounds(100, 100, 1920, 1080);
		telaCep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaCep.getContentPane().setLayout(null);
		
		txtcep = new JTextField();
		txtcep.setBounds(525, 221, 336, 27);
		txtcep.setOpaque(false);
		txtcep.setBorder(null);
		telaCep.getContentPane().add(txtcep);
		txtcep.setColumns(10);
		
		
		JButton btnProcurar = new JButton("");
		btnProcurar.setIcon(new ImageIcon(TelaCep.class.getResource("/imagens/State=Default.png")));
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnProcurar.setBounds(625, 290, 145, 45);
		btnProcurar.setOpaque(false);
		btnProcurar.setBorder(null);
		telaCep.getContentPane().add(btnProcurar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaCep.class.getResource("/imagens/TV - 1 (7).png")));
		lblNewLabel_2.setBounds(0, 0, 1370, 749);
		telaCep.getContentPane().add(lblNewLabel_2);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = txtcep.getText();
		        if(cep.matches("\\d{5}-?\\d{3}")) {
            		String endereço = "https://viacep.com.br/ws/"+cep+"/json";
		        						try {
						HttpClient cliente = HttpClient.newHttpClient();
						HttpRequest request = HttpRequest.newBuilder(URI.create(endereço)).build();
						HttpResponse <String> response = cliente.send(request, BodyHandlers.ofString());
						
						String json = response.body();
						
						Gson g = new Gson();
						CEP c = g.fromJson(json, CEP.class);
						
						dadosCEP d = new dadosCEP(c);
						CEPs.add(d);
						JOptionPane.showMessageDialog(null, d,"Resultado",1);
					} catch (IOException | InterruptedException ex) {
						JOptionPane.showMessageDialog(null, "Erro ao buscar o CEP","Erro",0);
					}
		        } else {
		            JOptionPane.showMessageDialog(null, "Formato inválido","aviso",-1);
		        }
			}
		});
	}
}
