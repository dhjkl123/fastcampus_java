package ch07;

import ch07.GenericPrinter;
import ch07.Powder;

public class GenericPrinterTest {

	public static void main(String[] args) {
		GenericPrinter<Powder> powderprinter = new GenericPrinter<>();
		Powder powder = new Powder();
		powderprinter.setMaterial(powder);
		
		Powder p = powderprinter.getMaterial();
		System.out.println(p);
		
		
	}

}
