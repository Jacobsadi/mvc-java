package com.utm.ip.mbipweb.mbip56.services.electricity;

import com.utm.ip.mbipweb.mbip56.models.electricity.Electricity;
import java.util.List;

public interface ElectricityService {
    List<Electricity> getAllElectricitys();

    Electricity addElectricity(final Electricity electricity);

    Electricity getElectricityById(String id);

    Electricity updateElectricity(final Electricity electricity);

    boolean deleteElectricity(String id);

    Electricity getElectricityByUserId(int user_id);

    boolean doesUserIdExistInElectricity(int user_id);

    List<Electricity> getElectricityForId(int id);


}
