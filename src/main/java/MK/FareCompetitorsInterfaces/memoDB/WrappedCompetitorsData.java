package MK.FareCompetitorsInterfaces.memoDB;

import MK.FareCompetitorsInterfaces.dto.CompetitorsData;

import java.util.ArrayList;
import java.util.List;

public class WrappedCompetitorsData {
    private List<CompetitorsData> competitorsDataList ;


    public List<CompetitorsData> getCompetitorsDataList() {
        return competitorsDataList;
    }

    public void setCompetitorsDataList(List<CompetitorsData> competitorsDataList) {
        this.competitorsDataList = competitorsDataList;
    }
}
