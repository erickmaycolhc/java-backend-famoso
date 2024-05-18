package com.inject.famoso.api.famoso.controllers;

import com.inject.famoso.api.famoso.dto.FamosoDto;
import com.inject.famoso.api.famoso.dto.Response;
import com.inject.famoso.api.famoso.services.FamosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/famoso/v1")
public class famosoController {
    @Autowired
    FamosoService famosoService;
    @GetMapping("famosos")
    public Response<List<FamosoDto>> listFamosos(){
        List<FamosoDto> famosoDto = famosoService.listFamosos();
        if(famosoDto.size() == 0){
            return new Response<List<FamosoDto>>().setMessage("No se encontro resultados");
        }
        System.out.println("famosos==> " + famosoDto);
        return new Response<List<FamosoDto>>().setData(famosoDto).setMessage("Se encontro resultados");

    }
}
