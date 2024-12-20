// ElectricityRepository.java
package com.utm.ip.mbipweb.mbip56.models.electricity;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ElectricityRepository {
    List<ElectricityDAO> getAllElectricitys();
    ElectricityDAO addElectricity(final ElectricityDAO electricity);
    ElectricityDAO getElectricityById(int id);
    ElectricityDAO updateElectricity(final ElectricityDAO electricity);
    boolean deleteElectricity(int id);
    ElectricityDAO getElectricityByUserId(int user_id);
    boolean doesUserIdExistInElectricity(int user_id);
    List<ElectricityDAO> getElectricityForId(int id);

}
