
public class ShellSort implements Sort{
   private int noOfSwaps, noOfComparison ;

    public ShellSort() {
    noOfSwaps = 0;
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
    
    @Override
    public int[] sort(int[] arr, int size) {
        for (int interval = size / 2; interval > 0; interval /= 2) {
        	
    for (int i = interval; i < size; i += 1) {

    int temp = arr[i];
    
    int j;
    
    for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
 	   noOfComparison++;
      arr[j] = arr[j - interval];
      
      noOfSwaps ++;
    }
    
    arr[j] = temp;
 
    }
  }
        return arr;
         

    }

    @Override
    public void printArray(int[] arr) {
    	
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", " );
        }
        System.out.println("");
       }
    

    

    
}
