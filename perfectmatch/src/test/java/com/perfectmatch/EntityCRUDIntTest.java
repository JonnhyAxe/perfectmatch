
import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import com.natixis.etrading.fxhub.dao.jpa.JpaGenericDao;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/natixis/etrading/fxhub/lucene/IntTest-Dev-context.xml" })
public abstract class EntityCRUDIntTest<T, ID> extends JpaGenericDao<T, Serializable> {
	
	protected T entity;
	
	public EntityCRUDIntTest(Class<T> type) {
		super(type);
	}

	
	@Before
	public void initialize() {
		this.buildEntity();
		Assert.assertNotNull(getType() + " entity is null. Please implement buildEntity()", entity);
	}

	@Transactional
	@Test
	public void entityCRUDTest(){	

		create(entity);
		Serializable id = getID();
		Assert.assertNotNull(getType() + " entity's ID is null. Please implement getID()", id);

		T created = read(id);
		Assert.assertEquals(getType() + " entity is not equal", entity, created);

		updateEntity();
		update(entity);
		T updated = read(id);
		Assert.assertEquals(getType() + " entity is correctly updated", entity, updated);

		delete(entity);
		T deleted = read(id);
		Assert.assertNull(getType() + " entity was not deleted", deleted);
		
	}
	
	
	public abstract void buildEntity();
	public abstract Serializable getID();
	public abstract void updateEntity();
	
	
}
