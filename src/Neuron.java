import java.util.Random;

public class Neuron {

    int numWeights;
    double[] weights;
    double threshold; 

    public Neuron(int numWeights, double threshold) {
        this.numWeights = numWeights;
        this.threshold = threshold;
        weights = new double[this.numWeights];

        Random rand = new Random();
        for (int i = 0; i < weights.length; i++) {
            weights[i] = rand.nextDouble();
            if (rand.nextBoolean()) {
                weights[i] *= -1;
            }
        }
    }
    public int produceOutput(int[] input) {
        double total = 0;

        for (int i = 0; i < input.length; i++) {
            total += input[i] * weights[i];
        }

        if (total > threshold)
            return 1;
        else
            return 0;
    }
}