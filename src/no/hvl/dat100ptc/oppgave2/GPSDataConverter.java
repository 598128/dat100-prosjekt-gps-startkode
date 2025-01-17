package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

    // konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
    // dvs. ignorer information om dato og omregn tidspunkt til sekunder
    // Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 

    private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

    public static int toSeconds(String timestr) {

        int secs;
        int hr, min, sec;

        // TODO
        // OPPGAVE - START


        String hrstr=timestr.substring(11,13);
        String minstr=timestr.substring(14,16);
        String secstr=timestr.substring(17,19);

        hr=Integer.parseInt(hrstr);
        min=Integer.parseInt(minstr);
        sec=Integer.parseInt(secstr);

        secs=3600*hr+60*min+sec;

        return secs;
        // OPPGAVE - SLUTT

    }

    public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) 
    {

        GPSPoint gpspoint;

        // TODO - START ;
        int time = toSeconds(timeStr);
        double latitudeDouble = Double.parseDouble(latitudeStr);
        double longitudeDouble = Double.parseDouble(longitudeStr);
        double elevationDouble = Double.parseDouble(elevationStr);

        gpspoint= new GPSPoint(time,latitudeDouble,longitudeDouble,elevationDouble);

        return gpspoint;
        // OPPGAVE - SLUTT ;

    }

}