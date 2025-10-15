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

        int a = Integer.parseInt(st.nextToken());
        int b  = Integer.parseInt(st.nextToken());

        int[][] arrayA = new int[a][b]; 

        int[][] arrayB = new int[a][b]; 


      StringBuilder sb = new StringBuilder(); 

        for(int i = 0; i< a; i++) {

          StringTokenizer at = new StringTokenizer(br.readLine()," ");

          for(int j = 0; j<b; j++) {
            arrayA[i][j] = Integer.parseInt(at.nextToken());
          }
        }

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i< a; i++) {
          

          StringTokenizer tt = new StringTokenizer(br.readLine()," ");

          for(int j = 0; j<b; j++) {
            arrayB[i][j] = Integer.parseInt(tt.nextToken());
            arrayA[i][j] += arrayB[i][j]; 
            sb.append(String.valueOf(arrayA[i][j]));
            
            if(j != b-1) {
              sb.append(" "); 
            } else {

              sb.append("\n"); 

            }
          }

          
        }

		bw.write(sb.toString());
 
		bw.flush();
		bw.close();
       

    }

}