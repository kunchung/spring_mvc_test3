package net.kc.spring.common.utils;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTemplateUtils {
	public static TransactionTemplate getTransactionTemplate(PlatformTransactionManager txManager, int propagationBehavior, int isolationLevel) {
		TransactionTemplate template = new TransactionTemplate(txManager);
		template.setPropagationBehavior(propagationBehavior);
		template.setIsolationLevel(isolationLevel);
		return template;
	}
	
	public static TransactionTemplate getDefaultTransactionTemplate(PlatformTransactionManager txManager) {
		return getTransactionTemplate(txManager, TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED);
	}
	
}
