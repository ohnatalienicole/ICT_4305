4305 Assignment #2, Part 2 

ID: UC-01 

Name: Use Parking Lot 

Short Description: This use case describes the process of a registered customer using a University parking lot with a valid parking permit. The system validates the permit and processes the parking transaction according to the pricing and scanning requirements of the selected parking lot. 

Goal: Allow a registered customer to use a University parking lot while ensuring the appropriate parking fee is calculated and charged to the customer’s account. 

Preconditions: The customer must be registered with the University Parking Office and have a valid parking permit for the vehicle. 

Success End Condition: The permit is successfully validated, the parking transaction is recorded, and the appropriate fee is charged to the customer’s account. 

Fail End Condition: The permit cannot be validated, or the parking transaction cannot be successfully completed. 

Stakeholder(s): The Customer, Parking Office, and Parking Lot. 

Trigger: 
The use case begins when a customer enters a University parking lot, and the vehicle’s parking permit is scanned. 

Normal Flow: 

The customer enters a University parking lot.  

The parking lot scans the vehicle’s permit.  

The system validates the parking permit.  

The system records the vehicle’s entry.  

The customer exits the parking lot and the permit is scanned again.  

The system calculates the parking fee based on the total time parked.  

If the registered vehicle is a compact car, the 20% discount is applied.  

The final parking fee is charged to the customer’s account. 

Alternative Flow: If the parking lot scans permits only upon entry, the system validates the permit and charges the applicable entry fee. If the vehicle remains parked overnight, the applicable daily charges are added without requiring an exit scan. 

Includes: Validate Parking Permit, Calculate Parking Fee, and Charge Customer Account. 

Frequency of Use: Multiple times per day. 

Constraints and Special Requirements: Parking fees vary by parking lot. Some parking lots scan permits only upon entry, while others scan permits upon both entry and exit. Compact cars receive a 20% discount compared to SUV cars. 

Assumptions: Customers are registered before using a University parking lot and have a valid permit for each vehicle. Customers may have multiple vehicles and parking permits. 

Notes and Issues: The parking system records parking charges to the customer’s account but does not process payments. The Parking Office sends a monthly bill, and payment occurs outside of the parking system.