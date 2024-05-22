import java.util.Scanner;

public class KeepSmallestN {

	public static void main(String[] args) {

		// Create a scanner object reading from System.in.
		Scanner sc = new Scanner(System.in);

		// Read the value of N (the number of smallest
		// items to keep).
		int N = sc.nextInt();

		// Create a min or max priority queue.  You'll need
		// to figure out which.

		HeapMaxPQ<Integer> minPQ = new HeapMaxPQ<>(N);

		// For each integer read from the input...

		while (sc.hasNextInt()) {
			int a = sc.nextInt();
			minPQ.insert(a);
			if (minPQ.size() > N) {
				minPQ.delMax();
			}
		}
		//    ...figure out how to use a priority queue to
		//    keep the nToKeep smallest ones.
		
		// Write out the final nToKeep smallest items
		// to System.out, one per line.

		while (!minPQ.isEmpty()) {
            System.out.println(minPQ.delMax());
        }
		sc.close();
	}
}
