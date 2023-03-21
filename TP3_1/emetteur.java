package TP3_1;

import java.io.*;
import java.net.*;

public class emetteur {
	public static void main(String arvg[]){
		int port =2001;
	
		String host="localhost";
	
		try {
			InetAddress adr = InetAddress.getByName(host);
			DatagramSocket socket= new DatagramSocket();
			String fileName = "C:\\Users\\Abderrahim\\Desktop\\GL\\reseau\\src\\TP3_1\\ipcb.png";
			File file = new File(fileName);
			byte[] name= file.getName().getBytes();
			DatagramPacket packet = new DatagramPacket(name,name.length,adr,port);
			socket.send(packet);
			byte[] reponse = new byte [9003];
			packet = new DatagramPacket(reponse,reponse.length);
			socket.receive(packet);
			String rep = new String(packet.getData(),0,packet.getLength());
			System.out.println(rep);
			FileInputStream input= new FileInputStream(file);
			while(input.read(reponse) != -1) {
				packet = new DatagramPacket(reponse,reponse.length, packet.getAddress(),packet.getPort());
				socket.send(packet);
				
			}
		}catch(Exception e) {
				System.out.println("Err :"+e);
		}
	}	
}
	            
	   