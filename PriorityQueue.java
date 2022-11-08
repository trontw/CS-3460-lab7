import java.lang.Math;


public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			// Expand the buffer allocated for the heap to 
			// another buffer that is twice as big. (from hw5)
			int new_size = 2 * size;//Double the table size;
			PriorityQueue x = new PriorityQueue(new_size);
			for (int i = 0; i < numElements; ++i){
				x.insert(heap[i]);
			}
		}
		// Insert without buffer expansion here.
		// First, place the new node at the end of the heap.
		//if (( k != null) && (k.getLength() > 0)){
		System.out.println("numElements = "+numElements);
		int num = numElements;
		heap[numElements] = k;
		numElements++;
		//siftUp((int) k.getLength());
		siftUp(num);
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
		
		return null; // Replace this statement with returning the max element (root) in the heap.
	}

	public int getParent(int k){
		return (k/2);
	}

	public int getLeftChild(int k){
			return (2*k);
	}

	public int getRightChild(int k){
		return (2*k + 1);
		
	}

	public void siftUp(int i){
		int p = getParent(i);
		/* [MAX HEAP]
		First, if there is no parent, and if parent is less than child
		If parent is smaller length than the child we will 
		sift-up the child, then check again, recursively until
		the child is greater length than the parent.
		 */ 
		System.out.println("Input i is "+i);
		System.out.println("Parent p is "+p);
		System.out.println("parent is "+heap[p]);
		System.out.println("child is "+heap[i]);
		System.out.println("------------------------------------------------------");
		// First node inserted, parent will be null and i = 0, 
		// so can't call compareTo, and don't siftUp (nothing to sift)
		if (heap[p] == null || heap[i] == null || heap[p].compareTo(heap[i]) >= 0) {
			System.out.println("WHAAAT");
			System.out.println("---------Q-after WHAAAAT-----------");
			print();
			return;
		// If parent < child, swap and continue sifting up.
	  	} else if (heap[i] != null && heap[p] != null && heap[p].compareTo(heap[i]) < 0) {
			System.out.println("COMPARING");
			Interval tmp = heap[p];//save parent node
			heap[p] = heap[i];//swap parent with the child
			heap[i] = tmp;//parent is now in the child node
			System.out.println("---------Q-after Comparing-----------");
			print();
			siftUp(p);
		} 
	}

	public void siftDown(int i){
		int p = getParent(i);
		int Rch = getRightChild(i);
		int Lch = getLeftChild(i);
		/*
		First find the larger priority child, then compare to parent.
		If parent priority is smaller than the child, we will sift-down
		the parent until the parent priority is smaller than the largest
		child.
		*/
		//Initially compare if Right child is greater than Left child
		if (heap[i] == null) return;
		if ((heap[Rch] != null || heap[Rch].compareTo(heap[Lch]) > 0)) {
			//If greater, then see if parent is greater than Right Child, if so, sift-down.
			if ((heap[p].compareTo(heap[Rch]) < 0)) {
				//i--;
				Interval tmp = heap[Rch];
				heap[Rch] = heap[p];
				heap[p] = tmp;
				siftDown(p);
			} else if ((heap[p].compareTo(heap[Rch])) > 0) {
				heap[p] = heap[Rch];
			}
		//Next, compare if Left child is greater than Left child
		} else if ((heap[Lch] != null && heap[Lch].compareTo(heap[Rch]) > 0)) {
			//If greater, then see if parent is greater than Left Child, if so, sift-down.
			if ((heap[p].compareTo(heap[Lch]) < 0)) {
				//i--;
				Interval tmp = heap[Lch];
				heap[Lch] = heap[p];
				heap[p] = tmp;
				siftDown(p);
			}
		} else if ((heap[p].compareTo(heap[Lch])) > 0) {
			heap[p] = heap[Lch];
		} else {
			System.out.println("Cannot have Right and Left children with same length! - error");
		}
	}

	public void swap(int i, int k){
		//code to swap parent with child
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
}
