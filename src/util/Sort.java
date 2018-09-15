/**
 * 
 */
package util;

import java.util.Scanner;

/**
 * @author clever
 *
 */
public class Sort {
	public static void printArr(String[] strArr) {
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i]);
			if (i < strArr.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void exeSort(Scanner sc, String[] strArr) {
		System.out.println("Select you wan to sort algorithm No:");
		System.out.println("1:Selection");
		System.out.println("2:Bubble");
		System.out.println("3:InsertSort");
		System.out.println("4:ShellSort");
		System.out.println("5:QuickSort");
		System.out.println("6:HeapSort");
		System.out.println("7:MergeSort");

		int no = sc.nextInt();
		sc.nextLine();

		int length = strArr.length;
		switch (no) {
		case 1:
			selectionSort(strArr);
			break;
		case 2:
			bubbleSort(strArr);
			break;
		case 3:
			insertSort(strArr, 1);
			break;
		case 4:
			shellSort(strArr);
			break;
		case 5:
			quickSort(strArr, 0, length - 1);
			break;
		case 6:
			heapSort(strArr);
			break;
		case 7:
			String[] tmpArr = new String[length];
			mergeSort(strArr,0,length -1,tmpArr);
			break;
		}
	}

	public static void mergeSort(String[] strArr, int first, int last, String[] tmpArr) {
		if (first<last) {
			int mid =(first+last)/2;
			//左边有序递归
			mergeSort(strArr, first, mid, tmpArr);
			//右边有序递归
			mergeSort(strArr, mid+1, last, tmpArr);
			////将二个有序数列合并
			mergearray(strArr, first, mid, last, tmpArr);
		}
	}

	private static void mergearray(String[] strArr, int first, int mid, int last, String[] tmpArr) {
		//原数组二分起始游标
		int i = first, j = mid + 1;
		//原数组二分终点游标
		int m = mid,   n = last;
		//新数组下标
		int k = 0;
		
		//原数组二分小组俱在的情况
		while (i <= m && j <= n)
		{
			//原数组的两分小组中的小值归并到新数组
			if (Integer.parseInt(strArr[i]) <= Integer.parseInt(strArr[j]))
				tmpArr[k++] = strArr[i++];
			else
				tmpArr[k++] = strArr[j++];
		}
		
		//原数组前小组存在情况
		while (i <= m)
			tmpArr[k++] = strArr[i++];
		
		//原数组后小组存在情况
		while (j <= n)
			tmpArr[k++] = strArr[j++];
		
		//新数组值copy到原数组
		for (i = 0; i < k; i++)
			strArr[first + i] = tmpArr[i];
	}

	public static void heapSort(String[] strArr) {
		int n;

		// 构建堆
		constuction_heap(strArr);
		n = strArr.length - 1;
		while (n > 0) {
			// 根和末尾交换
			swap(strArr, 0, n);
			// 交换后的元素从堆中分离
			n -= 1;
			// 重建堆
			down_heap(strArr, 0, n);
		}
	}

	private static void down_heap(String[] strArr, int root, int tail) {
		// 根植的備份
		String work = strArr[root];
		int left = root * 2 + 1;
		int leftChild = Integer.parseInt(strArr[left]);
		int right = left + 1;
		int rightChild = Integer.parseInt(strArr[right]);

		// 左大右小
		if (right <= tail && rightChild > leftChild) {
			left = right;
			leftChild = Integer.parseInt(strArr[left]);
		}

		while (left <= tail && Integer.parseInt(work) < leftChild) {
			//左大孩值作为根值
			strArr[root] = strArr[left];
			root = left;
			//重新计算左右子节点下标
			left = root * 2 + 1;
			right = left + 1;

			if (right <= tail) {
				leftChild = Integer.parseInt(strArr[left]);
				rightChild = Integer.parseInt(strArr[right]);
				if (rightChild > leftChild) {
					left = right;
				}
			}
		}
		if (!work.equals(strArr[root])) {
			strArr[root] = work;
		}
	}

	private static void constuction_heap(String[] strArr) {
		for (int i = (strArr.length - 1) / 2; i > 0; i--) {
			down_heap(strArr, i - 1, strArr.length - 1);
		}
	}

	public static void quickSort(String[] strArr, int left, int right) {
		int pivot, lb = left, rb = right;

		// 右端の値を基準値とする
		pivot = Integer.parseInt(strArr[right]);
		while (lb != rb) {
			// 获取第一个大于基准值的下标
			while (Integer.parseInt(strArr[lb]) < pivot) {
				lb += 1;
			}
			// 获取第一个小于基准值的下标
			while (lb < rb && Integer.parseInt(strArr[rb - 1]) > pivot) {
				rb -= 1;
			}
			// 第一个大于基准值的数和第一个小于基准值的数交换位置
			if (lb < rb) {
				swap(strArr, lb, rb - 1);
			}
		}

		// 基准值和最后一个小于基准值的数交换
		swap(strArr, lb, right);

		// 左区间递归
		if (lb - 1 > left) {
			quickSort(strArr, left, lb - 1);
		}

		// 右区间递归
		if (rb + 1 < right) {
			quickSort(strArr, rb + 1, right);
		}
	}

	public static void shellSort(String[] strArr) {
		// 间隔初始值
		int interval = strArr.length / 3;
		for (int i = interval; i >= 1; i--)
			// 插入排序
			insertSort(strArr, i);
	}

	public static void insertSort(String[] strArr, int intverval) {
		for (int i = intverval; i < strArr.length; i += intverval) {
			for (int j = i; j > 0; j -= intverval) {
				int curVal = Integer.parseInt(strArr[j]);
				int front = j - intverval;

				if (front < 0) {
					break;
				}
				int sortedVal = Integer.parseInt(strArr[front]);

				if (sortedVal > curVal) {
					swap(strArr, front, j);
				} else {
					break;
				}
			}
			printArr(strArr);
		}
	}

	public static void selectionSort(String[] strArr) {
		for (int i = 0; i < strArr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < strArr.length; j++) {
				if (Integer.parseInt(strArr[min]) > Integer.parseInt(strArr[j])) {
					min = j;
				}
			}

			if (i == min) {
				continue;
			}

			swap(strArr, i, min);

			System.out.println(String.format("Round %d min is ", i) + strArr[i]);
		}
	}

	private static void swap(String[] strArr, int i, int j) {
		String tmp;

		tmp = strArr[i];
		strArr[i] = strArr[j];
		strArr[j] = tmp;
	}

	public static void bubbleSort(String[] strArr) {
		for (int i = 0; i < strArr.length - 1; i++) {
			for (int j = 0; j < strArr.length - 1 - i; j++) {
				int cur = Integer.parseInt(strArr[j]);
				int next = Integer.parseInt(strArr[j + 1]);
				if (cur > next) {
					swap(strArr, j, j + 1);
				}
			}
		}
	}
}
