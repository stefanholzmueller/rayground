import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class SomethingTest {

    @Test
    public void something() {
        Assert.assertThat("rayground.engine", Is.is("rayground.engine"));
    }
}
