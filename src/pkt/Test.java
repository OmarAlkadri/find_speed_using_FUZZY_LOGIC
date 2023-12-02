package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Test {

	public static void main(String[] args) {
		java.util.Scanner in = new Scanner(System.in);
		System.out.print("dönuş açısı (0-360):");
		int ky = in.nextInt();
		System.out.print("Mesafe (KM)(10-400):");
		int ct = in.nextInt();
		MetroProgrami cm = null;
		try {
			cm = new MetroProgrami(ky,ct);
			System.out.print(cm);
			cm.toString();
			JFuzzyChart.get().chart(cm.getModel());
			for (Rule r : cm.getModel().getFunctionBlock("Model").getFuzzyRuleBlock("kuralblok1").getRules()) {
			if(r.getDegreeOfSupport() > 0)
				System.out.print("\n"+r);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
