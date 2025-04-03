package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Models {

    private static RequestSpecification request;

    public static void setUpHeaders() {
        request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 8f5976736de5afcf1469d286af2a46abcc866e843b6cc0306fd7dc60f5035206");
    }

    public static Response getListUsers(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }

    public static Response postNewUsers(String endpoint) {
        String name = "Test Name";
        String gender = "male";
        String email = Utility.generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response postNewUserUsingExistingEmail(String endpoint, String existingEmail) {
        String name = "Test Name";
        String gender = "male";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", existingEmail);
        payload.put("status", status);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response postNewUserUsingInvalidGenderAndStatus(String endpoint) {
        String name = "Test Name";
        String gender = "helicopter";
        String email = Utility.generateRandomEmail();
        String status = "offline";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_id) {
        setUpHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response patchUpdateUser(String endpoint, String user_id) {
        setUpHeaders();

        String name = "Ahmad Husain Edit";
        String gender = "male";
        String email = Utility.generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response getListSpecificUser(String endpoint, String user_id) {
        setUpHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().get(finalEndpoint);
    }

    public static Response getListInvalidUser(String endpoint) {
        setUpHeaders();
        String user_id = Utility.generateRandomUserId();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().get(finalEndpoint);
    }

    public static Response deleteInvalidUser(String endpoint) {
        setUpHeaders();
        String user_id = Utility.generateRandomUserId();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }
}
