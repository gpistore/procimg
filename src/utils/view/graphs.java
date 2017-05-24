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
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

public class graphs extends JFrame {

	private static final long serialVersionUID = 1L;

	public graphs(String chartTitle, XYSeries series) {
		super("Procimg");
		JFreeChart chart = createChart(series, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
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

	private JFreeChart createChart(XYSeries  series, String title) {
		
		XYSeriesCollection data = new XYSeriesCollection(series);

		JFreeChart chart = ChartFactory.createXYLineChart(title, "Luminosidade", "Número de Pixels", data,
		                                                  PlotOrientation.VERTICAL, 
		                                                  true, true, false);
		return chart;

	}
}
