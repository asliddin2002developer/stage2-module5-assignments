package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    private static List<String> stringList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringList = stringList;
    }

    private LocalProcessor() {
    }

    @ListIteratorAnnotation
    private void listIterator(List<String> stringList) {
        LocalProcessor.stringList = new LinkedList<>(stringList);
        for (String string : LocalProcessor.stringList) {
            if(string != null) {
                System.out.println(string.hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    private String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder strBuilder = new StringBuilder();
        for (String string : LocalProcessor.stringList) {
            processorName += string + " ";
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    private void readFullProcessorName(File file){
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion += informationScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (informationScanner != null) {
                informationScanner.close();
            }
        }
    }

}
