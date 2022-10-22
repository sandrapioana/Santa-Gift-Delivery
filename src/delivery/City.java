package delivery;

public final class City {
    /**
     * Name of the city
     */
    private String cityName;
    /**
     * Score of the city
     */
    private Double cityScore;
    /**
     * VNumber of children from this city
     */
    private Integer childrenFromThisCity;
    /**
     * Average score of the city
     */
    private Double cityScoreCalculated;

    public City(final String cityName) {
        this.cityName = cityName;
        this.cityScore = 0.0;
        this.childrenFromThisCity = 0;
        this.cityScoreCalculated = 0.0;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public Double getCityScore() {
        return cityScore;
    }

    public void setCityScore(final Double cityScore) {
        this.cityScore = cityScore;
    }

    public Integer getChildrenFromThisCity() {
        return childrenFromThisCity;
    }

    public void setChildrenFromThisCity(final Integer childrenFromThisCity) {
        this.childrenFromThisCity = childrenFromThisCity;
    }

    public Double getCityScoreCalculated() {
        return cityScoreCalculated;
    }

    public void setCityScoreCalculated(final Double cityScoreCalculated) {
        this.cityScoreCalculated = cityScoreCalculated;
    }
}
