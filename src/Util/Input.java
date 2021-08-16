package Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Input {
	
	private static InputStreamReader isr;
	private static BufferedReader br;
	
	public static int inputInteger() throws Exception{
		isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        int input = Integer.MIN_VALUE;
		try {
			input = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
        return input;
	}
	
	public static int[] inputIntegerArray() throws Exception{
		isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        int input[];
		try {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			throw e;
		} catch (IOException e) {
			throw e; 
		}
        return input;
	}
	
	public static String inputString() throws Exception{
		isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			throw e;
		}
        return input;
	}
}
