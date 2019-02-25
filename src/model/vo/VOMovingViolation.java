package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representation of a MovingViolation object
 */
public class VOMovingViolation implements Comparable<VOMovingViolation> {

	// TODO Definir los atributos de una infraccion
	/**
	 * Identificador �nico de la infracci�n
	 */
	private int objectId;
	
	/**
	 * Direcci�n en formato de texto
	 */
	private String rowLocation;
	
	/**
	 * ID de la direcci�n
	 */
	private int addresId;
	
	/**
	 * ID del segmento de la calle
	 */
	private int streetSegId;
	
	/**
	 * Coordenada X donde ocurri� (No corresponde a una longitud geogr�fica)
	 */
	private int xCoord;
	
	/**
	 * Coordenada y donde ocurri� (No corresponde a una longitud geogr�fica)
	 */
	private int yCoord;
	
	/**
	 * Tipo de infracci�n
	 */
	private String ticketType;
	
	/**
	 * Cantidad a pagar por la infracci�n en USD
	 */
	private int fineAMT;
	
	/**
	 * Cuanto dinero pag� el que recibi� la multa
	 */
	private int totalPaid;
	
	/**
	 * Dinero extra que debe pagar el conductor
	 */
	private int penal1;
	
	/**
	 * Dinero extra que debe pagar el conductor
	 */
	private int penal2;
	
	/**
	 * Indicador de accidente
	 */
	private String accidentIndicator;
	
	/**
	 * Numero de la agencia
	 */
	private int agencyId;
	
	/**
	 * Fecha cuando se puso la infracci�n
	 */
	private Date ticketIssueDate;
	
	/**
	 * C�digo de la infracci�n
	 */
	private int violationCode;
	
	/**
	 * Descripci�n textual de la infracci�n
	 */
	private String violationDesc;
	
	private int rowId;
	
	/**
	 * Es el formato que se usara para las fechas
	 */
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	/**
	 * Metodo constructor
	 * @throws ParseException 
	 */
	public VOMovingViolation( int pObjectId, String pLocation, int pAddrresId, int pStreetSegId,int pXCoord, int pYCoord, String pTicketType, int pSumaFINEAMT, int pTotalPaid, int pPenal1, int pPenal2, String pAccidentIndicator, int pAgencyId, String pTicketIssueDate, int pViolationCode, String pViolationDescription, int pRowId) throws ParseException
	{
		// TODO Implementar
		objectId = pObjectId;
		rowLocation = pLocation;
		addresId = pAddrresId;
		streetSegId = pStreetSegId;
		xCoord = pXCoord;
		yCoord = pYCoord;
		ticketType = pTicketType;
		fineAMT = pSumaFINEAMT;
		totalPaid = pTotalPaid;
		penal1 = pPenal1;
		penal2 = pPenal2;
		accidentIndicator =  pAccidentIndicator;
		agencyId = pAgencyId;
		ticketIssueDate = format.parse(pTicketIssueDate);
		violationCode = pViolationCode;
		violationDesc = pViolationDescription;
		rowId = pRowId;
	}	
	
	/**
	 * @return id - Identificador unico de la infraccion
	 */
	public int objectId() {
		// TODO Auto-generated method stub
		return objectId;
	}	
	
	
	/**
	 * @return location - Direccion en formato de texto.
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return rowLocation;
	}

	/**
	 * @return date - Fecha cuando se puso la infraccion .
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return ticketIssueDate.toString();
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente paga el que recibio la infraccion en USD.
	 */
	public int getTotalPaid() {
		// TODO Auto-generated method stub
		return totalPaid;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}
		
	/**
	 * @return description - Descripcion textual de la infraccion.
	 */
	public String  getViolationDescription() {
		// TODO Auto-generated method stub
		return violationDesc;
	}

	@Override
	public int compareTo(VOMovingViolation o) {
		// TODO implementar la comparacion "natural" de la clase
		return 0;
	}
	
	public String toString()
	{
		// TODO Convertir objeto en String (representacion que se muestra en la consola)
		return "-";
	}
}
