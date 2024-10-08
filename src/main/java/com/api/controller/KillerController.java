package com.api.controller;

import com.api.payload.KillerDto;
import com.api.service.KillerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/killer")
public class KillerController{
    @Autowired
    private KillerService killerService;
    @PostMapping
    public ResponseEntity<?> saveKiller(@Valid@RequestBody KillerDto killerDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
        }
        KillerDto dto = killerService.saveKiller(killerDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<KillerDto>> getAll(){
        List<KillerDto> dtos = killerService.getAll();
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<KillerDto> getKillerById(@PathVariable long id){
        KillerDto dto = killerService.getKillerById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteKiller(@RequestParam long id){
        killerService.deleteKiller(id);
        return new ResponseEntity<>("Record is deleted....",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<KillerDto> updateKiller(@PathVariable long id,@RequestBody KillerDto killerDto){
        KillerDto dto  = killerService.updateKiller(id,killerDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
