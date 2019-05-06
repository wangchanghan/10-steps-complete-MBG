package com.mybats;/*
 *@Description TODO 嘿嘿
 *@Date 2019/5/6 19:07
 *@CreateBy hunan
 */
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class GeneratorSqlMap {
    public void generator() throws Exception{
        List<String> warnings = new ArrayList<>();
        boolean overWrite = true;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis/generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        //根据加载的配置文件来解析
        Configuration configuration = configurationParser.parseConfiguration(inputStream);
        DefaultShellCallback defaultShellCallback=new DefaultShellCallback(overWrite);
        MyBatisGenerator generator = new MyBatisGenerator(configuration,defaultShellCallback,warnings);
        generator.generate(null);
    }
    public static void main(String[] args) {
        try {
            GeneratorSqlMap generatorSqlMap = new GeneratorSqlMap();
            generatorSqlMap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
