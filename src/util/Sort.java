/**
 * 
 */
package util;

/**
 * @author clever
 *
 */
public class Sort {
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
		
	}
}
