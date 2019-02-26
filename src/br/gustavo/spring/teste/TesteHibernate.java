package br.gustavo.spring.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TesteHibernate {

	public static void main(String[] args) {

		// Student student = new Student();
		//
		// student.setFirstName("Gustavo Martins");
		// student.setLastName("Marinelli");
		// student.setCountry("Brasil");
		//
		// Dao dao = new Dao();
		//
		// dao.salva(student);
		//
		// List<Student> students = dao.busca(Student.class);
		// students.forEach(s -> System.out.println(s.getFirstName()));

//		GregorianCalendar calendar = new GregorianCalendar(1997, 8, 15);
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		@SuppressWarnings("deprecation")
//		String calendarFormatado = format.format(new Date(1996-1900, 8-1, 15));
//		System.out.println("data = " + calendarFormatado);
//		
//		System.out.println(calendar.get(Calendar.YEAR));
//		System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
		String valor = "100,000.00";
		String[] split = valor.split(",", 2);
		
		String valorFormatado = "";
		for (int i = 0; i < split.length; i++) {
			 valorFormatado += split[i];
		}
		
		System.out.println(valorFormatado);
		System.out.println(Double.parseDouble(valorFormatado));
	}

}
