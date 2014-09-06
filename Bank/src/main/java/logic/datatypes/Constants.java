package logic.datatypes;

import org.apache.activemq.ActiveMQConnection;

public class Constants {
	public static String url= ActiveMQConnection.DEFAULT_BROKER_URL;
	public static String queuename= "TEST.queue";
	public static String[] transaction_type = {"compra","deposito","consulta de saldo","INVALID"};
	public static String[] card_type = {"debido","credito","prepaga","INVALID"};
	public static String[] money_code = {"UYU","USD","INVALID"};
	public static String[] device_type= {"POS","WEB","ATM","INVALID"};
	public static String[] dates= {"010114","010614","010814","0106140"};	//last invalid
	public static String[] hours= {"220114","030314","060807","2506140"};	//last invalid
	public static String[] trades= {"Microsoft","Apple","Oracle","Cualquiera"};
	public static String[] cards_numbers= {"29353","2432345","32","656"};

}
