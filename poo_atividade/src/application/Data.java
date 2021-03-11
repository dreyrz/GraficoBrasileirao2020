package application;

import com.google.gson.*;
import java.io.FileReader;
import java.io.Reader;

public class Data {

	public int readData(String team, int round) throws Exception {
		try (Reader reader = new FileReader("data.txt")) {
			int position = 0;
			Gson gson = new Gson();
			Round[] rounds = gson.fromJson(reader, Round[].class);
			for (int r = 0; r < 20; r++) {
				if (team.toLowerCase().equals(rounds[round].tabela.get(r).name.toLowerCase())) {
					position = rounds[round].tabela.get(r).position;
				}
			}
			return position;
		}
	}

}
