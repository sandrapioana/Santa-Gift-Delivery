package main;

import checker.Checker;
import child.Child;
import common.Constants;
import gift.Gift;
import input.Input;
import input.InputLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import output.Writer;
import santa.Solver;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String name = file.getName();
            String testNumber = name.replaceAll("[^0-9]", "");
            String filepath = Constants.OUTPUT_PATH + testNumber + Constants.FILE_EXTENSION;
            resolve(file.getAbsolutePath(), filepath);
        }
        Checker.calculateScore();
    }
    /**
     * Method that resolve tests
     */
    public static void resolve(final String filePath1, final String filePath2) throws IOException {
        InputLoader inputLoader = new InputLoader(filePath1);
        Input input = inputLoader.readInitialData();

        Writer writer = new Writer(filePath2);
        JSONArray arrayResult = new JSONArray();

        ArrayList<Child> children = Utils.transformChildInputIntoChild(input.getChildren());
        ArrayList<Gift> gifts = Utils.transformGiftInputIntoGift(input.getGifts());
        Solver.initializeSantaClaus(input.getSantaBudget(), children, gifts);
        JSONObject json = writer.writeChildrenOutput(Solver.giveGifts("id"));
        arrayResult.add(json);

        for (int i = 0; i < input.getNumberOfYears(); ++i) {
            Solver.changeAge();
            Solver.updateInfo(input.getAnnualChanges().get(i));
            json = writer.writeChildrenOutput(Solver.giveGifts(
                    input.getAnnualChanges().get(i).getStrategy()));
            arrayResult.add(json);
        }

        JSONObject finalOutput = writer.writeOutput(arrayResult);
        writer.closeJSON(finalOutput);
    }
}
