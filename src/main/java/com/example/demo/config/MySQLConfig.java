package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("com.example.demo.persistence") // 연결할 DAO 인터페이스를 담은 패키지 등록
public class MySQLConfig {

	
	
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        
		// SqlSessionFactory : Mysql과 Mybatis를 연결해주는 객체
		// SqlSessionFactoryBean : SqlSessionFactory 를 생성해주는 클래스
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		// setDataSource : 앞에서 정의한 datasource를 참조하게 한다.
        sessionFactory.setDataSource(dataSource);

        // PathMatchingResourcePatternResolver : 위치 검색을 돕는 Spring calss
        // getResources()로 경로 검색을 해서 SqlSessionFactory 에 mapper 와 mybatis-config를 set해준다
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));

        // classpath : resource 폴더를 나타냄
        // 여기서 언급되는 myBatisConfig는 말 그대로 Mybatis 설정 파일으로 필수는 아니지만 Mybatis 설정을 위해 생성해주는 편이 좋다.
        // resource폴더 아래에 mybatis-config.xml 을 생성해줬다.
     
        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
        sessionFactory.setConfigLocation(myBatisConfig);

        return sessionFactory.getObject();
    }
}
