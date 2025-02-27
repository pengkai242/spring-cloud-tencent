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

package com.tencent.cloud.polaris.discovery;

import static com.tencent.polaris.test.common.Consts.SERVICE_PROVIDER;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import com.tencent.cloud.polaris.pojo.PolarisServiceInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.cloud.client.ServiceInstance;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class PolarisDiscoveryClientTest {

    @Mock
    private PolarisServiceDiscovery polarisServiceDiscovery;

    @InjectMocks
    private PolarisDiscoveryClient client;

    @Test
    public void testGetInstances() {

        when(polarisServiceDiscovery.getInstances(anyString())).thenReturn(singletonList(mock(PolarisServiceInstance.class)));

        List<ServiceInstance> serviceInstances = client.getInstances(SERVICE_PROVIDER);

        assertThat(serviceInstances).isNotEmpty();
    }

    @Test
    public void testGetServices() {

        when(polarisServiceDiscovery.getServices()).thenReturn(singletonList(SERVICE_PROVIDER));

        List<String> services = client.getServices();

        assertThat(services).contains(SERVICE_PROVIDER).size().isEqualTo(1);

    }
}
