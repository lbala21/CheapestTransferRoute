# Cheapest Transfer Route Application

## How to Build and Run the Application

1. Clone the Repository:
   Clone the repository to your local machine using the following command:
   git clone <repository-url>
2. Navigate to the project directory:
   cd CheapestTransferRoute
3. Build the application:
   ./mvnw clean install
4. Run the application:
   ./mvnw spring-boot:run


##Example of CRUL requests and response for API:

curl -X POST http://localhost:8081/api/cheapest-route \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 15,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}'
# Expected Response:
# {
#   "selectedTransfers": [
#     { "weight": 10, "cost": 20 },
#     { "weight": 5, "cost": 10 }
#   ],
#   "totalCost": 30,
#   "totalWeight": 15
# }


curl -X POST http://localhost:8081/api/cheapest-route \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 5,
  "availableTransfers": [
    { "weight": 6, "cost": 10 },
    { "weight": 7, "cost": 15 },
    { "weight": 8, "cost": 20 }
  ]
}'
# Expected Response:
# {
#   "selectedTransfers": [],
#   "totalCost": 0,
#   "totalWeight": 0
# }


curl -X POST http://localhost:8081/api/cheapest-route \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 8,
  "availableTransfers": [
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 10 },
    { "weight": 2, "cost": 3 }
  ]
}'
# Expected Response:
# {
#   "selectedTransfers": [
#     { "weight": 8, "cost": 10 }
#   ],
#   "totalCost": 10,
#   "totalWeight": 8
# }


curl -X POST http://localhost:8081/api/cheapest-route \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 10,
  "availableTransfers": [
    { "weight": 5, "cost": 6 },
    { "weight": 5, "cost": 5 },
    { "weight": 8, "cost": 20 },
    { "weight": 2, "cost": 3 }
  ]
}'
# Expected Response:
# {
#   "selectedTransfers": [
#     { "weight": 2, "cost": 3 },
#     { "weight": 8, "cost": 20 }
#   ],
#   "totalCost": 23,
#   "totalWeight": 10
# }


curl -X POST http://localhost:8081/api/cheapest-route \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 4,
  "availableTransfers": [
    { "weight": 6, "cost": 7 },
    { "weight": 2, "cost": 3 }
  ]
}'
# Expected Response:
# {
#   "selectedTransfers": [
#     { "weight": 2, "cost": 3 }
#   ],
#   "totalCost": 3,
#   "totalWeight": 2
# }


curl -X POST http://localhost:8081/api/cheapest-route \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 30,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}'
# Expected Response:
# {
#   "selectedTransfers": [
#     { "weight": 5, "cost": 10 },
#     { "weight": 10, "cost": 20 },
#     { "weight": 3, "cost": 5 },
#     { "weight": 8, "cost": 15 }
#   ],
#   "totalCost": 50,
#   "totalWeight": 26
# }
