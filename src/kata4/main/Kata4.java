package kata4.main;

import kata4.model.*;
import kata4.view.*;
import java.io.IOException;
import java.util.List;


public class Kata4 {

    public static void main(String[] args) throws IOException {
        Kata4 kataCuatro = new Kata4(); 
        kataCuatro.execute();
    }
    
    private List<Mail> mailList;
    private Histogram<String> histogram;
    
    public void execute() throws IOException{
        input();
        process();
        output();
    }

    private void input() throws IOException {
        String fileName = ".\\src\\kata4\\emails.txt";
        mailList = MailListReader.read(fileName);
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        HistogramDisplay histodisplay = new HistogramDisplay(histogram);
        histodisplay.execute();
    }
}
