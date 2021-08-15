package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SampleClass {
    /**
     * sort the given array using merge sort
     *
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(left, mid);
        mergeSort(r, n - mid);
        merge(a, left, r, mid, n = mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int k = 0, i = 0, j = 0;
        while ((i < left) && (j < right)) {
            if (l[i] < r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    @Test
    public void shouldMerge() {
        int[] actualArray = {5, 1, 6, 2, 3, 4, 7};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        SampleClass.mergeSort(actualArray, actualArray.length);
        assertArrayEquals(expected, actualArray);
    }
}
