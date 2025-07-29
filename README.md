
# 💸 GloRepay – Group Expense Sharing System  
A Spring Boot-based web application that simplifies shared expense and repayment tracking. Built with real-world logic, it allows employees to log and categorize expenses, making group settlements seamless and transparent.

## 📌 Features  
✅ Register employees  
🍽️ Add food-related expenses  
🚗 Add private transport expenses  
🚌 Add public transport expenses  
📊 View categorized expense breakdowns  
👥 Track expenses per employee  
📄 View all employee details and their transactions  

## 🗃️ Tech Stack  
- Backend: Spring Boot, Spring Data JPA  
- Database: H2 / PostgreSQL  
- Build Tool: Maven  
- Validation: Hibernate Validator (JSR-380)  
- Testing: Postman for API testing  

## 🧩 Entity Relationships  

-  Employee ↔ Food – One-to-Many (Many Food records belong to one Employee)  
- Employee ↔ PrivateTransport – One-to-Many (Many private transport logs per Employee)  
- Employee ↔ PublicTransport – One-to-Many  
- Food, PrivateTransport, and PublicTransport ↔ Employee – Many-to-One  
 

## 📚 API Endpoints  

| Feature | Endpoint | Method |
|--------|----------|--------|
| Add Employee | `/addEmployee` | POST |
| Get Employee Details | `/getAllEmployees` | GET |
| Add Private Transport Expense | `/addPrivateTransportExpense/{employeeId}` | POST |
| Get Private Transport for Employee | `/getPrivateTransportExpenses/{employeeId}` | GET |
| Add Public Transport Expense | `/addPublicTransportExpense/{employeeId}` | POST |
| Get Public Transport for Employee | `/getPublicTransportExpenses/{employeeId}` | GET |
| Add Food Expense | `/addFoodExpense/{employeeId}` | POST |
| Get Food Expenses for Employee | `/getFoodExpenses/{employeeId}` | GET |

## 🔐 Validations  
- Mandatory fields enforced for all entities  
- Valid email and phone number for employees  
- Custom exception handling with meaningful messages  
- Entity-wise input validation via DTOs  

## 🚀 Getting Started  
1. Clone the repository:  
   ```bash
   git clone https://thimothybabu123/GloRepay.git

2. Import into your IDE (e.g., IntelliJ IDEA or Eclipse)

3. Configure DB settings in application.properties

4. Run the application using Spring Boot

5. Test endpoints using Postman

## 📝 License
This project is open-source and available under the MIT License.

## 👨‍💻 Author
Developed by Thimothy Babu Ramagalla
📧 thimothybaburamagalla@gmail.com
