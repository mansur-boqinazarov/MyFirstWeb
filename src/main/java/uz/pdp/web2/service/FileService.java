package uz.pdp.web2.service;

import uz.pdp.web2.model.File;
import uz.pdp.web2.repository.FileRepository;

import java.util.List;

/**
 * @author Mansurbek Boqinazarov
 */
public class FileService{
    public static final FileRepository fileRepository = new FileRepository();
    public List<File> getAllFiles(){
        return fileRepository.getAll();
    }
    public int save(File file){
        return fileRepository.save(file);
    }
    public File get(int id){
        return fileRepository.get(id);
    }
}
