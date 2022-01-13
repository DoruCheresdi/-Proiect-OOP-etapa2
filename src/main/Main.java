package main;

import checker.Checker;
import common.Constants;
import common.SimulationConstants;
import data.SimulationData;
import fileio.InputReader;
import fileio.Writer;
import simulation.Simulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * Method to read, solve and write data for one test
     * @param inputFileAbsolutPath
     * @param outputFileString
     * @throws IOException
     */
    public static void solveOneTest(final String inputFileAbsolutPath,
                                    final String outputFileString)
            throws IOException {
        // empty the database:
        SimulationData simulationData = SimulationData.getInstance();
        simulationData.emptyData();

        // load test data into database:
        InputReader inputReader = new InputReader(inputFileAbsolutPath);
        inputReader.readData();

        // start simulation:
        Writer writer = new Writer(outputFileString);
        Simulation simulation = new Simulation(writer);
        simulation.simulate();

        // write simulation result JSON to output file:
        writer.writeToFile();
    }

    /**
     * function to solve all tests
     */
    public static void solveTests() throws IOException {
        // checks if output directory exists, if not then create it:
        Path outPath = Paths.get(SimulationConstants.OUTPUT_DIR_PATH);
        if (!Files.exists(outPath)) {
            Files.createDirectories(outPath);
        }

        // delete all previous out files:
        File outputDirectory = new File(SimulationConstants.OUTPUT_DIR_PATH);
        for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
            if (!file.delete()) {
                System.out.println("File can't be deleted.");
            }
        }

        // solve each test:
        for (int testNumber = 1; testNumber <= Constants.TESTS_NUMBER; testNumber++) {
            String outputPathString = Constants.OUTPUT_PATH
                    + testNumber + Constants.FILE_EXTENSION;
            File outputFile = new File(outputPathString);

            String inputPathString = SimulationConstants.INPUT_PATH
                    + testNumber + Constants.FILE_EXTENSION;
            File inputFile = new File(inputPathString);

            boolean hasBeenCreated = outputFile.createNewFile();
            if (hasBeenCreated) {
                solveOneTest(inputFile.getAbsolutePath(), outputPathString);
            }
        }
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        solveTests();

        Checker.calculateScore();
    }
}
