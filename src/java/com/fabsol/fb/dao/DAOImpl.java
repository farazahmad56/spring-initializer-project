package com.fabsol.fb.dao;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class DAOImpl implements DAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    DataSourceTransactionManager transactionManager;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        setJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Override
    public List<Map<String, Object>> getData(String query) {
        return this.jdbcTemplate.queryForList(query);
    }

    @Override
    public boolean insertAll(String[] query, String userName) {
        boolean flag = false;
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = this.transactionManager.getTransaction(def);
        try {
            for (int i = 0; i < query.length; i++) {
                getJdbcTemplate().update(query[i]);
            }
            this.transactionManager.commit(status);
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.transactionManager.rollback(status);
        }
        return flag;
    }

    @Override
    public boolean insertAll(List<String> query, String userName) {
        boolean flag = false;
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = this.transactionManager.getTransaction(def);
        try {
            for (int i = 0; i < query.size(); i++) {
                getJdbcTemplate().update((String) query.get(i));
            }
            this.transactionManager.commit(status);
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.transactionManager.rollback(status);
        }
        return flag;
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
