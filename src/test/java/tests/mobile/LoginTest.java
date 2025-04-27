package tests.mobile;


import base.BaseTest;
import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screen.mobile.LoginScreen;
import java.io.FileReader;
import java.util.List;

public class LoginTest extends BaseTest {

    @Test(priority = 3, dataProvider = "loginData")
    public void mobileNumberLogin(String phoneNumber, String otp) {
        LoginScreen verification = new LoginScreen(driver);
        verification.login(phoneNumber, otp);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        // Initialize CSVReader to read the file using try-with-resources
        try (CSVReader reader = new CSVReader(new FileReader(getClass().getResource("/Data-Driven/data.csv").getFile()))) {
            List<String[]> lines = reader.readAll();

            // Log all rows to see the data being read
            for (String[] row : lines) {
                System.out.println("Read row: " + String.join(",", row));
            }

            // Check if there are enough rows in the CSV file
            if (lines.size() < 2) {
                throw new RuntimeException("Insufficient data in CSV file. Expected at least two rows.");
            }

            // Initialize Object[][] with the correct size based on the number of rows in the CSV
            Object[][] data = new Object[lines.size() - 1][2];
            int dataIndex = 0;

            // Loop through each line (skip the header)
            for (int i = 1; i < lines.size(); i++) {
                String[] row = lines.get(i);

                // Skip empty rows or rows with fewer than two columns
                if (row.length < 2 || row[0].trim().isEmpty() || row[1].trim().isEmpty()) {
                    System.out.println("Skipping invalid row " + (i + 1) + ": " + String.join(",", row));
                    continue;
                }

                // Log the data for debugging
                System.out.println("Row " + (i + 1) + ": " + String.join(",", row));

                // Fill in the data array
                data[dataIndex][0] = row[0]; // Phone number
                data[dataIndex][1] = row[1]; // OTP
                dataIndex++;
            }

            // Return the data
            return data;
        }
    }
}
