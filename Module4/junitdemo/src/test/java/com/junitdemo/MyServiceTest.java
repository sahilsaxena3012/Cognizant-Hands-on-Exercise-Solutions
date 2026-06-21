package com.junitdemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test

    public void testVerifyInteraction() {

        // create mock

        ExternalApi mockApi =

                mock(ExternalApi.class);

        // inject mock

        MyService service =

                new MyService(mockApi);

        // call method

        service.fetchData();

        // verify call happened

        verify(mockApi)

                .getData();

    }

    @Test

    public void testExternalApi() {

        // Step 1: Create Mock

        ExternalApi mockApi =

                mock(ExternalApi.class);

        // Step 2: Stubbing

        when(
                mockApi.getData())

                .thenReturn(
                        "Mock Data");

        // Step 3: Use Mock

        MyService service =

                new MyService(mockApi);

        String result =

                service.fetchData();

        // Assertion

        assertEquals(

                "Mock Data",

                result

        );

    }

}