package com.inject.famoso.api.famoso.services;

//import com.inject.famoso.api.famoso.repositories.FamosoRepository;
import com.inject.famoso.api.famoso.dto.FamosoDto;
import com.inject.famoso.api.famoso.entity.FamosoEntity;
import com.inject.famoso.api.famoso.repositories.FamosoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamosoServicelmpl implements FamosoService{
    @Autowired
    FamosoRepository famosoRepository;
    @Override
    public List<FamosoDto> listFamosos() {
        List<FamosoEntity> famosoEntities = famosoRepository.listFamosos();

        return famosoEntities.stream().map(entity ->
                entityToDto(entity)
        ).toList();
    }

    private FamosoDto entityToDto(FamosoEntity famosoEntity){
        if(famosoEntity == null) return null;

        return FamosoDto
                .builder()
                .id(famosoEntity.getId())
                .superhero(famosoEntity.getSuperhero())
                .publisher(famosoEntity.getPublisher())
                .alter_ego(famosoEntity.getAlter_ego())
                .first_appearance(famosoEntity.getFirst_appearance())
                .characters(famosoEntity.getCharacters())
                .alt_img(famosoEntity.getAlt_img())
                .build();
    }

}
