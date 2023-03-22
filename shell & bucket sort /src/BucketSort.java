
public class BucketSort implements Sort{
private int noOfSwaps;
private int noOfBuckets, noOfComparison;

    public BucketSort() {
        noOfSwaps = 0;
        noOfBuckets=0;
        noOfComparison = 0;
    }

    public int getNoOfSwaps() {
        return noOfSwaps;
    }
    
    public int getNoOfComparison() {
        return noOfComparison;
    }

    public void setNoOfSwaps(int noOfSwaps) {
        this.noOfSwaps = noOfSwaps;
    }
    
    public void setNoOfComparison(int noOfComparison) {
        this.noOfComparison = noOfComparison;
    }

    public int getNoOfBuckets() {
        return noOfBuckets;
    }
    
    

    @Override
    public int[] sort(int[] arr, int max) {
       int[] buck = new int[max + 1];
        int[] sortedArray = new int[arr.length];
        noOfBuckets = max+1;
        for (int i= 0; i <arr.length; i++)
            buck[arr[i]]++;
 
        int position = 0;
        for (int i = 0; i < buck.length; i++){
            for (int j = 0; j < buck[i]; j++){
                sortedArray[position++] = i;
               noOfSwaps++;
            }
            // noOfSwaps++;
        }
 
        return sortedArray;
    }

    @Override
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println("");
    }

 }