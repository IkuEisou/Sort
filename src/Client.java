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

		do {
			System.out.println("Input you want to sort array which delimiter is comma(input q to exit ):");

			input = sc.nextLine();
			if (input.equals("q")) {
				System.out.println("Exit from this app!");
				break;
			}

			String[] strArr = input.split(",");

			System.out.println("Select you wan to sort algorithm No:");
			System.out.println("1:Selection");
			System.out.println("2:Bubble");

			int no = sc.nextInt();
			sc.nextLine();

			try {
				exeSort(no, strArr);
				System.out.println("The sorted Array is:");
				for (int i = 0; i < strArr.length; i++) {
					System.out.print(strArr[i]);
					if (i < strArr.length - 1) {
						System.out.print(",");
					}
				}
				System.out.println();
			} catch (Exception e) {
				sc.close();
				e.printStackTrace();
			}

		} while (!input.equals("q"));

		sc.close();
	}
}
