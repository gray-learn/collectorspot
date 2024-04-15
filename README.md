# Game Collection Ecommerce Website

## Group Members
- Kuo-Rui Chang
- Steven Marty Ces

## Description
This project is an Ecommerce website dedicated to game collections. It features comprehensive admin functionalities including configuration of product services stock, CRUD operations for order services, and image services for file upload/download through AWS. The application uses Postman as the platform for transactions and offers a simple user interface for product browsing, detailed views, and cart operations. Upon purchase, transaction details are displayed and the cart is reset.

## Microservices

### Products Service
- **Responsibilities**: Manages product information (name, description, price, image id, stock).
- **Features**: Create, delete, and fetch product details. Supports data flow between product and image data.
- **Technology**: Can be containerized using Docker for scalability and deployment.

### Admin Service
- **Responsibilities**: Manages administrative tasks such as product and order oversight.
- **Features**: Create, delete, view, and update products; view orders.
- **Tools**: Utilizes Postman for API management and testing.

### Orders Service
- **Responsibilities**: Handles customer orders.
- **Features**: Processes product selections, calculates total price, and updates stock.

### Image Service
- **Responsibilities**: Manages image files associated with products.
- **Features**: Upload and download images.

### Service Discovery
- **Tool**: Eureka Server.

## Technical Requirements
- **Framework**: Spring for microservices.
- **Containers**: Docker for microservices and databases.
- **API Gateway**: Manages and routes external requests to the correct microservices.
- **Database**: H2 and PostgreSQL. Separate Docker containers for each microservice's database.

## Database Schemas
- **Products Table**: `id`, `name`, `description`, `price`, `stock`, `image_id`
- **Orders Table**: `id`, `order_date`, `total_price`, `product ids and quantities` (References `Products.id`)
- **Images Table**: `id`, `name`, `mime type`, etc.

## Communication between Microservices
- **Primary Method**: REST APIs.
- **Asynchronous Communication**: Kafka, used for order processing and admin product deletion notifications.
- **Example Implementation**: Kafka video tutorial reference used for setting up asynchronous communication.

## Frontend and Cart
- **UI**: Developed using a preferred frontend framework.
- **Cart Functionality**: Managed entirely on the frontend, no backend persistence.

## Deployment
- **Tool**: Docker Compose for deploying all microservices and their databases collectively.
