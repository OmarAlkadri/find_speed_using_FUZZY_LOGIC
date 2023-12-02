package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class MetroProgrami {
	private FIS fis;
	private int donusAcisi;
	private int Mesafe;

		public MetroProgrami(int donusAcisi,int Mesafe) throws URISyntaxException {
			this.donusAcisi = donusAcisi;
			this.Mesafe = Mesafe;
			File dosya = new File(getClass().getResource("Model.fcl").toURI());
			fis = FIS.load(dosya.getPath(),true);
			fis.setVariable("donusAcisi", donusAcisi);
			fis.setVariable("mesafe", Mesafe);
			fis.evaluate();
		}
		public MetroProgrami() throws URISyntaxException {
			File dosya = new File(getClass().getResource("Model.fcl").toURI());
			fis = FIS.load(dosya.getPath(),true);
		}
		public FIS getModel() {
			return fis;
		}
		
		@Override
		public String toString() {
		String ciktiString = "metronun hizi : "+(int)fis.getVariable("hiz").getValue() + " (KM)";
		return ciktiString;	
		}
}
