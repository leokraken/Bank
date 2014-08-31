package logic;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

import logic.Interfaces.Factory;
import logic.Interfaces.IBankController;


public class Main {
	

	private static int mes_send=10;
	private static int mes_rec=10;
	
	public static void main(String[] args){
		
		Factory fac = new Factory();
		IBankController IController= fac.getIBankController();
		
	
		try {
			//sends 10 random messages to queue
			System.out.println("Sending messages...");
			IController.sendMessages(mes_send);
			
			System.out.println("Receiving messages...");
			//receive 10 messages from queue
			IController.receiveMessages(mes_rec);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Error trying to connect with QUEUQ");
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Parsing XML");
			e.printStackTrace();
		}

	
	} 
	
}
