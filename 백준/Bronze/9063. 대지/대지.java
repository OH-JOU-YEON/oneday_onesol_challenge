import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
     public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

      int N = Integer.parseInt(br.readLine()); 

      int[][] points = new int[N][2]; 


      for(int i = 0; i< N; i++) {

          StringTokenizer st = new StringTokenizer(br.readLine()," ");
          points[i][0] = Integer.parseInt(st.nextToken()); 
          points[i][1] = Integer.parseInt(st.nextToken()); 

      }

      int Xmax = points[0][0]; 

      int Xmin = points[0][0];
      
      int Ymax = points[0][1]; 

      int Ymin = points[0][1]; 

      for(int i = 1; i < N; i++) {

        Xmax = Math.max(points[i][0],Xmax); 
        Xmin = Math.min(points[i][0],Xmin); 

        Ymax = Math.max(points[i][1],Ymax); 
        Ymin = Math.min(points[i][1], Ymin); 

      }
      

      int answer = Math.abs(Xmax - Xmin) * Math.abs(Ymax - Ymin); 

      

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(String.valueOf(answer));
 
		bw.flush();
		bw.close();
       

    }

}
