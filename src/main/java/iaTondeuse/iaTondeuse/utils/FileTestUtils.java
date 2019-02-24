package iaTondeuse.iaTondeuse.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.InitParam;
import iaTondeuse.iaTondeuse.model.Tondeuse;

@Service
public class FileTestUtils {

	public InitParam readFileTest() {
		LinkedHashMap<Tondeuse, String> mapTondeuse =  new LinkedHashMap<Tondeuse, String>();
		InitParam initParam = new InitParam(mapTondeuse, new Coordonnees(0,0));
		InputStream inputStream = getClass().getResourceAsStream("/test.txt");
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line;
	        boolean firstLine =true;
	        while ((line = br.readLine()) != null) {
	            String[] table = line.split(" ");
	            if(firstLine) {
	            	initParam.getCoordMax().setX(Integer.valueOf(table[0]));
					initParam.getCoordMax().setY(Integer.valueOf(table[1]));
		            firstLine = false;
	            }else {
					Tondeuse tondeuse = new Tondeuse(Integer.valueOf(table[0]),Integer.valueOf(table[1]), table[2]);
					String instruction = br.readLine();
					mapTondeuse.put(tondeuse, instruction);
				}
	        }
	    } catch (IOException e) {
			e.printStackTrace();
		}
		return initParam;
	}
}
