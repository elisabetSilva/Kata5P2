package kata4.main;

import kata4.model.*;
import kata4.view.*;
import java.io.IOException;
import java.util.List;


public class Kata4 {

    private static List<String> listMails;
    private static Histogram histograma;
    
    public static void main(String[] args) throws IOException {
        Kata4 kataCuatro = new Kata4(); 
        kataCuatro.execute();
    }
    
    public void execute() throws IOException{
        input();
        process();
        output();
    }

    private void input() throws IOException {
        MailListReaderBD bd = new MailListReaderBD();
        listMails = bd.read("jdbc:sqlite:PEOPLE.db", "EMAIL");
    }

    private void process() {
        MailHistogramBuilder builded = new MailHistogramBuilder();
        histograma = builded.build(listMails);
    }

    private void output() {
        new HistogramDisplay(histograma).execute();
    }
}
