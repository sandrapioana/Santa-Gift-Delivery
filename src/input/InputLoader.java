package input;


import changes.AnnualChange;
import changes.ChildUpdate;
import common.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputLoader {
    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }
    /**
     * Method that returns input path
     */
    public String getInputPath() {
        return inputPath;
    }
    /**
     * Method that reads Input data
     */
    public Input readInitialData() {
        JSONParser jsonParser = new JSONParser();
        int numberOfYears = 0;
        double santaBudget = 0.0;
        List<ChildInput> children = new ArrayList<>();
        List<GiftInput> gifts = new ArrayList<>();
        List<AnnualChange> annualChanges = new ArrayList<>();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(inputPath));
            numberOfYears = Integer.parseInt(((JSONObject) jsonObject)
                    .get(Constants.NUMBER_OF_YEARS).toString());
            santaBudget = Double.parseDouble(((JSONObject) jsonObject)
                    .get(Constants.SANTA_BUDGET).toString());
            JSONObject initialData = (JSONObject) jsonObject.get(Constants.INITIAL_DATA);
            JSONArray jsonChildren = (JSONArray) initialData.get(Constants.CHILDREN);
            JSONArray jsonSantaGifts = (JSONArray) initialData.get(Constants.SANTA_GIFTS);

            if (jsonChildren != null) {
                for (Object jsonChild : jsonChildren) {
                    children.add(new ChildInput(
                            Integer.parseInt(((JSONObject) jsonChild).get(Constants.ID).toString()),
                            (String) ((JSONObject) jsonChild).get(Constants.LAST_NAME),
                            (String) ((JSONObject) jsonChild).get(Constants.FIRST_NAME),
                            Integer.parseInt(((JSONObject) jsonChild)
                                    .get(Constants.AGE).toString()),
                            (String) ((JSONObject) jsonChild).get(Constants.CITY),
                            Double.parseDouble(((JSONObject) jsonChild)
                                    .get(Constants.NICE_SCORE).toString()),
                            Utils.convertJSONArray((JSONArray) ((JSONObject) jsonChild)
                                    .get(Constants.GIFTS_PREFERENCES)),
                            Integer.parseInt(((JSONObject) jsonChild)
                                    .get(Constants.NICE_SCORE_BONUS).toString()),
                            (String) ((JSONObject) jsonChild).get(Constants.ELF)
                    ));
                }
            } else {
                System.out.println("NU EXISTA COPII");
            }

            if (jsonSantaGifts != null) {
                for (Object jsonGift : jsonSantaGifts) {
                    gifts.add(new GiftInput(
                            (String) ((JSONObject) jsonGift).get(Constants.PRODUCT_NAME),
                            Double.parseDouble(((JSONObject) jsonGift)
                                    .get(Constants.PRICE).toString()),
                            (String) ((JSONObject) jsonGift).get(Constants.CATEGORY),
                            Integer.parseInt(((JSONObject) jsonGift)
                                    .get(Constants.QUANTITY).toString())
                    ));
                }
            } else {
                System.out.println("NU EXISTA CADOURI");
            }
            annualChanges = readChanges(jsonObject);
            if (jsonChildren == null) {
                children = null;
            }

            if (jsonSantaGifts == null) {
                gifts = null;
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return new Input(numberOfYears, santaBudget, children, gifts, annualChanges);
    }
    /**
     * Method that returns a list with annual changes
     */
    public List<AnnualChange> readChanges(final JSONObject jsonObject) {
        List<AnnualChange> changes = new ArrayList<>();
        JSONArray jsonChanges = (JSONArray) jsonObject.get(Constants.ANNUAL_CHANGES);
        if (jsonChanges != null) {
            for (Object jsonChange : jsonChanges) {
                double santaBudget = Double.parseDouble(((JSONObject) jsonChange)
                        .get(Constants.NEW_SANTA_BUDGET).toString());

                JSONArray jsonNewGifts = (JSONArray) ((JSONObject) jsonChange)
                        .get(Constants.NEW_GIFTS);
                List<GiftInput> newGifts = new ArrayList<>();
                if (jsonNewGifts != null) {
                    for (Object jsonNewGift : jsonNewGifts) {
                        newGifts.add(new GiftInput(
                                (String) ((JSONObject) jsonNewGift).get(Constants.PRODUCT_NAME),
                                Double.parseDouble(((JSONObject) jsonNewGift)
                                        .get(Constants.PRICE).toString()),
                                (String) ((JSONObject) jsonNewGift).get(Constants.CATEGORY),
                                Integer.parseInt(((JSONObject) jsonNewGift)
                                        .get(Constants.QUANTITY).toString())
                        ));
                    }
                } else {
                    System.out.println("NU EXISTA CADOURI NOI");
                }

                JSONArray jsonNewChildren = (JSONArray) ((JSONObject) jsonChange)
                        .get(Constants.NEW_CHILDREN);
                List<ChildInput> newChildren = new ArrayList<>();
                if (jsonNewChildren != null) {
                    for (Object jsonNewChild : jsonNewChildren) {
                        newChildren.add(new ChildInput(
                                Integer.parseInt(((JSONObject) jsonNewChild)
                                        .get(Constants.ID).toString()),
                                (String) ((JSONObject) jsonNewChild).get(Constants.LAST_NAME),
                                (String) ((JSONObject) jsonNewChild).get(Constants.FIRST_NAME),
                                Integer.parseInt(((JSONObject) jsonNewChild)
                                        .get(Constants.AGE).toString()),
                                (String) ((JSONObject) jsonNewChild).get(Constants.CITY),
                                Double.parseDouble(((JSONObject) jsonNewChild)
                                        .get(Constants.NICE_SCORE).toString()),
                                Utils.convertJSONArray((JSONArray) ((JSONObject) jsonNewChild)
                                        .get(Constants.GIFTS_PREFERENCES)),
                                Integer.parseInt(((JSONObject) jsonNewChild)
                                        .get(Constants.NICE_SCORE_BONUS).toString()),
                                (String) ((JSONObject) jsonNewChild).get(Constants.ELF)
                        ));
                    }
                } else {
                    System.out.println("NU EXISTA COPII NOI");
                }

                JSONArray jsonChildrenUpdates = (JSONArray) ((JSONObject) jsonChange)
                        .get(Constants.CHILDREN_UPDATE);
                List<ChildUpdate> childrenUpdate = new ArrayList<>();
                if (jsonChildrenUpdates != null) {
                    for (Object jsonChildUpdate : jsonChildrenUpdates) {
                        int id = Integer.parseInt(((JSONObject) jsonChildUpdate)
                                .get(Constants.ID).toString());
                        double niceScore = 0;
                        if (((JSONObject) jsonChildUpdate).get(Constants.NICE_SCORE) == null) {
                            niceScore = Constants.INVALID_SCORE;
                        } else {
                            niceScore = Double.parseDouble(((JSONObject) jsonChildUpdate)
                                    .get(Constants.NICE_SCORE).toString());
                        }
                        ArrayList<String> giftsPreferences = Utils.convertJSONArray(
                                (JSONArray) ((JSONObject) jsonChildUpdate)
                                        .get(Constants.GIFTS_PREFERENCES));
                        String elf;
                        elf = (String) ((JSONObject) jsonChildUpdate).get(Constants.ELF);
                        ChildUpdate update = new ChildUpdate(id, niceScore, giftsPreferences, elf);
                        childrenUpdate.add(update);
                    }
                } else {
                    System.out.println("NU EXISTA UPDATE-URI");
                }

                String strategy = (String) ((JSONObject) jsonChange).get(Constants.STRATEGY);
                changes.add(new AnnualChange(santaBudget, newGifts, newChildren,
                                             childrenUpdate, strategy));
            }
        } else {
            System.out.println("NU EXISTA SCHIMBARI");
            changes = null;
        }
        return changes;
    }
}
