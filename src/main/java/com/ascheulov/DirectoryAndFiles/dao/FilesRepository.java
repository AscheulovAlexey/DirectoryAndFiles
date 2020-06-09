package com.ascheulov.DirectoryAndFiles.dao;

import com.ascheulov.DirectoryAndFiles.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Long> {

    public List<Files> findByPath(String path);

}
