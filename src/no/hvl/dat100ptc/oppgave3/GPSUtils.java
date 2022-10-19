package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

			min = da[0];
		
			for (double d : da) {
				if (d < min) {
					min = d;
				}
			}
		
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];

		
		for (int i = 0; i<gpspoints.length; i++) {
            latitudes[i] = gpspoints[i].getLatitude();
        }

        return latitudes;
		
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

double[] longitudes = new double[gpspoints.length];

		
		for (int i = 0; i<gpspoints.length; i++) {
            longitudes[i] = gpspoints[i].getLongitude();
        }

        return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1=gpspoint1.getLatitude();
		latitude2=gpspoint2.getLatitude();
		longitude1=gpspoint1.getLongitude();
		longitude2=gpspoint2.getLongitude();
		
		
		double p1= toRadians(latitude1);
		double p2= toRadians(latitude2);
		double deltap=toRadians(latitude2-latitude1);
		double deltal=toRadians(longitude2-longitude1);
		double a=pow(sin(deltap/2),2)+cos(p1)*cos(p2)*pow(sin(deltal/2),2);
		double c=2*atan2(sqrt(a),sqrt(1-a));
		d=6371000*c;

		return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		double deltasecs= gpspoint2.getTime()-gpspoint1.getTime();
		double distance=distance(gpspoint1,gpspoint2);
		
		speed=(distance/deltasecs)*3.6;
		
		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int hours = secs/3600;
		int mins = (secs%3600)/60;
		int ss = secs-hours*3600-mins*60;
		
		timestr=String.format("%02d",hours)+TIMESEP+String.format("%02d",mins)+TIMESEP+String.format("%02d",ss);
		
		return timestr;
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		
		str=String.format(Locale.US,"%10.2f",d);
		return str;
		// TODO - SLUTT
		
	}
}

