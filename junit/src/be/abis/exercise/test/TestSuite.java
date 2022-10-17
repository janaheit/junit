package be.abis.exercise.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PersonTest.class, AddressTest.class})
public class TestSuite {
}
