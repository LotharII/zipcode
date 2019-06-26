import com.zipcode.Utils;
import com.zipcode.ZipCodeProcessor;
import com.zipcode.entity.Range;
import org.junit.Test;
import com.zipcode.service.IOService;
import com.zipcode.service.ZipCodeService;
import com.zipcode.service.impl.IOServiceImpl;
import com.zipcode.service.impl.ZipCodeServiceImpl;
import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import java.util.List;

public class ZipCodeProcessorTest {

  @Test
  public void zipCodeProcessorOutputDataTest(){
    List<Range> list = new LinkedList<>(Utils.buildSuccessZipCodeRanges());
    String expected = "[10000,10100] [10050,10150] [20000,30100]";
    ZipCodeService zipCodeService = new ZipCodeServiceImpl();
    IOService ioService = new IOServiceImpl();
    ZipCodeProcessor processor = new ZipCodeProcessor(ioService, zipCodeService);
    String result = processor.prepareOutputData(list);
    assertEquals(expected, result);
  }
}
