package logic.datatypes;

import java.math.BigDecimal;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Transaction")
public class Transaction {

	@XmlAttribute
	private long _id;
	private String _fecha;
	private String _hora;
	private String _tipo_transaccion;
	private String _codigo_comercio;
	private String _nombre_comercio;
	private String _numero_tarjeta;
	private String _tipo_tarjeta;
	private String _codigo_moneda;
	private String _tipo_dispositivo;
	private BigDecimal _monto;
	

	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String get_fecha() {
		return _fecha;
	}
	public void set_fecha(String _fecha) {
		this._fecha = _fecha;
	}
	public String get_hora() {
		return _hora;
	}
	public void set_hora(String _hora) {
		this._hora = _hora;
	}
	public String get_tipo_transaccion() {
		return _tipo_transaccion;
	}
	public void set_tipo_transaccion(String _tipo_transaccion) {
		this._tipo_transaccion = _tipo_transaccion;
	}
	public String get_codigo_comercio() {
		return _codigo_comercio;
	}
	public void set_codigo_comercio(String _codigo_comercio) {
		this._codigo_comercio = _codigo_comercio;
	}
	public String get_nombre_comercio() {
		return _nombre_comercio;
	}
	public void set_nombre_comercio(String _nombre_comercio) {
		this._nombre_comercio = _nombre_comercio;
	}
	public String get_numero_tarjeta() {
		return _numero_tarjeta;
	}
	public void set_numero_tarjeta(String _numero_tarjeta) {
		this._numero_tarjeta = _numero_tarjeta;
	}
	public String get_tipo_tarjeta() {
		return _tipo_tarjeta;
	}
	public void set_tipo_tarjeta(String _tipo_tarjeta) {
		this._tipo_tarjeta = _tipo_tarjeta;
	}
	public String get_codigo_moneda() {
		return _codigo_moneda;
	}
	public void set_codigo_moneda(String _codigo_moneda) {
		this._codigo_moneda = _codigo_moneda;
	}
	public String get_tipo_dispositivo() {
		return _tipo_dispositivo;
	}
	public void set_tipo_dispositivo(String _tipo_dispositivo) {
		this._tipo_dispositivo = _tipo_dispositivo;
	}
	public BigDecimal get_monto() {
		return _monto;
	}
	public void set_monto(BigDecimal _monto) {
		this._monto = _monto;
	}
	
	
}
