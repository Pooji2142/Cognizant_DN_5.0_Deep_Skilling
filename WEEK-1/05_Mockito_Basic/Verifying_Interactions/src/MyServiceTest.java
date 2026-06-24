import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Step 1: create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: inject mock into service
        MyService service = new MyService(mockApi);

        // Step 3: call method
        service.fetchData();

        // Step 4: verify interaction
        verify(mockApi).getData();
    }
}