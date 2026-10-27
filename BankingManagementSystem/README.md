# Banking Management System with Logging Using Spring AOP

## Requirements
- Java 17 or later
- Eclipse IDE with Maven support
- Internet connection for Maven dependency downloads

## Run in Eclipse
1. Extract this ZIP file.
2. In Eclipse, choose **File > Import > Maven > Existing Maven Projects**.
3. Browse to the extracted `BankingManagementSystem` folder.
4. Select `pom.xml`, then click **Finish**.
5. Right-click the project and choose **Maven > Update Project**.
6. Open `src/main/java/com/example/banking/BankingApplication.java`.
7. Choose **Run As > Java Application**.
8. Check the Eclipse Console for transaction logs.

## Expected transaction sequence
- Initial balance: ₹1000.00
- Deposit ₹500.00 => balance ₹1500.00
- Withdraw ₹300.00 => balance ₹1200.00
- Withdraw ₹2000.00 => rejected (insufficient balance)
- Deposit ₹0.00 => rejected (invalid amount)
- Final balance: ₹1200.00

The project demonstrates `@Before`, `@AfterReturning`, and `@AfterThrowing`.
