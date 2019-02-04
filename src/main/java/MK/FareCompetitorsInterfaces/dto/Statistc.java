package MK.FareCompetitorsInterfaces.dto;

public class Statistc {

    private String marketId;
    private String maxCompetitor;
    private Double maxFare;
    private String minCompetitor;
    private Double minFare;
    private Double avgFare;

    public Statistc(String marketId, String maxCompetitor,Double maxFare,String minCompetitor,Double minFare,
                    Double avgFare){
        this.marketId = marketId;
        this.maxCompetitor = maxCompetitor;
        this.maxFare = maxFare;
        this.minCompetitor = minCompetitor;
        this.minFare = minFare;
        this.avgFare = avgFare;
    }

    public Statistc(){    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMaxCompetitor() {
        return maxCompetitor;
    }

    public void setMaxCompetitor(String maxCompetitor) {
        this.maxCompetitor = maxCompetitor;
    }

    public Double getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(Double maxFare) {
        this.maxFare = maxFare;
    }

    public String getMinCompetitor() {
        return minCompetitor;
    }

    public void setMinCompetitor(String minCompetitor) {
        this.minCompetitor = minCompetitor;
    }

    public Double getMinFare() {
        return minFare;
    }

    public void setMinFare(Double minFare) {
        this.minFare = minFare;
    }

    public Double getAvgFare() {
        return avgFare;
    }

    public void setAvgFare(Double avgFare) {
        this.avgFare = avgFare;
    }
}
