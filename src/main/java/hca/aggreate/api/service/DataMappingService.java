package hca.aggreate.api.service;

import hca.aggreate.api.bean.AggregateData;
import hca.aggreate.api.bean.Resident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataMappingService {

    //Creating aggregate data from resident data
    public AggregateData createAggregateDataFromFacilityData(List<Resident> residentList, int facilityId){
        AggregateData aggregatedata = new AggregateData();
        int hasPetCount = 0;
        int isAmbulatoryCount = 0;
        int isAbleToCommunicateCount = 0;
        int isVaccinatedForCovid19Count = 0;
        int isFallRiskCount = 0;
        int isWanderRiskCount = 0;
        int isElopementRiskCount = 0;
        aggregatedata.setFacilityId(facilityId);

        for (Resident resident : residentList) {
            if (resident.getHasPet().equalsIgnoreCase("yes")) {
                hasPetCount++;
            }
            if (resident.getIsAmbulatory().equalsIgnoreCase("yes")) {
                isAmbulatoryCount++;
            }
            if (resident.getIsAbleToCommunicate().equalsIgnoreCase("yes")) {
                isAbleToCommunicateCount++;
            }
            if (resident.getIsVaccinatedForCovid19().equalsIgnoreCase("yes")) {
                isVaccinatedForCovid19Count++;
            }
            if (resident.getIsFallRisk().equalsIgnoreCase("yes")) {
                isFallRiskCount++;
            }
            if (resident.getIsWanderRisk().equalsIgnoreCase("yes")) {
                isWanderRiskCount++;
            }
            if (resident.getIsElopementRisk().equalsIgnoreCase("yes")) {
                isElopementRiskCount++;
            }
        }

        aggregatedata.setHasPet(hasPetCount);
        aggregatedata.setIsAmbulatory(isAmbulatoryCount);
        aggregatedata.setIsAbleToCommunicate(isAbleToCommunicateCount);
        aggregatedata.setIsVaccinatedForCovid19(isVaccinatedForCovid19Count);
        aggregatedata.setIsFallRisk(isFallRiskCount);
        aggregatedata.setIsWanderRisk(isWanderRiskCount);
        aggregatedata.setIsElopementRisk(isElopementRiskCount);

        return aggregatedata;
    }
}


