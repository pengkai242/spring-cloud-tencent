/*
 * Tencent is pleased to support the open source community by making Spring Cloud Tencent available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.cloud.polaris.context;

import com.tencent.polaris.client.api.SDKContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PolarisContextApplication.class, properties = {
        "spring.config.location = classpath:application-test.yml"})
public class PolarisContextGetHostTest {

    @Autowired
    private SDKContext polarisContext;

    @Test
    public void testGetConfigHost() {
        String bindIP = polarisContext.getConfig().getGlobal().getAPI().getBindIP();
        Assert.assertFalse(StringUtils.isBlank(bindIP));
        Assert.assertNotEquals(bindIP, "127.0.0.1");
    }
}
