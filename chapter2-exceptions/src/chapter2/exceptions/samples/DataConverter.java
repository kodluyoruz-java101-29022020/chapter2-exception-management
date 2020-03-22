package chapter2.exceptions.samples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class DataConverter {

	private Random random = null;
	
	public int convertToInt() {
		
		Scanner scanner = new Scanner(System.in);
		
		// bu örnekte hatayı tespit ediyoruz ve oluştuğu noktada önlemler alıyoruz.
		try 
		{	
			String inputFromKeyboard = scanner.nextLine();
			
			int number = Integer.parseInt(inputFromKeyboard);
			
			return number;
			
		}
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			// bu kısımda mutlaka loglama yapmanız önerilir.
			// kurumsal projelerde hata takibi ve logların izlenmesi hataların çözümü için çok önemlidir.
		}
		catch (NullPointerException e) 
		{
			// farklı hata tiplerine göre birden fazla catch bloğu açabilirsiniz.
			e.printStackTrace();
			
			random = new Random();
			int randomInt = random.nextInt();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		// hata olsun veya olmasın mutlaka çalıştırılır.
		finally 
		{
			scanner.close();
		}
		
		return -1;
	}
	
	
	public Date convertToDate(String dateAsText) throws ParseException{
		
		// "2020-12-29"
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	
		// bu örnekte ise String haldeki date bilgisini Date verisine çevirmeye çalıştık.
		// parse fonksiyonu "ParseException" tipinde bir hata fırlattığı için biz de bu hatayı çağrıldığımız bir üste ilettik.
		return dateFormatter.parse(dateAsText);
	}
	
	public String proxyString(String value) throws BatuhanException {
		
		if(value == null) {
			throw new BatuhanException("Gelen değer null olamaz!");
		}
		
		return value;
	}
	
}
