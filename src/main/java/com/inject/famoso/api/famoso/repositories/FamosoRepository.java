package com.inject.famoso.api.famoso.repositories;

import com.inject.famoso.api.famoso.entity.FamosoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamosoRepository extends JpaRepository<FamosoEntity,Integer> {
    @Query(value = "SELECT * FROM FAMOSOS", nativeQuery = true)
    List<FamosoEntity> listFamosos();
}
