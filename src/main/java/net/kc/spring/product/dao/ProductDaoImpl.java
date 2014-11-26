package net.kc.spring.product.dao;

import java.util.Date;

import net.kc.spring.product.domain.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
@SuppressWarnings("deprecation")
public class ProductDaoImpl extends SqlMapClientDaoSupport implements ProductDao {
	private static final String NAMESPACE = "net.kc.spring.product.dao.ProductMapper";

	private static Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	@Qualifier("sqlMapClient")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		logger.debug("sqlMapClient: " + sqlMapClient);
		setSqlMapClient(sqlMapClient);
	}

	@Override
	public Product getById(Long id) {
		return (Product) getSqlMapClientTemplate().queryForObject(NAMESPACE + ".getById", id);
	}

	@Override
	public Long insert(Product product) {
		product.setCreateDate(new Date());
		getSqlMapClientTemplate().insert(NAMESPACE + ".insert", product);
		return product.getId();
	}

	@Override
	public void update(Product product) {
		product.setUpdateDate(new Date());
		getSqlMapClientTemplate().insert(NAMESPACE + ".update", product);
	}

	@Override
	public void save(Product product) {
		if (product.getId() == null) {
			insert(product);
		} else {
			update(product);
		}
	}

}
