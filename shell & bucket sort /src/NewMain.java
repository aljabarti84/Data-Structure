
import java.util.Random;

public class NewMain {

    static int[] unsortedArray1Rand;
    static int[] unsortedArray2Rand;
    static int[] unsortedArray3Rand;
    static int[] unsortedArray1Part;
    static int[] unsortedArray2Part;
    static int[] unsortedArray3Part;
    static int noOfSwapsShell[];
    static int noOfCompShell[];
    static int noOfSwapsBucket[];
    static int noOfCompBucket[];
    static int sortedArray1ShellRand[];
    static int sortedArray2ShellRand[];
    static int sortedArray3ShellRand[];
    static int unSortedArray1RandCopy[];

    public static void main(String[] args) {
        unsortedArray1Rand = new int[100];
        unsortedArray2Rand = new int[500];
        unsortedArray3Rand = new int[1000];
        unsortedArray1Part = new int[100];
        unsortedArray2Part = new int[500];
        unsortedArray3Part = new int[1000];
        noOfSwapsShell = new int[3];
        noOfCompShell = new int [3];
        noOfSwapsBucket = new int[3];
        noOfCompBucket = new int [3];
        unSortedArray1RandCopy = new int[100];
        populateArrays();
        
        ShellSort shellSort = new ShellSort();
        BucketSort bucketSort = new BucketSort();
        sortedArray1ShellRand = shellSort.sort(unsortedArray1Rand, unsortedArray1Rand.length);
        noOfSwapsShell[0] = shellSort.getNoOfSwaps();
        shellSort.setNoOfSwaps(0);
        noOfCompShell[0] = shellSort.getNoOfComparison();
        shellSort.setNoOfComparison(0);
        sortedArray2ShellRand = shellSort.sort(unsortedArray2Rand, unsortedArray2Rand.length);
        noOfSwapsShell[1] = shellSort.getNoOfSwaps();
        shellSort.setNoOfSwaps(0);
        noOfCompShell[1] = shellSort.getNoOfComparison();
        shellSort.setNoOfComparison(0);
        sortedArray3ShellRand = shellSort.sort(unsortedArray3Rand, unsortedArray3Rand.length);
        noOfSwapsShell[2] = shellSort.getNoOfSwaps();
        shellSort.setNoOfSwaps(0);
        noOfCompShell[2] = shellSort.getNoOfComparison();
        shellSort.setNoOfComparison(0);
        System.out.println("Sorting of all random arrays done by Algo 1(Shell Sort)....");
        int sortedArray1BucketRand[] = bucketSort.sort(unsortedArray1Rand, maxValue(unsortedArray1Rand));
        noOfSwapsBucket[0] = bucketSort.getNoOfSwaps();
        bucketSort.setNoOfSwaps(0);
        int sortedArray2BucketRand[] = bucketSort.sort(unsortedArray2Rand, maxValue(unsortedArray2Rand));
        noOfSwapsBucket[1] = bucketSort.getNoOfSwaps();
        bucketSort.setNoOfSwaps(0);
        int sortedArray3BucketRand[] = bucketSort.sort(unsortedArray3Rand, maxValue(unsortedArray3Rand));
        noOfSwapsBucket[2] = bucketSort.getNoOfSwaps();
        bucketSort.setNoOfSwaps(0);
        System.out.println("Sorting of all random arrays done by Algo 2(Bucket Sort)....");
        //=========================================
        populatePartiallySorted();
        System.out.println("Partially Sorted Array Created/Populated");
        //==========================================
        System.out.println("");
        System.out.println("\t\t\t***********************************************");
        System.out.println("\t\t\t****Printing Statistics(Completly Random)******");
        System.out.println("\t\t\t***********************************************");
        System.out.println("\t\t\t++++++++++++++++Shell Sort++++++++++++++");
        System.out.println("Array 1:\n\tSize: " + unsortedArray1Rand.length + "\tNo of Swaps:" + noOfSwapsShell[0] + "\t No of comparison:"+ noOfCompShell [0]);
        System.out.println("Array 2:\n\tSize: " + unsortedArray2Rand.length + "\tNo of Swaps:" + noOfSwapsShell[1] + "\t No of comparison:"+ noOfCompShell [1]);
        System.out.println("Array 3:\n\tSize: " + unsortedArray3Rand.length + "\tNo of Swaps:" + noOfSwapsShell[2] + "\t No of comparison:"+ noOfCompShell [2]);
        System.out.println("\t\t\t+++++++++++++++Bucket Sort+++++++++++++++");
        System.out.println("Array 1:\n\tSize: " + unsortedArray1Rand.length + "\tNo of Buckets:" + noOfSwapsBucket[0]);
        System.out.println("Array 2:\n\tSize: " + unsortedArray2Rand.length + "\tNo of Buckets:" + noOfSwapsBucket[1]);
        System.out.println("Array 3:\n\tSize: " + unsortedArray3Rand.length + "\tNo of Buckets:" + noOfSwapsBucket[2]);
        //================================================================================
        shellSort.sort(unsortedArray1Part, unsortedArray1Part.length);
        noOfSwapsShell[0] = shellSort.getNoOfSwaps();
        shellSort.setNoOfSwaps(0);
        shellSort.sort(unsortedArray2Part, unsortedArray2Part.length);
        noOfSwapsShell[1] = shellSort.getNoOfSwaps();
        shellSort.setNoOfSwaps(0);
        shellSort.sort(unsortedArray3Part, unsortedArray3Part.length);
        noOfSwapsShell[2] = shellSort.getNoOfSwaps();
        shellSort.setNoOfSwaps(0);
        populatePartiallySorted();
        //shellSort.printArray(unsortedArray1Part);
        bucketSort.sort(unsortedArray1Part, maxValue(unsortedArray1Part));
        noOfSwapsBucket[0] = bucketSort.getNoOfBuckets();
        bucketSort.setNoOfSwaps(0);
        bucketSort.sort(unsortedArray2Part, maxValue(unsortedArray2Part));
        noOfSwapsBucket[1] = bucketSort.getNoOfBuckets();
        bucketSort.setNoOfSwaps(0);
        bucketSort.sort(unsortedArray3Part, maxValue(unsortedArray3Part));
        noOfSwapsBucket[2] = bucketSort.getNoOfBuckets();
        bucketSort.setNoOfSwaps(0);
//=================================================================================
        System.out.println("\t\t\t***********************************************");
        System.out.println("\t\t\t******Printing Statistics(partially Sorted)****");
        System.out.println("\t\t\t***********************************************");
        System.out.println("\t\t\t++++++++++++++++Shell Sort++++++++++++++");
        System.out.println("Array 1:\n\tSize: " + unsortedArray1Rand.length + "\tNo of Swaps:" + noOfSwapsShell[0]+ "\t No of comparison:"+ noOfCompShell [0]);
        System.out.println("Array 2:\n\tSize: " + unsortedArray2Rand.length + "\tNo of Swaps:" + noOfSwapsShell[1]);
        System.out.println("Array 3:\n\tSize: " + unsortedArray3Rand.length + "\tNo of Swaps:" + noOfSwapsShell[2]);
        System.out.println("\t\t\t+++++++++++++++Bucket Sort+++++++++++++++");
        System.out.println("Array 1:\n\tSize: " + unsortedArray1Rand.length + "\tNo of Buckets:" + noOfSwapsBucket[0]);
        System.out.println("Array 2:\n\tSize: " + unsortedArray2Rand.length + "\tNo of Buckets:" + noOfSwapsBucket[1]);
        System.out.println("Array 3:\n\tSize: " + unsortedArray3Rand.length + "\tNo of Buckets:" + noOfSwapsBucket[2]);
        //System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
        System.out.println("\t\t\t****************************************");
        System.out.println("\t\t\t******Printing Array Matrix UnSorted****");
        System.out.println("\t\t\t****************************************");
        arrayToMatrix(unSortedArray1RandCopy);
        System.out.println("\t\t\t****************************************");
        System.out.println("\t\t\t******Printing Array Matrix Sorted****");
        System.out.println("\t\t\t****************************************");
        arrayToMatrix(sortedArray1ShellRand);
    
    }

    public static void populateArrays() {
        Random rand = new Random();
        for (int i = 0; i < unsortedArray1Rand.length; i++) {
            unsortedArray1Rand[i] = rand.nextInt(999);
            unSortedArray1RandCopy[i] = unsortedArray1Rand[i];
        }
        
        System.out.println("Random Array of " + unsortedArray1Rand.length + " is ready.");
        for (int i = 0; i < unsortedArray2Rand.length; i++) {
            unsortedArray2Rand[i] = rand.nextInt(999);
        }
        System.out.println("Random Array of " + unsortedArray2Rand.length + " is ready.");
        for (int i = 0; i < unsortedArray3Rand.length; i++) {
            unsortedArray3Rand[i] = rand.nextInt(999);
        }
        System.out.println("Random Array of " + unsortedArray3Rand.length + " is ready.");
    }

    static int maxValue(int[] arr) {
        int max_value = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max_value) {
                max_value = arr[i];
            }
        }
        return max_value;
    }

    public static void populatePartiallySorted() {
        int temp = Integer.MIN_VALUE;
        unsortedArray1Part = sortedArray1ShellRand;
        temp = unsortedArray1Part[19];
        unsortedArray1Part[19] = unsortedArray1Part[20];
        unsortedArray1Part[20] = temp;
        //====================================================
        temp = Integer.MIN_VALUE;
        unsortedArray2Part = sortedArray2ShellRand;
        temp = sortedArray2ShellRand[19];
        sortedArray2ShellRand[19] = sortedArray2ShellRand[20];
        sortedArray2ShellRand[20] = temp;
        //====================================================
        temp = Integer.MIN_VALUE;
        unsortedArray3Part = sortedArray3ShellRand;
        temp = sortedArray3ShellRand[19];
        sortedArray3ShellRand[19] = sortedArray3ShellRand[20];
        sortedArray3ShellRand[20] = temp;
    }
public static void arrayToMatrix(int arr[]){
    int x=0;
    for (int i = 0; i < 10; i++) {
        for (int j=0; j < 10; j++) {
            System.out.print(arr[x++]+"\t");
        }
        System.out.println("");
    }

}
}
