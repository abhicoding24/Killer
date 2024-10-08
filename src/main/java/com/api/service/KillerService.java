package com.api.service;

import com.api.entity.Killer;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.KillerDto;
import com.api.repository.KillerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KillerService{
    @Autowired
    private KillerRepository killerRepository;
    @Autowired
    private ModelMapper modelMapper;
    Killer mapToEntity(KillerDto dto){
        Killer killer = modelMapper.map(dto,Killer.class);
        return killer;
    }
    KillerDto mapToDto(Killer k){
        KillerDto dto = modelMapper.map(k,KillerDto.class);
        return dto;
    }
    public KillerDto saveKiller(KillerDto dto){
        Killer k = killerRepository.save(mapToEntity(dto));
        return mapToDto(k);
    }
    public List<KillerDto> getAll(){
        List<Killer> killers = killerRepository.findAll();
        List<KillerDto> dtos = killers.stream().map(a->mapToDto(a)).collect(Collectors.toList());
        return dtos;
    }
    public KillerDto getKillerById(long id){
        Killer k =killerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Record is not present"));
        return mapToDto(k);
    }
    public void deleteKiller(long id){
        killerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Record is not present"));
        killerRepository.deleteById(id);
    }
    public KillerDto updateKiller(long id, KillerDto dto){
        Killer k = killerRepository.findById(id).get();
        k.setName(dto.getName());
        k.setEmail(dto.getEmail());
        k.setMobile(dto.getMobile());
        Killer killer = killerRepository.save(k);
        return mapToDto(killer);
    }
}
