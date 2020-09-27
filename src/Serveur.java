import java.net.*;
import java.io.*;

public class Serveur {	
	
	public static void main(String[] args) {
		ServerSocket servScket = null;
		Socket socket;
		int port =2013;
		String nomLivre;
		String [][] tab = {{'SQL',1},{'JavaFx',2},{'PHP',3};
		Boolean finded = false;
		
		try {
			servScket = new ServerSocket(port);
			socket =servScket.accept();
			InputStreamReader input = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(input);
			
			PrintStream out = new PrintStream(new BufferedReaderOutputStream(socket.getOutputStream()));
			nomLivre = in.readLine();
			
			for(int i=0; i<tab.length; i++) {
				if(tab[i][0] == nomLivre) {
					finded = true;
					out.println(tab[i][1])
				}if(finded == false) {
					out.println("Livre does not existed");
				}
			}
			out.flush();
			socket.close();
			servSocker.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	}
	
}
