public class NeuralNetwork {

    //input layer
    Neuron n1;
    Neuron n2;
    Neuron n3;

    //output layer
    Neuron n4;
    Neuron n5;
    Neuron n6;


    public static void main(String[] args) {
        int[] imageOfZero = {1,1,1,1, 1,0,0,1, 1,0,0,1, 1,0,0,1, 1,1,1,1};
        int[] imageOfOne = {0,0,1,0, 0,0,1,0, 0,0,1,0, 0,0,1,0, 0,0,1,0};
        int[] imageOfTwo = {1,1,1,1, 0,0,0,1, 1,1,1,1, 1,0,0,0, 1,1,1,1};
        int[] imageOfThree = {0,1,1,1, 0,0,0,1, 0,0,1,1, 0,0,0,1, 0,1,1,1};
        int[] imageOfFour = {1,0,1,0, 1,0,1,0, 1,1,1,0, 0,0,1,0, 0,0,1,0};
        int[] imageOfFive = {1,1,1,1, 1,0,0,0, 1,1,1,1, 0,0,0,1, 1,1,1,1};

        NeuralNetwork network = new NeuralNetwork();

        int result = network.classify(imageOfZero);
        System.out.println("passed the image of Zero, predicted: " + result);

        result = network.classify(imageOfOne);
        System.out.println("passed the image of One, predicted: " + result);

        result = network.classify(imageOfTwo);
        System.out.println("passed the image of Two, predicted: " + result);

        result = network.classify(imageOfThree);
        System.out.println("passed the image of Three, predicted: " + result);

        result = network.classify(imageOfFour);
        System.out.println("passed the image of Four, predicted: " + result);

        result = network.classify(imageOfFive);
        System.out.println("passed the image of Five, predicted: " + result);
    }

    

    public NeuralNetwork() {
        int imageSize = 20; //for a 4X5 image
        double threshold = 0.0;
        n1 = new Neuron(imageSize, threshold);
        n2 = new Neuron(imageSize, threshold);
        n3 = new Neuron(imageSize, threshold);

        n4 = new Neuron(3, threshold);
        n5 = new Neuron(3, threshold);
        n6 = new Neuron(3, threshold);
    }

    public int classify(int[] input) {
        int n1Result = n1.produceOutput(input);
        int n2Result = n2.produceOutput(input);
        int n3Result = n3.produceOutput(input);

        int[] hiddenLayerResults = {n1Result, n2Result, n3Result};

        int n4Result = n4.produceOutput(hiddenLayerResults);
        int n5Result = n5.produceOutput(hiddenLayerResults);
        int n6Result = n6.produceOutput(hiddenLayerResults);


        if (n4Result == 0 && n5Result == 0 && n6Result == 0)
            return 0;
        else if (n4Result == 1 && n5Result == 0 && n6Result == 0)
            return 1;
        else if (n4Result == 1 && n5Result == 1 && n6Result == 0)
            return 2;        
        else if (n4Result == 1 && n5Result == 1 && n6Result == 1)
            return 3;
        else if (n4Result == 0 && n5Result == 1 && n6Result == 1)
            return 4;
        else //if (n4Result == 0 && n5Result == 0 && n6Result == 1)
            return 5;           
    }   
}