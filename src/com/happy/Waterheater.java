package com.happy;

/**
 * Created by Happy on 3/17/2017.
 *
 */
import java.util.Date;

public class Waterheater extends ServiceCall {
    int waterHeaterAge;
    double cityFee = 20;
    public Waterheater(String serviceAddress, String problemDescription, Date date, int waterHeaterAge) {
        super(serviceAddress, problemDescription, date);
        this.waterHeaterAge = waterHeaterAge;
    }

    @Override
    public String toString() {
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Waterheater Service Call " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString + "\n" +
                "City Fee = $" + cityFee;


    }
}

