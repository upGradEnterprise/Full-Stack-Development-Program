import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite @SelectPackages({
        "com.zeta.testing.bean"
}) public class EmployeeEmailTestSuite {}