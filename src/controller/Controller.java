package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Scanner;
import model.data_structures.*;
import model.util.Sort;
import model.vo.VOMovingViolation;
import view.MovingViolationsManagerView;

@SuppressWarnings("unused")
public class Controller {


	/**
	 * Constante que representa los datos de las infracciones realizadas en Enero
	 */
	public static final String DATOS_ENERO = "./data/Moving_Violations_Issued_in_January_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Febrero
	 */
	public static final String DATOS_FEBRERO = "./data/Moving_Violations_Issued_in_February_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Marzo
	 */
	public static final String DATOS_MARZO = "./data/Moving_Violations_Issued_in_March_2018.csv";	
	
	private MovingViolationsManagerView view;
	
	// TODO Definir las estructuras de datos para cargar las infracciones del periodo definido
	
	// Muestra obtenida de los datos cargados 
	Comparable<VOMovingViolation> [ ] muestra;

	// Copia de la muestra de datos a ordenar 
	Comparable<VOMovingViolation> [ ] muestraCopia;

	/**
	 * Cola donde se van a cargar los datos de los archivos
	 */
	private Queue<VOMovingViolation> movingViolationsQueue;
	
	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private Stack<VOMovingViolation> movingViolationsStack;
	
	public Controller() {
		view = new MovingViolationsManagerView();
		
		//TODO inicializar las estructuras de datos para la carga de informacion de archivos
		movingViolationsQueue = null;
		movingViolationsStack = null;
		
	}

	/**
	 * Leer los datos de las infracciones de los archivos. Cada infraccion debe ser Comparable para ser usada en los ordenamientos.
	 * Todas infracciones (MovingViolation) deben almacenarse en una Estructura de Datos (en el mismo orden como estan los archivos)
	 * A partir de estos datos se obtendran muestras para evaluar los algoritmos de ordenamiento
	 * @return numero de infracciones leidas 
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public int loadMovingViolations() throws Exception {
		// TODO Los datos de los archivos deben guardarse en la Estructura de Datos definida
		int numInf = 0;
		boolean finish = false;
		int i = 0;
		String mes = null;
		
		while(finish) {
			if(i == 0) {
				mes = DATOS_ENERO;
				i++;
			}
			if(i == 1) {
				mes = DATOS_FEBRERO;
				i++;
			}
			if(i == 2) {
				mes = DATOS_MARZO;
				i++;
				finish = true;
			}
			
			File flMovingViolations = new File(mes);
			FileReader fr = new FileReader(flMovingViolations);
			BufferedReader lector = new BufferedReader(fr);
			lector.readLine();
			
			String info = lector.readLine();
			
			while(info != null)
			{
				String[] mv = info.split(",");
				
				String objectId = mv[0].trim();
				String row = mv[1].trim();
				String location = mv[2].trim();
				String addressId = mv[3].trim();
				String streetsegId = mv[4].trim();
				String xCoord = mv[5].trim();
				String yCoord = mv[6].trim();
				String ticketType= mv[7].trim();
				String fineAMT = mv[8].trim();
				String totalPaid = mv[9].trim();
				String penalty1 = mv[10].trim();
				String penalty2 = mv[11].trim();
				String accidentIndicator = mv[12].trim();
				String ticketIssueDate = mv[13].trim();
				String violationCode = mv[14].trim();
				String violationDescription = mv[15].trim();
				String rowId = mv[16].trim();
				
				movingViolationsQueue.enqueue(new VOMovingViolation(Integer.parseInt(objectId), location, Integer.parseInt(addressId), Integer.parseInt(streetsegId), Integer.parseInt(xCoord), Integer.parseInt(yCoord), ticketType, Integer.parseInt(fineAMT), Integer.parseInt(totalPaid), Integer.parseInt(penalty1), Integer.parseInt(penalty2), accidentIndicator, ticketIssueDate, Integer.parseInt(violationCode), violationDescription, Integer.parseInt(rowId)));
				movingViolationsStack.push(new VOMovingViolation(Integer.parseInt(objectId), location, Integer.parseInt(addressId), Integer.parseInt(streetsegId), Integer.parseInt(xCoord), Integer.parseInt(yCoord), ticketType, Integer.parseInt(fineAMT), Integer.parseInt(totalPaid), Integer.parseInt(penalty1), Integer.parseInt(penalty2), accidentIndicator, ticketIssueDate, Integer.parseInt(violationCode), violationDescription, Integer.parseInt(rowId)));
				
			}
			if(finish == true)
			{
				lector.close();
				fr.close();	
			}	
		}
		
		numInf = movingViolationsQueue.size();
		
		return numInf;
	}
	
	/**
	 * Generar una muestra aleatoria de tamaNo n de los datos leidos.
	 * Los datos de la muestra se obtienen de las infracciones guardadas en la Estructura de Datos.
	 * @param n tamaNo de la muestra, n > 0
	 * @return muestra generada
	 */
	public Comparable<VOMovingViolation> [ ] generarMuestra( int n )
	{
		muestra = new Comparable[ n ];
					
		// TODO Llenar la muestra aleatoria con los datos guardados en la estructura de datos
		
		return muestra;
		
	}
	
	/**
	 * Generar una copia de una muestra. Se genera un nuevo arreglo con los mismos elementos.
	 * @param muestra - datos de la muestra original
	 * @return copia de la muestra
	 */
	public Comparable<VOMovingViolation> [ ] obtenerCopia( Comparable<VOMovingViolation> [ ] muestra)
	{
		Comparable<VOMovingViolation> [ ] copia = new Comparable[ muestra.length ]; 
		for ( int i = 0; i < muestra.length; i++)
		{    copia[i] = muestra[i];    }
		return copia;
	}
	
	/**
	 * Ordenar datos aplicando el algoritmo ShellSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public void ordenarShellSort( Comparable<VOMovingViolation>[ ] datos ) {
		
		Sort.ordenarShellSort(datos);
	}
	
	/**
	 * Ordenar datos aplicando el algoritmo MergeSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public void ordenarMergeSort( Comparable<VOMovingViolation>[ ] datos ) {

		Sort.ordenarMergeSort(datos, muestraCopia);
	}

	/**
	 * Ordenar datos aplicando el algoritmo QuickSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public void ordenarQuickSort( Comparable<VOMovingViolation>[ ] datos ) {

		Sort.ordenarQuickSort(datos);
	}

	/**
	 * Invertir una muestra de datos (in place).
	 * datos[0] y datos[N-1] se intercambian, datos[1] y datos[N-2] se intercambian, datos[2] y datos[N-3] se intercambian, ...
	 * @param datos - conjunto de datos a invertir (inicio) y conjunto de datos invertidos (final)
	 */
	public void invertirMuestra( Comparable[ ] datos ) {

		// TODO implementar
	}
	
	public void run() throws Exception {
		long startTime;
		long endTime;
		long duration;
		
		int nDatos = 0;
		int nMuestra = 0;
		
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		
		while(!fin)
		{
			view.printMenu();
			
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					// Cargar infracciones
					nDatos = this.loadMovingViolations();
					view.printMensage("Numero infracciones cargadas:" + nDatos);
					break;
					
				case 2:
					// Generar muestra de infracciones a ordenar
					view.printMensage("Dar tamaNo de la muestra: ");
					nMuestra = sc.nextInt();
					muestra = this.generarMuestra( nMuestra );
					view.printMensage("Muestra generada");
					break;
					
				case 3:
					// Mostrar los datos de la muestra actual (original)
					if ( nMuestra > 0 && muestra != null && muestra.length == nMuestra )
					{    
						view.printDatosMuestra( nMuestra, muestra);
					}
					else
					{
						view.printMensage("Muestra invalida");
					}
					break;

				case 4:
					// Aplicar ShellSort a una copia de la muestra
					if ( nMuestra > 0 && muestra != null && muestra.length == nMuestra )
					{
						muestraCopia = this.obtenerCopia(muestra);
						startTime = System.currentTimeMillis();
						this.ordenarShellSort(muestraCopia);
						endTime = System.currentTimeMillis();
						duration = endTime - startTime;
						view.printMensage("Ordenamiento generado en una copia de la muestra");
						view.printMensage("Tiempo de ordenamiento ShellSort: " + duration + " milisegundos");
					}
					else
					{
						view.printMensage("Muestra invalida");
					}
					break;
					
				case 5:
					// Aplicar MergeSort a una copia de la muestra
					if ( nMuestra > 0 && muestra != null && muestra.length == nMuestra )
					{
						muestraCopia = this.obtenerCopia(muestra);
						startTime = System.currentTimeMillis();
						this.ordenarMergeSort(muestraCopia);
						endTime = System.currentTimeMillis();
						duration = endTime - startTime;
						view.printMensage("Ordenamiento generado en una copia de la muestra");
						view.printMensage("Tiempo de ordenamiento MergeSort: " + duration + " milisegundos");
					}
					else
					{
						view.printMensage("Muestra invalida");
					}
					break;
											
				case 6:
					// Aplicar QuickSort a una copia de la muestra
					if ( nMuestra > 0 && muestra != null && muestra.length == nMuestra )
					{
						muestraCopia = this.obtenerCopia(muestra);
						startTime = System.currentTimeMillis();
						this.ordenarQuickSort(muestraCopia);
						endTime = System.currentTimeMillis();
						duration = endTime - startTime;
						view.printMensage("Ordenamiento generado en una copia de la muestra");
						view.printMensage("Tiempo de ordenamiento QuickSort: " + duration + " milisegundos");
					}
					else
					{
						view.printMensage("Muestra invalida");
					}
					break;
											
				case 7:
					// Mostrar los datos de la muestra ordenada (muestra copia)
					if ( nMuestra > 0 && muestraCopia != null && muestraCopia.length == nMuestra )
					{    view.printDatosMuestra( nMuestra, muestraCopia);    }
					else
					{
						view.printMensage("Muestra Ordenada invalida");
					}
					break;
					
				case 8:	
					// Una muestra ordenada se convierte en la muestra a ordenar
					if ( nMuestra > 0 && muestraCopia != null && muestraCopia.length == nMuestra )
					{    
						muestra = muestraCopia;
						view.printMensage("La muestra ordenada (copia) es ahora la muestra de datos a ordenar");
					}
					break;

				case 9:
					// Invertir la muestra a ordenar
					if ( nMuestra > 0 && muestra != null && muestra.length == nMuestra )
					{    
						this.invertirMuestra(muestra);
						view.printMensage("La muestra de datos a ordenar fue invertida");
					}
					else
					{
						view.printMensage("Muestra invalida");
					}

					break;
					
				case 10:	
					fin=true;
					sc.close();
					break;
			}
		}
	}

}
