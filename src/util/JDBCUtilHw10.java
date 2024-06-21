package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JDBCUtilHw10 {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
		
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
				
			rd.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	
	public static SqlSession getSqlSession(boolean autoCommit) {
		return sqlSessionFactory.openSession(autoCommit);
	}
	
}
