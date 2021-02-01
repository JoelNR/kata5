
package kata5;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.SQLMailListLoader;

public class Kata5 {

    private static List<String> mailList;
    private static Histogram<String> histogram;
    private static HistogramDisplay histogramDisplay;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        execute();
    }

    private static void execute() throws ClassNotFoundException, SQLException{
        mailList = SQLMailListLoader.read();
        histogram = build(mailList);
        histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.display();
    }
    
    public static Histogram<String> build(List<String> mailList){
        Histogram<String> histogram = new Histogram();
        for (String mail : mailList) {
            histogram.increment(mail);
        }
        
        return histogram;
    }

}
