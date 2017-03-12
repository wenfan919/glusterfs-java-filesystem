package objectstack.repository.impl;

import objectstack.api.Message;
import objectstack.api.MessageRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tangfeixiong on 3/12/17.
 * https://github.com/tangfeixiong/osev3-examples/tree/master/spring-boot/sample-microservices-springboot/repositories-mem
 */
public class InMemoryMessageRepository implements MessageRepository {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<Long, Message>();

    @Override
    public List<Message> findAll() {
        System.out.println("InMemoryMessageRepository.findAll");
        return new ArrayList<Message>(this.messages.values());
    }

    @Override
    public Iterable<Message> findAllIt() {
        System.out.println("InMemoryMessageRepository.findAllIt");
        return this.messages.values();
    }

    @Override
    public Message save(Message message) {
        System.out.println("InMemoryMessageRepository.save[pre]: " + message);
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        System.out.println("InMemoryMessageRepository.save[post]: " + message);
        this.messages.put(id, message);
        return message;
    }

    @Override
    public Message findMessage(Long id) {
        System.out.println("InMemoryMessageRepository.findMessage: " + id);
        return this.messages.get(id);
    }

    @Override
    public void delete(Long id) {
        System.out.println("InMemoryMessageRepository.delete: " + id);
        messages.remove(id);
    }
    
    /*
     * https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-web-mustache
     */
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	private static class ServiceUnavailableException extends RuntimeException {

	}

	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	private static class InsufficientStorageException extends RuntimeException {

	}

    /*
     * https://github.com/spring-projects/spring-boot/blob/master/spring-boot-samples/spring-boot-sample-web-ui
     */
    @Override
    public void deleteObject(Long id) {
        throw new RuntimeException("RepositoryFactory.delete: " + id);
    }

    @Override
    public void deleteContainer(Long id) {
    	throw new ServiceUnavailableException();
    }
    
    @Override
    public void deleteAccount(Long id) {
    	throw new InsufficientStorageException();
    }
}
