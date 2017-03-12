package objectstack.repository.impl;

/*
 * # HTTP multipart/form-data upload
 * - https://github.com/spring-guides/gs-uploading-files
 * # HTTP status code / Java Runtime Exception
 * - https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-web-mustache
 * # POJO Service
 * - https://github.com/spring-projects/spring-boot/blob/master/spring-boot-samples/spring-boot-sample-web-ui
 */
import objectstack.api.Message;
import objectstack.api.StorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 *  Created by tangfeixiong (tangfx128@gmail.com) on 3/6/17.
 */
public class Glusterfs implements StorageService {
	private static final Logger logger = LoggerFactory
			.getLogger(Glusterfs.class);

	private final Path glusterHost;
	private final String glusterAddr;
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<Long, Message>();

    public static FileSystemProvider getProvider(String scheme) {
        for (FileSystemProvider fsp : FileSystemProvider.installedProviders()) {
            if (fsp.getScheme().equals(scheme)) {
                return fsp;
            }
        }
        throw new IllegalArgumentException("No provider found for scheme: " + scheme);
    }

    public Glusterfs() {
    	try {
	        Properties properties = new Properties();
	        properties.load(Glusterfs.class.getClassLoader().getResourceAsStream("application.properties"));
	
	        String scheme = properties.getProperty("storage.fss");
	        if (null == scheme || "gluster" != scheme.toLowerCase() || "glusterfs"  != scheme.toLowerCase()) {
	        	glusterHost = Paths.get("/tmp");
	        	glusterAddr = "";
	        	return; 
	        }
	        
	        String vagrantBox = properties.getProperty("glusterfs.server");
	        String volname = properties.getProperty("glusterfs.volume");
	        String location = properties.getProperty("storage.location");
	
	        System.out.println(getProvider("gluster").toString());
	
	        String mountUri = "gluster://" + vagrantBox + ":" + volname + "/";
	        String testUri = "gluster://" + vagrantBox + ":" + volname + "/" + location;
	        Path mountPath = Paths.get(new URI(mountUri));
	        logger.debug(mountPath.toString());
	        logger.debug(testUri);
	
	        FileSystem fileSystem = FileSystems.newFileSystem(new URI(mountUri), null);
	        FileStore store = fileSystem.getFileStores().iterator().next();
	        System.out.println("TOTAL SPACE: " + store.getTotalSpace());
	        System.out.println("USABLE SPACE: " + store.getUsableSpace());
	        System.out.println("UNALLOCATED SPACE: " + store.getUnallocatedSpace());
	        System.out.println(fileSystem.toString());
	 
	        Path glusterPath = Paths.get(new URI(testUri));
	        System.out.println(glusterPath.getClass());
	        System.out.println(glusterPath);
	        System.out.println(glusterPath.getFileSystem().toString());
	        
	        this.glusterHost = mountPath;
	        this.glusterAddr = testUri;
    	} catch (URISyntaxException e) {
        	throw new StorageException("Failed to locate storage ", e);
    	} catch (IOException e) {
        	throw new StorageException("Failed to locate storage ", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
    	logger.info(file.toString());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            Path glusterPath = Paths.get(new URI(glusterAddr));
//            Path copyPath = glusterPath.resolveSibling("copy");
            Path copyPath = glusterPath.resolve(file.getOriginalFilename());
//            Files.createFile(copyPath, PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-rw-rw-")));
//            Files.copy(glusterPath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file.getInputStream(), copyPath, StandardCopyOption.REPLACE_EXISTING);
            long copySize = Files.size(copyPath);
            System.out.println("Source are copied by" + copySize + " bytes.");
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        } catch (URISyntaxException e) {
        	throw new StorageException("Failed to locate storage " + glusterAddr, e);
        }
    }

    @Override
    public void storeAll(MultipartFile[] files) {
    	Arrays.stream(files).forEach(file -> store(file));
    }

    @Override
    public Stream<Path> loadAll() {
        try {
        	Path glusterPath = Paths.get(new URI(glusterAddr));
            return Files.walk(glusterPath, 1)
                    .filter(path -> !path.equals(glusterPath))
                    .map(path -> glusterPath.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        } catch (URISyntaxException e) {
        	throw new StorageException("Failed to locate storage " + glusterAddr, e);
        }

    }

    @Override
    public Path load(String filename) {
    	try {
    	    Path glusterPath = Paths.get(new URI(glusterAddr));
            return glusterPath.resolve(filename);
    	} catch (URISyntaxException e) {
    		throw new StorageException("Failed to locate storage " + glusterAddr, e);
    	}
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
    	if ( 0 == glusterAddr.length()) return;
    	try {
	    	Path glusterPath = Paths.get(new URI(glusterAddr));
	    	Files.walk(glusterPath, 1)
	    	    .filter(path -> !path.equals(glusterPath))
	    	    .map(Path::toFile)
	    	    .forEach(FileSystemUtils::deleteRecursively);
        } catch (IOException e) {
            throw new StorageException("Failed to delete store", e);
    	} catch ( URISyntaxException e ) {
    		throw new StorageException("Failed to locate storage " + glusterAddr, e);
    	}
    }
    
    @Override
    public void init() {
    	if ( 0 == glusterAddr.length()) return; 
    	try {
    	    Path glusterPath = Paths.get(new URI(glusterAddr));
    	    if (!Files.exists(glusterPath)) {
	            Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rwx------");
	            FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(posixFilePermissions);
	            Files.createDirectory(glusterPath, attrs);
	        }
    	} catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
    	} catch ( URISyntaxException e ) {
    		throw new StorageException("Failed to locate storage " + glusterAddr, e);
        }
    }
}
