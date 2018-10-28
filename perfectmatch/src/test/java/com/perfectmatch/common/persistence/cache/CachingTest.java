package com.perfectmatch.common.persistence.cache;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import com.goyello.esa.model.Message;
import com.goyello.esa.storage.MessageStorage;
import com.goyello.esa.web.controllers.MessageController;

import net.sf.ehcache.CacheManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-context-test.xml" })
public class CachingTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	CacheManager cacheManager;
	
	MessageStorage storage;
	
	MessageStorage storageDelegate;
	
	MessageController controller;
	
	
	@Before
	public void before() throws Exception {
		storageDelegate = Mockito.mock(MessageStorage.class);
		storage = (MessageStorage) context.getBean("messageStorage");
		storage.setDelegate(storageDelegate);
		controller = new MessageController(storage);
		
		cacheManager.clearAll();
	}
	
	@Test
	public void testCaching_MessagesCache() {
		StopWatch sw = new org.springframework.util.StopWatch();

		sw.start("getAllMessages-1"); // Start a named task
		controller.getAllMessages();
		sw.stop();
		
		sw.start("getAllMessages-2"); // Start a named task
		controller.getAllMessages();
		sw.stop();

		verify(storageDelegate, times(1)).findAllMessages();
		print(sw);
	}
	
	private void print(StopWatch sw ) {

		System.out.println("Total time in milliseconds for all tasks :\n" + sw.getTotalTimeMillis());
		System.out.println("Table describing all tasks performed :\n" + sw.prettyPrint());

		System.out.println("\n Array of the data for tasks performed � Task Name: Time Taken");
		TaskInfo[] listofTasks = sw.getTaskInfo();
		for (TaskInfo task : listofTasks) {
		    System.out.format("[%s]:[%d]\n", task.getTaskName(), task.getTimeMillis());
		}
	}
	
	@Test
	public void testCaching_MessagesCacheRemove() {
		StopWatch sw = new org.springframework.util.StopWatch();
		
		sw.start("getAllMessages-1"); // Start a named task
		controller.getAllMessages();
		sw.stop(); 
		
		sw.start("getAllMessages-2"); // Start a named task
		controller.getAllMessages();
		sw.stop(); 

		sw.start("addMessage-1"); // Start a named task
		controller.addMessage(new Message());
		sw.stop(); 
		
		sw.start("getAllMessages-3"); // Start a named task
		controller.getAllMessages();
		sw.stop(); 
		
		verify(storageDelegate, times(2)).findAllMessages();
		verify(storageDelegate, times(1)).addMessage(any(Message.class));
		print(sw);
	}
	
	@Test
	public void testCaching_MessageCache() {
		StopWatch sw = new org.springframework.util.StopWatch();
		sw.start("getMessageById-1"); // Start a named task

		controller.getMessageById(1);
		sw.stop(); 
		
		sw.start("getMessageById-2"); // Start a named task
		controller.getMessageById(1);
		sw.stop(); 
		
		sw.start("addMessage-1"); // Start a named task
		controller.addMessage(new Message());
		sw.stop();
		
		sw.start("getMessageById-3"); // Start a named task
		controller.getMessageById(1);
		sw.stop(); 

		verify(storageDelegate, times(1)).findMessage(1);
		verify(storageDelegate, times(1)).addMessage(any(Message.class));
		print(sw);
	}
	
}
