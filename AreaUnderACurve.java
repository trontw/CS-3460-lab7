import java.util.Scanner;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-10;//1e-05; // This is the comparison error. See document for description.
		double d = 1.0;
		double c = 0.0;
		double p = 0.0;
		double m = 0.0;
		double n = 0.0;
		int s = 1000;
		// Insert first Interval into the Priority Queue
		PriorityQueue x = new PriorityQueue(s);
		x.insert(new Interval(a, b));
		c = (b - a)*f(b);
		System.out.println("error is = "+ error);
		while (d > 0) {
			// Next, remove max from the Priority Queue
			Interval max = x.remove_max();//take largest interval
			
			//double max_d = max.getLength();
			//System.out.println("Length of max is "+max_d);
			
			// Getting First Large interval values
			m = max.getStart();
			System.out.println("Start of max: "+m); 
			n = max.getEnd();
			System.out.println("End of max: "+n);
			//c = (n - m)*f(n);
			
			System.out.println("c =  "+c);
			// Next, break Large Interval in half 
			p = ((m + n)/2);
			System.out.println("Half of max, p = "+p);
			// Calculate the Area Under the Curve
			d = c - (n - m)*f(n) + (p - m)*f(p) + (n - p)*f(n);
			//Reinsert the new halves back into the Priority Queue.
			if (Math.abs(d - c) <= error) {
				System.out.println("Finished");
				return c;
			} else {
				x.insert(new Interval(m, p));
				x.insert(new Interval(p, n));
				System.out.println("d = "+d);
				System.out.println("d - c = "+(Math.abs(d - c)));
				c = d;
				System.out.println("CUTTING IN HALF AGAIN");
			}
		}
		return c;
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
