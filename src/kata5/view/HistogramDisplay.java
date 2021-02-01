package kata5.view;

import kata5.model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;



public class HistogramDisplay extends ApplicationFrame{
    Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram ) {
        super("Resultados del procesado");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart freeChart = ChartFactory.createBarChart("JFreeChart Histogram", 
                                                            "email domains", 
                                                            "nº emails", 
                                                            dataSet, 
                                                            PlotOrientation.VERTICAL, 
                                                            false, 
                                                            false,
                                                            rootPaneCheckingEnabled);
        return freeChart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int others = 0;
        for (String key : histogram.keySet()) {
            int value = histogram.get(key);
            if(value > 1) {
                dataSet.addValue(value, "", key);
            } else {
                others++;
            }
        }
        dataSet.addValue(others, "", "others");
        return dataSet;
    }
    
    public void display(){
        this.setVisible(true);
    }
}
