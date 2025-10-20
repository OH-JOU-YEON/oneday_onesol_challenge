import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
     public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

      int n = Integer.parseInt(br.readLine()); 

      int count = 1; 

      int range = 2; 

      if (n== 1) {

        count = 1; 
      }
     else {

      while (range <= n) {
          range = range + (6 * count); 
          count++; 
      }
     }

      

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(String.valueOf(count));
 
		bw.flush();
		bw.close();
       

    }

}