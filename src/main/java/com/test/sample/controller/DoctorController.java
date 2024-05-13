package com.test.sample.controller;

import com.test.sample.dao.DoctorDAO;
import com.test.sample.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorDAO doctorDAO;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Doctor>> getDoctors(){
        return new ResponseEntity<List<Doctor>>(doctorDAO.list(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Boolean> create(@RequestBody Doctor doctor){
        return new ResponseEntity<Boolean>(doctorDAO.save(doctor), HttpStatus.CREATED);
    }

    @GetMapping(path = "/show/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Integer id){
        return new ResponseEntity<Doctor>(doctorDAO.get(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Boolean> create(@PathVariable Integer id, @RequestBody Doctor doctor){
        return new ResponseEntity<Boolean>(doctorDAO.update(id, doctor), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<Boolean>(doctorDAO.delete(id), HttpStatus.OK);
    }
}
