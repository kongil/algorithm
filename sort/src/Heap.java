import java.util.*;

public class Heap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getParentIndex(int childIndex) {
        return childIndex / 2 - 1;
    }
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) <= size;
    }
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) <= size;
    }
    private boolean hasParent(int index) {
        return index > 1;
    }
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    private int parent(int index) {
        return items[getParentIndex(index)];
    }
    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }
    public int peek() {
        if (size == capacity) throw new IllegalStateException();
        return items[0];
    }
    public int poll() {
        if (size == 0) throw new IllegalStateException();

        int item = items[0];

        items[0] = items[size - 1];

        size--;

        heapifyDown();

        return item;
    }
    private void heapifyDown() {
        int index = 1;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            swap(smallerChildIndex, index);
            index = smallerChildIndex;
        }
    }
    private void swap(int smallerChildIndex, int index) {
        int tmp = items[smallerChildIndex];
        items[smallerChildIndex] = items[index];
        items[index] = tmp;
    }
}
