package com.test.sample.dao;

import com.test.sample.domain.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Component
public class DoctorDAO {

    static List<Doctor> doctorList = new ArrayList<>();

    static{
        doctorList.add(new Doctor(1, "Pratik", "MBBS", 4.2, "Orthologist", 750.00));
        doctorList.add(new Doctor(2, "Pooja", "MBBS", 2.0, "Gynacologist", 1500.00));
    }

    public List<Doctor> list(){
        return doctorList;
    }

    public Boolean save(Doctor doctor){
        if(doctor!=null){
            doctorList.add(doctor);
            return true;
        }
        else{
            return false;
        }
    }

    public Doctor get(Integer id){
        return doctorList.stream()
                .filter(doctor-> doctor.getId()==id)
                .findFirst().orElse(null);
    }

    public Boolean update(Integer id, Doctor doctor){
        for(Doctor doc : doctorList){
            if(doc.getId() == id){
                int index = doctorList.indexOf(doc);
                doctorList.set(index, doctor);
                return true;
            }
        }
        return false;
    }

    public Boolean delete(Integer id){
        Doctor existingDoctor = doctorList.stream()
                .filter(doctor -> doctor.getId() == id)
                .findFirst().orElse(null);
        if(existingDoctor!=null){
            doctorList.remove(existingDoctor);
            return true;
        }
        else{
            return false;
        }
    }
}
