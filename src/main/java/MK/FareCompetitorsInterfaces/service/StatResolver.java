 package MK.FareCompetitorsInterfaces.service;

import MK.FareCompetitorsInterfaces.dto.CompetitorsData;
import MK.FareCompetitorsInterfaces.dto.Statistc;
import MK.FareCompetitorsInterfaces.memoDB.WrappedCompetitorsData;
import MK.FareCompetitorsInterfaces.memoDB.WrappedStatistics;
import ch.qos.logback.classic.gaffer.ComponentDelegate;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public  class StatResolver {

    public static List<Statistc> getStat(WrappedCompetitorsData data){
        return countStat(data);
    }

    private static List<Statistc> countStat(WrappedCompetitorsData data){


        Map<String,Statistc> statistcMap = new HashMap<>();
        List<Statistc> statistcs = new ArrayList<>();
        List<CompetitorsData> competitorsData = data.getCompetitorsDataList();

        Map<String, Map<String, Map<String, Optional<CompetitorsData>>>> max
                = competitorsData.stream()
                .collect(
                        groupingBy(CompetitorsData::getOrigin,
                                groupingBy(CompetitorsData::getDate,
                                        groupingBy(CompetitorsData::getDestination
                                 ,Collectors.maxBy( Comparator.comparing(CompetitorsData::getFare) )))));

        Map<String, Map<String, Map<String, Optional<CompetitorsData>>>> min
                = competitorsData.stream()
                .collect(
                        groupingBy(CompetitorsData::getOrigin,
                                groupingBy(CompetitorsData::getDate,
                                        groupingBy(CompetitorsData::getDestination
                                                ,Collectors.minBy( Comparator.comparing(CompetitorsData::getFare) )))));

        Map<String, Map<String, Map<String, Double>>> avg
                = competitorsData.stream()
                .collect(
                        groupingBy(CompetitorsData::getOrigin,
                                groupingBy(CompetitorsData::getDate,
                                        groupingBy(CompetitorsData::getDestination
                                               , Collectors.averagingDouble(CompetitorsData::getFare)))));





        for(Map.Entry<String, Map<String, Map<String, Optional<CompetitorsData>>>> orgin: max.entrySet()) {
            for (Map.Entry<String, Map<String, Optional<CompetitorsData>>> date : orgin.getValue().entrySet()) {
                for(Map.Entry<String, Optional<CompetitorsData>> dest : date.getValue().entrySet()){

                    CompetitorsData competitorsRecord = dest.getValue().get();
                    Statistc statistcRecord = new Statistc();
                    statistcRecord.setMaxCompetitor(competitorsRecord.getAirline());
                    statistcRecord.setMaxFare(competitorsRecord.getFare());
                    statistcRecord.setMarketId(competitorsRecord.getOrigin()+"["+
                            competitorsRecord.getDate()+"]"+competitorsRecord.getDestination());

                    statistcMap.put(competitorsRecord.getOrigin()+"["+
                            competitorsRecord.getDate()+"]"+competitorsRecord.getDestination(),statistcRecord);


                }
            }
        }

        for(Map.Entry<String, Map<String, Map<String, Optional<CompetitorsData>>>> orgin: min.entrySet()) {
            for (Map.Entry<String, Map<String, Optional<CompetitorsData>>> date : orgin.getValue().entrySet()) {
                for(Map.Entry<String, Optional<CompetitorsData>> dest : date.getValue().entrySet()){

                    CompetitorsData competitorsRecord = dest.getValue().get();
                    Statistc statistcRecord = statistcMap.get(competitorsRecord.getOrigin()+"["+
                            competitorsRecord.getDate()+"]"+competitorsRecord.getDestination());
                    statistcRecord.setMinCompetitor(competitorsRecord.getAirline());
                    statistcRecord.setMinFare(competitorsRecord.getFare());
                    statistcMap.remove(competitorsRecord.getOrigin()+"["+
                            competitorsRecord.getDate()+"]"+competitorsRecord.getDestination());
                    statistcMap.put(competitorsRecord.getOrigin()+"["+
                            competitorsRecord.getDate()+"]"+competitorsRecord.getDestination(),statistcRecord);


                }
            }
        }

        String key;

        for(Map.Entry<String, Map<String, Map<String, Double>>> orgin: avg.entrySet()) {
            key= orgin.getKey()+"[";
            for (Map.Entry<String, Map<String, Double>> date : orgin.getValue().entrySet()) {
                if(key.isEmpty())
                    key= orgin.getKey()+"["+date.getKey()+"]";
                else
                    key+=date.getKey()+"]";
                for(Map.Entry<String, Double> dest : date.getValue().entrySet()){
                    if(key.isEmpty())
                        key= orgin.getKey()+"["+date.getKey()+"]"+dest.getKey();
                    else
                        key+=dest.getKey();

                    Statistc statistcRecord = statistcMap.get(key);
                    statistcRecord.setAvgFare(dest.getValue());
                    statistcMap.remove(key);
                    statistcs.add(statistcRecord);
                    key="";


                }
            }
        }


        return statistcs;


    }
}
