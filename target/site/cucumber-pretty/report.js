$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Assignment.feature");
formatter.feature({
  "line": 1,
  "name": "Car Details Check feature",
  "description": "",
  "id": "car-details-check-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Verify Vehicle details",
  "description": "",
  "id": "car-details-check-feature;verify-vehicle-details",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I have list of Car Registration Numbers in the \"\u003cinput_file\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I have expected car details are there in the \"\u003coutput_file\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I check car details in the cartax check website",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Actual vehicle details are verified with expected details",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "car-details-check-feature;verify-vehicle-details;",
  "rows": [
    {
      "cells": [
        "input_file",
        "output_file"
      ],
      "line": 10,
      "id": "car-details-check-feature;verify-vehicle-details;;1"
    },
    {
      "cells": [
        "src/test/resources/testdata/car_input.txt",
        "src/test/resources/testdata/car_output.txt"
      ],
      "line": 11,
      "id": "car-details-check-feature;verify-vehicle-details;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Verify Vehicle details",
  "description": "",
  "id": "car-details-check-feature;verify-vehicle-details;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I have list of Car Registration Numbers in the \"src/test/resources/testdata/car_input.txt\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I have expected car details are there in the \"src/test/resources/testdata/car_output.txt\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I check car details in the cartax check website",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Actual vehicle details are verified with expected details",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "src/test/resources/testdata/car_input.txt",
      "offset": 48
    }
  ],
  "location": "TestStepDefinitions.vehicleDetailsAreThereInThe(String)"
});
formatter.result({
  "duration": 4425663363,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "src/test/resources/testdata/car_output.txt",
      "offset": 46
    }
  ],
  "location": "TestStepDefinitions.vehicleDetailsAreVerifiedOnTheCartaxCheckWebsite(String)"
});
formatter.result({
  "duration": 386348726,
  "status": "passed"
});
formatter.match({
  "location": "TestStepDefinitions.navigateCarCheckSite()"
});
formatter.result({
  "duration": 2385355974,
  "status": "passed"
});
formatter.match({
  "location": "TestStepDefinitions.vehicleDetailsShouldMatchTheDetailsInThe()"
});
formatter.result({
  "duration": 5177664256,
  "status": "passed"
});
formatter.after({
  "duration": 285648940,
  "status": "passed"
});
});