package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Test;

import pojo.User;
import util.MyBatisUtil;

public class UserDaoTest {
	private Logger logger = (Logger)LogManager.getLogger();
	@Test
	public void countTest() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			sqlSession.selectOne("dao.UserMapper.count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSesion(sqlSession);
			//关闭
		}
		
		
	}
	////
	
	
	@Test
	public void addTest() {
		
		SqlSession sqlSession = null;
		
		try {
			User user = new User();
			user.setUserCode("bcubbo");
			user.setUserName("bo");
			user.setUserPassword("bcubbo");
			sqlSession = MyBatisUtil.createSqlSession();
			sqlSession.insert("dao.UserMapper.add",user);
			sqlSession.commit();
		}catch(Exception e) {
			logger.debug("添加失败");
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			
			MyBatisUtil.closeSqlSesion(sqlSession);
			logger.debug("添加成功关闭成功");
			
		
		}
	}
	
	@Test
	public void updateTest() {
		SqlSession sqlSession = null;
		
		try {
			User user = new User();
			user.setId(37);
			user.setUserCode("userCode001");
			user.setUserName("bcubbo0");
			user.setUserPassword("123455");
			sqlSession = MyBatisUtil.createSqlSession();
			sqlSession.update("dao.UserMapper.update",user);
			sqlSession.commit();
			logger.debug("update方法提交成功");
			
		} catch (Exception e) {
			logger.debug("update方法更新失败");
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			logger.debug("update方法关闭成功");
			MyBatisUtil.closeSqlSesion(sqlSession);
		}
	}
	
	@Test
	public void deleteTest() {
		SqlSession sqlSession = null;
		try {
			User user = new User();
			user.setId(41);
			sqlSession = MyBatisUtil.createSqlSession();
			sqlSession.delete("dao.UserMapper.delete",user);
			sqlSession.commit();
			logger.debug("delete提交成功");
		} catch (Exception e) {
			logger.debug("delete方法删除失败");
			e.printStackTrace();
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			logger.debug("delete方法关闭成功");
			MyBatisUtil.closeSqlSesion(sqlSession);
		}
	}

}
