/**
 * 
 */
package util;

/**
 * @author clever
 *
 */
public class Sort {
	public static void exeSort(int no, String[] strArr) {
		switch (no) {
		case 1:
			selectionSort(strArr);
			break;
		case 2:
			bubbleSort(strArr);
			break;
		case 3:
			insertSort(strArr);
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
		
	}

	private static void insertSort(String[] strArr) {
		// TODO Auto-generated method stub
		
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
				int next = Integer.parseInt(strArr[j+1]);
				if (cur > next) {
					swap(strArr, j, j+1);
				}
			}
		}
	}
}
