package com.ascheulov.DirectoryAndFiles.controller;

import com.ascheulov.DirectoryAndFiles.entity.Directory;
import com.ascheulov.DirectoryAndFiles.entity.Files;
import com.ascheulov.DirectoryAndFiles.service.DirectoryService;
import com.ascheulov.DirectoryAndFiles.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final DirectoryService directoryService;
    private final FilesService filesService;

    @Autowired
    public MainController(DirectoryService directoryService, FilesService filesService) {
        this.directoryService = directoryService;
        this.filesService = filesService;
    }

    @GetMapping
    public String viewAllDirectories(Map<String, Object> model){
        List<Directory> allDirectories = directoryService.findAllDirectories();
        model.put("directories", allDirectories);

        return "main";
    }

    @PostMapping
    public String addNewDirectory(@RequestParam String path, Model model)  {
        Directory directory;
        try {
            directory = directoryService.addNewDirectory(path);
            model.addAttribute("directory", directory);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Неправильный путь или нет доступа. Введите другой путь.");
            return "main";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String deleteDirectory(@PathVariable Long id){
        directoryService.deleteDirectoryById(id);

        return "redirect:/";
    }

    @GetMapping("/{id}/files")
    public String getFiles(@PathVariable Long id, Model model){
        Directory directory = directoryService.findById(id);
        List<Files> allFiles = filesService.findByPath(directory.getPath());
        model.addAttribute("allFiles", allFiles);
        model.addAttribute("directory", directory);

        return "files";
    }




}
