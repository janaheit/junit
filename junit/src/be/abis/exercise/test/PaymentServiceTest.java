package be.abis.exercise.test;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisPaymentService;
import be.abis.exercise.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    private PaymentService service;

    @BeforeEach
    void setUp(){
        service = new AbisPaymentService();
    }

    @Mock
    private Person mockPerson;

    @Test
    public void paymentWorks() throws SalaryTooLowException {
        when(mockPerson.getFirstName()).thenReturn("Jana");
        when(mockPerson.calculateNetSalary()).thenReturn(1750.0);
        assertEquals("Paying 1750.0€ to Jana", service.paySalary(mockPerson));
    }

    @Test
    public void throwsExceptionWhenPaymentGoesWrong() throws SalaryTooLowException {
        when(mockPerson.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        assertThrows(SalaryTooLowException.class, () -> service.paySalary(mockPerson));
    }
}