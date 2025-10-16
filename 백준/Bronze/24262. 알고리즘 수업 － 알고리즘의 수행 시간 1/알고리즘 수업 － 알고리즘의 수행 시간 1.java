import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Main {
     public static void main(String[] args) throws IOException{

      StringBuilder sb = new StringBuilder("1\n0"); 

      

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(sb.toString());
 
		bw.flush();
		bw.close();
       

    }

}
