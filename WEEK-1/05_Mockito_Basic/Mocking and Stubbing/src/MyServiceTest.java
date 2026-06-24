import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        // 1. Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject mock into service
        MyService service = new MyService(mockApi);

        // 4. Call method
        String result = service.fetchData();

        // 5. Assert result
        assertEquals("Mock Data", result);
    }
}