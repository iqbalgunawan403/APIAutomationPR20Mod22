Feature: REST API Automation Test

  @api @get @positive
  Scenario: Test GET list data users normal
    Given prepare URL for "GET_LIST_USERS"
    And hit api GET list users
    Then validation status code is equal to 200
    Then validation response body GET list users
    Then validation response JSON with JSONSchema "get_list_users_normal.json"

  @api @get @positive
  Scenario: Test GET list data specific user
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api GET list specific users
    Then validation status code is equal to 200
    Then validation response body GET list specific user
    Then validation response JSON with JSONSchema "get_list_specific_user.json"

  @api @get @negative
  Scenario: Test GET list data from invalid user
    Given prepare URL for "GET_LIST_USERS"
    And hit api GET list data invalid users
    Then validation status code is equal to 404
    Then validation response body GET list invalid user
    Then validation response JSON with JSONSchema "get_list_invalid_user.json"

  @api @post @positive
  Scenario: Test POST new user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    Then validation response JSON with JSONSchema "post_new_users_normal.json"

  @api @post @negative
  Scenario: Test POST new user using existing email
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api POST new user using existing email
    Then validation status code is equal to 422
    Then validation response body POST new user using existing email
    Then validation response JSON with JSONSchema "post_new_users_existing_email.json"

  @api @post @negative
  Scenario: Test POST new user using invalid gender and status
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user using invalid gender and status
    Then validation status code is equal to 422
    Then validation response body POST new user using invalid gender and status
    Then validation response JSON with JSONSchema "post_new_users_invalid_gender_status.json"

  @api @delete @positive
  Scenario: Test DELETE user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api DELETE user
    Then validation status code is equal to 204

  @api @delete @negative
  Scenario: Test DELETE invalid user
    Given prepare URL for "DELETE_USERS"
    And hit api DELETE invalid user
    Then validation status code is equal to 404
    Then validation response body DELETE invalid user
    Then validation response JSON with JSONSchema "delete_invalid_user.json"

  @api @patch @positive
  Scenario: Test PATCH update user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api PATCH update user
    Then validation status code is equal to 200
    Then validation response body PATCH update user
    Then validation response JSON with JSONSchema "patch_update_users_normal.json"

