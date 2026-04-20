# API Framework - Maven Commands Guide

This document provides detailed information about running tests in the API Framework project using Maven and Cucumber tag filtering.

## Running All Tests

To run all tests in the project:
```bash
mvn test
```

This will execute all Cucumber scenarios defined in the feature files.

## Running Tests with Tag Filtering

### Correct Command Syntax (Cucumber 7.x)

The correct command to filter and run tests by Cucumber tags is:

**PowerShell / Command Prompt:**
```bash
mvn test -Dcucumber.filter.tags=@AddPlace
```

**Important Notes for Windows PowerShell:**
- Use single quotes around the parameter: `'-Dcucumber.filter.tags=@AddPlace'`
- This ensures proper escaping in PowerShell environment

### Example Commands

#### 1. Run only @AddPlace scenarios
```bash
mvn test '-Dcucumber.filter.tags=@AddPlace'
```
**Output:** Runs 1 test (the AddPlace scenario outline)

#### 2. Run only @DeletePlace scenarios
```bash
mvn test '-Dcucumber.filter.tags=@DeletePlace'
```
**Output:** Runs 1 test (the DeletePlace scenario)

#### 3. Run multiple tags (OR logic)
```bash
mvn test '-Dcucumber.filter.tags=@AddPlace or @DeletePlace'
```

#### 4. Run multiple tags (AND logic)
```bash
mvn test '-Dcucumber.filter.tags=@AddPlace and @DeletePlace'
```

#### 5. Exclude tags (NOT logic)
```bash
mvn test '-Dcucumber.filter.tags=not @DeletePlace'
```

## Why Your Original Command Didn't Work

Your original command:
```bash
mvn test -Dcucumber.filter.tags="@AddPlace"
```

**Issue:** In PowerShell, double quotes have special meaning and can cause issues with parameter parsing. The system interpreted the quotes as part of the parameter name, resulting in:
```
Unknown lifecycle phase ".filter.tags=@AddPlace"
```

**Solution:** Use single quotes to properly escape the parameter:
```bash
mvn test '-Dcucumber.filter.tags=@AddPlace'
```

## Cucumber 7.x Property Name

The property name for Cucumber 7.x is:
- **`cucumber.filter.tags`** (correct for your version)

Previously in Cucumber 4.x, it was:
- `cucumber.options` (deprecated)

Your project uses Cucumber 7.34.3 and 7.23.0, so the newer property name is required.

## Testing the Commands

All commands have been tested successfully:
- ✅ `mvn test '-Dcucumber.filter.tags=@AddPlace'` - **1 test, Success**
- ✅ `mvn test '-Dcucumber.filter.tags=@DeletePlace'` - **1 test, Success**
- ✅ `mvn test` - **2 tests, Success**

## Framework Information

- **Framework:** Cucumber BDD 7.x with JUnit
- **Build Tool:** Maven 3.x
- **Test Runner:** cucumber.options.TestRunner
- **Feature Files Location:** src/test/java/features/
- **Step Definitions:** stepDefinations package
- **Available Tags:** @AddPlace, @DeletePlace

## Additional Maven Options

### Skip Tests
```bash
mvn clean -DskipTests
```

### Run with Debug Output
```bash
mvn test -X '-Dcucumber.filter.tags=@AddPlace'
```

### Generate Reports
Reports are automatically generated during test execution:
```bash
mvn test
# HTML report generated at: target/cucumber-reports/
```

## Summary

| Command | Purpose | Result |
|---------|---------|--------|
| `mvn test` | Run all tests | 2 scenarios |
| `mvn test '-Dcucumber.filter.tags=@AddPlace'` | Run AddPlace only | 1 scenario |
| `mvn test '-Dcucumber.filter.tags=@DeletePlace'` | Run DeletePlace only | 1 scenario |
| `mvn clean test` | Clean and run all tests | Fresh build + 2 scenarios |

---

**Note:** Always use single quotes when passing Cucumber filter tags in Windows PowerShell to avoid parameter parsing issues.

