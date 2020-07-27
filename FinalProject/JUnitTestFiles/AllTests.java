package TestSuiteChatClientSide;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ClientSideTest.class,LoginOnly.class,SignUpTest.class,ServerSideTests.class})
public class AllTests {

	
	
}
