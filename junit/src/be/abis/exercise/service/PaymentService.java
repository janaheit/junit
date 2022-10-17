package be.abis.exercise.service;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;

public interface PaymentService {
    String paySalary(Person person) throws SalaryTooLowException;
}
