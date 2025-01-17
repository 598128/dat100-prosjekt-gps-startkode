package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START
		
		for(int i=0; i<gpspoints.length;i++) {
			if(i+1<gpspoints.length) {
			distance=distance+GPSUtils.distance(gpspoints[i], gpspoints[i+1]);	
			}
			
		}
		
		
		return distance;
		// TODO - SLUTT

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO - START

		for(int i=0; i<gpspoints.length;i++){
			if(i-1<0) {
				elevation=gpspoints[i].getElevation();
			}
			else {
				if(gpspoints[i-1].getElevation()<gpspoints[i].getElevation()) {
				elevation=gpspoints[i].getElevation();	
				}
			}
			
			
			
		}
		return elevation;

		// TODO - SLUTT

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {

		int time;
		int start = gpspoints[0].getTime();
		int slutt = gpspoints[gpspoints.length-1].getTime();
		
		time= slutt-start;
		return time;

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		// TODO - START		// OPPGAVE - START
			double[] speeds;
			speeds= new double[gpspoints.length-1];
			
		for(int i=0; i<gpspoints.length;i++) {
			if(i+1<gpspoints.length) {	
			double speed=GPSUtils.speed(gpspoints[i], gpspoints[i+1]);	
			speeds[i]=speed;

			}
		}
			
		return speeds;
		// TODO - SLUTT

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO - START
		
		double[] speeds;
		speeds = speeds();
		
			maxspeed = speeds[0];
		
			for (double d : speeds) {
				if (d > maxspeed) {
					maxspeed = d;
				}
		}
		
		return maxspeed;
		
		// TODO - SLUTT
		
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO - START
		
		average=totalDistance()/totalTime()*3.6;

		return average;
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)   
		double met = 0;		
		double speedmph = speed * MS;

		// TODO - START
		
		if(speedmph<10) met=4;
		else if(10<speedmph&&speedmph<12) met=6;
		else if(12<speedmph&&speedmph<14) met=8;
		else if(14<speedmph&&speedmph<16) met=10;
		else if(16<speedmph&&speedmph<20) met=12;
		else if(20<speedmph) met=16;
		
		kcal= weight*secs/3600*met;
		
		
		
		return kcal;
		// TODO - SLUTT
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
				
		totalkcal= kcal(weight,totalTime(),averageSpeed());
		return totalkcal;
		// TODO - SLUTT
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START
		String kolon=":";
		System.out.println("Total Time"+kolon+GPSUtils.formatTime(totalTime()));
		System.out.println("Total Distance"+kolon+totalDistance()/1000+" km");
		System.out.println("Total Elevation"+kolon+totalElevation()+" m");
		System.out.println("Max speed"+kolon+maxSpeed()+" km/t");
		System.out.println("Average speed"+kolon+averageSpeed()+" km/t");
		System.out.println("Energy"+kolon+totalKcal(WEIGHT)+" kcal");
		
		// TODO - SLUTT
		
	}

}