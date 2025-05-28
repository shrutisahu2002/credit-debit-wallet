# credit-debit-wallet
# Credit-Debit Wallet (Spring Boot, REST, MySQL)

## 🔧 Technologies
- Java 17
- Spring Boot (REST)
- MySQL
- JPA + Hibernate
- JUnit (Tests)

## 💡 Features
- View current balance
- Deposit money
- Withdraw money
- View transaction history

## 🔄 API Endpoints
- `GET /wallet/balance` → Get balance
- `POST /wallet/deposit?amount=100` → Deposit money
- `POST /wallet/withdraw?amount=50` → Withdraw money
- `GET /wallet/history` → Get transaction history

## 🧪 Test Cases
Run with: `mvn test`

## ⚙️ MySQL Config
Edit in `src/main/resources/application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/walletdb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

## 📦 Run Project
```bash
mvn spring-boot:run
```

## 🚀 Deployment
```bash
git init
git remote add origin https://github.com/shrutisahu2002/credit-debit-wallet.git
git add .
git commit -m "Initial commit"
git push -u origin master
