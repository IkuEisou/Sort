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
		String tmp = null;

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

			tmp = strArr[i];
			strArr[i] = strArr[min];
			strArr[min] = tmp;

			System.out.println(String.format("Round %d min is ", i) + strArr[i]);
		}
	}
}
