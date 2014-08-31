package logic.Controllers;

import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import logic.Interfaces.IBankController;
import logic.datatypes.Constants;
import logic.datatypes.Transaction;

import org.apache.activemq.ActiveMQConnectionFactory;

public class BankController implements IBankController{

	public void sendMessages(int messages) throws JMSException, JAXBException{
		TransactionsController tController= new TransactionsController();
		ConnectionFactory connectf= new ActiveMQConnectionFactory(Constants.url);
		Connection con= connectf.createConnection();
		con.start();
		Session s=con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination d= s.createQueue(Constants.queuename);
		MessageProducer producer = s.createProducer(d);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		for(int i=0; i<messages;i++){		
		Transaction transaction = tController.createTransaction();
		StringWriter sw = new StringWriter();

		//parse to XML
		
			JAXBContext context = JAXBContext.newInstance(Transaction.class);
			Marshaller mar= context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			mar.marshal(transaction, sw);


		TextMessage textm= s.createTextMessage(sw.toString());
		//System.out.print(sw.toString());
		producer.send(textm);
		
		}
		
		s.close();
		con.close();
	}

	public void receiveMessages(int messages) throws JMSException, JAXBException{
		//receive messages

		System.out.print("Sleeping");
		ConnectionFactory connectf2= new ActiveMQConnectionFactory(Constants.url);
		Connection con2= connectf2.createConnection();
		con2.start();
		Session s2=con2.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination d2= s2.createQueue(Constants.queuename);
		MessageConsumer mescons= s2.createConsumer(d2);
		Message mensajerec;//= mescons.receive();
		TransactionsController tController = new TransactionsController();
		
		for(int i=0; i<messages;i++){
			mensajerec=mescons.receive();
			if(mensajerec!=null){
			TextMessage textm2 = (TextMessage)mensajerec;
			Transaction trans= tController.StringXMLtoTransaction(textm2.getText());
			System.out.println("Filter BY TRADE: " + trans.get_nombre_comercio());
			}
		}
		System.out.print("END");

		s2.close();
		con2.close();	
		
		
	}
	
}