package com.isoldier.sort;



/** 归并排序
 * @author jinmeng on 2018/9/22.
 * @version 1.0
 */
public class MergeSort {


    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        // 初始话左右两个序列
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r);
    }


    /**
     * 合并两个有序数组
     * @param a
     * @param l
     * @param r
     */
    public static void merge(int[] a, int[] l, int[] r) {

        int i = 0, j = 0, k = 0;
        int lLen = l.length;
        int rLen = r.length;
        while (i < lLen && j < rLen) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < lLen) {
            a[k++] = l[i++];
        }
        while (j < rLen) {
            a[k++] = r[j++];
        }
    }

}
