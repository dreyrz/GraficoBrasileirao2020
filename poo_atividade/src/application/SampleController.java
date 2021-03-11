package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * Olá mundo Descrição dessa classe
 */
public class SampleController extends Data implements Initializable {
	ArrayList<String> aux = new ArrayList<String>();
	@FXML
	private ListView<String> teamsList;

	@FXML
	private LineChart<String, Integer> lineChart;

	@FXML
	private CategoryAxis categoryAxis;

	@FXML
	private NumberAxis numberAxis;

	@FXML
	void onMouseClickedLV(MouseEvent event) throws Exception {
		String teamSelected = teamsList.getSelectionModel().getSelectedItem();
		XYChart.Series<String, Integer> teams = new XYChart.Series<String, Integer>();
		teams.setName(teamSelected);
		if (!teamSelected.equals("Limpar")) {
			if (!aux.contains(teamSelected)) {
				aux.add(teamSelected);
				for (int r = 1; r < 11; r++) {
					XYChart.Data<String, Integer> chart = new XYChart.Data<String, Integer>("Rodada " + r,
							21 - readData(teamSelected, r - 1));
					teams.getData().add(chart);
				}
				lineChart.getData().add(teams);
			}

		} else {
			lineChart.getData().clear();
			aux.clear();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constants constants = new Constants();
		ObservableList<String> items = FXCollections.observableArrayList(constants.kTeams);
		teamsList.setItems(items);

	}

}
