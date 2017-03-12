package objectstack.api;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by tangfeixiong on 3/11/17.
 */
public interface StorageService {
	
	void init();

    void store(MultipartFile file);

    void storeAll(MultipartFile[] files);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);
    
    void deleteAll();

}