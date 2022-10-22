package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import santa.ChildOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    private final FileWriter file;

    public Writer(final String path) throws IOException {
        this.file = new FileWriter(path);
    }
    /**
     * Method that transforms list of Children output in a JSONObject
     */
    public JSONObject writeChildrenOutput(final ArrayList<ChildOutput> children) {
        JSONObject object = new JSONObject();

        object.put(Constants.CHILDREN, children);
        return object;
    }
    /**
     * Method that transforms the output in a JSONObject
     */
    public JSONObject writeOutput(final JSONArray output) {
        JSONObject object = new JSONObject();

        object.put(Constants.ANNUAL_CHILDREN, output);
        return object;
    }
    /**
     * Method that writes to the file and closes it
     */
    public void closeJSON(final JSONObject object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String output = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            file.write(output);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
