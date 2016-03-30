import java.util.HashMap;

import flanagan.analysis.Stat;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class principal {

    public static void main(String[] args) {

        int inputArray[] = {2,2,3,3,3,3,4,4,4,5,5,6,6};

        // Get a DescriptiveStatistics instance
        DescriptiveStatistics stats = new DescriptiveStatistics();
        Stat st = new Stat(inputArray);
        st.setDenominatorToN();


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
        int mode = mode(inputArray);

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        System.out.println("Mo ( Moda ): "+mode);
        System.out.println("Me ( Mediana ) \"No usar para arrays impares\": "+median);
        System.out.println("ŕ ( Promedio ): "+mean);
        System.out.println("S² ( Varianza ): "+st.variance_as_double());
        System.out.println("S²(n-1) ( Cuasivariancia ): "+variance);
        System.out.println("S ( Desvio Estandar ): "+st.standardDeviation_as_double());
        System.out.println("S(n-1) ( Cuasidesvio Estandar ): "+std);
        System.out.printf("Cv ( Coeficiente de Variacion - Desvio ): %.2f%s\n",(st.standardDeviation_as_double()/mean)*100,"%");
        System.out.printf("Cv(n-1) ( Coeficiente de Variacion - Cuasidesvio ): %.2f%s\n",cv,"%");
        System.out.println("As ( Asimetria ): " + st.momentSkewness_as_double());
        System.out.println("Ku ( Kurtosis ): "+st.kurtosis_as_double());

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");


    }


    private static int mode(int[] array)
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int max=1;
        int temp=0;
        for(int i=0;i<array.length;i++)
        {
            if(hm.get(array[i])!=null)
            {
                int count=hm.get(array[i]);
                count=count+1;
                hm.put(array[i],count);
                if(count>max)
                {max=count;
                    temp=array[i];}
            }
            else
            {hm.put(array[i],1);}
        }
        return temp;
    }

}
