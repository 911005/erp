package com.eleadmin;


import com.eleadmin.SalesManagement.salesContract.service.SalescontractService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class EleAdminApplicationTests {
    @Resource
    private SalescontractService salescontractService;
    @Test
    public void contextLoads() {
    }

}
