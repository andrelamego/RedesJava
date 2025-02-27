package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() { super(); }
	
	private String os() {
		String name = System.getProperty("os.name");
		return name;
	}
	
	public void ip() {
		String osName = os();
		
		if(osName.contains("Windows")) {	
			String procWin = "ipconfig";
			String[] vetCmd = procWin.split(" ");
			
			
			try {
				Process p = Runtime.getRuntime().exec(vetCmd);
				
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				String linha = buffer.readLine();
				String bufferNome = null;
				while(linha != null) {
					
					if(linha.contains("Adaptador")) {
						bufferNome = linha;
					}
					
					if(linha.contains("IPv4")) {
						System.out.println(bufferNome);
						System.out.println(linha);
						System.out.println("");
					}
					
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				stream.close();
				
				
			} catch (Exception e) {
				String erro = e.getMessage();
				System.err.println(erro);
			}
		}
		else {
			String procLinux = "ip addr";
			String[] vetCmd = procLinux.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetCmd);
				
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				String linha = buffer.readLine();
				String bufferNome = null;
				while(linha != null) {
					
					if(linha.contains("qlen")) {
						bufferNome = linha;
					}
					
					if(linha.contains("inet")) {
						System.out.println(bufferNome);
						System.out.println(linha);
						System.out.println("");
					}
					
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				stream.close();
				
				
			} catch (Exception e) {
				String erro = e.getMessage();
				System.err.println(erro);
			}
		}
	}
	
	
	public void ping() {
		
	}
}
