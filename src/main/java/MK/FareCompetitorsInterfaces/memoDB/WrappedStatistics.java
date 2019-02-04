package MK.FareCompetitorsInterfaces.memoDB;

import MK.FareCompetitorsInterfaces.dto.Statistc;

import java.util.List;

public class WrappedStatistics {

    private List<Statistc> statistcs;

    public List<Statistc> getStatistcs() {
        return statistcs;
    }

    public void setStatistcs(List<Statistc> statistcs) {
        this.statistcs = statistcs;
    }
}
