import org.junit.Test;
import service.CEPService;

public class backendTest {

    @Test
    public void wsTest() {

        CEPService service = new CEPService();

        System.out.print(service.consultar("03311111"));

    }

}
