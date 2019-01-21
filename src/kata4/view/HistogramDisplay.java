package kata4.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
 
public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;
     
    public HistogramDisplay(Histogram<String> Histogram) {
        super("Kata 4: HISTOGRAMA");
        this.histogram = Histogram;
        setContentPane(createPanel());
        pack();
    }
 
    public void execute(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
 
    private JPanel createPanel() {
        ChartPanel charPanel = new ChartPanel(createChart(createDataset()));
        charPanel.setPreferredSize(new Dimension(500,400));
        return charPanel;
    }
     
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart FreeChart = ChartFactory.createBarChart(
                "Histograma JFreeChart",
                "Dominios Email",
                "Nº Emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return FreeChart;
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataset.addValue(histogram.getKey(key),"",key);
        }
        return dataset;
    }
     
}