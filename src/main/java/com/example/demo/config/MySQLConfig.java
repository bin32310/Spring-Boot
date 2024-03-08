package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan("com.example.demo.persistence") // 연결할 DAO 인터페이스를 담은 패키지 등록
public class MySQLConfig {

	// SqlSessionFactory
	//  SqlSessionFactory는 마이바티스에서 핵심 역할을 하는 객체로
	//  데이터베이스 연결 및 SQL 실행을 관리한다.
	//  스프링부트와 마이바티스를 연동할 때 SqlSessionFactory를 빈으로 등록해야한다.
	@Bean(name ="sqlSessionFactory")
	@Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource")DataSource dataSource,
    											ApplicationContext applicationContext,
    											@Value("${mybatis.type-aliases-package}") String typeAliasesPackage,
                                                @Value("${mybatis.mapper-locations}") String mapperLocations,
                                                @Value("${mybatis.config-location}") String configLocation
    											) throws Exception {
        
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
        
        
        // alias 연결
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
       

        return sessionFactory.getObject();
    }
	

	
	
	// SqlSessionTemplate
	//  SqlSessionTemplate은 마이바티스에서 제공하는 SqlSession 인터페이스의 구현체로 
	//  SQL 실행 및 트랜잭션 관리를 담당한다.
	//  스프링 부트와 마이바티스를 연동할 때 SqlSessionTemplate 빈을 등록해야한다.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	
	// DataSourceTransactionManager  생성 - @Transactional 어노테이션을 사용하여 트랜잭션을 간편하게 관리할 수 있다.
	// 스프링에서 트랜잭션을 관리하기 위해 DataSourceTransactionManage을 이용하여 DataSource를 설정해야한다.
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}


}
