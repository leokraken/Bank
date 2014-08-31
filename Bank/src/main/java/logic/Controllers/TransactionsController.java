package logic.Controllers;

import java.io.StringReader;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import logic.datatypes.Constants;
import logic.datatypes.Transaction;

public class TransactionsController {


	public int getRandomId(){
		Random rand = new Random();
		return rand.nextInt(100);
	}
	
	public String getRandomTransactionType(){
		Random rand = new Random();
		return Constants.transaction_type[rand.nextInt(Constants.transaction_type.length)];
	}
	
	public String getRandomCardType(){
		Random rand = new Random();
		return Constants.card_type[rand.nextInt(Constants.card_type.length)];
	}
	
	public String getRandomMoneyCode(){
		Random rand = new Random();
		return Constants.money_code[rand.nextInt(Constants.money_code.length)];
	}
	
	public String getRandomDeviceType(){
		Random rand = new Random();
		return Constants.device_type[rand.nextInt(Constants.device_type.length)];
	}
	
	public String getRandomDate(){
		Random rand = new Random();
		return Constants.dates[rand.nextInt(Constants.dates.length)];
	}
	
	public String getRandomHour(){
		Random rand = new Random();
		return Constants.hours[rand.nextInt(Constants.hours.length)];
	}
	
	public String getRandomTrade(){
		Random rand = new Random();
		return Constants.trades[rand.nextInt(Constants.trades.length)];
	}
	
	public String getRandomCardNumber(){
		Random rand = new Random();
		return Constants.cards_numbers[rand.nextInt(Constants.cards_numbers.length)];	
	}
	
	public int getRandomMonto(){
		Random rand = new Random();
		return rand.nextInt(1000000);	
	}
	
	public Transaction createTransaction(){
		Transaction transaction= new Transaction();
		int id= getRandomId();
		String t_t= getRandomTransactionType();
		String c_t= getRandomCardType();
		String money= getRandomMoneyCode();
		String device= getRandomDeviceType();
		String date= getRandomDate();
		String hour= getRandomHour();
		String trade= getRandomTrade();
		String card= getRandomCardNumber();
		int monto= getRandomMonto();
		
		transaction.set_id(id);
		transaction.set_fecha(date);
		transaction.set_hora(hour);
		transaction.set_tipo_transaccion(t_t);
		transaction.set_codigo_comercio(c_t);
		transaction.set_nombre_comercio(trade);
		transaction.set_numero_tarjeta(card);
		transaction.set_tipo_tarjeta(c_t);
		transaction.set_codigo_moneda(money);
		transaction.set_tipo_dispositivo(device);
		transaction.set_monto(monto);
		return transaction;
		
	}
	
	public Transaction StringXMLtoTransaction(String XMLs) throws JAXBException{
		JAXBContext context= JAXBContext.newInstance(Transaction.class);
		Unmarshaller un = context.createUnmarshaller();
		StringReader sr = new StringReader(XMLs);
		Transaction transaction = (Transaction) un.unmarshal(sr);
		return transaction;
	}

	
}
