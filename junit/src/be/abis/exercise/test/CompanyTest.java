package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company belgian;

    @BeforeEach
    void setUp(){
        Address belgianAddress = new Address("Rue de Bourgogne", "99", "1190", "Bruxelles", "Belgique", "BE");
        belgian = new Company("Janas company", belgianAddress);

    }

    @Test
    public void taxForBelgianCompanyShouldBe51(){
        assertEquals(51.0, belgian.calculateTaxToPay());
    }

}