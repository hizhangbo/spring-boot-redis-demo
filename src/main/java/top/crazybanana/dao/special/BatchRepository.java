package top.crazybanana.dao.special;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * 数据库批量操作
 * EntityManagerFactory (对应 Hibernate 中的 SessionFactory)。
 * EntityManager (对应 Hibernate 中的Session)。
 *
 * @Author: zhangbo
 * @DateTime: 2019/2/22 14:43
 */
@Slf4j
@Repository
public class BatchRepository<T> {

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private Integer batchSize;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    private EntityTransaction entityTransaction;

    /**
     * 批量新增
     */
    public void batchInsert(List<T> entities) {
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            for (int i = 0; i < entities.size(); i++) {
                entityManager.persist(entities.get(i));

                if (i % batchSize == 0 && i > 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
            entityTransaction.commit();
        } catch (RuntimeException ex) {
            entityTransaction.rollback();
            log.error("批量新增运行时错误", ex);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    /**
     * 批量更新
     */
    public void batchUpdate(List<T> entities) {
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            for (int i = 0; i < entities.size(); i++) {
                T entity = entities.get(i);
                entity = entityManager.merge(entity);
                entityManager.persist(entity);

                if (i % batchSize == 0 && i > 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
            entityTransaction.commit();
        } catch (RuntimeException ex) {
            entityTransaction.rollback();
            log.error("批量更新运行时错误", ex);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}