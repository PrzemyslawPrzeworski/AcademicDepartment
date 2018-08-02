package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import entity.Terpenoid;
import repository.TerpenoidRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static method.CalculateRetentionInd.calculateRetentionIndex;


@Controller
@RequestMapping("retention")
public class TerpenoidController {

    @Autowired
    TerpenoidRepository terpenoidRepository;

    @GetMapping("/a")
    @ResponseBody
    public String aaa () {
        try {
            URL url = new URL("https://webbook.nist.gov/cgi/cbook.cgi?Name=Seudenol&Units=SI");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.matches("<h1>.*</h1>")) {
                        Pattern p = Pattern.compile("<h1>(.*)</h1>");
                        Matcher matcher = p.matcher(line);
                        matcher.find();
                        String name = matcher.group(1);
                        System.out.println(name);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "aaa";
    }

    @GetMapping("/xxx")
    public String xx (Model model) {
        List<Terpenoid> terpenoids = terpenoidRepository.findClosestTerpenoid(2500);
        model.addAttribute("terpenoids", terpenoids);
        return "terpenoids";
    }


    @GetMapping("")
    public String enterRetentionTime () {
        return "enterTime";
    }

    @PostMapping("")
    public String calculateRetentionTime(@RequestParam ("time") double time, Model model ) {
        double obtainedRetentionIndex = calculateRetentionIndex(time);
        List<Terpenoid> terpenoids = terpenoidRepository.findClosestTerpenoid(obtainedRetentionIndex);
        model.addAttribute("terpenoids", terpenoids);
        DecimalFormat df = new DecimalFormat("#.#");
        obtainedRetentionIndex = Double.parseDouble(df.format(obtainedRetentionIndex));
        model.addAttribute("obtainedRetentionIndex", obtainedRetentionIndex);
        return "terpenoids";
    }


    @GetMapping("/fillTable")
    @ResponseBody
    public String s () {

        String line = "";
        String tab = "\t";

        File file = new File("/home/przemek/Desktop/kurs/Hibernate/RetentionIndexFinder/src/main/resources/terpenoids.txt");
        StringBuilder reading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String chem_name = line.substring( line.indexOf(tab) + 1 , line.indexOf(tab, line.indexOf(tab) + 1)  - 1);
                String ret_ind = line.substring( line.indexOf(tab, line.indexOf(tab)+1)    + 1,   line.indexOf(tab, line.indexOf(tab,line.indexOf(tab)+1)+1) );
                System.out.print(chem_name);
                System.out.print(" ");
                System.out.println(ret_ind);

                Terpenoid terpenoid = new Terpenoid();
                terpenoid.setChemical_name(chem_name);
                terpenoid.setRetention_index(Integer.valueOf(ret_ind));
                terpenoid.setLink("https://webbook.nist.gov/cgi/cbook.cgi?Name=" + chem_name + "&Units=SI");

//                terpenoid.listOfRetentionIndices.add(Integer.valueOf(ret_ind));


                terpenoidRepository.save(terpenoid);




            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }


        return "aaa";
    }
}
