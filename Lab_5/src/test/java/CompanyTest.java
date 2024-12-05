import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {
    private static Company company;

    @BeforeAll
    public static void setUp() {
        company = new Company("Test Company", "TC", "15.05.2000", "100", "IT", "Software Development");
    }

    @Test
    public void testFindCompanyByShortTitle() {
        assertTrue(company.FindCompany("TC", 1));
        assertFalse(company.FindCompany("BT", 1));
    }

    @Test
    public void testFindCompanyByBranch() {
        assertTrue(company.FindCompany("IT", 2));
        assertFalse(company.FindCompany("Finance", 2));
    }

    @Test
    public void testFindCompanyByActivity() {
        assertTrue(company.FindCompany("Software Development", 3));
        assertFalse(company.FindCompany("Data Analysis", 3));
    }

    @Test
    public void testIsBetweenEmployee() {
        assertTrue(company.isBetweenEmployee("50", "150"));
        assertFalse(company.isBetweenEmployee("101", "150"));
    }

    @Test
    public void testIsBetweenDate() {
        assertTrue(company.isBetweenDate("01.01.1999", "01.01.2021"));
        assertFalse(company.isBetweenDate("01.01.2001", "01.01.2005"));
    }

    @Test
    public void testInvalidDateFormat() {
        // Проверка на некорректный формат даты
        company = new Company("Test Company", "TC", "111.2.1000", "100", "IT", "Software Development");
        assertFalse(company.isBetweenDate("01.01.1999", "01.01.2021"));
    }
}