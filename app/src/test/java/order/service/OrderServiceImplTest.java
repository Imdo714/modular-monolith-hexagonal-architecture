package order.service;

import com.modular.EcommerceApplication;
import com.modular.service.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = EcommerceApplication.class)
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @DisplayName("통합 : 회원이 존재하면 주문저장")
    @Test
    void createOrder() {
        // given

        // when & then
        assertDoesNotThrow(() -> orderServiceImpl.createOrder());
    }

}
