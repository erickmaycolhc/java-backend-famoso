package com.inject.famoso.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inject.famoso.api.famoso.entity.FamosoEntity;
import com.inject.famoso.api.famoso.repositories.FamosoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Component
public class FamosoDataLoader implements ApplicationRunner {
    @Autowired
    FamosoRepository famosoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Path file = ResourceUtils.getFile("classpath:data/famoso.json").toPath();
        String fileContent = new String(Files.readAllBytes(file));

        ObjectMapper objectMapper = new ObjectMapper();
        List<FamosoEntity> famosos = Arrays.asList(objectMapper.readValue(fileContent, FamosoEntity[].class));
        famosoRepository.saveAll(famosos);
    }
}
