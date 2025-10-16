import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
     public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

      Long count = Long.parseLong(br.readLine()); 

      br.close();

      StringBuilder sb = new StringBuilder(count*count*count + "\n" + 3); 

      

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(sb.toString());
 
		bw.flush();
		bw.close();
       

    }

}