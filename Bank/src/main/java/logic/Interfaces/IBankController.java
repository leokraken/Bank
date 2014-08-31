package logic.Interfaces;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

public interface IBankController {

	public void sendMessages(int messages) throws JMSException, JAXBException;
	public void receiveMessages(int messages) throws JMSException, JAXBException;

}
