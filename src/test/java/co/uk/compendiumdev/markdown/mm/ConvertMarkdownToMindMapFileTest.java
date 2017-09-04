package co.uk.compendiumdev.markdown.mm;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertMarkdownToMindMapFileTest {

    @Test
    public void canCreateAHackyTestToConvertMarkdownSlidesToMindMapImport() throws IOException {

        String fileToConvertToMarkdown = "D:\\Users\\Alan\\Documents\\Documents\\Compendium Developments\\testing\\conferences\\fistb\\2017\\keynote\\automatingStrategicTactically.txt";


        File inputFile = new File(fileToConvertToMarkdown);

        List<Slide> slides = new ArrayList<Slide>();
        Slide currentSlide = new Slide();

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String processThisLine = line.trim();

                if(processThisLine.startsWith("---")){
                    // create a new slide
                    slides.add(currentSlide);
                    currentSlide = new Slide();
                }else {

                    if (processThisLine.startsWith("#") && !currentSlide.hasATitle()) {
                        currentSlide.setTitle(processThisLine);
                    }

                    currentSlide.addTextLine(line);
                }
            }


        // output an 'outline'
        String prefix ="";

        for (Slide aSlide : slides) {

            System.out.println(prefix + aSlide.getTitle());
            prefix = "   ";
        }


    }
}
