package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;

public class Hooks extends BaseClass{
	@Before
	public void start_report(Scenario scenario) {
		create_report(scenario.getName());
	}

	@After
	public void end_test() {
		end_report();
		kill_driver();
	}

}
