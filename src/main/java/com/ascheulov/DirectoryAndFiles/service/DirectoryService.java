package com.ascheulov.DirectoryAndFiles.service;

import com.ascheulov.DirectoryAndFiles.dao.DirectoryRepository;
import com.ascheulov.DirectoryAndFiles.entity.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DirectoryService {

    private final DirectoryRepository directoryRepository;
    private final FilesService filesService;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository, FilesService filesService) {
        this.directoryRepository = directoryRepository;
        this.filesService = filesService;
    }

    public List<Directory> findAllDirectories(){
        return directoryRepository.findAll();
    }
    
    public Directory findById(Long id){
        return directoryRepository.findById(id).get();
    }

    public Directory addNewDirectory(String path) throws IOException {

        Directory directory = new Directory();
        directory.setDate(new Date());
        directory.setPath(path);
        directory.setAmount(new File(path).list().length);

        Path folder = Paths.get(path);
        long size = Files.walk(folder)
                .filter(s -> s.toFile().isFile())
                .mapToLong(s -> s.toFile().length())
                .sum();

        directory.setSize(size/1024);
        filesService.saveFiles(path);

        List<com.ascheulov.DirectoryAndFiles.entity.Files> allFiles = filesService.findByPath(path);
        directory.setFiles(allFiles);
        directoryRepository.save(directory);

        return directory;
    }

    public void deleteDirectoryById(Long id){
        directoryRepository.deleteById(id);
    }
}
