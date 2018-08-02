package method;

public class CalculateRetentionInd {
    public static double calculateRetentionIndex (double measuredRetentionTime) {


        int alcaneBefore = 0;
        double previousRetentionTime = 0;
        double nextRetentionTime = 0;


        if (measuredRetentionTime < 1.85) {

        }
        else if (measuredRetentionTime < 2.71) {
            alcaneBefore = 8;
            previousRetentionTime = 1.85;
            nextRetentionTime = 2.71;
        }
        else if (measuredRetentionTime < 3.69) {
            alcaneBefore = 9;
            previousRetentionTime = 2.71;
            nextRetentionTime = 3.69;
        }
        else if (measuredRetentionTime < 4.59) {
            alcaneBefore = 10;
            previousRetentionTime = 3.69;
            nextRetentionTime = 4.59;
        }
        else if (measuredRetentionTime < 5.37) {
            alcaneBefore = 11;
            previousRetentionTime = 4.59;
            nextRetentionTime = 5.37;
        }
        else if (measuredRetentionTime < 6.19) {
            alcaneBefore = 12;
            previousRetentionTime = 5.37;
            nextRetentionTime = 6.19;
        }
        else if (measuredRetentionTime < 7.17) {
            alcaneBefore = 13;
            previousRetentionTime = 6.19;
            nextRetentionTime = 7.17;
        }
        else if (measuredRetentionTime < 8.40) {
            alcaneBefore = 14;
            previousRetentionTime = 7.17;
            nextRetentionTime = 8.40;
        }
        else if (measuredRetentionTime < 9.99) {
            alcaneBefore = 15;
            previousRetentionTime = 8.40;
            nextRetentionTime = 9.99;
        }

        double unknownRetentionTime = 100 * alcaneBefore + 100 * (measuredRetentionTime - previousRetentionTime) / (nextRetentionTime - previousRetentionTime);

        return unknownRetentionTime;


    }
}
