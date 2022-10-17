package be.abis.exercise.service;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;

public class AbisPaymentService implements PaymentService {

    @Override
    public String paySalary(Person person) throws SalaryTooLowException {
        double net = person.calculateNetSalary();
        return "Paying " + net + "€ to " + person.getFirstName();
    }
}
