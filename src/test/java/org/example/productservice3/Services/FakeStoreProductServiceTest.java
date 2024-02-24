package org.example.productservice3.Services;

import org.example.productservice3.Clients.FakeStore.Client.FakeStoreApiClient;
import org.example.productservice3.Clients.FakeStore.Dtos.FakeStoreClientProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoreProductServiceTest {

    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;

    //THIS IS NEITHER A UNIT TEST, NOR AN INTEGRATION TEST
    //HERE WE HAVE CREATED A WRAPPER WHICH IS FAKESTORECLIENT AND CALLING IT
    //WE SHOULD BE CREATING FAKESTORECLIENTTEST CLASS IN WHICH WE WILL BE
    //TESTING CONNECTIVITY AND RESPONSE FROM FAKESTORE
    @Test
    public void Test_GetProductsFromFakeStroreApiClient() {
        FakeStoreClientProductDto product = fakeStoreApiClient.getProduct(1L);
        assertNotNull(product);
    }
}