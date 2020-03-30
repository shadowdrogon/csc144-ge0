
package searchandsort;
import java.util.ArrayList;
import java.util.List;
public class SearchAndSort {
    
    /**
     * This program will have 5 different features. It will show linear search, binary search, insertion sort, selection sort, and merge sort.
     * The main will test all of the searches and sorts. This project highlights different searches and sorts that are very useful algoritms in
     * all coding languages. I myself do not know python so i do not have the ability to highlight any key differences between these two languages,
     * but I am sure that understanding and knowing what these 5 searches and sorts are is necessary to be successful in learning and using any 
     * programming language. 
     * 
     * @author Rahul Rangarajan
     * @param args
    */
    public static void main( String [] args ) {
        System.out.println( "Searching and sorting algorithms" );
        //array a will be used for the search and sorts
        int counter = 0;
        List<Integer> a1 = new ArrayList<Integer>();
        int[] a = new int[20];
        System.out.print("The array that we will be working with today is : ");
        for(int i = 0; i < 20; i++) {
            a1.add((int)(Math.random()*100));
            System.out.print(a1.get(i)+ ", ");
        }
        for(int gg : a1){
            a[counter] = gg;
            counter++;
        }
        System.out.println();
        // the number I am looking for
        int n = (int) (Math.random() * 100);
        System.out.println( "The number you are looking for is " + n);
        //calling linear search method
        System.out.println();
        System.out.println("The index of the number you are looking for using linear search is " + linearsearch(a1, n));
        //using selection sort to sort array a
        List<Integer> b = selectionsort(a1, a1.size(), 0);
        System.out.println("Selection Sort");
        //check to see if array has been properly sorted
        for(int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i) + " , ");
        }
        //calling binary search using the sorted array b
        int r = b.size()-1;
        int l = 0;
        System.out.println();
        System.out.println("The index of the number you are looking for using binary search is " + binarysearch(b, n, l, r ));
        //calling insertion sort
        List<Integer> b1= Insertion(a1);
        //check to see if array has been properly sorted
        System.out.println("Insertion Sort");
        for(int i = 0; i < b1.size(); i++) {
            System.out.print(b1.get(i)+ ", ");
        } 
        //calling merge sort
        int[] b2 = sorter(a);
        //check to see if array has been properly sorted
        System.out.println("Merge Sort");
        for(int i = 0; i < b2.length; i++) {
            System.out.print(b2[i]+ ", ");
        }
    } // main( String [] )
    /**
     * This is linear search. This algorithm has a length of n. It systematically searches each
     * and every Integer until it finds the one it is looking for.
     * @param a List of Integers that will be searched through 
     * @param n The number that we are looking for
     * @return  The index of the number we are looking for. If the number
     *          does not exist, the method returns -1.
     */
    public static int linearsearch(List<Integer> a, int n) {
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) == n)
                return i;
        }
        return -1;
    }
    /**
     * This method shows the binary search. Having a speed of log n,it splits the 
     * list into half and checks either side splitting the List by two every time.
     * @param a The List being used in this method
     * @param n The number that we are searching for
     * @param l The left-most value in the part of the array we are searching in
     * @param r The right-most value in the part of the array we are searching in
     * @return the index of the value we are searching for. If the number does not
     * exist, the method returns -1.
     */
    public static int binarysearch(List<Integer> a, int n, int l , int r) {
        int m = (l+r)/2;
        if(a.get(l) == n)
             return l ;
        else if(a.get(r) == n)
             return r ;
        else if (a.get(m) == n)
            return m;
        if(l != r && l != m && r != m) {
            if(n< a.get(m))
                return binarysearch(a,n,l, m-1);
            else if(n > a.get(m) && m+1 != r)
                return binarysearch(a,n,m+1,r);
        }
        return -1;
    }
    public static int min(List<Integer> a, int i, int j) { 
        if (i == j) 
            return i; 
        int k = min(a, i + 1, j); 
        return (a.get(i) < a.get(k))? i : k; 
    } 
    /**
     * The Selection sort sorts a method by systematically checking every element
     * against every other element in the List. 
     * @param a The List being sorted
     * @param n size of the list being sorted
     * @param index The index that the method is currently on
     * @return returns a list that is sorted
     */
    public static List<Integer> selectionsort(List<Integer> a, int n, int index) {
	if (index == n) 
	    return a; 
	int k = min(a, index, n-1); 
	if (k != index){ 
            int temp = a.get(k); 
            a.set(k,a.get(index)); 
            a.set(index, temp);
        }
        return selectionsort(a, n, index + 1);  
    }
    /**
     * insertion sort sorts a list by inserting each value into a new List and comparing each value with only those in this new List 
     * @param array The list being sorted
     * @return  returns a sorted list
     */
    public static List<Integer> Insertion(List<Integer> array) {
	int t; 
	for(int i =1; i < array.size(); i++) {
            for(int k =i; k>0; k--) {
		if(array.get(k) < array.get(k-1)) {
                    t = array.get(k);
                    array.set(k, array.get(k-1));
                    array.set(k-1, t);
                }
            }
        }
        return array;
		
    }
    /**
     * Merge sort breaks apart a List into pairs and reorders these pairs. Then 
     * the sorter stitches the array back together sorting the pieces as it goes along
     * completing the sort in log n time. 
     * @param alist the array being sorted
     * @return  returns a sorted list
     */
      public static int[] sorter(int[]alist)
    {
        if(alist.length<2){
            return alist;
        }
        else {
            int middle = alist.length/2;
            int firsth = 0;
            int sech = 0;
            for (int i = 0; i<middle; i++){
                firsth+=alist[i];
            }
            for (int i = middle; i<alist.length; i++){
                sech+=alist[i];
            }

            if (firsth>=sech){
                int [] blist = new int[middle];
                for (int i = 0; i<middle; i++){
                    blist[i]=alist[i];
                }
                int [] clist = new int[alist.length-middle];
                for (int i = middle; i<alist.length; i++) {
                    clist[i-middle] = alist[i];
                }
                return merge(sorter(blist), sorter(clist));
            }
            else {
                int [] blist = new int[middle];
                for (int i = 0; i<middle; i++){
                    blist[i]=alist[i];
                }
                int [] clist = new int[alist.length-middle];
                for (int i = middle; i<alist.length; i++){
                    clist[i-middle] = alist[i];
                }
                return merge(sorter(clist), sorter(blist));
            }
        }
    }
    public static int[] merge(int[] flist, int[] slist) {
        int[] nlist = new int[flist.length+slist.length];
        for (int i = 0; i<flist.length; i++){
            nlist[i] = flist[i];
        }
        for (int i = flist.length; i<(flist.length+slist.length); i++){
            nlist[i] = slist[i-flist.length];
        }
        finalredo(nlist.length, nlist);
        return nlist;
    }
    public static void finalredo(int size, int a[]){
        int base;
        for (int i = 0; i<size; i++){
            for (int z = 0; z < (size - 1); z++) {
                base=0;
                if (a[z]>a[z + 1]) {
                    base=a[z];
                    a[z]=a[z + 1];
                    a[z+1]=base;
                }
            }
        }
    }
} // SearchAndSort
