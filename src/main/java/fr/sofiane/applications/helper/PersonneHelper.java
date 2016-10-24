package fr.sofiane.applications.helper;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Sofiane on 24/10/2016.
 */
public class PersonneHelper {

    private static PersonneHelper instance = null;

    private PersonneHelper(){}

    public static PersonneHelper getInstance(){
        if(instance == null){
            return new PersonneHelper();
        }else{
            return instance;
        }
    }


    public Integer calculateAgeFromDateOfBirth(Date date){
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(dateOfBirth,today).getYears();
    }

}