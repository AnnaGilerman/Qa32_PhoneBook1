package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestNgMyListener implements ITestListener {

    Logger logger = LoggerFactory.getLogger(TestNgMyListener.class);

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }
}
