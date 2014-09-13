package logic;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

import logic.Interfaces.Factory;
import logic.Interfaces.IBankController;


public class Main {
	

	private static int mes_send=5;
	private static int mes_rec=10;
	private static int mes_send_interval = 5000;
	
	//http://localhost:8161/admin/queues.jsp
	
	
	public static void main(String[] args){
		
		Factory fac = new Factory();
		IBankController IController= fac.getIBankController();
		SendMessagesThread send = new SendMessagesThread(mes_send_interval, mes_send);
		
	
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Presione una para iniciar el envio de mensajes.");
			br.readLine();
			
			send.start();
			
			Thread.sleep(500);
			System.out.println("Presione una tecla para detener el envio de mensajes y terminar.");
			br.readLine();
			
			send.stop();
			
			
			
			//sends 10 random messages to queue
			//System.out.println("Sending messages...");
			//IController.sendMessages(mes_send);
			
			//System.out.println("Receiving messages...");
			//receive 10 messages from queue
			//IController.receiveMessages(mes_rec);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	
	} 
	
}
