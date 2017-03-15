package utils.view;

import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class graphs extends JFrame {

	private static final long serialVersionUID = 1L;

	public graphs(String chartTitle, DefaultCategoryDataset dataset) {
		super("Procimg");

		// com base no conjunto de dados que criamos o gráfico
		JFreeChart chart = createChart(dataset, chartTitle);

		// vamos colocar o gráfico em um painel
		ChartPanel chartPanel = new ChartPanel(chart);

		// default tamanho
		chartPanel.setPreferredSize(new java.awt.Dimension(640, 480));

		// adiciona a nossa aplicação
		JDialog dialog = new JDialog();
		dialog.add( chartPanel );
		dialog.pack();
		dialog.setVisible(true);

	}



	/**
	 * Cria um gráfico 
	 */

	private JFreeChart createChart(DefaultCategoryDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createLineChart( 
				title,
				"Luminosidade",
				"Número de Pixels", 
				dataset, // dados
				PlotOrientation.VERTICAL,
				true, // include lenda
				true, false);
		NumberAxis xAxis = new NumberAxis();
		xAxis.setTickUnit(new NumberTickUnit(2));

		// Assign it to the chart
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setDomainAxis(xAxis);
		return chart;

	}
}
