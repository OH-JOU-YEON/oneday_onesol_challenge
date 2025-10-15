import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
     public static void main(String[] args) throws IOException{

      char[][] array = new char[5][15]; 

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
      //배열에 담기 
   

        for(int i = 0; i< 5; i++) {

        String next = br.readLine(); 

         
            for(int j = 0; j<next.length(); j++) {
              array[i][j] = next.charAt(j); 
            }
          
        }


        //배열 읽기 

        StringBuilder sb = new StringBuilder(); 


        for(int i = 0; i<15; i++) { 

          for(int j = 0; j<5; j++) {

            if(array[j][i] != '\u0000') {
              sb.append(array[j][i]); 
            }
            
          }

        }

        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      

		bw.write(sb.toString());
 
		bw.flush();
		bw.close();
       

    }

}
