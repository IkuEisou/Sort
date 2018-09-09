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
			quickSort(strArr);
			break;
		case 6:
			heapSort(strArr);
			break;
		case 7:
			mergeSort(strArr);
			break;
		}

	}

	private static void mergeSort(String[] strArr) {
		// TODO Auto-generated method stub

	}

	private static void heapSort(String[] strArr) {
		// TODO Auto-generated method stub

	}

	private static void quickSort(String[] strArr) {
		// TODO Auto-generated method stub

	}

	private static void shellSort(String[] strArr) {
		// TODO Auto-generated method stub
		int interval = strArr.length / 3;
		for (int i = interval; i >= 1; i--)
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

//			System.out.println(String.format("Round %d sorted resultn is ", i));
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

	private static void swap(String[] strArr, int i, int min) {
		String tmp;

		tmp = strArr[i];
		strArr[i] = strArr[min];
		strArr[min] = tmp;
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
