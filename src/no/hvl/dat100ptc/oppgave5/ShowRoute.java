package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		//showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		ystep = MAPYSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;
		

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		int xnew;
		int ynew;
		int xold;
		int yold;
		for(int i=0;i<gpspoints.length;i++) {
			xnew = (int)((gpspoints[i].getLatitude()-60)*2000);
			ynew = (int)((gpspoints[i].getLongitude()-5)*2000);
			if(i>0) {
				xold = (int)((gpspoints[i-1].getLatitude()-60)*2000);
				yold = (int)((gpspoints[i-1].getLongitude()-5)*2000);
			}
			else {
			xold = (int)((gpspoints[i].getLatitude()-60)*2000);
			yold = (int)((gpspoints[i].getLongitude()-5)*2000);	
			}
			
			drawLine(xold,yold,xnew,ynew);
			fillCircle(xnew,ynew,1);
			setColor(100, 100, 200);
		}
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		//int x = GPSComputer.totalTime();
		
		// TODO - SLUTT;
	}

}

