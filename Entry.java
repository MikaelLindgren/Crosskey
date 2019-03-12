package mortgage;

public class Entry {
	private String name;
	private double totalLoan;
	private double interestRate;
	private double periodYears;
	
	public Entry(String nm, double tl, double ir, double py) {
		this.name = nm;
		this.totalLoan = tl;
		this.interestRate = ir;
		this.periodYears = py;		
	}
	public String getName() {
		return name;
	}
	public double getTotalLoan() {
		return totalLoan;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public double getPeriodYears() {
		return periodYears;
	}
}
