/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.markw.simplemathwaterman;

import java.util.Scanner;
/*
import java .util.Scanner;
//final double
		Scanner keyedInput = new Scanner (System.in);
		//keyedInput.nextInt();
		//keyedInput.nextDouble();
		//keyedInput.nextLine();
		int num1 = keyedInput.nextInt();
	}
}
 */

public class SimpleMathWaterman {

	public static void main(String[] args) {
		Scanner keyedInput = new Scanner (System.in);
		System.out.println("cost");
		System.out.println("minimizer");
		System.out.println("       ac");
		System.out.println("----#======+");
		System.out.println("   #       |");
		System.out.println("  #bc      y");
		System.out.println(" #         |");
		System.out.println("#-----x----+");
		System.out.println("horizontal distance");
		System.out.print("x = ");
		double x = keyedInput.nextDouble();
		System.out.println("vertical distance");
		System.out.print("y = ");
		double y = keyedInput.nextDouble();
		System.out.println("cost for A");
		System.out.print("ac = ");
		double ac = keyedInput.nextDouble();
		System.out.println("cost for B");
		System.out.print("bc = ");
		double bc = keyedInput.nextDouble();
		double c = bc/ac;
		double r = y/x;
		//<editor-fold defaultstate="collapsed" desc="math">
		//solve output/(1 sqrt(output^2 + 0^2)) - (1 - output)/(c sqrt((1 - output)^2 + r^2)) =0 for output
		//sgn(output) + (output-1)/(c sqrt((output-1)^2 + r^2)) =0
		//sgn(output)*(c sqrt((output-1)^2 + r^2)) + (output-1) =0
		//(c sgn(output) sqrt(output^2 - 2 output + 1 + r^2))^2 = (1 - output)^2
		//c^2 sgn(output)^2 (output^2 - 2 output + r^2 + 1) = output^2 - 2 output + 1
		//c^2 output^2 - 2 c^2 output + c^2 r^2 + c^2 - output^2 + 2 output - 1 = 0
		//output^2*(c^2 - 1) + output*(2 - 2 c^2) + (c^2 r^2 + c^2 - 1) = 0
		//output = -(2 - 2 c^2) \pm sqrt ((2 - 2 c^2)^2-4(c^2 - 1)(c^2 r^2 + c^2 - 1))/2(c^2 - 1)
		//output = 1 \pm sqrt (4 - 8 c^2 + 4 c^4 -4 + 8 c^2 - 4 c^4 + 4 c^2 r^2 - 4 c^4 r^2)/2(c^2 - 1)
		//output = 1 \pm sqrt (4 c^2 r^2 - 4 c^4 r^2)/2(c^2 - 1)
		//output = 1 \pm 2 r c sqrt (1 - c^2 )/-2(1 - c^2)
		//output = 1 \mp r c /sqrt (1 - c^2 )
		//</editor-fold>
		double outputA = 1 - c*r/Math.sqrt(1 - c*c);
		double crossingA = Math.sqrt((1-outputA)*(1-outputA) + r*r);
		double outputB = 1 + c*r/Math.sqrt(1 - c*c);
		double crossingB = Math.sqrt((1-outputB)*(1-outputB) + r*r);
		double output;
		double crossing;
		if(outputA + crossingA < outputB + crossingB){
			output = outputA*x;
			crossing = crossingA*x;
		} else{
			output = outputB*x;
			crossing = crossingB*x;
		}
		//<editor-fold defaultstate="collapsed" desc="debug">
		/*if(false){
		System.out.println("----#==1===+");
		System.out.println("   #       |");
		System.out.println("  #c       r");
		System.out.println(" #         |");
		System.out.println("#-----1----+");
		System.out.println("x " + x);
		System.out.println("y " + y);
		System.out.println("ac " + ac);
		System.out.println("bc " + bc);
		System.out.println("c " + c);
		System.out.println("r " + r);
		System.out.println("oa " + oa);
		System.out.println("ob " + ob);
		System.out.println("output " + output);
		}*/
		//</editor-fold>
		System.out.println("      " + output);
		System.out.println("----#======+");
		System.out.println("   #       |");
		System.out.println("  #        |");
		System.out.println(" #         |");
		System.out.println("#----------+");
		System.out.println("optimal route is: ");
		System.out.println("go west " + output);
		System.out.println("then go to end (" + crossing + ")");
		System.out.println("for a cost of " + (output + crossing));
		System.out.println(keyedInput.next());
	}
}
