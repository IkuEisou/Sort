import static util.Sort.*;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author clever
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "";
		Scanner sc = new Scanner(System.in);
		try {
			do {
				System.out.println("Input you want to sort array which delimiter is comma(input q to exit ):");

				input = sc.nextLine();
				if (input.equals("q")) {
					System.out.println("Exit from this app!");
					break;
				}

				String[] strArr = input.split(",");
				exeSort(sc, strArr);
				System.out.println("The sorted Array is:");
				printArr(strArr);

			} while (!input.equals("q"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
}
