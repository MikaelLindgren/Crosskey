package mortgage;
import java.io.*;
import java.io.File;
import java.io.FileReader;

public class Crosskey {
	public static void main(String[] args) {
		File file = new File("./prospects.txt");
		FileReader fr;
		BufferedReader br;
		double total;
		double years;
		double interest;
		String name;
		double E; // Fixed monthly payment			I write these 
		double b; // Interest on a monthly basis
		double U; // Total loan
		double p; // Number of payments
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			try {				
				String s;
				boolean first = true;
				int count = 1;
				while ((s= br.readLine()) != null) {
					if(first) {
						first = false;
						continue;
					}
					if(s.length() == 0) {
						break;
					}
					Entry entry = lineReader(s);
					total = entry.getTotalLoan();
					years = entry.getPeriodYears();
					interest = entry.getInterestRate();
					b = interest/12;
					p = years*12;
					U = total;
					name = entry.getName();
					E = U*b*getPower((1+b),p)/(getPower((1+b),p)-1);
					System.out.print("Prospect "+ Integer.toString(count) + ": "+ name +  " wants to borrow " + Double.toString(U));
					System.out.print(" € for a period of " + Double.toString(years) + " years and pay " + Double.toString(E));
					System.out.println(" € each month");
					count++;
				}
			}
			catch(IOException e) {
				System.out.println("IOException");
			}
		}			
		catch(FileNotFoundException e) {
            System.out.println("File not Found Exception");
		}
	}
	public static Entry lineReader(String s) {
		String name;
		double totalLoan;
		double interestRate;
		double periodYears;
		int length = s.length();
		int partition = 0;
		String[] strA = new String[4];
		for(int i = 0; i<4;i++) {
			strA[i] = "";
		}
		for(int i = 0; i < length-1; i++) {
			char c = s.charAt(i);
			char d = s.charAt(i+1);
			//System.out.println(!(Character.toString(c).equals(",") && Character.isDigit(d)));
			if (!(Character.toString(c).equals(",")  && Character.isDigit(d))) {
				strA[partition] = strA[partition] + c;					
			}
			else {
				partition++;
			}
			if (i == length-2) {
				strA[partition] = strA[partition] + d;
			}			
		}
		name = strA[0];
		totalLoan = Double.parseDouble(strA[1]);
		interestRate = Double.parseDouble(strA[2]);
		interestRate = interestRate/100;
		periodYears = Double.parseDouble(strA[3]);
		Entry entry = new Entry(name, totalLoan, interestRate, periodYears);
		return entry;		
	}
	public static double getPower(double base, double exponent) {
		double result = base;
		while(exponent > 1) {
			result = result*base;
			exponent--;
		}	
		return result;
	}

}
