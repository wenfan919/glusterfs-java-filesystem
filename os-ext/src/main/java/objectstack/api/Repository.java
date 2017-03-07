package objectstack.api;

import java.util.List;

/**
 * Created by tangfeixiong on 3/6/17.
 */
public interface Repository {

    List<Message> findAll();

    Iterable<Message> findAllIt();

    Message save(Message message);

    Message findMessage(Long id);

    void delete(Long id);

    Container newContainer();
	
    List<Container> findAllContainers();
	
	Iterable<Container> findAllContainersIt();
	
	Container renameContainer();
	
	boolean removeContainer();
	
	List<Account> findAllAccounts();
	
	Iterable<Account> findAllAccountsIt();
}