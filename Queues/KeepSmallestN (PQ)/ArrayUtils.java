
public class ArrayUtils {

	// NOTE: In preconditions, I use a shortcut syntax to refer to
	// everything in a half-open range of an array. The notation
	// a[lo,hi) refers to every element of array a in the range [lo,hi).
	// For example
	//
	// a[lo,hi) < 0
	//
	// is a shortcut for "every element a[i] with lo <= i < hi
	// is less than 0".

	// checkArguments() is used to check for preconditions; it checks to
	// make sure the array is not null.
	private static <T> boolean checkArguments(T[] a, boolean allowEmpty) {
		assert (a != null);
		assert (allowEmpty || a.length > 0);
		return true;
	}

	// checkArguments() is used to check for preconditions; it checks to
	// make sure the array is not null, and that 'lo' and 'hi' are within
	// the bounds of the array.
	private static <T> boolean checkArguments(T[] a, int lo, int hi, boolean allowEmpty) {
		assert (a != null);
		assert ((lo >= 0) && (lo <= a.length));
		assert ((hi >= 0) && (hi <= a.length));
		assert (allowEmpty || hi - lo > 0);
		return true;
	}

	// swap exchanges the values at indices idx1 and idx2
	// in array a.
	// Preconditions:
	// a != null
	// a.length > 0
	// 0 <= idx1 < a.length
	// 0 <= idx2 < a.length
	// Postconditions (let a' be the original array):
	// for i in [0, length)
	// if i not in {idx1,idx2} a[i] = a'[i]
	// a[idx1] = a'[idx2]
	// a[idx2] = a'[idx1]
	public static <T> void swap(T[] a, int idx1, int idx2) {
		assert (checkArguments(a, false));
		T t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// copy copies the subrange aFrom[lo,hi) to aTo[lo,hi). All
	// other elements of aTo are untouched. No elements of a
	// are modified.
	// Preconditions:
	// aFrom != null
	// 0 <= lo <= hi <= aFrom.length <= aTo.length
	// aTo != null
	// Postconditions (let aTo' and aFrom' be the original aTo and aFrom):
	// for i in [0,a.length) aFrom[i] == aFrom'[i]
	// for i in [0,lo) aTo[i] = aTo'[i]
	// for i in [lo,hi) aTo[i] = aFrom[i]
	// for i in [hi,aTo.length) aTo[i] = aTo'[i]
	public static <T> void copy(T[] aFrom, T[] aTo, int lo, int hi) {
		assert (checkArguments(aFrom, lo, hi, true));
		assert (checkArguments(aTo, lo, hi, true));
		for (int i = lo; i < hi; i++)
			aTo[i] = aFrom[i];
	}

	// copy copies the subrange aFrom[loFrom,hiFrom) to
	// aTo[aTo,aTo+(hiFrom-loFrom)). All other elements
	// of aTo are untouched. No elements of a are
	// modified.
	// Preconditions:
	// aFrom != null
	// 0 <= loFrom <= hiFrom <= aFrom.length
	// aTo != null
	// 0 <= loTo <= loTo+(hiFrom-loFrom) <= aTo.length
	// Postconditions (let aTo' and aFrom' be the original aTo and aFrom):
	// let hiTo = loTo + (hiFrom - loFrom)
	// for i in [0,a.length) aFrom[i] == aFrom'[i]
	// for i in [0,loTo) aTo[i] = aTo'[i]
	// for i in [loTo,hiTo) aTo[i] = aFrom[i]
	// for i in [hiTo,aTo.length) aTo[i] = aTo'[i]
	public static <T> void copy(T[] aFrom, int loFrom, int hiFrom, T[] aTo, int loTo) {
		assert (checkArguments(aFrom, loFrom, hiFrom, true));
		assert (checkArguments(aTo, loTo, loTo + (hiFrom - loFrom), true));
		for (int iFrom = loFrom, iTo = loTo; iFrom < hiFrom; iFrom++, iTo++) {
			aTo[iTo] = aFrom[iFrom];
		}
	}

	/**
	 * Moves <tt>aFrom[loFrom,hiFrom)</tt> to <tt>aTo[loTo,loTo+(hiFrom-hTo))</tt>.
	 * The elements in aFrom are set to null.
	 * 
	 * @param aFrom
	 *               the array to move from
	 * @param loFrom
	 *               the low index of the source range
	 * @param hiFrom
	 *               the high index of the source range
	 * @param aTo
	 *               the array to move to
	 * @param loTo
	 *               the low index of the target range
	 */
	public static <T> void move(T[] aFrom, int loFrom, int hiFrom, T[] aTo, int loTo) {

		// Check preconditions
		checkArguments(aFrom, loFrom, hiFrom, true);
		checkArguments(aTo, loTo, loTo + (hiFrom - loFrom), true);

		while (loFrom < hiFrom) {
			aTo[loTo++] = aFrom[loFrom];
			aFrom[loFrom++] = null;
		}
	}

	/**
	 * Moves <tt>aFrom[lo,hi)</tt> to <tt>aTo[lo,hi)</tt>. The elements in
	 * aFrom are set to null.
	 * 
	 * @param aFrom
	 *              the array to move from
	 * @param aTo
	 *              the array to move to
	 * @param lo
	 *              the start of the range to copy
	 * @param hi
	 *              the end of the range to copy
	 */
	public static <T> void move(T[] aFrom, T[] aTo, int lo, int hi) {

		// Check preconditions
		checkArguments(aFrom, lo, hi, true);
		checkArguments(aTo, lo, hi, true);

		move(aFrom, lo, hi, aTo, lo);
	}

}
