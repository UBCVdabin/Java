package Lab.CPSC_112;

// Programming Exercises 4.6
public class Wk4Lab_Dabin_Im_10122964 {
    // Constant
    public static final double DEGREE_OF_TRIANGLE = 180.0;
    public static final double EPSILON = 0.000001;
    public static final int RADIUS = 40;
    public static final int DECIMAL_PLACE = 2;

    // Common Functions
    //#region 
    public static int RandInt(int lowerLimit, int upperLimit, boolean inclusiveLowerLimit, boolean inclusiveUpperLimit) {
        int range;

        if (inclusiveLowerLimit == false) {
            lowerLimit += 1;
        }
        if (inclusiveUpperLimit == false) {
            upperLimit -= 1;
        }

        range = upperLimit - lowerLimit + 1;

        if (range <= 0) {
            return -1;
        }
        else {
            return (int)(Math.random() * range) + lowerLimit;
        }
    }

    public static double MyRound(double value, int digits) {
        return Math.round(value * Math.pow(10, digits)) / Math.pow(10, digits);
    }

    public static boolean DblEquals(double x, double y, double eps) {
        boolean result = false;
        
        double gap = x - y;
        gap = Math.abs(gap);

        if (gap < eps)
            result = true;
        
        return result; 
    }
    //#endregion
    
    public static boolean IsTriangle(double[] arrX, double[] arrY, double[] arrAngle) {
        // 1. Make lines
        double a = Math.sqrt(Math.pow(arrX[1] - arrX[2], 2) + Math.pow(arrY[1] - arrY[2], 2));
        double b = Math.sqrt(Math.pow(arrX[0] - arrX[2], 2) + Math.pow(arrY[0] - arrY[2], 2));
        double c = Math.sqrt(Math.pow(arrX[0] - arrX[1], 2) + Math.pow(arrY[0] - arrY[1], 2));

        // 2. Find Angles (The Law of Cosines)
        arrAngle[0] = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        arrAngle[1] = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        arrAngle[2] = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));

        /** 3. Check  
         *  - Angle A + Angle B + Angle C == 180
         *  - However, These are double type values so we need to use epsilon method.
        */
        if (arrAngle[0] > 0 && arrAngle[1] > 0 && arrAngle[2] > 0 && 
            DblEquals(arrAngle[0] + arrAngle[1] + arrAngle[2], DEGREE_OF_TRIANGLE, EPSILON)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void GeneratePoint(double[] arrX, double[] arrY) {
        int count = 0;

        while (count < 3) {
            double x, y;
            /** 1. x^2 + y^2 = r^2
             * -----------------------
             * Range x: -40 <= x <= 40
             * Range y: -40 <= y <= 40
             * -----------------------
            */
            x = RandInt((RADIUS * -1), RADIUS, true, true); 
            y = RandInt((RADIUS * -1), RADIUS, true, true);

            if (DblEquals(Math.pow(x, 2) + Math.pow(y, 2), Math.pow(RADIUS, 2), EPSILON)) {
                arrX[count] = x;
                arrY[count++] = y;
            }
        }
    }

    public static void GeneratePointUsingDegree(double[] arrX, double[] arrY) {
        double radian;
        /** 
         * 1. Generate Degree 
              Circle degree 360 = 0
              0 <= x < 360
        */
        for (int i = 0; i < 3; i++) {
            radian = Math.toRadians(RandInt(0, 360, true, false));
            arrX[i] = RADIUS * Math.cos(radian);
            arrY[i] = RADIUS * Math.sin(radian);
        }
    }

    public static void PrintResult(double[] arrX, double[] arrY, double[] arrAngle) {
        System.out.println("Three random points on a circle centered at (0, 0) with radius 40");

        for (int i = 0; i < 3; i++) {
            System.out.println("x" + (i+1) + ", " + "y" + (i+1) + ": " + 
                                MyRound(arrX[i], DECIMAL_PLACE) + ", " + 
                                MyRound(arrY[i], DECIMAL_PLACE));
        }
   
        System.out.println("Three angles (p, q, r) in a triangle formed by these three points is " 
                            + MyRound(arrAngle[0], DECIMAL_PLACE) + " " 
                            + MyRound(arrAngle[1], DECIMAL_PLACE) + " "
                            + MyRound(arrAngle[2], DECIMAL_PLACE));
        
        System.out.println();
    } 
    public static void Method_1(double[] arrX, double[] arrY, double[] arrAngle) {
        // 1.1 Generate Each Point
        // 1.2 Check whether this point is on the circle or not by using a^2 + b^2 = r^2
        // 1.3 If so, store them.
        GeneratePoint(arrX, arrY);

        // 2. Check whether triangle is or not and store each angle.
        while (!IsTriangle(arrX, arrY, arrAngle)) {
            GeneratePoint(arrX, arrY);
        }

        // 3. Print All.
        PrintResult(arrX, arrY, arrAngle);
    }
    
    public static void Method_2(double[] arrX, double[] arrY, double[] arrAngle) {
        // 1.1 Generate Circle degree
        // 1.2 Convert Degree to Radians
        // 1.3 Find each point (x, y)
        GeneratePointUsingDegree(arrX, arrY);

        // 2. Check whether triangle is or not and store each angle.
        while (!IsTriangle(arrX, arrY, arrAngle)) {
            GeneratePointUsingDegree(arrX, arrY);
        }

        // 3. Print All.
        PrintResult(arrX, arrY, arrAngle);        
    }
    public static void main(String[] args) {
        double [] arrX = new double[3];
        double [] arrY = new double[3];
        double [] arrAngle = new double[3];

        // using random point (-40 <= x <= 40 and -40 <= y <= 40)
        Method_1(arrX, arrY, arrAngle);

        // using random degree of circle (0 <= x < 360)
        Method_2(arrX, arrY, arrAngle);
    }
}
