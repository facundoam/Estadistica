import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class principal {

    public static void main(String[] args) {


        List<Comparable<?>> modeList = new ArrayList<Comparable<?>>();
        // Get a DescriptiveStatistics instance
        DescriptiveStatistics stats = new DescriptiveStatistics();

        double inputArray[] = {2,2,3,3,3,3,4,4,4,5,5,6,6};
        // Add the data from the array
        for( int i = 0; i < inputArray.length; i++) {
            stats.addValue(inputArray[i]);
        }

        // Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
        double variance = stats.getVariance();
        double skew = stats.getSkewness();
        double kat = stats.getKurtosis();
        double S = Math.sqrt(stats.getVariance());
        double cv = (S/mean)*100;
        System.out.println("ŕ: "+mean);
        System.out.println("ei: "+std);
        System.out.println("Me: "+median);
        System.out.println("S: "+ S);
        System.out.println("S^2: "+variance);
        System.out.println("Cv: "+ cv);
        System.out.println("As: "+skew);
        System.out.println("Ku: "+kat);

    }

}
