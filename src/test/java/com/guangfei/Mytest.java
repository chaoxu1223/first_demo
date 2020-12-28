package com.guangfei;

import com.guangfei.business.entity.Party;
import com.guangfei.business.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {

    @Test
    public void mytest() {
        List<Party> parties = Arrays.asList(new Party(1, "工厂党", "张三01"),
                new Party(2, "工厂党", "张三02"),
                new Party(3, "工厂党", "张三03"),
                new Party(4, "过命党", "李四01"),
                new Party(5, "过命党", "李四02"),
                new Party(6, "过命党", "李四03"));
        /*Map<String, List<Party>> map = parties.stream().collect(Collectors.groupingBy(e -> e.getLeaderName()));
        parties.stream().sorted((x,y)->(y.getId().compareTo(x.getId()))).forEach(System.out::println);*/
        Map<String, String> collect = parties.stream().filter(e -> !StringUtils.isEmpty(e.getPartyName())).collect(Collectors.toMap(Party::getPartyName, Party::getLeaderName,(k1,k2)->k2));
        System.out.println("************");
    }

    @Test
    public void myTestService() {
        TestService testService = (a,b) -> a+b ;
        String VV = testService.myTestService("50","50");
        System.out.println(VV);
    }
}
