package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateConvert {
	private static String data;
	private static int dia;
	private static int mes;
	private static int ano;
	public static DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	public static DateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
	public static DateFormat formatoDataBanco = new SimpleDateFormat("yyyy-MM-dd");
	
	/**CAPITURA DATA ATUAL DO SISTEMA**/
	public static String dataAtual()
	{
		DateFormat data = new SimpleDateFormat( "dd/MM/yyyy" );
		String dataAtual = data.format( new Date() );
		return dataAtual;
	}
	
	/**CAPITURA DATA ATUAL DO SISTEMA**/
	public static String horaAtual()
	{
		DateFormat hora = new SimpleDateFormat( "HH:mm:ss" );
		String horaAtual = hora.format( new Date() );
		return horaAtual;
	}
	
	/**CONVERTE A DATA DO BD PARA A DATA NO FORMATO NORMAL
	 * RECEBE UMA STRING NESSE FORMATO yyyy/MM/dd COMO PARAMETRO**/
	public static String convertNormal( String data ){
		String novaData = "";
		novaData = data.substring(8,10) + data.substring(5,7) + data.substring(0,4) ;
		return novaData;
	}//fim do convertNormal
	
	public static String converteDDMMAAAA( String data ){
		String novaData = "";
		novaData = data.substring(8,10) +"/"+ data.substring(5,7) +"/"+ data.substring(0,4) ;
		return novaData;
	}//fim do convertNormal
	
	/**
	* Coverta data para inteiro
	* E valida Mês e Dia verificando o retorno de cada metodo
	*/
	public static boolean validaData(String dataTemp){

		if( dataTemp.length() < 10){
			return false;
		}
		int mesTemp;
		int diaTemp;
		data = dataTemp.replace("/","");
		dia = Integer.parseInt(data.trim().substring(0,2));
		mes = Integer.parseInt(data.trim().substring(2,4));
		ano = Integer.parseInt(data.trim().substring(4,8));
		
		mesTemp = checaMes(mes);
		
		
		if( mesTemp != -1 ){
			mes = mesTemp;
			diaTemp = checaDia(dia);
			if(diaTemp != -1){
				dia = diaTemp;
				return true;
			}else{
				//JOptionPane.showMessageDialog(null,"Data Inválida.");
				return false;
			}
		}else{
			//JOptionPane.showMessageDialog(null,"Data Inválida.");
			return false;
		}
	}

	/**
	 * Checa mes verificando se é maior que zero e menor que 12
	 */
	private static int checaMes(int mesTemp){

		if(mesTemp > 0 && mesTemp <= 12){ 
			return mesTemp;
		}else{
			return -1;
		}
	}

	/**
	Checa dia tendo uma variavel inteira como arrayc ultimoDiaMes com os valores do ultimo dia
	de cada mes.
	Verifica também se o ano é Bissexto
	*/
	private static int checaDia(int diaTemp){
		int ultimoDiaMes[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(diaTemp > 0 && diaTemp <= ultimoDiaMes[mes]){ 
			return diaTemp;
		}else if(mes == 2 && diaTemp == 29 && (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0 ) ) ){
			return diaTemp;
		}else{
			return -1;
		}
	}
	
	/***CONTA A QUANTIDADE DE DIAS ENTRE DUAS DATAS***/
	public static int qtdDias(Date date, Date date2) {  
		   Calendar currentDate = new GregorianCalendar();  
		   currentDate.setTime(date);  
		   Calendar newDate= new GregorianCalendar();  
		   newDate.setTime(date2);  
		   long millisBetween = Math.abs(currentDate.getTime().getTime() - newDate.getTime().getTime());  
		   return (int) Math.round (millisBetween / (1000 * 60 * 60 * 24));  
	}  
	
	public static java.sql.Date dataBanco(String data){
		java.sql.Date dataBanco = null;
		try{
			dataBanco = new java.sql.Date(formatoData.parse(data).getTime());
		}catch (Exception ex) {
			// TODO: handle exception
		}
		return dataBanco;
	}

	
	public static String getDataBackup()
	{
		DateFormat data = new SimpleDateFormat( "dd-MM-yyyy" );
		String dataAtual = data.format( new Date() );
		
		Random r = new Random();

		return dataAtual + "_" + r.nextInt();
	}
	
	public static String getDataRelatorio()
	{
		DateFormat data = new SimpleDateFormat( "dd-MM-yyyy" );
		String dataAtual = data.format( new Date() );
		
		return dataAtual.replace("-", "_")+".pdf";
	}
	
	public static java.sql.Date getDateSql(String data){
		java.sql.Date retorno = null;
		try{
			retorno = new java.sql.Date(DateConvert.formatoData.parse(data).getTime());
		}catch (Exception ex) {
		}
		return retorno;	
	}
}
