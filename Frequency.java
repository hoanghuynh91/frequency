import java.util.*;

public class Frequency {

    private static class Element implements Comparable<Element> {

        public int value;
        public int position;

        public Element(int value, int position) {
            this.value = value;
            this.position = position;
        }

        public int compareTo(Element other) {
            return Integer.compare(value, other.value);
        }
    }

    /**
     * Step 1: Creating an array of Element 'e' of the same size as 'a' 
     * Step 2: Initializing elements of 'e' with value and position 
     * Example: 
     *          given array = {3, 1, 4, 1, 4, 4} 
     *          e = {(3, 0), (1, 1), (4, 2), (1, 3), (4, 4), (4, 5)}
     * Step 3: Sorting the array 'e' on the basis of the value of Element
     *          e = {(1, 1), (1, 3), (3, 0), (4, 2), (4, 4), (4, 5)}
     * Step 4: Counting the frequencies of each value and updating the array f:
     *          => We will run a loop form 0 to l-1
     *          => We will use a counter to count the frequencies of each value
     *          => We will increment the counter by 1 if the value of next element is equal to the current, else we set the frequencies at all indices for that value to count and reset the count to 0 again
     *          => Continue the loop
     * 
     * Here: 
     * i=0 : j=0, count = 1,  and f = {0, 0, 0, 0, 0, 0}
     * i=1 : j=0, count = 2,  and f = {0, 2, 0, 2, 0, 0}
     * i=2 : j=2, count = 1,  and f = {1, 2, 0, 2, 0, 0}
     * i=3 : j=3, count = 1,  and f = {1, 2, 0, 2, 0, 0}
     * i=4 : j=3, count = 2,  and f = {1, 2, 0, 2, 0, 0}
     * i=5 : j=6, count = 3,  and f = {1, 2, 3, 2, 3, 3}
     * 
     * 
     *
     * return f.
     *
     */
    public static int[] frequencyOfElements(int[] a) {
        int l = a.length;
        Element e[] = new Element[l];
        int f[] = new int[l];

        for (int i = 0; i < l; i++) {
            e[i] = new Element(a[i], i);
        }
        Arrays.sort(e);

        int count = 0;
        for (int i = 0, j = 0; i < l; i++) {
            count++;
            if (l==1 || (i == l - 1 && f[l-2] != 0)) {
                f[l - 1] = 1;
            }
            else if ((i==l-1 && f[l-2]==0) || e[i].compareTo(e[i + 1]) != 0) {
                for (; j <= i; j++) {
                    f[e[j].position] = count;
                }
                count = 0;
            }
        }
        System.out.println(Arrays.toString(f));
        return f;
    }
    public static void main(String s[])
	 {
	  frequencyOfElements(new int[] {3,1,4,1,4,4}); 
	 }
}
