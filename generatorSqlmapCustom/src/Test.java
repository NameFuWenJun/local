import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.mapper.DataExportMapper;
import com.itheima.mybatis.mapper.LinkInfoMapper;
import com.itheima.mybatis.pojo.DataExport;
import com.itheima.mybatis.pojo.LinkInfo;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataExportMapper dataExportMapper = ac.getBean(DataExportMapper.class);
       /* DataExport example = new DataExport();
        example.setRuleId("1");
        example.setEndTime(new Date());
        example.setAppend((short)1);
        example.setExportType((short) 1);
        example.setInstanceId("1");
        example.setStarterId("1");
        example.setTableName("test");
        example.setStartTime(new Date());
        dataExportMapper.insert(example);*/
        LinkInfoMapper infoMapper=ac.getBean(LinkInfoMapper.class);
        LinkInfo info=new LinkInfo();
        info.setLinkId("1");
        info.setLinkName("test");
        info.setTestTable("testTable");
        info.setTestUrl("testUrl");
        info.setUrlPattern("urlpattern");
        infoMapper.insert(info);
        
    }
}
