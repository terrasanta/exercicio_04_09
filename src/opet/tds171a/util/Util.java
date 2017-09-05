package opet.tds171a.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	public static final String PADRAO_DATA = "dd/MM/yyyy HH:mm:ss";
	public static final String PADRAO_DATA_HORA = "dd/MM/yyyy";
	public static Date formataData_(String dataFormatoString) throws ParseException{
		
		Locale localeBrasil = new Locale("pt","BR");
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, localeBrasil);
		df.setLenient(false);
		return df.parse(dataFormatoString);
	}
	public static String formataData_(Date dataFormatoString) throws ParseException{
		Locale localeBrasil = new Locale("pt","BR");
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, localeBrasil);
		df.setLenient(false);
		return df.format(dataFormatoString);
	}
	public static Date formataData(String dataFormatoString) throws ParseException{
			SimpleDateFormat sdf = new SimpleDateFormat(PADRAO_DATA);
			sdf.setLenient(false);
			return sdf.parse(dataFormatoString);
	}
	public static String formataData(Date dataFormatoString) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(PADRAO_DATA);
		sdf.setLenient(false);
		return sdf.format(dataFormatoString);
	}

}
