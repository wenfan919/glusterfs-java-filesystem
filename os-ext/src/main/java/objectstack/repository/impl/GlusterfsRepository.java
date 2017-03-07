package objectstack.repository.impl;

/**
 * Created by tangfeixiong (tangfx128@gmail.com) on 3/6/17.
 */
import objectstack.api.Message;
import objectstack.api.Repository;

import java.nio.file.spi.FileSystemProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author TangFeiXiong
 */
public class GlusterfsRepository implements Repository {

    public static FileSystemProvider getProvider(String scheme) {
        for (FileSystemProvider fsp : FileSystemProvider.installedProviders()) {
            if (fsp.getScheme().equals(scheme)) {
                return fsp;
            }
        }
        throw new IllegalArgumentException("No provider found for scheme: " + scheme);
    }

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

}
