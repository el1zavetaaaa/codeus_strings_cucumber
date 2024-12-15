# Overview

You'll get acquainted with the cucumber framework, which is used for BDD testing. In this project you'll integrate cucumber scenarios with JUnit 4 framework.  

--------------------------------------------
# STEPS TO COMPLETE THE TASK 🎁

1. Create an empty class that uses the Cucumber JUnit runner.<br/>
The name of the class could be arbitrary. ✅<br/> 

<b>EXAMPLE</b><br/>
```
@RunWith(Cucumber.class)
@CucumberOptions(
   features = {"path/to/your/feature/package"},
   glue = {"path/to/your/step/definitions"},
   plugin = {"pretty", "html:target/cucumber-reports"}, #used for generating console logs
   dryRun = true #verified that all mappings have the corresponded steps
)
public class RunCucumberTest {
}
```
2. Complete instructions inside [managing_christmas_presents_positive_scenarios.feature](features%2Ffeatures%2Fmanaging_christmas_presents_positive_scenarios.feature) ✅.
3. Complete instructions inside [managing_christmas_presents_negative_scenarios.feature](features%2Ffeatures%2Fmanaging_christmas_presents_negative_scenarios.feature) ✅.
4. complete instructions inside [ManagingChristmasPresentsPositiveScenariosSteps.java](src%2Ftest%2Fjava%2Fthursday%2Fsteps%2FManagingChristmasPresentsPositiveScenariosSteps.java) ✅.

# CONGRATS! You finished the task! ❄️