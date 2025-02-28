package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		RedesController redes = new RedesController();
		
		int select = 0;
		
		while(select != 9) {
			
			select = Integer.parseInt(JOptionPane.showInputDialog("1 - Exibir endereço IPv4\n2 - Exibir ping médio (www.google.com.br)\n9 - Finalizar Programa"));
			
			switch (select) {
			case 1:
				redes.ip();
				break;
			case 2:
				redes.ping();
				break;
			case 9:
				System.out.println("Programa Finalizado");
				break;
			default:
				break;
			}
		}
	}
}
