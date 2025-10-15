import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException{

      int max = 0; 

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
      //최댓값의 위치
      StringBuilder pos = new StringBuilder(); 

        for(int i = 1; i<= 9; i++) {

          StringTokenizer at = new StringTokenizer(br.readLine()," ");

          for(int j = 1; j<=9; j++) {
            int next = Integer.parseInt(at.nextToken()); 

            if(next >= max) {
              max = next; 
              pos = new StringBuilder(i + " " + j); 
            }
          }
        }

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(max + "\n" + pos.toString());
 
		bw.flush();
		bw.close();
       

    }

}
