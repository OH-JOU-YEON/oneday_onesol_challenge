import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
     public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

      StringTokenizer st = new StringTokenizer(br.readLine()," "); 
      
      int x = Integer.parseInt(st.nextToken()); 

      int y = Integer.parseInt(st.nextToken()); 

      int w = Integer.parseInt(st.nextToken());

      int h = Integer.parseInt(st.nextToken()); 
      

      
      int answer1 = (x) > (w-x) ? (w-x) : (x);
      
      int answer2 = y > h-y ? (h-y) : y; 



     

      

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(String.valueOf(String.valueOf(Math.min(answer1, answer2))));
 
		bw.flush();
		bw.close();
       

    }

}
