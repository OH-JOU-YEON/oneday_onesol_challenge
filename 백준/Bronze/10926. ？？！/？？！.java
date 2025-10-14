import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); 
       StringBuilder sb = new StringBuilder(input);
       sb.append("??!"); 

       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       System.out.println(sb.toString()); 

       

    }

}
