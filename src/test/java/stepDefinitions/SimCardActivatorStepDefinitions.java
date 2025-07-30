package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import au.com.telstra.simcardactivator.dto.simDTO;
import au.com.telstra.simcardactivator.controller.simController;
import io.cucumber.java.en.*;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private simDTO requestDTO;
    private simDTO responseDTO;

    @Given("a SIM card with ICCID {string} and email {string}")
    public void a_sim_card_with_iccid_and_email(String iccid, String email) {
        requestDTO = new simDTO();
        requestDTO.setIccid(iccid);
        requestDTO.setCustomerEmail(email);
    }

    @When("I activate the SIM")
    public void i_activate_the_sim() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<simDTO> request = new HttpEntity<>(requestDTO, headers);

        ResponseEntity<simDTO> response = restTemplate.postForEntity(
                "http://localhost:8080/simActivate/",
                request,
                simDTO.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        responseDTO = response.getBody();
    }

    @Then("the activation response should be success")
    public void the_activation_response_should_be_success() {
        assertNotNull(responseDTO);
        assertTrue(responseDTO.getActive(), "Expected SIM to be active, but it was not.");
    }

    @Then("the activation response should be failure")
    public void the_activation_response_should_be_failure() {
        assertNotNull(responseDTO);
        assertFalse(responseDTO.getActive(), "Expected SIM to be inactive, but it was active.");
    }

    @And("querying the activation by ID {int} should return status {string}")
    public void querying_activation_by_id_should_return_status(int id, String expectedStatus) {
        ResponseEntity<simDTO> response = restTemplate.getForEntity(
                "http://localhost:8080/simActivate/" + id,
                simDTO.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        simDTO sim = response.getBody();
        assertNotNull(sim);

        boolean expectedActive = expectedStatus.equalsIgnoreCase("SUCCESS");
        assertEquals(expectedActive, sim.getActive(), "SIM activation status did not match expected.");
    }
}