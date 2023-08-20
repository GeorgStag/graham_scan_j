import java.util.Arrays;
import java.util.Comparator;


public class grahamScan{

    public static double gramAngle(double[] point1, double[] point2, double[] point3) {
        double angleRadians = Math.atan2(point3[1] - point2[1], point3[0] - point2[0]) - Math.atan2(point1[1] - point2[1], point1[0] - point2[0]);
        double angleDegrees = Math.toDegrees(angleRadians);
        if (angleDegrees < 0) {
            angleDegrees += 360; 
        }
        return angleDegrees;
    }
    
    public static boolean hullCheck(double[][] points) {
        int last = 0;
        boolean output = false;
        int[] polygonEdges = new int[points.length];
        polygonEdges[0] = 0;
        polygonEdges[1] = 1;
        outerLoop: for (int iEdge = 1; iEdge < points.length-1; iEdge++) {
            double min = 361;
            for (int jEdge = 0; jEdge < points.length; jEdge++) {
                if ( jEdge ==  polygonEdges[iEdge-1] | jEdge ==  polygonEdges[iEdge] ){
                    continue;
                }
                double test = gramAngle( points[polygonEdges[iEdge-1]], points[polygonEdges[iEdge]], points[jEdge]);
                if (test <= min){
                    polygonEdges[iEdge+1] = jEdge;
                    min = test;
                }
            }
            last = iEdge+1;
            for (int checkEdge = 0; checkEdge < last; checkEdge++) {
                if( polygonEdges[checkEdge] == polygonEdges[last]){
                    break outerLoop;
                }
            }
        }
        if( last < points.length-1){
            output = true;
        }
        return output;
    }
	
    public static double[][] sample = new double[20][2];
	
    public void setSample(double[][] sample) {
        this.sample = Arrays.sort(sample, Comparator.comparingDouble(pair -> pair[1]));
    }

    public double[][] getSample() {
        return sample;
    }
	
    public boolean checkHull() {
        return hullCheck(sample);
    }

}
