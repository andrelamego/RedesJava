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
					
					if(linha.contains("inet ")) {
						String[] splitBuffer = bufferNome.split(" ");
						String[] splitIP = linha.split(" ");
						StringBuffer nomeAdaptador = new StringBuffer();
						StringBuffer enderecoIP = new StringBuffer();
						
						nomeAdaptador.append(splitBuffer[0]);
						nomeAdaptador.append(splitBuffer[1]);
						
						enderecoIP.append(splitIP[0]);
						enderecoIP.append(" ");
						enderecoIP.append(splitIP[1]);
						
						System.out.println(nomeAdaptador);
						System.out.println(enderecoIP);
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
		String osName = os();
		
		if(osName.contains("Windows")) {
			String procWin = "ping -4 -n 10 www.google.com.br";
			String[] vetCmd = procWin.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetCmd);
				
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				String linha = buffer.readLine();
				
				while(linha != null) {
					if(linha.contains("dia")) {
						System.out.println(linha.substring(34));
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
			String procLinux = "ping -4 -c 10 www.google.com.br";
			String[] vetCmd = procLinux.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetCmd);
				
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				String linha = buffer.readLine();
				
				while(linha != null) {
					if(linha.contains("avg")) {
						System.out.println("Avg: "+linha.substring(30, 36)+"ms");
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
}
