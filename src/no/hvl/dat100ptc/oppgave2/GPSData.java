package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

    private GPSPoint[] gpspoints;
    protected int antall = 0;

    public GPSData(int n) {

        // TODO - START

        gpspoints = new GPSPoint[n]; //lager ny gpspoint med lengde n
        antall = 0;

        // TODO - SLUTT
    }

    public GPSPoint[] getGPSPoints() {
        return this.gpspoints;
    }

    protected boolean insertGPS(GPSPoint gpspoint) {

        boolean inserted = false;

        // TODO - START 

        int lengde = gpspoints.length;

        if(antall<lengde) { 
            gpspoints[antall]=gpspoint;
            inserted = true;
            antall++;
        }

        return inserted;

        // TODO - SLUTT
    }

    public boolean insert(String time, String latitude, String longitude, String elevation) {

        GPSPoint gpspoint;

        // TODO - START

        gpspoint = GPSDataConverter.convert(time,latitude,longitude,elevation);
        insertGPS(gpspoint);
        return true;

        // TODO - SLUTT

    }

    public void print() {

        System.out.println("====== Konvertert GPS Data - START ======");

        // TODO - START

        for(GPSPoint e : gpspoints) {
            System.out.println(e.toString());
        }

        // TODO - SLUTT

        // System.out.println("====== Konvertert GPS Data - SLUTT ======");

    }
}