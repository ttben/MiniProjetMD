import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestF43kSolution {
	public static void main(String[] args) throws IOException {
		int prof = 10;
		
		AbstractSolution.params = new int[]{200,600,300,prof,0,0, 60, 20, 0, 5/2};

		new F43kSolution(prof);	
	
	}
}
