package objectstack.api;

import java.util.List;

/**
 * Created by tangfeixiong on 3/6/17.
 * https://github.com/tangfeixiong/osev3-examples/tree/master/spring-boot/sample-microservices-springboot/repositories-mem
 */
public interface MessageRepository {
    List<Message> findAll();

    Iterable<Message> findAllIt();

    Message save(Message message);

    Message findMessage(Long id);

    void delete(Long id);
    
//	Iterable<Message> findAll();
//
//	Message save(Message message);
//
//	Message findMessage(Long id);
//
//	void deleteMessage(Long id);
	
	void deleteObject(Long id);
	
//    List<Container> findAllContainers();
//	
//	Iterable<Container> findAllContainersIt();
//	
//	Container renameContainer();
	
	void deleteContainer(Long id);
	
//	List<Account> findAllAccounts();
//	
//	Iterable<Account> findAllAccountsIt();

	void deleteAccount(Long id);
}